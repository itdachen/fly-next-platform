package com.github.itdachen.tools;

import com.github.itdachen.admin.sdk.dto.NetDiskMd5Dto;
import com.github.itdachen.admin.sdk.vo.NetDiskMd5Vo;
import com.github.itdachen.admin.service.INetDiskMd5Service;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.response.ServerResponse;
import com.github.itdachen.framework.core.utils.StringUtils;
import com.github.itdachen.framework.file.FileHelper;
import com.github.itdachen.framework.file.entity.FileInfo;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Description: 文件上传
 * Created by 王大宸 on 2023/04/14 22:52
 * Created with IntelliJ IDEA.
 */
@RestController
@RequestMapping("/oss/file")
public class OssFileController {

    private final FileHelper fileHelper;
    private final INetDiskMd5Service netDiskMd5Service;

    public OssFileController(FileHelper fileHelper,
                             INetDiskMd5Service netDiskMd5Service) {
        this.fileHelper = fileHelper;
        this.netDiskMd5Service = netDiskMd5Service;
    }


    /**
     * 上传文件
     */
    @PostMapping("/upload")
    public ServerResponse<FileInfo> upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            return ServerResponse.errMsg("上传文件不能为空");
        }
        final String md5Hex = fileHelper.md5Hex(file);
        final NetDiskMd5Vo netDiskMd5 = netDiskMd5Service.findNetDiskMd5(md5Hex);
        if (null == netDiskMd5) {
            FileInfo upload = fileHelper.upload(file);
            upload.setMd5(md5Hex);
            netDiskMd5Service.saveNetDiskMd5(NetDiskMd5Dto.builder()
                    .fileFormat(upload.getFormat())
                    .fileSize(upload.getSize())
                    .url(upload.getUrl())
                    .md5(md5Hex)
                    .fileName(upload.getName())
                    .build());
            return ServerResponse.okData(upload);
        }
        return ServerResponse.okData(new FileInfo.Builder()
                .md5(md5Hex)
                .url(netDiskMd5.getUrl())
                .format(netDiskMd5.getFileFormat())
                .size(netDiskMd5.getFileSize())
                .name(netDiskMd5.getFileName())
                .build());
    }

    /***
     * 文件下载, 支持本地文件和网络文件
     *
     * @author 王大宸
     * @date 2022/8/16 10:51
     * @param response response
     * @param uri 文件地址, http 请求地址
     * @param filename 文件名称,如果不传,默认以文件地址名称
     * @return void
     */
    @RequestMapping(value = "/download")
    public void download(HttpServletResponse response,
                         String uri,
                         String filename) throws Exception {
        if (StringUtils.isEmpty(uri)) {
            throw new BizException("下载的文件地址不能为空");
        }
        fileHelper.download(response, uri, filename);
    }

    /***
     * 文件 md5 检查
     *
     * @author 王大宸
     * @date 2022/9/25 21:30
     * @param md5Hex md5Hex
     * @return com.itdachen.framework.core.response.ServerResponse<com.itdachen.oss.sdk.vo.FileNode>
     */
    @GetMapping("/md5/{md5Hex}")
    @ResponseBody
    public ServerResponse<FileInfo> checkUpMd5Hex(@PathVariable("md5Hex") String md5Hex) throws Exception {
        NetDiskMd5Vo netDiskMd5 = netDiskMd5Service.findNetDiskMd5(md5Hex);
        if (null != netDiskMd5) {
            return ServerResponse.ok();
        }
        return ServerResponse.okData(new FileInfo.Builder()
                .md5(md5Hex)
                .url(netDiskMd5.getUrl())
                .format(netDiskMd5.getFileFormat())
                .size(netDiskMd5.getFileSize())
                .name(netDiskMd5.getFileName())
                .build());
    }


}
