package com.github.itdachen.jsoup.mining;

import com.github.itdachen.jsoup.XSSFWorkBookExpHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

/**
 * 3-2 采矿权转让公示
 *
 * @author 王大宸
 * @date 2024/8/16 1:53
 */
public class TransferOfMiningRights3_2 {
    private static final String URI_PREFIX = "https://ky.mnr.gov.cn/zrgs/ckzrgs";

    public static void main(String[] args) throws Exception {

//        Map<String, String> cookies = new HashMap<String, String>();
//        cookies.put("thor", UUID.randomUUID().toString().replaceAll("-", ""));
//        String uri = "https://ky.mnr.gov.cn/zrgs/ckzrgs/202408/t20240813_8995046.htm";
//        LinkedHashMap<String, String> hashMap = handler(uri);
//        System.err.println(hashMap);


        List<String> uriList = new ArrayList<>();
        uriList.add("https://ky.mnr.gov.cn/zrgs/ckzrgs/index.htm");
        for (int i = 1; i < 4; i++) {
            uriList.add("https://ky.mnr.gov.cn/zrgs/ckzrgs/index_" + i + ".htm");
        }

        List<LinkedHashMap<String, String>> hashMaps = new ArrayList<>();
        LinkedHashMap<String, String> hashMap = null;
        for (String uri : uriList) {
            Document document = Jsoup.connect(uri).get();
            Elements clearfix = document.getElementsByClass("gu-kqgglist-section clearfix");

            Elements liList = clearfix.select("li a");

            List<String> uris = new ArrayList<>();
            for (Element element : liList) {
                String stringUri = element.toString();
                String replace = stringUri.replace("<a href=\".", "");

                stringUri = URI_PREFIX + replace.substring(0, stringUri.indexOf(".htm")) + ".htm";
                stringUri = stringUri.replace("\" targ.htm", "");
                uris.add(stringUri);
            }


            for (String s : uris) {
                hashMap = handler(s);
                if (null == hashMap) {
                    continue;
                }
                hashMaps.add(hashMap);
            }
        }

        exp(hashMaps);


    }

    public static LinkedHashMap<String, String> handler(String uri) throws IOException {
        //   System.out.println("访问链接: " + uri);
        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();

        Document document = Jsoup.connect(uri).get();

        Elements msoNormal = document.getElementsByClass("MsoNormal");

        // 转让人名称 转让人统一社会信用代码
        //受让人名称 受让人统一社会信用代码
        // 矿山名称 采矿矿种 开采范围 转让价格 转让方式

        String zrr = "", zrrXydm = "", srr = "", srrXydm = "", ksmx = "", kz = "", kcfw = "", ja = "", fs = "";
        for (Element element : msoNormal) {
            String msoNormalElement = element.toString();

            if (!msoNormalElement.contains("data-bind=\"text:")) {
                continue;
            }
            if (msoNormalElement.contains("公示时间")) {
                continue;
            }

            if (!msoNormalElement.contains("名称：")
                    && !msoNormalElement.contains("统一社会信用代码：")
                    && !msoNormalElement.contains("项目名称：")
                    && !msoNormalElement.contains("矿种：")
                    && !msoNormalElement.contains("价格：")
                    && !msoNormalElement.contains("范围：面积")
                    && !msoNormalElement.contains("方式：")
            ) {
                continue;
            }

            String replace = msoNormalElement.replace("</span></span></p>", "")
                    .replace("</span>万元</span></p>", "")
                    .replace("</span> </span></p>", "");
//            System.out.println();
//            System.out.println(replace);

            if (replace.contains("NA_CESSION") && replace.contains("ko19")) {
                replace = replace.replace("<p class=\"MsoNormal\" style=\"MARGIN: 0cm 0cm 0pt; LINE-HEIGHT: 150%; TEXT-INDENT: 32pt; mso-char-indent-count: 2.0\" __ko__1723450505621=\"ko18\"><span style=\"FONT-SIZE: 16pt; FONT-FAMILY: 仿宋; LINE-HEIGHT: 150%; mso-bidi-font-size: 14.0pt\">名称：<span data-bind=\"text:NA_CESSION\" __ko__1723450505621=\"ko19\">", "");
                replace = replace.replace("<p style=\"LINE-HEIGHT: 150%; TEXT-INDENT: 32pt; MARGIN: 0cm 0cm 0pt; mso-char-indent-count: 2.0\" class=\"MsoNormal\" __ko__1723804348621=\"ko18\"><span style=\"LINE-HEIGHT: 150%; FONT-FAMILY: 仿宋; FONT-SIZE: 16pt; mso-bidi-font-size: 14.0pt\">名称：<span data-bind=\"text:NA_CESSION\" __ko__1723804348621=\"ko19\">", "");
                replace = KoNumOfUtils.indexOf(replace);
                //  System.err.println("出让人名称: " + replace);
                zrr = replace;
                continue;
            }
            if (replace.contains("NA_CESSION_CODE")) {
                replace = replace.replace("<p class=\"MsoNormal\" style=\"MARGIN: 0cm 0cm 0pt; LINE-HEIGHT: 150%; TEXT-INDENT: 32pt; mso-char-indent-count: 2.0\" __ko__1723450505621=\"ko24\"><span style=\"FONT-SIZE: 16pt; FONT-FAMILY: 仿宋; LINE-HEIGHT: 150%; mso-bidi-font-size: 14.0pt\">统一社会信用代码：<span data-bind=\"text:NA_CESSION_CODE\" __ko__1723450505621=\"ko25\">", "");
                //  System.err.println("出让人统一社会信用代码: " + replace);

                // NA_CESSION_CODE">
                int p = replace.indexOf("NA_CESSION_CODE\">");
                if (0 < p) {
                    replace = replace.substring(p + 17);
                }
                replace = KoNumOfUtils.indexOf(replace);
                zrrXydm = replace;
                continue;
            }
            if (replace.contains("NA_CESSIONARY") && replace.contains("ko28")) {
                replace = replace.replace("<p class=\"MsoNormal\" style=\"MARGIN: 0cm 0cm 0pt; LINE-HEIGHT: 150%; TEXT-INDENT: 32pt; mso-char-indent-count: 2.0\" __ko__1723450505621=\"ko27\"><span style=\"FONT-SIZE: 16pt; FONT-FAMILY: 仿宋; LINE-HEIGHT: 150%; mso-bidi-font-size: 14.0pt\">名称：<span data-bind=\"text:NA_CESSIONARY\" __ko__1723450505621=\"ko28\">", "");
                //  System.err.println("受让人名称: " + replace);
                replace = KoNumOfUtils.indexOf(replace);
                srr = replace;
                continue;
            }


            if (replace.contains("NA_CESSIONARY_CODE")) {
                replace = replace.replace("<p class=\"MsoNormal\" style=\"MARGIN: 0cm 0cm 0pt; LINE-HEIGHT: 150%; TEXT-INDENT: 32pt; mso-char-indent-count: 2.0\" __ko__1723450505621=\"ko33\"><span style=\"FONT-SIZE: 16pt; FONT-FAMILY: 仿宋; LINE-HEIGHT: 150%; mso-bidi-font-size: 14.0pt\">统一社会信用代码：<span data-bind=\"text:NA_CESSIONARY_CODE\" __ko__1723450505621=\"ko34\">", "");
                //  System.err.println("受让人统一社会信用代码: " + replace);
                replace = KoNumOfUtils.indexOf(replace);
                // CESSIONARY_CODE">
                int p = replace.indexOf("CESSIONARY_CODE\">");
                if (0 < p) {
                    replace = replace.substring(p + 17);
                }
                srrXydm = replace;
                continue;
            }

            if (replace.contains("NA_APP_NAME")) {
                replace = replace.replace("<p class=\"MsoNormal\" style=\"MARGIN: 0cm 0cm 0pt; LINE-HEIGHT: 150%; TEXT-INDENT: 32pt; mso-char-indent-count: 2.0\" __ko__1723450505621=\"ko37\"><span style=\"FONT-SIZE: 16pt; FONT-FAMILY: 仿宋; LINE-HEIGHT: 150%; mso-bidi-font-size: 14.0pt\"><span data-bind=\"text:APP_CATEGORY.indexOf('采矿权')>-1?'矿山':'项目'\" __ko__1723450505621=\"ko38\">矿山</span>名称：<span data-bind=\"    text:NA_APP_NAME\" __ko__1723450505621=\"ko39\">", "");
                replace = replace.replace("<p class=\"MsoNormal\" style=\"MARGIN: 0cm 0cm 0pt; LINE-HEIGHT: 150%; TEXT-INDENT: 32pt; mso-char-indent-count: 2.0\" __ko__1707052034329=\"ko29\"><span style=\"FONT-SIZE: 16pt; FONT-FAMILY: 仿宋; LINE-HEIGHT: 150%; mso-bidi-font-size: 14.0pt\"><span data-bind=\"text:APP_CATEGORY.indexOf('采矿权')>-1?'项目':'项目'\" __ko__1707052034329=\"ko30\">项目</span>名称：<span data-bind=\"text:NA_APP_NAME\" __ko__1707052034329=\"ko31\">", "");
                replace = KoNumOfUtils.indexOf(replace);

                //   NA_APP_NAME">
                int p = replace.indexOf("NA_APP_NAME\">");
                if (0 < p) {
                    replace = replace.substring(p + 13);
                }
                //   System.err.println("矿山名称: " + replace);
                ksmx = replace;
                continue;
            }
            if (replace.contains("MAIN_MINE_Name")) {
                replace = replace.replace("<p class=\"MsoNormal\" style=\"MARGIN: 0cm 0cm 0pt; LINE-HEIGHT: 150%; TEXT-INDENT: 32pt; mso-char-indent-count: 2.0\" __ko__1723450505621=\"ko43\"><span style=\"FONT-SIZE: 16pt; FONT-FAMILY: 仿宋; LINE-HEIGHT: 150%; mso-bidi-font-size: 14.0pt\"><span data-bind=\"text:APP_CATEGORY.indexOf('采矿权')>-1?'采矿':'勘查'\" __ko__1723450505621=\"ko44\">采矿</span>矿种：<span data-bind=\"    text:MAIN_MINE_Name\" __ko__1723450505621=\"ko45\">", "");
                // System.err.println("勘查矿种: " + replace);
                replace = KoNumOfUtils.indexOf(replace);


                int  n = replace.indexOf("MAIN_MINE_Name\">"); //  MAIN_MINE_Name">
                if (0 < n) {
                    replace = replace.substring(n + 16);
                }
                kz = replace;
                continue;
            }

            if (replace.contains("QT_CESSION_PRICE")) {
                replace = replace.replace("<p class=\"MsoNormal\" style=\"MARGIN: 0cm 0cm 0pt; LINE-HEIGHT: 150%; TEXT-INDENT: 32pt; mso-char-indent-count: 2.0\" __ko__1723450505621=\"ko188\"><span style=\"FONT-SIZE: 16pt; FONT-FAMILY: 仿宋; LINE-HEIGHT: 150%; mso-bidi-font-size: 14.0pt\">转让价格：<span data-bind=\"text:QT_CESSION_PRICE\" __ko__1723450505621=\"ko189\">", "");
                replace = replace.replace("</span> 万元</span></p>", "");

                replace = KoNumOfUtils.indexOf(replace);
                int n = replace.indexOf("14.0pt\">"); //  14.0pt">
                if (0 < n) {
                    replace = replace.substring(n + 29);
                }
                n = replace.indexOf("_CESSION_PRICE\">"); //  _CESSION_PRICE">
                if (0 < n) {
                    replace = replace.substring(n + 16);
                }

                //  System.err.println("转让价格: " + replace);
                ja = replace;
            }
            if (replace.contains("QT_TOTAL_AREA")) {
                replace = replace.replace("<p class=\"MsoNormal\" style=\"MARGIN: 0cm 0cm 0pt; LINE-HEIGHT: 150%; TEXT-INDENT: 32pt; mso-char-indent-count: 2.0\" __ko__1723450505621=\"ko53\"><span style=\"FONT-SIZE: 16pt; FONT-FAMILY: 仿宋; LINE-HEIGHT: 150%; mso-bidi-font-size: 14.0pt\"><span data-bind=\"text:APP_CATEGORY.indexOf('采矿权')>-1?'开采':'勘查'\" __ko__1723450505621=\"ko54\">开采</span>范围：面积<span data-bind=\"    text:QT_TOTAL_AREA\" __ko__1723450505621=\"ko55\">", "")
                        .replace("</span>平方千米，拐点坐标如下（2000国家大地坐标）：</span></p>", "");
                //  System.err.println("开采范围: " + replace);
                replace = KoNumOfUtils.indexOf(replace);

                // QT_TOTAL_AREA">
                int n = replace.indexOf("QT_TOTAL_AREA\">");
                if (0 < n) {
                    replace = replace.substring(n + 15);
                }
                replace = replace.replace("转让价格：<span data-bind=\"text:QT_CESSION_PRICE\">", "");
                kcfw = replace;
            }
            if (replace.contains("IN_CESSION_STYLE_NAME")) {
                replace = KoNumOfUtils.indexOf(replace);
                int n = replace.indexOf("STYLE_NAME\">");
                if (0 < n) {
                    replace = replace.substring(n + 13);
                }
                replace = replace.replace(">","");

                // System.err.println("转让方式: " + replace);
                fs = replace;
            }

        }


        hashMap.put("zrr", zrr);
        hashMap.put("zrrXydm", zrrXydm);
        hashMap.put("srr", srr);
        hashMap.put("srrXydm", srrXydm);
        hashMap.put("ksmx", ksmx);
        hashMap.put("kz", kz);
        hashMap.put("kcfw", kcfw);
        hashMap.put("ja", ja);
        hashMap.put("fs", fs);
        return hashMap;

    }


    // 转让人名称 转让人统一社会信用代码
    //受让人名称 受让人统一社会信用代码
    // 矿山名称 采矿矿种 开采范围 转让价格
    public static void exp(List<LinkedHashMap<String, String>> dataList) throws Exception {
        List<String> fields = new ArrayList<>();
        fields.add("转让人名称");
        fields.add("转让人统一社会信用代码");
        fields.add("受让人名称");
        fields.add("受让人统一社会信用代码");
        fields.add("矿山名称");
        fields.add("采矿矿种");
        fields.add("开采范围");
        fields.add("转让价格");
        fields.add("转让方式");
        // 项目名称 开采矿种 中标人/竞得人  成交时间  统一社会信用代码 成交价 缴纳方式 缴纳时间
        XSSFWorkBookExpHelper workBookExpHelper = new XSSFWorkBookExpHelper();
        workBookExpHelper.expHandler(fields,
                dataList,
                "3-1采矿权转让公示",
                true,
                "D:/upload/");

    }


}
