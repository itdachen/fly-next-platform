package com.github.itdachen.api.sign;

import org.springframework.core.codec.EncodingException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * 接口签名工具类
 *
 * @author 王大宸
 * @date 2024/11/3 12:47
 */
public class SignUtils {
    private static final String SIGN_ALGORITHM =  "HmacSHA1";

    /**
     * 使用 HmacSHA1 算法进行签名
     * @param secretKey 密钥
     * @param data 数据
     * @return
     */
    public static String signWithHmacSha1(String secretKey, String data) {
        try {
            SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), SIGN_ALGORITHM);
            Mac mac = Mac.getInstance(SIGN_ALGORITHM);
            mac.init(signingKey);
            return Base64.getEncoder().encodeToString(mac.doFinal(data.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 验证签名
     * @param secretKey 密钥
     * @param data 数据
     * @param hmac 签名
     * @return
     */
    public static boolean verify(String secretKey, String data, String hmac) {
        String calculatedHmac = signWithHmacSha1(secretKey, data);
        return calculatedHmac.equals(hmac);
    }


}
