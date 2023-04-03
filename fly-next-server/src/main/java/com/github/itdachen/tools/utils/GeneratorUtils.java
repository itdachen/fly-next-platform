package com.github.itdachen.tools.utils;

import org.apache.commons.lang.WordUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description:
 * Created by 王大宸 on 2022-06-20 16:57
 * Created with IntelliJ IDEA.
 */
public class GeneratorUtils {
    private static final Logger logger = LoggerFactory.getLogger(GeneratorUtils.class);
    private static final Snowflake snowflake = new Snowflake(1, 1, 0L);
    /** 下划线 */
    private static final char SEPARATOR = '_';

    public static String getId() {
        return String.valueOf(snowflake.nextId());
    }

    /**
     * 列名转换成 Java 属性名
     */
    public static String columnToJava(String columnName) {
        return WordUtils.capitalizeFully(columnName, new char[]{'_'}).replace("_", "");
    }

    /**
     * 表名转换成 Java 类名
     */
    public static String tableToJava(String tableName, String tablePrefix) {
        if (StringUtils.isNotBlank(tablePrefix)) {
            tableName = tableName.replace(tablePrefix, "");
        }
        return columnToJava(tableName);
    }

    /***
     * 功能说明：获取权限前缀
     *
     * @author 王大宸
     * @date 2020/11/12 0:22
     * @param moduleName      模块名称
     * @param clazzName       java 类名
     * @return java.lang.String
     */
    public static String getPermissionPrefix(String moduleName, String clazzName) {
        StringBuilder stringBuilder = new StringBuilder();
        if (StringUtils.isNotEmpty(moduleName)) {
            stringBuilder.append(moduleName).append(":");
        }
        for (int i = 0; i < clazzName.length(); i++) {
            char c = clazzName.charAt(i);
            if (Character.isUpperCase(c)) {
                stringBuilder.append(":").append(Character.toLowerCase(c));
                continue;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    /**
     * 驼峰式命名法 例如：user_name->userName
     */
    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == SEPARATOR) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String s = "sysUser";
        System.err.println("tableToJava: " + toCamelCase("sys_user"));
        System.err.println(getPermissionPrefix("base", s));
    }

}
