package com.github.itdachen.security.handler;

import com.github.itdachen.dashboard.entity.LoginErrorRecord;
import com.github.itdachen.dashboard.mapper.ILoginErrorRecordMapper;
import com.github.itdachen.dashboard.service.IAuthFailureBadCredentialsService;
import com.github.itdachen.framework.core.utils.StringUtils;
import com.github.itdachen.framework.tools.ip.IpAddressUtils;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.security.constants.LoginModeConstant;
import com.github.itdachen.security.constants.SecurityBrowserConstants;
import com.github.itdachen.security.exception.BizSecurityException;
import com.github.itdachen.security.properties.SecurityBrowserProperties;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 登录失败处理器
 * Created by 王大宸 on 2022-09-23 16:39
 * Created with IntelliJ IDEA.
 */
@Component("authenticationFailureHandler")
public class FlyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private static final Logger logger = LoggerFactory.getLogger(FlyAuthenticationFailureHandler.class);

    private final SecurityBrowserProperties securityProperties;
    private final IAuthFailureBadCredentialsService authFailureBadCredentialsService;

    public FlyAuthenticationFailureHandler(SecurityBrowserProperties securityProperties,
                                           IAuthFailureBadCredentialsService authFailureBadCredentialsService) {
        this.securityProperties = securityProperties;
        this.authFailureBadCredentialsService = authFailureBadCredentialsService;
    }


    /* (non-Javadoc)
     * @see org.springframework.security.web.authentication.AuthenticationFailureHandler#onAuthenticationFailure(jakarta.servlet.http.HttpServletRequest, jakarta.servlet.http.HttpServletResponse, org.springframework.security.core.AuthenticationException)
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        // 登录错误，添加跳转路径，跳转到登陆页面，需要在路径后面添加 ?error=true 作为 thymeleaf 页面提示
        String failureUrl = securityProperties.getSignInPage() + "?error=true";

        /* 登录之后是否需要重定向到指定地址 */
        String queryString = request.getQueryString();
        if (StringUtils.isNotEmpty(queryString) && queryString.contains(SecurityBrowserConstants.REDIRECT_URI)) {
            List<String> strings = StringUtils.strToList(queryString, "&");
            String[] split;
            for (String string : strings) {
                split = string.split("=");
                if (!SecurityBrowserConstants.REDIRECT_URI.contains(split[0])) {
                    continue;
                }
                failureUrl += "&" + string;
                break;
            }
        }

        if (null == exception) {
            setDefaultFailureUrl(failureUrl);
            super.onAuthenticationFailure(request, response, exception);
            return;
        }

        final String message = exception.getMessage();
        Map<String, String> body = getAllRequestParam(request);
        LoginErrorRecord build = LoginErrorRecord.builder()
                .id(EntityUtils.getId())
                .createTime(LocalDateTime.now())
                .sessionId(request.getSession().getId())
                .clientId("web_app")
                .ip(request.getRemoteAddr())
                .requestId(request.getRequestId())
                .message(exception.getMessage())
                .build();

        String type = "";
        /* 登录验证码 */
        if (body.containsKey("imageCode")) {
            build.setVerificationCode(body.get("imageCode"));
            build.setErrorType("password");
            build.setUsername(body.get("username"));
            build.setPassword(body.get("password"));
            type = "password";
        }
        if (body.containsKey("smsCode")) {
            build.setVerificationCode(body.get("smsCode"));
            build.setUsername(body.get("mobile"));
            build.setPassword(body.get("smsCode"));
            build.setErrorType("sms");
            type = "sms";
        }
        /* 操作系统, 浏览器 */
        String osAndBrowserInfo = getOsAndBrowserInfo(request);
        String[] split = osAndBrowserInfo.split("-");
        if (2 == split.length || 3 == split.length) {
            build.setOs(split[0]);
            if (2 == split.length) {
                build.setBrowser(split[1]);
            } else {
                build.setBrowser(split[1] + "(" + split[2] + ")");
            }
        }

        authFailureBadCredentialsService.onApplicationEvent(build);

        // 手机号码登录失败
        if (StringUtils.startsWithIgnoreCase(message, "SMS")) {
            type = "sms";
            exception = new BizSecurityException("验证码错误");
        }
        if (StringUtils.startsWithIgnoreCase(message, LoginModeConstant.NO_MOBILE_USER)) {
            type = "sms";
            exception = new BizSecurityException(message.replaceAll(LoginModeConstant.NO_MOBILE_USER, ""));
        }
        /* 密码登录失败 */
        if (StringUtils.startsWithIgnoreCase(message, "IMAGE")) {
            type = "password";
            exception = new BizSecurityException("验证码错误");
        }
        if (StringUtils.startsWithIgnoreCase(message, LoginModeConstant.NOT_HAVE_USER)) {
            type = "password";
            exception = new BizSecurityException("用户名或密码错误");
        }

        if (StringUtils.isNotEmpty(type)) {
            failureUrl = failureUrl + "&mode=" + type;
        }
        setDefaultFailureUrl(failureUrl);
        super.onAuthenticationFailure(request, response, exception);
    }

    /***
     * Post 请求获取参数
     *
     * @author 王大宸
     * @date 2023/7/1 0:09
     * @param request request
     * @return java.util.Map<java.lang.String,java.lang.String>
     */
    private Map<String, String> getAllRequestParam(final HttpServletRequest request) {
        Map<String, String> res = new HashMap<String, String>();
        Enumeration<?> temp = request.getParameterNames();
        if (null != temp) {
            while (temp.hasMoreElements()) {
                String en = (String) temp.nextElement();
                String value = request.getParameter(en);
                res.put(en, value);
            }
        }
        return res;
    }


    /***
     * 获取操作系统,浏览器及浏览器版本信息
     *
     * @author 王大宸
     * @date 2023/7/1 0:09
     * @param request request
     * @return java.lang.String
     */
    public static String getOsAndBrowserInfo(HttpServletRequest request) {
        String browserDetails = request.getHeader("User-Agent");
        String userAgent = browserDetails;
        String user = userAgent.toLowerCase();

        String os = "";
        String browser = "";

        //=================OS Info=======================
        if (userAgent.toLowerCase().indexOf("windows") >= 0) {
            os = "Windows";
        } else if (userAgent.toLowerCase().indexOf("mac") >= 0) {
            os = "Mac";
        } else if (userAgent.toLowerCase().indexOf("x11") >= 0) {
            os = "Unix";
        } else if (userAgent.toLowerCase().indexOf("android") >= 0) {
            os = "Android";
        } else if (userAgent.toLowerCase().indexOf("iphone") >= 0) {
            os = "IPhone";
        } else {
            os = "UnKnown, More-Info: " + userAgent;
        }
        //===============Browser===========================
        if (user.contains("edge")) {
            browser = (userAgent.substring(userAgent.indexOf("Edge")).split(" ")[0]).replace("/", "-");
        } else if (user.contains("msie")) {
            String substring = userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
            browser = substring.split(" ")[0].replace("MSIE", "IE") + "-" + substring.split(" ")[1];
        } else if (user.contains("safari") && user.contains("version")) {
            browser = (userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0]
                    + "-" + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
        } else if (user.contains("opr") || user.contains("opera")) {
            if (user.contains("opera")) {
                browser = (userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0]
                        + "-" + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
            } else if (user.contains("opr")) {
                browser = ((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-"))
                        .replace("OPR", "Opera");
            }
        } else if (user.contains("chrome")) {
            browser = (userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
        } else if ((user.indexOf("mozilla/7.0") > -1) || (user.indexOf("netscape6") != -1) ||
                (user.indexOf("mozilla/4.7") != -1) || (user.indexOf("mozilla/4.78") != -1) ||
                (user.indexOf("mozilla/4.08") != -1) || (user.indexOf("mozilla/3") != -1)) {
            browser = "Netscape-?";
        } else if (user.contains("firefox")) {
            browser = (userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
        } else if (user.contains("rv")) {
            String IEVersion = (userAgent.substring(userAgent.indexOf("rv")).split(" ")[0]).replace("rv:", "-");
            browser = "IE" + IEVersion.substring(0, IEVersion.length() - 1);
        } else {
            browser = "UnKnown, More-Info: " + userAgent;
        }
        return os + "-" + browser;
    }

}
