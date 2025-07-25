package com.github.itdachen.ooxml.poi.utils;

/**
 * 文件上传至服务器
 *
 * @author 王大宸
 * @date 2025-07-25 16:09
 */
public class WorkBookFileUploadUtils {


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
