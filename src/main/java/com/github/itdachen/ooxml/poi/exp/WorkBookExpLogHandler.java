package com.github.itdachen.ooxml.poi.exp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.itdachen.boot.autoconfigure.AppContextHelper;
import com.github.itdachen.boot.autoconfigure.app.AppInfoProperties;
import com.github.itdachen.boot.autoconfigure.app.PlatformInfoProperties;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.id.IdUtils;
import com.github.itdachen.framework.context.userdetails.UserInfoDetails;
import com.github.itdachen.framework.tools.ServletUtils;
import com.github.itdachen.framework.tools.useragent.UserAgentUtils;
import com.github.itdachen.ooxml.poi.entity.PoiExpModel;
import com.github.itdachen.ooxml.poi.entity.PoiUploadInfo;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.concurrent.*;

/**
 * 操作日志处理
 *
 * @author 王大宸
 * @date 2025-07-22 11:19
 */
public class WorkBookExpLogHandler {
    private static final Logger logger = LoggerFactory.getLogger(WorkBookExpLogHandler.class);
    private final static ObjectMapper objectMapper = new ObjectMapper();

    private final static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8, 16, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("work-book-exp-log-thread-" + ThreadLocalRandom.current().nextInt(1000));
            return thread;
        }
    });


    /***
     * 添加导出日志文件信息
     *
     * @author 王大宸
     * @date 2025/7/22 15:08
     * @param request request
     * @param userDetails 用户信息
     * @param msgId       消息ID
     * @param params      请求参数
     * @param uploadInfo  文件上传信息
     * @return void
     */
    public static void saveLog(HttpServletRequest request,
                               UserInfoDetails userDetails,
                               String msgId,
                               Object params,
                               PoiUploadInfo uploadInfo) throws JsonProcessingException {

        AppInfoProperties appClientProperties = AppContextHelper.getBean(AppInfoProperties.class);
        PlatformInfoProperties platformClientProperties = AppContextHelper.getBean(PlatformInfoProperties.class);

        LocalDateTime now = LocalDateTime.now();
        String userAgent = request.getHeader("User-Agent");
        final String jsonString = objectMapper.writeValueAsString(params);

        PoiExpModel poiExpModel = PoiExpModel.builder()
                .id(IdUtils.getId())
                .msgId(msgId)
                .appId(appClientProperties.getAppId())
                .appTitle(appClientProperties.getAppName())
                .appVersion(appClientProperties.getVersion())
                .platId(platformClientProperties.getId())
                .platTitle(platformClientProperties.getTitle())

                /* 人员信息 */
                .userId(userDetails.getId())
                .nickName(userDetails.getNickName())
                .roleId(userDetails.getRoleId())
                .roleName(userDetails.getRoleName())

                /* 行政区划 */
                .provId(userDetails.getProvCode())
                .provTitle(userDetails.getProvName())
                .cityId(userDetails.getCityCode())
                .cityTitle(userDetails.getCityName())
                .countyId(userDetails.getCountyCode())
                .countyTitle(userDetails.getCountyName())

                /* 具体所属部门 */
                .deptId(userDetails.getDeptId())
                .deptTitle(userDetails.getDeptTitle())
                .deptLevel(userDetails.getDeptLevel())
                .deptParentId(userDetails.getDeptParentId())

                /* 日志标题 */
                .msgId(msgId)
                .funcId("-")
                .funcTitle(uploadInfo.getTitle())

                /* 操作主机信息 */
                .hostIp(ServletUtils.getIPAddress(request))
                .hostAddress("-")
                .hostOs(UserAgentUtils.getOSInfo(userAgent))
                .hostBrowser(UserAgentUtils.getBrowserName(userAgent))
                .hostUserAgent(userAgent)

                /* 请求信息 */
                .requestId(null == request.getRequestId() ? "-" : request.getRequestId())
                .requestUri(request.getRequestURI())
                .requestMethod("GET")
                .requestParams(jsonString)

                /* 导出信息 */
                .dataTotal("-")
                .fileName(uploadInfo.getFileName())
                .fileUrl(uploadInfo.getFileUri())
                .fileSize(String.valueOf(uploadInfo.getFileSize()))
                .fileTotal(String.valueOf(uploadInfo.getDataTotal()))

                .exInfo("-")
                .remarks("-")
                .executeTime(uploadInfo.getTakeUpTime() + " ms")

                .monthly(String.valueOf(now.getMonthValue()))
                .yearly(String.valueOf(now.getYear()))
                .build();


        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    AppContextHelper.getBean(IOplogPoiExpLogClient.class).save(poiExpModel);
                } catch (Exception e) {
                    logger.error("数据导出日志入库失败: ", e);
                }
            }
        });

    }


}
