package com.github.itdachen.jsoup.mining;

import java.util.ArrayList;
import java.util.List;

/**
 * KoNumOfUtils
 *
 * @author 王大宸
 * @date 2024/8/18 23:42
 */
public class KoNumOfUtils {

    private static final List<String> KO_NUM_LIST = new ArrayList<>();
    private static final List<String> FIELD_LIST = new ArrayList<>(); // field

    static {
        /* ko 数字 */
        for (int i = 0; i < 5000; i++) {
            KO_NUM_LIST.add(String.valueOf(i + 1));
        }

        /* 结尾字段 */
        FIELD_LIST.add("text:NA_CESSION\">");
        FIELD_LIST.add("text:NA_CESSIONARY\">");
        FIELD_LIST.add("text:NA_CESSIONARY_CODE\">");
        FIELD_LIST.add("text:NA_CESSION_CODE\">");
        FIELD_LIST.add("text:MAIN_MINE_Name\">");
        FIELD_LIST.add("text: NA_APP_NAME\">");
        FIELD_LIST.add("text: MAIN_MINE_Name\">");
        FIELD_LIST.add("text: NA_TRANSFER_PERSON\">");
        FIELD_LIST.add("text: NA_CAPITAL_PERSON\">");
        FIELD_LIST.add("text: NA_CAPITAL_CODE\">");
        FIELD_LIST.add("text: MAIN_MINE_Name\">");
        FIELD_LIST.add("text: NA_PERAMBULATE_GRADE\">");
        FIELD_LIST.add("text: QT_TOTAL_AREA\\\">\"");
        FIELD_LIST.add("text:NA_APP_NAME\">");
        FIELD_LIST.add("text:QT_CESSION_PRICE\">");


        FIELD_LIST.add("format('yyyy年MM月dd日')\"");
        FIELD_LIST.add("14.0pt;\">");
        FIELD_LIST.add("矿种：");


    }

    public static String cleanHandle(String str) {
        for (int i = 0; i < 20; i++) {
            str = indexOf(str);
        }

        for (int i = 0; i < 20; i++) {
            str = replaceStr(str);
        }

        return str;
    }


    public static String indexOf(String str) {
        int p = -1, length = 0;
        for (String string : KO_NUM_LIST) {
            string = "=\"ko" + string + "\">";
            p = str.indexOf(string);
            if (p == -1) {
                continue;
            }
            length = p + string.length();
            str = str.substring(length);
        }
        return str;
    }

    public static String replaceStr(String str) {
        int length = 0, p = -1;
        for (String string : FIELD_LIST) {
            p = str.indexOf(string);  // 得到字符串错在位置
            if (-1 == p) {
                continue;
            }
            //  str = str.substring(length);
            //         int i = value.indexOf(str);
            //        i = i + str.length();
            length = string.length(); // 得到字符串的长度
            p = p + length; // 字符串所在位置加上所在长度, 则是截取位置
            str = str.substring(p);
        }
        return str;
    }


    public static void main(String[] args) {
        // 14.0pt">
        String str = "14.0pt\">";
        String value = "ize: 14.0pt\">陕西省凤县邓家沟金矿普查";

        int i = value.indexOf(str);
        i = i + str.length();
        System.out.println(value.substring(i));

    }

}
