package com.github.itdachen.oplog.service;

import com.github.itdachen.oplog.sdk.dto.OplogPoiTestDTO;
import com.github.itdachen.oplog.sdk.query.OplogPoiTestQuery;
import com.github.itdachen.oplog.sdk.vo.OplogPoiTestVO;
import com.github.itdachen.framework.webmvc.service.IBizService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 * 导入导出测试 业务接口
 *
 * @author 王大宸
 * @date 2025-07-28 16:55:09
 */
public interface IOplogPoiTestService extends IBizService< OplogPoiTestDTO, OplogPoiTestVO, OplogPoiTestQuery, String > {

}
