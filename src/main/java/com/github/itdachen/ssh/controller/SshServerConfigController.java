package com.github.itdachen.ssh.controller;

import com.github.itdachen.ssh.service.ISshServerConfigService;
import com.github.itdachen.ssh.sdk.dto.SshServerConfigDTO;
import com.github.itdachen.ssh.sdk.query.SshServerConfigQuery;
import com.github.itdachen.ssh.sdk.vo.SshServerConfigVO;
import com.github.itdachen.framework.context.annotation.FuncTitle;
import com.github.itdachen.framework.webmvc.controller.BizController;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * SSH 连接
 *
 * @author 王大宸
 * @date 2025-08-18 22:58:10
 */
@Controller
@RequestMapping("/ssh/server")
@FuncTitle("SSH 连接")
public class SshServerConfigController extends BizController<ISshServerConfigService, SshServerConfigDTO, SshServerConfigVO, SshServerConfigQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(SshServerConfigController.class);
    private static final String PATH_PREFIX = "ssh";

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2025-08-18 22:58:10
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    @PreAuthorize("hasAuthority('fly:ssh:server:index')")
    public String index() {
        return PATH_PREFIX + "/index";
    }

    /***
     * 跳转到添加页面
     *
     * @author 王大宸
     * @date 2025-08-18 22:58:10
     * @return java.lang.String
     */
    @GetMapping(value = "/add")
    @PreAuthorize("hasAuthority('fly:ssh:server:save')")
    public String add() {
        return PATH_PREFIX + "/add";
    }

    /***
     * 跳转到修改页面
     *
     * @author 王大宸
     * @date 2025-08-18 22:58:10
     * @param id id
     * @param modelMap   modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/edit/{id}")
    @PreAuthorize("hasAuthority('fly:ssh:server:update')")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("sshServerConfig", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/edit";
    }

    /***
     * 跳转到查看页面
     *
     * @author 王大宸
     * @date 2025-08-18 22:58:10
     * @param id 需要查看数据的 id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('fly:ssh:server:view')")
    public String view(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("sshServerConfig", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/view";
    }


    /**
     * 测试服务器连接
     */
    @PostMapping("/connection/{id}")
    public ResponseEntity<Map<String, Object>> testConnection(@PathVariable("id") String id) throws Exception {
        SshServerConfigVO sshServerConfigVO = bizService.selectByPrimaryKey(id);
        try {
            // 验证必要参数
            if (sshServerConfigVO.getHostIp() == null || sshServerConfigVO.getHostIp().trim().isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of("success", false, "message", "服务器地址不能为空"));
            }
            if (sshServerConfigVO.getHostUsername() == null || sshServerConfigVO.getHostUsername().trim().isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of("success", false, "message", "用户名不能为空"));
            }
            if (sshServerConfigVO.getHostPassword() == null || sshServerConfigVO.getHostPassword().trim().isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of("success", false, "message", "密码不能为空"));
            }

            // 设置默认端口
            int port = sshServerConfigVO.getHostPort() != null ? Integer.parseInt(sshServerConfigVO.getHostPort()) : 22;

            // 简单的连接测试
            JSch jsch = new JSch();
            Session session = jsch.getSession(sshServerConfigVO.getHostUsername(), sshServerConfigVO.getHostIp(), port);
            session.setPassword(sshServerConfigVO.getHostPassword());
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect(5000); // 5秒超时
            session.disconnect();

            return ResponseEntity.ok(Map.of("success", true, "message", "连接测试成功"));
        } catch (Exception e) {
            return ResponseEntity.ok(Map.of("success", false, "message", "连接测试失败: " + e.getMessage()));
        }
    }


}