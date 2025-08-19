package com.github.itdachen.ssh.controller;

import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.ssh.entity.SshServerConfig;
import com.github.itdachen.ssh.sdk.vo.SshServerConfigVO;
import com.github.itdachen.ssh.service.ISshServerConfigService;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * SSHServerController
 *
 * @author 王大宸
 * @date 2025/8/19 22:01
 */
@RestController
@RequestMapping("/api/servers")
public class SSHServerController {

    @Autowired
    private ISshServerConfigService serverService;

//    @Autowired
//    private ServerService serverService;
//

    /**
     * 获取服务器列表
     */
    @GetMapping
    public ResponseEntity<List<SshServerConfigVO>> getServers() throws Exception {
        TableData<SshServerConfigVO> page = serverService.page(null);
        return ResponseEntity.ok(page.getRows());
    }

//
//    /**
//     * 获取单个服务器配置
//     */
//    @GetMapping("/{id}")
//    public ResponseEntity<ServerConfig> getServer(@PathVariable Long id) {
//        try {
//            Optional<ServerConfig> server = serverService.getServerById(id);
//            if (server.isPresent()) {
//                return ResponseEntity.ok(server.get());
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().build();
//        }
//    }
//
//    /**
//     * 添加服务器
//     */
//    @PostMapping
//    public ResponseEntity<Map<String, Object>> addServer(@RequestBody ServerConfig server) {
//        try {
//            // 验证必要参数
//            if (server.getHost() == null || server.getHost().trim().isEmpty()) {
//                return ResponseEntity.badRequest().body(Map.of("success", false, "message", "服务器地址不能为空"));
//            }
//            if (server.getUsername() == null || server.getUsername().trim().isEmpty()) {
//                return ResponseEntity.badRequest().body(Map.of("success", false, "message", "用户名不能为空"));
//            }
//            if (server.getPassword() == null || server.getPassword().trim().isEmpty()) {
//                return ResponseEntity.badRequest().body(Map.of("success", false, "message", "密码不能为空"));
//            }
//
//            // 设置默认值
//            if (server.getPort() == null) {
//                server.setPort(22);
//            }
//            if (server.getName() == null || server.getName().trim().isEmpty()) {
//                server.setName(server.getUsername() + "@" + server.getHost());
//            }
//
//            Long serverId = serverService.saveServer(server);
//            return ResponseEntity.ok(Map.of("success", true, "id", serverId));
//        } catch (Exception e) {
//            return ResponseEntity.badRequest()
//                    .body(Map.of("success", false, "message", e.getMessage()));
//        }
//    }
//
//    /**
//     * 删除服务器
//     */
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Map<String, Object>> deleteServer(@PathVariable Long id) {
////        try {
////            serverService.deleteServer(id);
////            return ResponseEntity.ok(Map.of("success", true));
////        } catch (Exception e) {
////            return ResponseEntity.badRequest()
////                    .body(Map.of("success", false, "message", e.getMessage()));
////        }
//
//        return null;
//    }

    /**
     * 测试服务器连接
     */
    @PostMapping("/test")
    public ResponseEntity<Map<String, Object>> testConnection() throws Exception {
//        try {
//            // 验证必要参数
//            if (server.getHost() == null || server.getHost().trim().isEmpty()) {
//                return ResponseEntity.badRequest().body(Map.of("success", false, "message", "服务器地址不能为空"));
//            }
//            if (server.getUsername() == null || server.getUsername().trim().isEmpty()) {
//                return ResponseEntity.badRequest().body(Map.of("success", false, "message", "用户名不能为空"));
//            }
//            if (server.getPassword() == null || server.getPassword().trim().isEmpty()) {
//                return ResponseEntity.badRequest().body(Map.of("success", false, "message", "密码不能为空"));
//            }
//
//            // 设置默认端口
//            int port = server.getPort() != null ? server.getPort() : 22;
//
//            // 简单的连接测试
//            JSch jsch = new JSch();
//            Session session = jsch.getSession(server.getUsername(), server.getHost(), port);
//            session.setPassword(server.getPassword());
//            session.setConfig("StrictHostKeyChecking", "no");
//            session.connect(5000); // 5秒超时
//            session.disconnect();
//
//            return ResponseEntity.ok(Map.of("success", true, "message", "连接测试成功"));
//        } catch (Exception e) {
//            return ResponseEntity.ok(Map.of("success", false, "message", "连接测试失败: " + e.getMessage()));
//        }


        String id = "1957460886314684416";

        SshServerConfigVO sshServerConfigVO = serverService.selectByPrimaryKey(id);
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
