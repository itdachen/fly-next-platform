package com.github.itdachen.ooxml.poi.imp;

import com.github.itdachen.boot.autoconfigure.AppContextHelper;
import com.github.itdachen.boot.oss.FileHelper;
import com.github.itdachen.boot.oss.entity.FileInfo;
import com.github.itdachen.ooxml.poi.entity.PoiUploadInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * DefaultWorkBookImpFileUpload
 *
 * @author 王大宸
 * @date 2025-07-25 17:21
 */
public class DefaultWorkBookImpFileUpload implements IWorkBookImpFileUploadHandler {


    @Override
    public void toUpload(MultipartFile multipartFile, PoiUploadInfo uploadInfo) throws Exception {
        if (null == uploadInfo) {
            uploadInfo = new PoiUploadInfo();
        }
        FileHelper fileHelper = AppContextHelper.getBean(FileHelper.class);
        FileInfo upload = fileHelper.upload(multipartFile, PoiUploadInfo.EXP_DISK_PREFIX);

        uploadInfo.setFileDiskUri(upload.getUrl());   // 文件磁盘地址
        uploadInfo.setFileUri(upload.getUrl());       // 文件访问地址
        uploadInfo.setFileSize(upload.getSize());     // 文件大小
    }


}
