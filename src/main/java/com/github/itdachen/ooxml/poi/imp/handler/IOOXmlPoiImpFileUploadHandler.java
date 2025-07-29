package com.github.itdachen.ooxml.poi.imp.handler;

import com.github.itdachen.boot.oss.entity.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * 文件上传
 *
 * @author 王大宸
 * @date 2025-07-25 17:20
 */
public interface IOOXmlPoiImpFileUploadHandler {

    FileInfo toUpload(MultipartFile multipartFile) throws Exception;

    FileInfo toUpload(InputStream inputStream,String fileName) throws Exception;


}
