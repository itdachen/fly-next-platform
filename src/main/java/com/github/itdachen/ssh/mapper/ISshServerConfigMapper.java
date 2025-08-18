package com.github.itdachen.ssh.mapper;

import com.github.itdachen.ssh.entity.SshServerConfig;
import com.github.itdachen.ssh.sdk.query.SshServerConfigQuery;
import com.github.itdachen.ssh.sdk.vo.SshServerConfigVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * SSH 连接 持久层接口
 *
 * @author 王大宸
 * @date 2025-08-18 22:58:10
 */
public interface ISshServerConfigMapper extends Mapper<SshServerConfig> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2025-08-18 22:58:10
     * @param params params
     * @return com.github.itdachen.ssh.sdk.vo.sshServerConfigVO
     */
    List<SshServerConfigVO> list(SshServerConfigQuery params);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2025-08-18 22:58:10
     * @param id 需要查询的数据id
     * @return com.github.itdachen.ssh.sdk.vo.sshServerConfigVo
     */
    SshServerConfigVO selectSshServerConfigVO(String id);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2025-08-18 22:58:10
     * @param list java.util.List<com.github.itdachen.ssh.entity.SshServerConfig>
     */
    void batchSave(List<SshServerConfig> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2025-08-18 22:58:10
     * @param list java.util.List<com.github.itdachen.ssh.entity.SshServerConfig>
     */
    void batchUpdate(List<SshServerConfig> list);

}
