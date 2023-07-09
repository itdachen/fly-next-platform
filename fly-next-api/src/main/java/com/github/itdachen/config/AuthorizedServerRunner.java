package com.github.itdachen.config;

import com.github.itdachen.framework.jwt.SecretKeyHelper;
import com.github.itdachen.framework.jwt.config.SecretKeyConfiguration;
import com.github.itdachen.framework.jwt.constants.JwtRedisKeyConstants;
import com.github.itdachen.framework.jwt.core.JwtSecretKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Description: 初始化 JWT 密钥/公钥
 * Created by 王大宸 on 2023/04/25 21:40
 * Created with IntelliJ IDEA.
 */
@Component
public class AuthorizedServerRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(AuthorizedServerRunner.class);

    @Autowired
    private SecretKeyConfiguration secretKeyConfiguration;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private SecretKeyHelper secretKeyHelper;

    @Override
    public void run(String... args) throws Exception {

        final JwtSecretKey jwtSecretKey = secretKeyHelper.secretKey();

        if (Boolean.TRUE.equals(redisTemplate.hasKey(JwtRedisKeyConstants.USER_PRI_KEY))
                && Boolean.TRUE.equals(redisTemplate.hasKey(JwtRedisKeyConstants.USER_PUB_KEY))) {

            final String privateKey = redisTemplate.opsForValue().get(JwtRedisKeyConstants.USER_PRI_KEY);
            final String publicKey = redisTemplate.opsForValue().get(JwtRedisKeyConstants.USER_PUB_KEY);

            secretKeyConfiguration.setUserPriKey(privateKey);
            secretKeyConfiguration.setUserPubKey(publicKey);

        } else {
            redisTemplate.opsForValue().set(JwtRedisKeyConstants.USER_PRI_KEY, jwtSecretKey.getPrivateKey());
            redisTemplate.opsForValue().set(JwtRedisKeyConstants.USER_PUB_KEY, jwtSecretKey.getPublicKey());

            secretKeyConfiguration.setUserPriKey(jwtSecretKey.getPrivateKey());
            secretKeyConfiguration.setUserPubKey(jwtSecretKey.getPublicKey());
        }
    }

}
