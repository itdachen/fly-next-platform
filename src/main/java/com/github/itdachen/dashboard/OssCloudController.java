package com.github.itdachen.dashboard;

import com.github.itdachen.boot.oss.FileHelper;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.models.FileInfo;
import com.github.itdachen.framework.context.userdetails.UserInfoDetails;
import com.github.itdachen.framework.core.response.ServerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * OssCloudController
 *
 * @author 王大宸
 * @date 2025/2/22 15:45
 */
@Controller
@RequestMapping("/oss")
public class OssCloudController {

    private final FileHelper fileHelper;

    public OssCloudController(FileHelper fileHelper) {
        this.fileHelper = fileHelper;
    }


    /***
     * 文件上传
     */
    @PostMapping("/upload")
    @ResponseBody
    public ServerResponse<FileInfo> upload(@RequestParam("file") MultipartFile file) throws Exception {
        UserInfoDetails userDetails = BizContextHandler.getUserDetails();
        return ServerResponse.ok(fileHelper.upload(file));
    }

}
