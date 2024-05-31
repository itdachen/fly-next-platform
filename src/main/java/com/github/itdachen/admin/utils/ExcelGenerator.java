package com.github.itdachen.admin.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

import static cn.hutool.core.text.StrPool.CRLF;

/**
 * 生成excel 上传到服务器
 *
 * @author 王大宸
 * @date 2024-05-27 16:40
 */
public class ExcelGenerator {

    public static void main(String[] args) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("ExampleSheet");

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Hello World");

        // 将Excel写入文件系统
        FileOutputStream fileOut = new FileOutputStream("example.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        // 上传到服务器的方法
        uploadToServer("example.xlsx", "http://yourserver.com/upload");
    }

    private static void uploadToServer(String filePath, String uploadUrl) throws IOException {
        File file = new File(filePath);
        HttpURLConnection connection = (HttpURLConnection) new URL(uploadUrl).openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "multipart/form-data");

        // Prepare the form data
        String boundary = Long.toHexString(System.currentTimeMillis());
        connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

        try (
                OutputStream output = connection.getOutputStream();
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(output, "UTF-8"), true);
        ) {
            // Send normal param
            writer.append("--" + boundary).append(CRLF);
            writer.append("Content-Disposition: form-data; name=\"param\"").append(CRLF);
            writer.append(CRLF).append("value").append(CRLF).flush();

            // Send file
            writer.append("--" + boundary).append(CRLF);
            writer.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + file.getName() + "\"").append(CRLF);
            writer.append("Content-Type: " + URLConnection.guessContentTypeFromName(file.getName())).append(CRLF);
            writer.append(CRLF).flush();

            Files.copy(file.toPath(), output);
            output.flush(); // flush output before continuing

            writer.append(CRLF).flush(); // CRLF is important! It indicates end of binary boundary.

            // End of multipart form data
            writer.append("--" + boundary + "--").append(CRLF).flush();
        }

        int responseCode = connection.getResponseCode();
        System.out.println("Upload done. Server response: " + responseCode);
    }

}
