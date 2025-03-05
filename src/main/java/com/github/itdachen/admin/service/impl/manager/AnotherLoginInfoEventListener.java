package com.github.itdachen.admin.service.impl.manager;

import com.github.itdachen.admin.service.IAppInfoService;
import com.github.itdachen.admin.service.IUserInfoService;
import com.github.itdachen.auth.entity.LoginInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

/**
 * 另外两种方式
 *
 * @author 王大宸
 * @date 2025/1/22 21:55
 */
// @Component
public class AnotherLoginInfoEventListener {
    private static final Logger logger = LoggerFactory.getLogger(AnotherLoginInfoEventListener.class);

    /***
     * 3.2、@EventListener 注解
     * 除了基于接口的订阅方式，Spring还提供了@EventListener注解来简化订阅者的实现。插播一条：如果你想加入我们，可以点击->程序员交流社区
     * Spring还提供了对异步事件的支持，可以使用@Async注解来实现异步处理，从而避免阻塞事件的发布者
     *
     * @author 王大宸
     * @date 2025/1/22 21:59
     * @param event event
     * @return void
     */
    @EventListener
    @Async
    public void handleUserRegisteredEvent(LoginInfoEvent event) {
        LoginInfo loginInfo = event.getLoginInfo();
        // 逻辑处理
        // System.err.println("3.2 @EventListener 注解 LoginInfo: " + loginInfo.toString());
        // logger.info("@EventListener 注解 LoginInfo: {}", loginInfo.toString());
    }


    /**
     * 3.3、事件源Object source的作用
     * 假设有一个 Web服务 和一个 API 服务都可能触发 LoginInfoEvent 事件，你可以在监听器中根据 source 进一步区分事件的处理方式
     *
     * @param event
     */
    @EventListener
    public void onUserRegistered(LoginInfoEvent event) {
        Object source = event.getSource();
        if (source instanceof IUserInfoService) {
            // 处理通过 后台添加用户
            // System.err.println(" 3.3、事件源Object source的作用, 处理通过后台添加用户: " + event.getLoginInfo().toString());
            //   logger.info(" 3.3、事件源Object source的作用, 处理通过后台添加用户: {}", event.getLoginInfo().toString());
        } else if (source instanceof IAppInfoService) {
            // 处理通过 API 注册的用户
        }
    }

}
