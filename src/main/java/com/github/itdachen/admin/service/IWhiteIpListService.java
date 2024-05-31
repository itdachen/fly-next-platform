package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.WhiteIpListDTO;
import com.github.itdachen.admin.sdk.query.WhiteIpListQuery;
import com.github.itdachen.admin.sdk.vo.WhiteIpListVO;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 菜单白名单 业务接口
 *
 * @author 王大宸
 * @date 2024-04-20 22:16:38
 */
public interface IWhiteIpListService extends IBizService< WhiteIpListDTO, WhiteIpListVO, WhiteIpListQuery, String > {

}
