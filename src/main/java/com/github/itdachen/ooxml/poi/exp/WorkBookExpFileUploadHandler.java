package com.github.itdachen.ooxml.poi.exp;

import com.github.itdachen.boot.autoconfigure.AppContextHelper;
import com.github.itdachen.boot.autoconfigure.oss.properties.OssLocalAutoconfigureProperties;
import com.github.itdachen.ooxml.poi.entity.PoiUploadInfo;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 下载文件上传
 *
 * @author 王大宸
 * @date 2025-07-22 11:20
 */
public class WorkBookExpFileUploadHandler {
    private static final Logger logger = LoggerFactory.getLogger(WorkBookExpFileUploadHandler.class);


    public static void setUploadToFolder(XSSFWorkbook workbook, PoiUploadInfo uploadInfo) {
        OssLocalAutoconfigureProperties ossProperties = AppContextHelper.getBean(OssLocalAutoconfigureProperties.class);
        String diskUri = ossProperties.getDiskFolder();
        if (!diskUri.endsWith(uploadInfo.getDiskPrefix())) {
            diskUri += PoiUploadInfo.EXP_DISK_PREFIX;
        }
        diskUri = diskUri.replaceAll("//", "/");

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        diskUri += pattern.format(ldt) + "/";

        String localDateTime = ExcelExpUtils.getLocalDateTime();
        localDateTime = localDateTime.replaceAll("-", "").replaceAll(" ", "").replaceAll(":", "");
        diskUri += localDateTime + ExcelExpUtils.getUUid() + uploadInfo.getFileFormat();

        /* 如果文件目录不存在, 则创建文件目录 */
        File file = new File(diskUri);
        File parentDir = file.getParentFile();
        long fileSize = file.length();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs(); // 创建所有不存在的父目录
        }

        // 保存Excel到服务器
        try (FileOutputStream outputStream = new FileOutputStream(diskUri)) {
            workbook.write(outputStream);

            final String fileUri = loadHttpUri(ossProperties.getMapPath(), diskUri,
                    ossProperties.getDiskFolder(),
                    ossProperties.getLocalHttp());

            uploadInfo.setFileDiskUri(diskUri);   // 文件磁盘地址
            uploadInfo.setFileUri(fileUri);       // 文件访问地址
            uploadInfo.setFileSize(fileSize);     // 文件大小

        } catch (IOException e) {
            logger.error("文件保存到服务器失败: {}", e.getMessage());
        }

    }


    /***
     * 文件网络地址处理
     *
     * @author 王大宸
     * @date 2024/5/28 14:24
     * @param mapPath    映射路径, 例如: upload
     * @param diskUri    文件存放的磁盘详细地址, 例如: D:/upload/excel/exp/2024/05/28/xxxxx.xlsx
     * @param diskFolder 服务器存储位置, 例如: D:/upload/
     * @param bizHttp    应用访问地址, 例如: http://128.0.0.1:8080/app
     * @return java.lang.String 最终访问地址: http://128.0.0.1:8080/app/upload/excel/exp/2024/05/28/xxxxx.xlsx
     */
    public static String loadHttpUri(String mapPath, String diskUri, String diskFolder, String bizHttp) {
        String url = mapPath(mapPath) + diskUri.replace(diskFolder, "");
        url = url.replaceAll("//", "/");
        if (bizHttp.endsWith("/")) {
            return bizHttp.substring(0, bizHttp.length() - 1) + url;
        }
        return bizHttp + url;
    }


    /***
     * 映射路径处理
     *
     * @author 王大宸
     * @date 2023/2/13 9:32
     * @param path path
     * @return java.lang.String
     */
    public static String mapPath(String path) {
        path = !path.startsWith("/") ? "/" + path : path;
        path = !path.endsWith("/") ? path + "/" : path;
        return path;
    }


}
