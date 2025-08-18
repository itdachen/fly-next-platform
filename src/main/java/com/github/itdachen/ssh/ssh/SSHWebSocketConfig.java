package com.github.itdachen.ssh.ssh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * 配置WebSocket，实现浏览器与服务器的实时通信
 *
 * @author 王大宸
 * @date 2025/8/18 23:53
 */
@Configuration
@EnableWebSocket
public class SSHWebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private SSHWebSocketHandler sshWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(sshWebSocketHandler, "/ssh")
                .setAllowedOriginPatterns("*"); // 生产环境中应该限制域名
    }

}
