package com.github.itdachen.config;

import com.github.itdachen.framework.core.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

/**
 * Description: 自定义redis key过期监听器，继承KeyExpirationEventMessageListener类
 * Created by 王大宸 on 2023-08-28 16:06
 * Created with IntelliJ IDEA.
 */
@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {
    private static final Logger logger = LoggerFactory.getLogger(RedisKeyExpirationListener.class);

    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        //注意：只能获取失效的key值，获取不到key对应的value值的。
        String expiredKey = message.toString();
        try {
            if (!StringUtils.isEmpty(expiredKey)) {
                //具体处理逻辑......

                logger.info("Redis Key Expire: {}", expiredKey);

            }
        } catch (Exception e) {
            logger.info("---------redis 过期缓存处理 异常---------");
            e.printStackTrace();
        }
    }

}
