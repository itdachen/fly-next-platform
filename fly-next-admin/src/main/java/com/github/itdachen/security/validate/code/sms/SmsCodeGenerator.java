package com.github.itdachen.security.validate.code.sms;

import com.github.itdachen.security.properties.SecurityBrowserProperties;
import com.github.itdachen.security.validate.code.ValidateCode;
import com.github.itdachen.security.validate.code.ValidateCodeGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Description: 短信验证码生成
 * Created by 王大宸 on 2021-11-27 10:28
 * Created with IntelliJ IDEA.
 */
@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    private final SecurityBrowserProperties securityProperties;

    public SmsCodeGenerator(SecurityBrowserProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
    }

}
