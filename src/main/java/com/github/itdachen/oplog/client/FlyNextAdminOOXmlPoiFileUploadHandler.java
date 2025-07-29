package com.github.itdachen.oplog.client;

import com.github.itdachen.boot.autoconfigure.AppContextHelper;
import com.github.itdachen.boot.oplog.ooxml.poi.fileupload.IOOXmlPoiFileUploadHandler;
import com.github.itdachen.boot.oss.FileHelper;
import com.github.itdachen.framework.context.models.FileInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 导入导出文件上传至服务器
 *
 * @author 王大宸
 * @date 2025-07-29 18:08
 */
@Service
public class FlyNextAdminOOXmlPoiFileUploadHandler implements IOOXmlPoiFileUploadHandler {
    private static final Logger logger = LoggerFactory.getLogger(FlyNextAdminOOXmlPoiFileUploadHandler.class);


    @Override
    public FileInfo toUpload(MultipartFile multipartFile, String path) {
        try {
            return AppContextHelper.getBean(FileHelper.class).upload(multipartFile, path);
        } catch (Exception e) {
            logger.error("导入导出文件上传失败: ", e);
            return null;
        }

    }


}
