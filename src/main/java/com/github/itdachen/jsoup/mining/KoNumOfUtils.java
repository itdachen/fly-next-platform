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

    public static String indexOf(String str) {
        List<String> strings = koNumList();
        for (String string : strings) {
            string = "=\"ko" + string + "\">";
            int p = str.indexOf(string);
            if (0 < p) {
                str = str.substring(p + 8);
            }
        }

        return str;
    }

    public static String indexOf(String str,  List<String> koNumList) {
        for (String string : koNumList) {
            string = "=\"ko" + string + "\">";
            int p = str.indexOf(string);
            if (0 < p) {
                str = str.substring(p + 8);
            }
        }

        return str;
    }


    public static List<String> koNumList() {
        List<String> koNumList = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            koNumList.add(String.valueOf(i + 1));
        }

        return koNumList;
    }


}
