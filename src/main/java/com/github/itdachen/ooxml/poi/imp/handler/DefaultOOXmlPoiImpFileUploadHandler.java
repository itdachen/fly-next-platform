package com.github.itdachen.ooxml.poi.imp.handler;

import com.github.itdachen.boot.autoconfigure.AppContextHelper;
import com.github.itdachen.boot.oss.FileHelper;
import com.github.itdachen.boot.oss.entity.FileInfo;
import com.github.itdachen.ooxml.poi.entity.PoiUploadInfo;
import com.github.itdachen.ooxml.poi.utils.CommonsMultipartFile;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件上传默认实现
 *
 * @author 王大宸
 * @date 2025-07-25 17:21
 */
public class DefaultOOXmlPoiImpFileUploadHandler implements IOOXmlPoiImpFileUploadHandler {
    private static final Logger logger = LoggerFactory.getLogger(DefaultOOXmlPoiImpFileUploadHandler.class);


    @Override
    public FileInfo toUpload(MultipartFile multipartFile) throws Exception {
        FileHelper fileHelper = AppContextHelper.getBean(FileHelper.class);
        return fileHelper.upload(multipartFile, PoiUploadInfo.IMP_DISK_PREFIX);
    }

    @Override
    public FileInfo toUpload(InputStream inputStream,String fileName) throws Exception {
        MultipartFile fileItem = getMultipartFile(inputStream, fileName);
        FileHelper fileHelper = AppContextHelper.getBean(FileHelper.class);
        return fileHelper.upload(fileItem, PoiUploadInfo.IMP_DISK_PREFIX);
    }


    public MultipartFile getMultipartFile(InputStream inputStream, String fileName) {
        FileItem fileItem = createFileItem(inputStream, fileName);
        //CommonsMultipartFile是feign对multipartFile的封装，但是要FileItem类对象
        return new CommonsMultipartFile(fileItem);
    }


    /**
     * FileItem类对象创建
     *
     * @param inputStream inputStream
     * @param fileName    fileName
     * @return FileItem
     */
    public FileItem createFileItem(InputStream inputStream, String fileName) {
        FileItemFactory factory = new DiskFileItemFactory(16, null);
        String textFieldName = "file";
        FileItem item = factory.createItem(textFieldName, MediaType.MULTIPART_FORM_DATA_VALUE, true, fileName);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        OutputStream os = null;
        //使用输出流输出输入流的字节
        try {
            os = item.getOutputStream();
            while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            inputStream.close();
        } catch (IOException e) {
            logger.error("Stream copy exception", e);
            throw new IllegalArgumentException("文件上传失败");
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    logger.error("Stream close exception", e);

                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.error("Stream close exception", e);
                }
            }
        }

        return item;
    }

}
