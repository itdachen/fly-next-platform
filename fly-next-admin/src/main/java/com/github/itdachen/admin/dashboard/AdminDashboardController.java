package com.github.itdachen.admin.dashboard;

import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.permission.PermissionInfo;
import com.github.itdachen.config.WebAppClientConfig;
import com.github.itdachen.security.properties.SecurityBrowserProperties;
import com.github.itdachen.config.TemplateEnum;
import com.github.itdachen.admin.service.IPermsAuthWebService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Description:
 * Created by 王大宸 on 2022-09-25 15:08
 * Created with IntelliJ IDEA.
 */
@Controller
public class AdminDashboardController {
    private static final String PATH_PREFIX = "backstage/layui";
    private static final String LYEAR_PREFIX = "backstage/lyear";
    private static final String OK_PATH_PREFIX = "backstage/okadmin";
    private static final String PEAR_PREFIX = "backstage/pear";

    private final Environment environment;
    private final WebAppClientConfig webAppClientConfig;
    private final IPermsAuthWebService permsAuthService;

    public AdminDashboardController(Environment environment,
                                    WebAppClientConfig webAppClientConfig,
                                    IPermsAuthWebService permsAuthService) {
        this.environment = environment;
        this.webAppClientConfig = webAppClientConfig;
        this.permsAuthService = permsAuthService;
    }

    /***
     * 登录成功之后跳转页面 (LayuiAdmin)
     *
     * @author 王大宸
     * @date 2022/9/6 22:44
     * @param modelMap modelMap
     *
     * @return java.lang.String
     */
    @GetMapping({"/", "/index"})
    public String index(ModelMap modelMap) {
        clientInfo(modelMap);


        if (TemplateEnum.LYEAR == webAppClientConfig.getTemplate()) {
            return LYEAR_PREFIX + "/index";
        } else if (TemplateEnum.LAYUI == webAppClientConfig.getTemplate()) {
            String permsAuthUri = contextPath() + "/perms/auth/menu";
            modelMap.put("permsAuthUri", permsAuthUri);
            return PATH_PREFIX + "/index";
        } else if (TemplateEnum.OKADMIN == webAppClientConfig.getTemplate()) {
            return OK_PATH_PREFIX + "/index";
        } else if (TemplateEnum.PEAR == webAppClientConfig.getTemplate()) {
            return PEAR_PREFIX + "/index";
        } else {
            return PEAR_PREFIX + "/index";
        }
    }

    /***
     * 跳转到首页
     *
     * @author 王大宸
     * @date 2022/9/6 22:44
     * @return java.lang.String
     */
    @GetMapping("/dashboard/console")
    public String homeConsole() {
        return PATH_PREFIX + "/console2";
    }

    /***
     * 跳转到修改密码页面
     *
     * @author 王大宸
     * @date 2022/9/7 16:42
     * @return java.lang.String
     */
    @GetMapping("/paw")
    public String paw() {
        return PATH_PREFIX + "/paw";
    }

    /***
     * 统一返回给前端页面信息
     *
     * @author 王大宸
     * @date 2023/2/2 17:22
     * @param modelMap modelMap
     * @return void
     */
    private void clientInfo(ModelMap modelMap) {
        /* 登录用户头像和姓名 */
        modelMap.put("userName", BizContextHandler.getNickName());
        modelMap.put("avatar", BizContextHandler.getAvatar());

        /* 系统信息 */
        modelMap.put("copyrightYear", webAppClientConfig.getCopyrightYear());
        modelMap.put("clientName", webAppClientConfig.getName());
        modelMap.put("version", webAppClientConfig.getVersion());
        modelMap.put("issuer", webAppClientConfig.getIssuer());

        /* 默认跳转页面 */
        PermissionInfo homeUri = permsAuthService.getHomeUri(webAppClientConfig.getId());
        modelMap.put("homeId", homeUri.getId());
        modelMap.put("homeUri", homeUri.getUri());
        modelMap.put("menuName", homeUri.getName());

        /* 退出登录 */
        modelMap.put("logoutUri", contextPath() + "/logout");
    }

    /***
     * 获取当前上下文
     *
     * @author 王大宸
     * @date 2023/2/15 16:12
     * @return java.lang.String
     */
    private String contextPath() {
        String contextPath = environment.getProperty("server.servlet.context-path");
        if (StringUtils.isEmpty(contextPath)) {
            return "";
        }
        return contextPath;
    }


}
