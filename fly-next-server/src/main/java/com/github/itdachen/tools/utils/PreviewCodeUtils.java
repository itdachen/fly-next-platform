package com.github.itdachen.tools.utils;

import com.github.itdachen.framework.core.constants.Constants;
import com.github.itdachen.tools.sdk.vo.TableInfoVo;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 预览代码
 * Created by 王大宸 on 2023/04/10 21:56
 * Created with IntelliJ IDEA.
 */
public class PreviewCodeUtils {

    public static Map<String, String> previewCode(TableInfoVo tableInfoVo) {
        Map<String, String> dataMap = new LinkedHashMap<>();
        // 设置主键列信息
        PkColumnUtils.setPkColumn(tableInfoVo);
        VelocityInitializer.initVelocity();

        VelocityContext context = VelocityUtils.prepareContext(tableInfoVo);

        // 获取模板列表
        List<String> templates = VelocityUtils.getTemplateList(tableInfoVo.getTplCategory());
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
