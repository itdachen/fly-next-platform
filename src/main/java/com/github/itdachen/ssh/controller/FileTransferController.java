package com.github.itdachen.ssh.controller;

import com.github.itdachen.framework.core.AssertUtils;
import com.github.itdachen.ssh.sdk.vo.SshServerConfigVO;
import com.github.itdachen.ssh.service.ISshServerConfigService;
import com.github.itdachen.ssh.ssh.FileTransferService;
import com.github.itdachen.ssh.ssh.SSHServerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * FileTransferController
 *
 * @author 王大宸
 * @date 2025/8/19 0:13
 */
@RestController
@RequestMapping("/ssh/files")
public class FileTransferController {

    @Autowired
    private FileTransferService fileTransferService;
    @Autowired
    private ISshServerConfigService serverService;

    /**
     * 上传文件到服务器
     */
    @PostMapping("/upload/{serverId}")
    public ResponseEntity<Map<String, Object>> uploadFile(@PathVariable String serverId,
                                                          @RequestParam("file") MultipartFile file,
                                                          @RequestParam("remotePath") String remotePath) {
        try {
            if (file.isEmpty()) {
                return ResponseEntity.badRequest()
                        .body(Map.of("success", false, "message", "文件不能为空"));
            }


            SSHServerInfo sshServerInfo = toSSHServerInfo(serverId);

            fileTransferService.uploadFile(sshServerInfo, file, remotePath);

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", "文件上传成功",
                    "filename", file.getOriginalFilename(),
                    "size", file.getSize()
            ));

        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("success", false, "message", "上传失败: " + e.getMessage()));
        }
    }

    /**
     * 批量上传文件
     */
    @PostMapping("/upload-batch/{serverId}")
    public ResponseEntity<Map<String, Object>> uploadFiles(@PathVariable String serverId,
                                                           @RequestParam("files") MultipartFile[] files,
                                                           @RequestParam("remotePath") String remotePath) {
        try {

            if (files == null || files.length == 0) {
                return ResponseEntity.badRequest()
                        .body(Map.of("success", false, "message", "请选择要上传的文件"));
            }


            SSHServerInfo sshServerInfo = toSSHServerInfo(serverId);

            fileTransferService.uploadFiles(sshServerInfo, files, remotePath);

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", "批量上传成功",
                    "count", files.length
            ));

        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("success", false, "message", "批量上传失败: " + e.getMessage()));
        }
    }

    /**
     * 从服务器下载文件
     */
    @GetMapping("/download/{serverId}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String serverId,
                                               @RequestParam("remoteFilePath") String remoteFilePath) {
        try {

            SSHServerInfo sshServerInfo = toSSHServerInfo(serverId);

            byte[] fileContent = fileTransferService.downloadFile(sshServerInfo, remoteFilePath);

            // 从路径中提取文件名
            String filename = remoteFilePath.substring(remoteFilePath.lastIndexOf('/') + 1);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(fileContent);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * 列出远程目录内容
     */
    @GetMapping("/list/{serverId}")
    public ResponseEntity<Map<String, Object>> listDirectory(@PathVariable String serverId,
                                                             @RequestParam("remotePath") String remotePath) {
        try {

            SSHServerInfo sshServerInfo = toSSHServerInfo(serverId);

            List<FileTransferService.FileInfo> files = fileTransferService.listDirectory(sshServerInfo, remotePath);

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "files", files,
                    "path", remotePath
            ));

        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("success", false, "message", "获取目录列表失败: " + e.getMessage()));
        }
    }

    /**
     * 创建远程目录
     */
    @PostMapping("/mkdir/{serverId}")
    public ResponseEntity<Map<String, Object>> createDirectory(@PathVariable String serverId,
                                                               @RequestBody Map<String, String> request) {
        try {

            String remotePath = request.get("remotePath");
            if (remotePath == null || remotePath.trim().isEmpty()) {
                return ResponseEntity.badRequest()
                        .body(Map.of("success", false, "message", "目录路径不能为空"));
            }

            SSHServerInfo sshServerInfo = toSSHServerInfo(serverId);

            fileTransferService.createRemoteDirectory(sshServerInfo, remotePath);

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", "目录创建成功",
                    "path", remotePath
            ));

        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("success", false, "message", "创建目录失败: " + e.getMessage()));
        }
    }

    /**
     * 删除远程文件或目录
     */
    @DeleteMapping("/delete/{serverId}")
    public ResponseEntity<Map<String, Object>> deleteFile(@PathVariable String serverId,
                                                          @RequestParam("remotePath") String remotePath,
                                                          @RequestParam(value = "isDirectory", defaultValue = "false") boolean isDirectory) {
        try {

            SSHServerInfo sshServerInfo = toSSHServerInfo(serverId);

            fileTransferService.deleteRemoteFile(sshServerInfo, remotePath, isDirectory);

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", (isDirectory ? "目录" : "文件") + "删除成功",
                    "path", remotePath
            ));

        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("success", false, "message", "删除失败: " + e.getMessage()));
        }
    }

    /**
     * 重命名远程文件
     */
    @PostMapping("/rename/{serverId}")
    public ResponseEntity<Map<String, Object>> renameFile(@PathVariable String serverId, @RequestBody Map<String, String> request) {
        try {
            SSHServerInfo sshServerInfo = toSSHServerInfo(serverId);

            String oldPath = request.get("oldPath");
            String newPath = request.get("newPath");

            if (oldPath == null || newPath == null || oldPath.trim().isEmpty() || newPath.trim().isEmpty()) {
                return ResponseEntity.badRequest()
                        .body(Map.of("success", false, "message", "路径不能为空"));
            }

            fileTransferService.renameRemoteFile(sshServerInfo, oldPath, newPath);

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", "重命名成功",
                    "oldPath", oldPath,
                    "newPath", newPath
            ));

        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("success", false, "message", "重命名失败: " + e.getMessage()));
        }
    }


    private SshServerConfigVO getSshServerConfigVO(String serverId) throws Exception {
        SshServerConfigVO sshServerConfigVO = serverService.selectByPrimaryKey(serverId);
        AssertUtils.isTrue(null == sshServerConfigVO, "服务器不存在！");
        return sshServerConfigVO;
    }


    private SSHServerInfo toSSHServerInfo(SshServerConfigVO sshServerConfigVO) throws Exception {
        return new SSHServerInfo(sshServerConfigVO.getHostIp(),
                sshServerConfigVO.getHostPort(),
                sshServerConfigVO.getHostUsername(),
                sshServerConfigVO.getHostPassword());
    }


    private SSHServerInfo toSSHServerInfo(String serverId) throws Exception {
        SshServerConfigVO sshServerConfigVO = serverService.selectByPrimaryKey(serverId);
        AssertUtils.isTrue(null == sshServerConfigVO, "服务器不存在！");

        return new SSHServerInfo(sshServerConfigVO.getHostIp(),
                sshServerConfigVO.getHostPort(),
                sshServerConfigVO.getHostUsername(),
                sshServerConfigVO.getHostPassword());
    }


}
