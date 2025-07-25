package com.github.itdachen.ooxml.poi.imp;

import com.github.itdachen.ooxml.poi.entity.PoiUploadInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 *
 * @author 王大宸
 * @date 2025-07-25 17:20
 */
public interface IWorkBookImpFileUploadHandler {

    void toUpload(MultipartFile multipartFile, PoiUploadInfo uploadInfo) throws Exception;


}
