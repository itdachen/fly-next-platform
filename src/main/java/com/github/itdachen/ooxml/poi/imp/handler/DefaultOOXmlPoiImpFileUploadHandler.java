package com.github.itdachen.ooxml.poi.imp.handler;

import com.github.itdachen.boot.autoconfigure.AppContextHelper;
import com.github.itdachen.boot.oss.FileHelper;
import com.github.itdachen.boot.oss.entity.FileInfo;
import com.github.itdachen.ooxml.poi.entity.PoiUploadInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传默认实现
 *
 * @author 王大宸
 * @date 2025-07-25 17:21
 */
public class DefaultOOXmlPoiImpFileUploadHandler implements IOOXmlPoiImpFileUploadHandler {


    @Override
    public FileInfo toUpload(MultipartFile multipartFile) throws Exception {
        FileHelper fileHelper = AppContextHelper.getBean(FileHelper.class);
        return fileHelper.upload(multipartFile, PoiUploadInfo.IMP_DISK_PREFIX);
    }


}
