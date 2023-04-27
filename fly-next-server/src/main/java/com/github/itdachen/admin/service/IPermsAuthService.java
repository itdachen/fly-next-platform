package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.PermsAuthDto;
import com.github.itdachen.admin.sdk.query.PermsAuthQuery;
import com.github.itdachen.admin.sdk.vo.PermsAuthVo;
import com.github.itdachen.framework.assets.tree.ZTreeNode;
import com.github.itdachen.framework.webmvc.service.IBizService;

import java.util.List;

/**
 * 权限下发 业务接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public interface IPermsAuthService extends IBizService<PermsAuthDto, PermsAuthVo, PermsAuthQuery, String > {


    List<ZTreeNode> findMenuWithUser(String userId, String userType, String currentUserId) throws Exception;

}
