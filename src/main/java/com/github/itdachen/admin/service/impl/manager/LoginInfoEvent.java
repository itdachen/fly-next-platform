package com.github.itdachen.admin.service.impl.manager;

import com.github.itdachen.auth.entity.LoginInfo;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

/**
 * 订阅模式：解耦与异步通信的高效实现
 * 通过订阅模式实现登录信息入库
 * 1、定义事件
 * <p>
 * 发布订阅模式，又称为观察者模式（Observer Pattern）的一种变体，是一种基于消息传递的设计模式。在这个模式中，主要涉及三个核心角色：发布者（Publisher）、订阅者（Subscriber）和消息代理（Message Broker）。
 * 发布者是消息的产生者，它负责生成特定类型的消息并将其发送到消息代理。发布者不需要了解有哪些订阅者对其发布的消息感兴趣，它只专注于消息的生成和发布。
 * 订阅者则是对特定类型消息感兴趣的组件，它们向消息代理注册自己感兴趣的消息类型。当消息代理接收到发布者发送的符合订阅者兴趣的消息时，会将消息转发给对应的订阅者。订阅者可以根据接收到的消息进行相应的业务处理。
 * 消息代理是发布者和订阅者之间的中介，它负责接收发布者的消息，并根据订阅者的注册信息将消息分发给相应的订阅者。消息代理的存在使得发布者和订阅者之间实现了高度的解耦，它们不需要直接相互引用或通信，只需要与消息代理进行交互即可。
 *
 * @author 王大宸
 * @date 2025/1/22 21:25
 */
public class LoginInfoEvent extends ApplicationEvent {

    private final LoginInfo loginInfo;

    /**
     * 构造函数
     *
     * @param source   事件的源对象，用于表明这个事件是由哪个对象触发的
     * @param userId   用户ID
     * @param username 登录账号
     * @param password 登录密码(未加密)
     */
    public LoginInfoEvent(Object source, String userId, String username, String password) {
        super(source);

        LocalDateTime now = LocalDateTime.now();

        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setId(userId);
        loginInfo.setUsername(username);
        loginInfo.setPassword(password);
        loginInfo.setValidFlag(YesOrNotConstant.Y);
        loginInfo.setExpTime(now.plusMonths(6));
        loginInfo.setLastTime(now);
        loginInfo.setCreateTime(now);
        loginInfo.setUpdateTime(now);

        this.loginInfo = loginInfo;
    }


    public LoginInfo getLoginInfo() {
        return this.loginInfo;
    }


}
