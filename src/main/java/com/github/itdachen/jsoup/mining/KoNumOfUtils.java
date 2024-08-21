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
        for (int i = 0; i < 1000; i++) {
            KO_NUM_LIST.add(String.valueOf(i + 1));
        }

        /* 结尾字段 */
        FIELD_LIST.add("text:NA_CESSION\">");
        FIELD_LIST.add("text:NA_CESSIONARY\">");
        FIELD_LIST.add("text:NA_CESSION_CODE\">");
        FIELD_LIST.add("text:NA_CESSIONARY\">");

    }


    public static String indexOf(String str) {
        for (String string : KO_NUM_LIST) {
            string = "=\"ko" + string + "\">";
            int p = str.indexOf(string);
            if (0 < p) {
                str = str.substring(p + 8);
            }
        }
        return str;
    }

    public static String replaceStr(String str) {
        int length = 0;
        for (String string : FIELD_LIST) {
            length = string.length();
            int p = str.indexOf(string);
            if (0 < p) {
                str = str.substring(length);
            }
        }
        return str;
    }

}
