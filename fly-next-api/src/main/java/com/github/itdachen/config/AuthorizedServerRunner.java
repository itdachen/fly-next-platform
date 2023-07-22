package com.github.itdachen.config;

import com.github.itdachen.framework.autoconfigure.jwt.FlyJwtAutoconfigureProperties;
import com.github.itdachen.framework.jwt.constants.RsaKeyConstant;
import com.github.itdachen.framework.jwt.core.AuthKeyConfiguration;
import com.github.itdachen.framework.jwt.utils.RsaKeyHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Description: 初始化 JWT 密钥/公钥
 * Created by 王大宸 on 2023/04/25 21:40
 * Created with IntelliJ IDEA.
 */
@Component
public class AuthorizedServerRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(AuthorizedServerRunner.class);

    @Autowired
    private AuthKeyConfiguration keyConfiguration;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private FlyJwtAutoconfigureProperties properties;

//    @Autowired
//    private SecretKeyHelper secretKeyHelper;

//    @Autowired
//    private IAuthKeyHelper authKeyHelper;

    @Override
    public void run(String... args) throws Exception {


        logger.info("正在初始化用户公钥/密钥...");
        if (Boolean.TRUE.equals(redisTemplate.hasKey(RsaKeyConstant.REDIS_USER_PRI_KEY))
                && Boolean.TRUE.equals(redisTemplate.hasKey(RsaKeyConstant.REDIS_USER_PUB_KEY))) {
            keyConfiguration.setUserPriKey(RsaKeyHelper.toBytes(redisTemplate.opsForValue().get(RsaKeyConstant.REDIS_USER_PRI_KEY)));
            keyConfiguration.setUserPubKey(RsaKeyHelper.toBytes(redisTemplate.opsForValue().get(RsaKeyConstant.REDIS_USER_PUB_KEY)));
        } else {
            Map<String, byte[]> keyMap = RsaKeyHelper.generateKey(properties.getAuthSecret());
            keyConfiguration.setUserPriKey(keyMap.get(RsaKeyConstant.PRI_KEY));
            keyConfiguration.setUserPubKey(keyMap.get(RsaKeyConstant.PUB_KEY));
            redisTemplate.opsForValue().set(RsaKeyConstant.REDIS_USER_PRI_KEY, RsaKeyHelper.toHexString(keyMap.get(RsaKeyConstant.PRI_KEY)));
            redisTemplate.opsForValue().set(RsaKeyConstant.REDIS_USER_PUB_KEY, RsaKeyHelper.toHexString(keyMap.get(RsaKeyConstant.PUB_KEY)));
        }
        logger.info("初始化用户公钥/密钥成功...");

        // authKeyHelper.runnerAuthKey();

//        final JwtSecretKey jwtSecretKey = secretKeyHelper.secretKey();
//
//        if (Boolean.TRUE.equals(redisTemplate.hasKey(JwtRedisKeyConstants.USER_PRI_KEY))
//                && Boolean.TRUE.equals(redisTemplate.hasKey(JwtRedisKeyConstants.USER_PUB_KEY))) {
//
//            final String privateKey = redisTemplate.opsForValue().get(JwtRedisKeyConstants.USER_PRI_KEY);
//            final String publicKey = redisTemplate.opsForValue().get(JwtRedisKeyConstants.USER_PUB_KEY);
//
//            secretKeyConfiguration.setUserPriKey(privateKey);
//            secretKeyConfiguration.setUserPubKey(publicKey);
//
//        } else {
//            redisTemplate.opsForValue().set(JwtRedisKeyConstants.USER_PRI_KEY, jwtSecretKey.getPrivateKey());
//            redisTemplate.opsForValue().set(JwtRedisKeyConstants.USER_PUB_KEY, jwtSecretKey.getPublicKey());
//
//            secretKeyConfiguration.setUserPriKey(jwtSecretKey.getPrivateKey());
//            secretKeyConfiguration.setUserPubKey(jwtSecretKey.getPublicKey());
//        }
    }

}
