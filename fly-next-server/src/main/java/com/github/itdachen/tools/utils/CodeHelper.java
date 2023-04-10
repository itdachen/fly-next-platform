package com.github.itdachen.tools.utils;

import com.github.itdachen.framework.core.constants.Constants;
import com.github.itdachen.tools.sdk.vo.TableInfoVo;
import org.apache.commons.io.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * Description:
 * Created by 王大宸 on 2023/04/10 22:44
 * Created with IntelliJ IDEA.
 */
public class CodeHelper {
    private static final Logger logger = LoggerFactory.getLogger(CodeHelper.class);

    /***
     * 下载代码
     *
     * @author 王大宸
     * @date 2023/4/10 23:03
     * @param tableNames tableNames
     * @param response response
     * @return void
     */
    public static void downloadCode(List<TableInfoVo> tableNames,
                                    HttpServletResponse response) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        VelocityInitializer.initVelocity();
        for (TableInfoVo tableName : tableNames) {
            GeneratorUtils.generatorCode(tableName, zip);
        }
        IOUtils.closeQuietly(zip);
        byte[] data = outputStream.toByteArray();

        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=home-admin.zip");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }

    /***
     * 预览代码
     *
     * @author 王大宸
     * @date 2023/4/10 23:03
     * @param tableInfoVo tableInfoVo
     * @return java.util.Map<java.lang.String, java.lang.String>
     */
    public static Map<String, String> previewCode(TableInfoVo tableInfoVo) {
        Map<String, String> dataMap = new LinkedHashMap<>();
        // 设置主键列信息
        PkColumnUtils.setPkColumn(tableInfoVo);
        VelocityInitializer.initVelocity();

        VelocityContext context = VelocityUtils.prepareContext(tableInfoVo);

        // 获取模板列表
        List<String> templates = VelocityUtils.getTemplateList(tableInfoVo.getTplCategory(), tableInfoVo.getUiStyle());
        StringWriter sw;
        Template tpl;
        for (String template : templates) {
            // 渲染模板
            sw = new StringWriter();
            tpl = Velocity.getTemplate(template, Constants.UTF8);
            tpl.merge(context, sw);
            dataMap.put(template, sw.toString());
        }
        return dataMap;
    }


}
