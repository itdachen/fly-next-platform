package com.github.itdachen.jsoup.mining;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 3-1 探矿权转让公示
 *
 * @author 王大宸
 * @date 2024/8/16 1:25
 */
public class TransferOfExplorationRights2 {

    public static void main(String[] args) throws IOException {

        Map<String, String> cookies = new HashMap<String, String>();
        cookies.put("thor", UUID.randomUUID().toString().replaceAll("-", ""));
        String uri = "https://ky.mnr.gov.cn/zrgs/tkzrgs/202408/t20240813_8995047.htm";
        /* 单个页面 */
        Document document = Jsoup.connect(uri).cookies(cookies).get();
        LinkedHashMap<String, String> hashMap = handler(document);
        System.err.println(hashMap);

    }

    public static LinkedHashMap<String, String> handler(Document document) {
        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
        Elements msoNormal = document.getElementsByClass("MsoNormal");

        /// 转让人名称 转让人统一社会信用代码
        // 受让人名称 受让人统一社会信用代码
        // 项目名称 勘查矿种 转让价格

        String zrr = "", zrrXydm = "", srr = "", srrXydm = "", xmmx = "", kz = "", ja = "";
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
            ) {
                continue;
            }

            String replace = msoNormalElement.replace("</span></span></p>", "")
                    .replace("</span>万元</span></p>", "")
                    .replace("</span> </span></p>", "");
           // System.out.println(replace);

            if (replace.contains("NA_CESSION")  && replace.contains("ko18")) {
                replace = replace.replace("<p style=\"LINE-HEIGHT: 150%; TEXT-INDENT: 32pt; MARGIN: 0cm 0cm 0pt; mso-char-indent-count: 2.0\" class=\"MsoNormal\" __ko__1723429561283=\"ko18\"><span style=\"LINE-HEIGHT: 150%; FONT-FAMILY: 仿宋; FONT-SIZE: 16pt; mso-bidi-font-size: 14.0pt\">名称：<span data-bind=\"text:NA_CESSION\" __ko__1723429561283=\"ko19\">", "");
                System.err.println("出让人名称: " + replace);
                zrr = replace;
                continue;
            }
            if (replace.contains("NA_CESSION_CODE")) {
                replace = replace.replace("<p style=\"LINE-HEIGHT: 150%; TEXT-INDENT: 32pt; MARGIN: 0cm 0cm 0pt; mso-char-indent-count: 2.0\" class=\"MsoNormal\" __ko__1723429561283=\"ko24\"><span style=\"LINE-HEIGHT: 150%; FONT-FAMILY: 仿宋; FONT-SIZE: 16pt; mso-bidi-font-size: 14.0pt\">统一社会信用代码：<span data-bind=\"text:NA_CESSION_CODE\" __ko__1723429561283=\"ko25\">", "");
                replace = replace.replace("<p style=\"LINE-HEIGHT: 150%; TEXT-INDENT: 32pt; MARGIN: 0cm 0cm 0pt; mso-char-indent-count: 2.0\" class=\"MsoNormal\" __ko__1723429561283=\"ko24\"><span style=\"LINE-HEIGHT: 150%; FONT-FAMILY: 仿宋; FONT-SIZE: 16pt; mso-bidi-font-size: 14.0pt\">统一社会信用代码：<span data-bind=\"text:NA_CESSION_CODE\" __ko__1723429561283=\"ko25\">", "");
                System.err.println("出让人统一社会信用代码: " + replace);
                zrrXydm = replace;
                continue;
            }
            if (replace.contains("NA_CESSIONARY")  && replace.contains("ko27")) {
                replace = replace.replace("<p style=\"LINE-HEIGHT: 150%; TEXT-INDENT: 32pt; MARGIN: 0cm 0cm 0pt; mso-char-indent-count: 2.0\" class=\"MsoNormal\" __ko__1723429561283=\"ko27\"><span style=\"LINE-HEIGHT: 150%; FONT-FAMILY: 仿宋; FONT-SIZE: 16pt; mso-bidi-font-size: 14.0pt\">名称：<span data-bind=\"text:NA_CESSIONARY\" __ko__1723429561283=\"ko28\">", "");
                System.err.println("受让人名称: " + replace);
                srr = replace;
                continue;
            }


            if (replace.contains("NA_CESSIONARY_CODE")) {
                replace = replace.replace("<p style=\"LINE-HEIGHT: 150%; TEXT-INDENT: 32pt; MARGIN: 0cm 0cm 0pt; mso-char-indent-count: 2.0\" class=\"MsoNormal\" __ko__1723429561283=\"ko33\"><span style=\"LINE-HEIGHT: 150%; FONT-FAMILY: 仿宋; FONT-SIZE: 16pt; mso-bidi-font-size: 14.0pt\">统一社会信用代码：<span data-bind=\"text:NA_CESSIONARY_CODE\" __ko__1723429561283=\"ko34\">", "");
                System.err.println("受让人统一社会信用代码: " + replace);
                srrXydm = replace;
                continue;
            }

            if (replace.contains("NA_APP_NAME")) {
                replace = replace.replace("<p style=\"LINE-HEIGHT: 150%; TEXT-INDENT: 32pt; MARGIN: 0cm 0cm 0pt; mso-char-indent-count: 2.0\" class=\"MsoNormal\" __ko__1723429561283=\"ko37\"><span style=\"LINE-HEIGHT: 150%; FONT-FAMILY: 仿宋; FONT-SIZE: 16pt; mso-bidi-font-size: 14.0pt\"><span data-bind=\"text:APP_CATEGORY.indexOf('采矿权')>-1?'矿山':'项目'\" __ko__1723429561283=\"ko38\">项目</span>名称：<span data-bind=\"    text:NA_APP_NAME\" __ko__1723429561283=\"ko39\">", "");
                System.err.println("矿山/项目名称: " + replace);
                xmmx = replace;
                continue;
            }
            if (replace.contains("MAIN_MINE_Name")) {
                replace = replace.replace("<p style=\"LINE-HEIGHT: 150%; TEXT-INDENT: 32pt; MARGIN: 0cm 0cm 0pt; mso-char-indent-count: 2.0\" class=\"MsoNormal\" __ko__1723429561283=\"ko43\"><span style=\"LINE-HEIGHT: 150%; FONT-FAMILY: 仿宋; FONT-SIZE: 16pt; mso-bidi-font-size: 14.0pt\"><span data-bind=\"text:APP_CATEGORY.indexOf('采矿权')>-1?'采矿':'勘查'\" __ko__1723429561283=\"ko44\">勘查</span>矿种：<span data-bind=\"    text:MAIN_MINE_Name\" __ko__1723429561283=\"ko45\">", "");
                System.err.println("勘查矿种: " + replace);
                kz = replace;
                continue;
            }

            if (replace.contains("QT_CESSION_PRICE")) {
                replace = replace.replace("名称：<span data-bind=\"text:NA_CESSION\" __ko__1723429561283=\"ko19\">", "");
                replace = replace.replace("</span> 万元</span></p>", "");
                replace = replace.replace("<p style=\"LINE-HEIGHT: 150%; TEXT-INDENT: 32pt; MARGIN: 0cm 0cm 0pt; mso-char-indent-count: 2.0\" class=\"MsoNormal\" __ko__1723429561283=\"ko118\"><span style=\"LINE-HEIGHT: 150%; FONT-FAMILY: 仿宋; FONT-SIZE: 16pt; mso-bidi-font-size: 14.0pt\">转让价格：<span data-bind=\"text:QT_CESSION_PRICE\" __ko__1723429561283=\"ko119\">", "");
                System.err.println("转让价格: " + replace);
                ja = replace;
            }

        }


        hashMap.put("zrr", zrr);
        hashMap.put("zrrXydm", zrrXydm);
        hashMap.put("srr", srr);
        hashMap.put("srrXydm", srrXydm);
        hashMap.put("xmmx", xmmx);
        hashMap.put("kz", kz);
        hashMap.put("ja", ja);
        return hashMap;

    }


}
