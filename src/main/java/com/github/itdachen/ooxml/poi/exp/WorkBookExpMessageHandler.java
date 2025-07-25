package com.github.itdachen.ooxml.poi.exp;

import com.github.itdachen.boot.autoconfigure.AppContextHelper;
import com.github.itdachen.framework.context.userdetails.UserInfoDetails;
import com.github.itdachen.framework.core.enums.MsgClazzEnum;
import com.github.itdachen.framework.core.enums.NoticeTypeEnum;
import com.github.itdachen.framework.core.utils.LocalDateUtils;
import com.github.itdachen.framework.tools.ServletUtils;
import com.github.itdachen.framework.tools.ip.AddressUtils;
import com.github.itdachen.framework.tools.useragent.UserAgentUtils;
import com.github.itdachen.ooxml.poi.entity.MsgModel;
import com.github.itdachen.ooxml.poi.msg.IOplogMsgClient;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * WorkBookExpMessage
 *
 * @author 王大宸
 * @date 2025-07-22 10:30
 */
public class WorkBookExpMessageHandler {
    private static final Logger logger = LoggerFactory.getLogger(WorkBookExpMessageHandler.class);

    protected final static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8, 16, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("work-book-exp-message-thread-" + ThreadLocalRandom.current().nextInt(1000));
            return thread;
        }
    });


    /***
     * 添加消息信息
     *
     * @author 王大宸
     * @date 2025/7/22 10:41
     * @param msgId msgId
     * @param content content
     * @param title title
     * @param userDetails userDetails
     * @return void
     */
    public static void saveExpMessageInfo(HttpServletRequest request,
                                          String msgId,
                                          String content,
                                          String title,
                                          UserInfoDetails userDetails) throws Exception {

        String userAgent = request.getHeader("user-agent");
        String ipAddress = ServletUtils.getIPAddress(request);
        String realAddress = AddressUtils.getRealAddressByIP(ipAddress);


        MsgModel build = MsgModel.builder()
                .id(msgId)
                .msgType(NoticeTypeEnum.MSG.value())
                .msgTypeTitle(NoticeTypeEnum.MSG.title())
                .clazzType(MsgClazzEnum.EXCEL_EXP.value())
                .clazzTitle(MsgClazzEnum.EXCEL_EXP.title())
                .title(title)
                .content(content)
                .files(new ArrayList<>())

                .hostIp(ipAddress)
                .hostAddress(realAddress)
                .hostOs(UserAgentUtils.getOSInfo(userAgent))
                .hostBrowser(UserAgentUtils.getBrowserName(userAgent))
                .hostUserAgent(userAgent)

                .build();
        AppContextHelper.getBean(IOplogMsgClient.class).save(build, userDetails);

    }

    /***
     * 消息内容追加
     *
     * @author 王大宸
     * @date 2025/7/22 10:41
     * @param msgId msgId
     * @param msgContent msgContent
     * @return void
     */
    public static void appendContent(String msgId, String msgContent) {
        try {
            AppContextHelper.getBean(IOplogMsgClient.class).appendContent(
                    MsgModel.builder()
                            .id(msgId)
                            .content(msgContent)
                            .build());
        } catch (Exception e) {
            logger.error("追加消息失败, 消息ID: {}, 消息内容: {}", msgContent, msgContent, e);
        }
    }

    /***
     * 追加消息
     *
     * @author 王大宸
     * @date 2025/7/24 9:26
     * @param msgId      消息ID
     * @param msgContent 追加消息
     * @param sendMsg    是否推送
     * @return void
     */
    public static void appendContent(String msgId, String msgContent, boolean sendMsg) {
        if (!sendMsg) {
            return;
        }
        try {
            AppContextHelper.getBean(IOplogMsgClient.class).appendContent(
                    MsgModel.builder()
                            .id(msgId)
                            .content(msgContent)
                            .build());
        } catch (Exception e) {
            logger.error("追加消息失败, 消息ID: {}, 消息内容: {}", msgContent, msgContent, e);
        }
    }


    /***
     * 追加消息
     *
     * @author 王大宸
     * @date 2025/7/24 9:26
     * @param msgId      消息ID
     * @param title      标题/文件标题
     * @param msgContent 追加消息
     * @param sendMsg    是否推送
     * @return void
     */
    public static void appendContent(String msgId, String title, String msgContent, boolean sendMsg) {
        if (!sendMsg) {
            return;
        }
        String content = "【" + LocalDateUtils.getLocalDateTimeMillis() + "】";
        if (null != title && !title.isEmpty()) {
            content += "《" + title + "》";
        }
        content += msgContent;

        try {
            AppContextHelper.getBean(IOplogMsgClient.class).appendContent(
                    MsgModel.builder()
                            .id(msgId)
                            .content(content)
                            .build());
        } catch (Exception e) {
            logger.error("追加消息失败, 消息ID: {}, 消息内容: {}", msgContent, msgContent, e);
        }
    }

}
