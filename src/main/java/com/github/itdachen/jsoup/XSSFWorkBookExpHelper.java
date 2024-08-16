package com.github.itdachen.jsoup;

import com.github.itdachen.framework.core.utils.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jxl.write.WriteException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

/**
 * 导出
 *
 * @author 王大宸
 * @date 2024-05-28 10:49
 */
public class XSSFWorkBookExpHelper {
    private static final Logger logger = LoggerFactory.getLogger(XSSFWorkBookExpHelper.class);
    public static final String FILE_NAME_FORMAT = ".xlsx";
    private static final String DISK_PREFIX = "/excel/";

    /**
     * 是否展示序号
     */
    private Boolean hasRowNum;

    /**
     * 是否保存到服务器
     */
    private Boolean toUpload;

    /**
     * 文件访问地址
     */
    private String fileUri;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件在磁盘上的详细的一直
     */
    private String fileDiskUri;

    /**
     * 文件大小
     */
    private Long fileSize;


    public XSSFWorkBookExpHelper() {
        this.hasRowNum = true;
        this.toUpload = true;
    }

    /***
     * 导出
     *
     * @author 王大宸
     * @date 2024/5/28 10:52
     * @param fields fields
     * @param list list
     * @param fileName fileName
     * @param hasRowNum hasRowNum
     * @return void
     */
    public void expHandler(List<String> fields,
                           List<LinkedHashMap<String, String>> list,
                           String fileName,
                           Boolean hasRowNum,
                           String diskUri) throws Exception {
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook();
            /* 创建 sheet */
            Sheet sheet = workbook.createSheet(fileName);
            sheet.setDefaultColumnWidth(30); // 设置默认宽度

            /* 表头设置 */
            setTitleCell(workbook, sheet, fileName, fields, hasRowNum);

            if (!list.isEmpty()) {
                int index = 1; // 序号
                int rowNum = 2; // 行号
                LinkedHashMap<String, String> map;
                String value;
                int dateColumn = 0; // 列号
                Row row;
                Cell cell;

                /* 内容文本字体 */
                XSSFCellStyle textCellStyle = workbook.createCellStyle();
                textCellStyle.setAlignment(HorizontalAlignment.CENTER); // 设置水平居中
                textCellStyle.setVerticalAlignment(VerticalAlignment.CENTER); // 设置垂直居中
                XSSFFont textXssfFont = workbook.createFont();
                textXssfFont.setFontHeightInPoints((short) 12);
                textXssfFont.setBold(false); //粗体显示
                textCellStyle.setFont(textXssfFont);
                // textCellStyle.setWrapText(true); //设置自动换行

                for (Iterator<LinkedHashMap<String, String>> var = list.iterator(); var.hasNext(); ++index) {
                    row = sheet.createRow(rowNum);
                    row.setHeight(Short.parseShort("500"));
                    map = var.next();
                    dateColumn = 0;

                    if (hasRowNum) {
                        dateColumn = 1;
                        cell = row.createCell(0);
                        cell.setCellValue(String.valueOf(index)); // 添加序号
                        cell.setCellStyle(textCellStyle);
                    }

                    for (Iterator<String> varMap = map.values().iterator(); varMap.hasNext(); ++dateColumn) {
                        value = String.valueOf(varMap.next());
                        if (value == null || "null".equals(value) || StringUtils.isEmpty(value)) {
                            value = "";
                        }
                        cell = row.createCell(dateColumn);
                        cell.setCellValue(value);
                        cell.setCellStyle(textCellStyle);
                    }
                    rowNum++;
                }
            }

            if (toUpload) {
                setUploadToFolder(diskUri, fileName, workbook);
                setFileName(fileName + FILE_NAME_FORMAT);
            }

            /* 通过流写入到前端 */
            // workbook.write(os);
        } catch (Exception e) {
            logger.error("数据导出失败: {} ", e.getMessage(), e);
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
//                if (os != null) {
//                    os.close();
//                }
            } catch (Exception e) {
                logger.error("数据导出, 关闭输出流失败: {} ", e.getMessage(), e);
            }
        }

    }

    /***
     * 自定义表头标题导出方法
     *
     * @author 张桥
     * @date 2024/7/16 10:52
     * @param request request
     * @param response response
     * @param fields fields
     * @param list list
     * @param fileName fileName
     * @param hasRowNum hasRowNum
     * @return void
     */
    private void expHandler(HttpServletRequest request,
                            HttpServletResponse response,
                            List<String> fields,
                            List<LinkedHashMap<String, String>> list,
                            String fileName,
                            String titleName,
                            Boolean hasRowNum,
                            String diskUri) throws Exception {
        XSSFWorkbook workbook = null;
        OutputStream os = null;
        try {
            workbook = new XSSFWorkbook();
            os = response.getOutputStream();
            response.reset();// 清空输出流
            // excel 文件的 MIME 类型
            response.setContentType("application/msexcel");
            //在导出前对名称根据浏览器做下处理
            String agent = request.getHeader("USER-AGENT").toLowerCase();
            response.setContentType("application/vnd.ms-excel");
            //***************很重要
            //文件名中文乱码
            if (agent.contains("firefox")) {
                response.setCharacterEncoding("utf-8");
                response.setHeader("content-disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1") + FILE_NAME_FORMAT);
            } else {
                String codedFileName = java.net.URLEncoder.encode(fileName, "UTF-8");
                response.setHeader("content-disposition", "attachment;filename=" + codedFileName + FILE_NAME_FORMAT);
            }

            /* 创建 sheet */
            Sheet sheet = workbook.createSheet(fileName);
            sheet.setDefaultColumnWidth(30); // 设置默认宽度

            /* 表头设置 */
            //两个方法区别在有自定义表头标题
            setTitleCell(workbook, sheet, fileName, titleName, fields, hasRowNum);

            if (!list.isEmpty()) {
                int index = 1; // 序号
                int rowNum = 3; // 行号
                LinkedHashMap<String, String> map;
                String value;
                int dateColumn = 0; // 列号
                Row row;
                Cell cell;

                /* 内容文本字体 */
                XSSFCellStyle textCellStyle = workbook.createCellStyle();
                textCellStyle.setAlignment(HorizontalAlignment.CENTER); // 设置水平居中
                textCellStyle.setVerticalAlignment(VerticalAlignment.CENTER); // 设置垂直居中
                XSSFFont textXssfFont = workbook.createFont();
                textXssfFont.setFontHeightInPoints((short) 12);
                textXssfFont.setBold(false); //粗体显示
                textCellStyle.setFont(textXssfFont);
                // textCellStyle.setWrapText(true); //设置自动换行

                for (Iterator<LinkedHashMap<String, String>> var = list.iterator(); var.hasNext(); ++index) {
                    row = sheet.createRow(rowNum);
                    row.setHeight(Short.parseShort("500"));
                    map = var.next();
                    dateColumn = 0;

                    if (hasRowNum) {
                        dateColumn = 1;
                        cell = row.createCell(0);
                        cell.setCellValue(String.valueOf(index)); // 添加序号
                        cell.setCellStyle(textCellStyle);
                    }

                    for (Iterator<String> varMap = map.values().iterator(); varMap.hasNext(); ++dateColumn) {
                        value = String.valueOf(varMap.next());
                        if (value == null || "null".equals(value) || StringUtils.isEmpty(value)) {
                            value = "";
                        }
                        cell = row.createCell(dateColumn);
                        cell.setCellValue(value);
                        cell.setCellStyle(textCellStyle);
                    }
                    rowNum++;
                }
            }

            if (toUpload) {
                setUploadToFolder(diskUri, fileName, workbook);
                setFileName(fileName + FILE_NAME_FORMAT);
            }

            /* 通过流写入到前端 */
            workbook.write(os);
        } catch (Exception e) {
            logger.error("数据导出失败: {} ", e.getMessage(), e);
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (Exception e) {
                logger.error("数据导出, 关闭输出流失败: {} ", e.getMessage(), e);
            }
        }

    }

    /***
     * 设置表头
     *
     * @author 王大宸
     * @date 2024/5/28 10:22
     * @param workbook workbook
     * @param sheet sheet
     * @param fields     二级标题
     * @param title      一级标题
     * @param hasRowNum  是否显示序号
     * @return void
     */
    private void setTitleCell(XSSFWorkbook workbook, Sheet sheet, String title, List<String> fields, boolean hasRowNum) throws WriteException {
        /* 标题 */
        XSSFCellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER); // 设置水平居中
        headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER); // 设置垂直居中

        XSSFFont headerXssfFont = workbook.createFont();
        headerXssfFont.setBold(true); //粗体显示
        headerXssfFont.setFontName("仿宋_GB2312");
        headerXssfFont.setFontHeightInPoints((short) 24);
        headerCellStyle.setFont(headerXssfFont);


        int endColumnNum = fields.size() - 1;
        if (hasRowNum) {
            endColumnNum = fields.size();
        }

        CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, endColumnNum);
        sheet.addMergedRegion(cellRangeAddress);

        Row headerRow = sheet.createRow(0);
        headerRow.setHeight(Short.parseShort("800"));
        Cell cell = headerRow.createCell(0);
        cell.setCellValue(title);
        cell.setCellStyle(headerCellStyle);


        /* 二级表头 */
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER); // 设置水平居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER); // 设置垂直居中
        XSSFFont xssfFont = workbook.createFont();
        xssfFont.setBold(true); //粗体显示
        xssfFont.setFontName("仿宋_GB2312");
        xssfFont.setFontHeightInPoints((short) 16);
        cellStyle.setFont(xssfFont);

        Row row = sheet.createRow(1);
        row.setHeight(Short.parseShort("700"));


        int columnNum = 0;
        if (hasRowNum) {
            cell = row.createCell(columnNum);
            cell.setCellValue("序号");
            cell.setCellStyle(cellStyle);
            columnNum = 1;
        }

        for (String field : fields) {
            cell = row.createCell(columnNum);
            cell.setCellValue(field);
            cell.setCellStyle(cellStyle);
            columnNum++;
        }
    }


    /***
     * 设置表头和查询条件
     *
     * @author 张桥
     * @return void
     */
    private void setTitleCell(XSSFWorkbook workbook, Sheet sheet, String title, String titleName, List<String> fields, boolean hasRowNum) throws WriteException {
        /* 标题 */
        XSSFCellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER); // 设置水平居中
        headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER); // 设置垂直居中

        XSSFFont headerXssfFont = workbook.createFont();
        headerXssfFont.setBold(true); //粗体显示
        headerXssfFont.setFontName("仿宋_GB2312");
        headerXssfFont.setFontHeightInPoints((short) 24);
        headerCellStyle.setFont(headerXssfFont);


        int endColumnNum = fields.size() - 1;
        if (hasRowNum) {
            endColumnNum = fields.size();
        }

        CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, endColumnNum);
        sheet.addMergedRegion(cellRangeAddress);

        Row headerRow = sheet.createRow(0);
        headerRow.setHeight(Short.parseShort("800"));
        Cell cell = headerRow.createCell(0);
        cell.setCellValue(title);
        cell.setCellStyle(headerCellStyle);

        /* 查询条件 */
        XSSFCellStyle titleNameCellStyle = workbook.createCellStyle();
        titleNameCellStyle.setAlignment(HorizontalAlignment.LEFT); // 设置靠左
        titleNameCellStyle.setVerticalAlignment(VerticalAlignment.CENTER); // 设置垂直居中
        XSSFFont titleNameXssfFont = workbook.createFont();
        titleNameXssfFont.setFontName("仿宋_GB2312");
        titleNameXssfFont.setFontHeightInPoints((short) 18);
        titleNameCellStyle.setFont(titleNameXssfFont);


        CellRangeAddress celltitleNameRangeAddress = new CellRangeAddress(1, 1, 1, endColumnNum);
        sheet.addMergedRegion(celltitleNameRangeAddress);

        Row titleNameRow = sheet.createRow(1);
        headerRow.setHeight(Short.parseShort("700"));
        Cell titleNameCell = titleNameRow.createCell(1);
        titleNameCell.setCellValue(titleName);
        titleNameCell.setCellStyle(titleNameCellStyle);


        /* 二级表头 */
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER); // 设置水平居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER); // 设置垂直居中
        XSSFFont xssfFont = workbook.createFont();
        xssfFont.setBold(true); //粗体显示
        xssfFont.setFontName("仿宋_GB2312");
        xssfFont.setFontHeightInPoints((short) 16);
        cellStyle.setFont(xssfFont);

        Row row = sheet.createRow(2);
        row.setHeight(Short.parseShort("700"));


        int columnNum = 0;
        if (hasRowNum) {
            cell = row.createCell(columnNum);
            cell.setCellValue("序号");
            cell.setCellStyle(cellStyle);
            columnNum = 1;
        }

        for (String field : fields) {
            cell = row.createCell(columnNum);
            cell.setCellValue(field);
            cell.setCellStyle(cellStyle);
            columnNum++;
        }
    }


    /***
     * 将文件保持至服务器
     *
     * @author 王大宸
     * @date 2024/5/28 11:20
     * @param diskUri   服务器存储文件地址
     * @param workbook workbook
     * @return void
     */
    private void setUploadToFolder(String diskUri, String fileName, XSSFWorkbook workbook) {
        if (StringUtils.isEmpty(diskUri)) {
            return;
        }
        if (!diskUri.endsWith(DISK_PREFIX)) {
            diskUri += DISK_PREFIX;
        }
        diskUri = diskUri.replaceAll("//", "/");

//        LocalDateTime ldt = LocalDateTime.now();
//        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//        diskUri += pattern.format(ldt) + "/";

        diskUri = diskUri + "/" + fileName;

        String localDateTime = getLocalDateTime();
        localDateTime = localDateTime.replaceAll("-", "")
                .replaceAll(" ", "")
                .replaceAll(":", "");
        diskUri += localDateTime + getUUid() + FILE_NAME_FORMAT;



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

//            setFileDiskUri(diskUri); // 文件磁盘地址
//            setFileUri(fileUri);     // 文件访问地址
//            setFileSize(fileSize);   // 文件大小

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
    private static String loadHttpUri(String mapPath, String diskUri, String diskFolder, String bizHttp) {
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
    private static String mapPath(String path) {
        path = !path.startsWith("/") ? "/" + path : path;
        path = !path.endsWith("/") ? path + "/" : path;
        return path;
    }


    private static String getLocalDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    private static String getUUid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void main(String[] args) {
        System.err.println(getLocalDateTime());
    }

    public Boolean getHasRowNum() {
        return hasRowNum;
    }

    public void setHasRowNum(Boolean hasRowNum) {
        this.hasRowNum = hasRowNum;
    }

    public Boolean getToUpload() {
        return toUpload;
    }

    public void setToUpload(Boolean toUpload) {
        this.toUpload = toUpload;
    }

    public String getFileUri() {
        return fileUri;
    }

    public void setFileUri(String fileUri) {
        this.fileUri = fileUri;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDiskUri() {
        return fileDiskUri;
    }

    public void setFileDiskUri(String fileDiskUri) {
        this.fileDiskUri = fileDiskUri;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }
}
