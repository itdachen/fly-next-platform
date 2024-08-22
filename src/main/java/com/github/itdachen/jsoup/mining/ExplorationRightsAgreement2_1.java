package com.github.itdachen.jsoup.mining;

import com.github.itdachen.jsoup.XSSFWorkBookExpHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

/**
 * 二、探矿权协议出让公示
 * 探矿权协议出让公示
 *
 * @author 王大宸
 * @date 2024/8/16 0:55
 */
public class ExplorationRightsAgreement2_1 {
    private static final String URI_PREFIX = "https://ky.mnr.gov.cn/xycrgs/ckq/";


    public static void main(String[] args) throws Exception {
        Document document = Jsoup.connect(URI_PREFIX).get();
        Elements clearfix = document.getElementsByClass("gu-kqgglist-section clearfix");
        Elements liList = clearfix.select("li a");

        List<LinkedHashMap<String, String>> hashMaps = new ArrayList<>();
        LinkedHashMap<String, String> hashMap = null;

        List<String> uris = new ArrayList<>();
        for (Element element : liList) {
            String stringUri = element.toString();
            String replace = stringUri.replace("<a href=\".", "");

            stringUri = URI_PREFIX + replace.substring(0, stringUri.indexOf(".htm")) + ".htm";
            stringUri = stringUri.replace("\" targ.htm", "");
            uris.add(stringUri);
            // System.err.println(stringUri);
        }
        Document uriDocument;
        Elements msoNormal;
        for (String uri : uris) {
            uriDocument = Jsoup.connect(uri).get();
            msoNormal = uriDocument.getElementsByClass("MsoNormal");
            if (!msoNormal.isEmpty()) {
                hashMap = handler(msoNormal, uri);
                hashMaps.add(hashMap);
                continue;
            }

            Elements p = uriDocument.getElementsByTag("p");
            if (!p.isEmpty()) {
                hashMap = pHandler(p, uri);
                hashMaps.add(hashMap);
            }
        }


        exp(hashMaps);
    }


    public static LinkedHashMap<String, String> pHandler(Elements msoNormal, String uri) throws IOException {
        String crr = "", srr = "", xydm = "", xmmx = "", kz = "", kcgm = "", mj = "";
        int index = 0;
        for (Element element : msoNormal) {
            String msoNormalElement = element.toString();
            if (msoNormalElement.contains("公示时间")
                    || msoNormalElement.contains("本公示在")
                    || msoNormalElement.contains("出让公示")
                    || msoNormalElement.contains("公示文号")
                    || msoNormalElement.contains("公示如下")
                    || msoNormalElement.contains("出让人")
                    || msoNormalElement.contains("受让人")
                    || msoNormalElement.contains("符合协议出让规定的情形及理由")
                    || msoNormalElement.contains("对公示内容提出异议的方式及途径")
                    || msoNormalElement.contains("<p style=\"text-align: center;\">")
                    || msoNormalElement.startsWith("<p style=\"text-align: center;\">")
            ) {
                continue;
            }


            if (!msoNormalElement.contains("名称：") // 名称 出让人 名称 / 受让人  名称
                    && !msoNormalElement.contains("统一社会信用代码：") // 统一社会信用代码
                    && !msoNormalElement.contains("项目名称：")
                    && !msoNormalElement.contains("规模：")
                    && !msoNormalElement.contains("面积：")
                    && !msoNormalElement.contains("矿种：")
                    && !msoNormalElement.contains("规模：")
                    && !msoNormalElement.contains("平方千米")

            ) {
                continue;
            }

            String replace = msoNormalElement.replace("<p style=\"line-height: 150%; margin: 0cm 0cm 0pt; text-indent: 30pt; font-size: 15pt; font-family: 仿宋_GB2312;\">", "");
            replace = replace.replace("</span></p>", "");

            /* 出让人名称 */
            if (0 == index) {
                replace = replace.replace("名称： <span>", "");
                crr = replace;
            }
            /* 受让人名称 */
            if (1 == index) {
                replace = replace.replace("名称： <span>", "");
                srr = replace;
            }
            /* 统一社会信用代码 */
            if (2 == index) {
                replace = replace.replace("统一社会信用代码： <span>", "");
                xydm = replace;
            }

            /* 矿山/项目名称 */
            if (3 == index) {
                replace = replace.replace("项目名称： <span>", "");
                replace = replace.replace("矿山名称： <span>", "");
                xydm = replace;
            }

            /* 开采/勘查矿种 */
            if (4 == index) {
                replace = replace.replace("开采矿种： <span>", "");
                kz = replace;
            }

            /* 开采规模 */
            if (5 == index) {
                replace = replace.replace("开采规模： <span>", "");
                kcgm = replace;
            }
            /* 面积(平方千米) */
            if (6 == index) {
                replace = replace.replace("面积： <span>", "")
                        .replace("</span>平方千米，拐点范围坐标（2000国家大地坐标）： </p>", "");
                kcgm = replace;
            }

            index++;
        }

        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
        hashMap.put("crr", crr);
        hashMap.put("srr", srr);
        hashMap.put("xydm", xydm);
        hashMap.put("xmmx", xmmx);
        hashMap.put("kz", kz);
        hashMap.put("kcgm", kcgm);
        hashMap.put("mj", mj);
        hashMap.put("q", uri);
        return hashMap;
    }


    public static LinkedHashMap<String, String> handler(Elements msoNormal, String uri) throws IOException {
        String crr = "", srr = "", xydm = "", xmmx = "", kz = "", kcgm = "", mj = "";
        for (Element element : msoNormal) {
            String msoNormalElement = element.toString();
            if (msoNormalElement.contains("公示时间")
                    || msoNormalElement.contains("本公示在")
            ) {
                continue;
            }

            if (!msoNormalElement.contains("名称：") // 名称 出让人 名称 / 受让人  名称
                    && !msoNormalElement.contains("统一社会信用代码：") // 统一社会信用代码
                    && !msoNormalElement.contains("项目名称：")
                    && !msoNormalElement.contains("规模：")
                    && !msoNormalElement.contains("面积：")
                    && !msoNormalElement.contains("矿种：")
                    && !msoNormalElement.contains("规模：")
                    && !msoNormalElement.contains("平方千米")

            ) {
                continue;
            }

            String replace = msoNormalElement.replace("</span></span></p>", "")
                    .replace("</span>万元</span></p>", "")
                    .replace("</span> </span></p>", "");

            /* 出让人名称 */
            if (replace.contains("text: NA_TRANSFER_PERSON")) {
                replace = KoNumOfUtils.cleanHandle(replace);
                crr = replace;
                continue;
            }
            /* 受让人名称 */
            if (replace.contains("text: NA_CAPITAL_PERSON")) {
                replace = KoNumOfUtils.cleanHandle(replace);
                replace = replace.replace("名称：<span data-bind=\"text: NA_CAPITAL_PERSON\">", "");
                // System.err.println("受让人名称: " + replace);
                srr = replace;
                continue;
            }
            if (replace.contains("text: NA_CAPITAL_CODE")) {
                replace = KoNumOfUtils.cleanHandle(replace);
                replace = replace.replace("统一社会信用代码：<span data-bind=\"text: NA_CAPITAL_CODE\">", "")
                        .replace("</span> </span></p>", "");
                //  System.err.println("统一社会信用代码: " + replace);
                xydm = replace;
                continue;
            }
            if (replace.contains("text: NA_APP_NAME")) {
                replace = KoNumOfUtils.cleanHandle(replace);
                replace = replace.replace("<span data-bind=\"text: $parent.APP_CATEGORY.indexOf('采矿权') > -1 ? '矿山' : '项目'\">项目</span>名称：<span data-bind=\"    text: NA_APP_NAME\">", "")
                        .replace("</span> </span></p>", "");
                //  System.err.println("矿山/项目名称: " + replace);
                xmmx = replace;
                continue;
            }
            if (replace.contains("text: MAIN_MINE_Name")) {
                replace = KoNumOfUtils.cleanHandle(replace);
                replace = replace.replace("<span data-bind=\"text: $parent.APP_CATEGORY.indexOf('采矿权') > -1 ? '开采' : '勘查'\">勘查</span>矿种：<span data-bind=\"    text: MAIN_MINE_Name\">", "")
                        .replace("</span> </span></p>", "");
                // System.err.println("开采/勘查矿种: " + replace);
                kz = replace;
                continue;
            }
            if (replace.contains("text: NA_PERAMBULATE_GRADE")) {
                replace = KoNumOfUtils.cleanHandle(replace);
                replace = replace.replace("开采规模： <span data-bind=\"text: NA_PERAMBULATE_GRADE\">", "")
                        .replace("</span> </span></p>", "");
                // System.err.println("开采规模: " + replace);
                kcgm = replace;
                continue;
            }
            if (replace.contains("text: QT_TOTAL_AREA")) {
                replace = KoNumOfUtils.cleanHandle(replace);
                replace = replace.replace("面积：<span data-bind=\"    text: QT_TOTAL_AREA\">", "")
                        .replace("</span> </span></p>", "")
                        .replace("</span>平方千米，拐点坐标如下（2000国家大地坐标）：</span></p>", "");
                //  System.err.println("面积: " + replace);
                mj = replace;
            }
        }

        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
        hashMap.put("crr", crr);
        hashMap.put("srr", srr);
        hashMap.put("xydm", xydm);
        hashMap.put("xmmx", xmmx);
        hashMap.put("kz", kz);
        hashMap.put("kcgm", kcgm);
        hashMap.put("mj", mj);
        hashMap.put("q", uri);
        return hashMap;
    }

    // 出让人名称: 克州自然资源局
    //受让人名称: 克州新辉矿业有限公司
    //统一社会信用代码: 9165302432879609XC
    //矿山/项目名称: 关于新疆乌恰县克孜拉根石灰石矿隔离带普查探矿权协议出让的公示
    //开采/勘查矿种: 水泥用石灰岩
    //开采规模: 普查
    //面积: 0.0328
    public static void exp(List<LinkedHashMap<String, String>> dataList) throws Exception {
        List<String> fields = new ArrayList<>();
        fields.add("出让人名称");
        fields.add("受让人名称");
        fields.add("统一社会信用代码");
        fields.add("矿山/项目名称");
        fields.add("开采/勘查矿种");
        fields.add("开采规模");
        fields.add("面积(平方千米)");
        // 项目名称 开采矿种 中标人/竞得人  成交时间  统一社会信用代码 成交价 缴纳方式 缴纳时间
        XSSFWorkBookExpHelper workBookExpHelper = new XSSFWorkBookExpHelper();
        workBookExpHelper.expHandler(fields,
                dataList,
                "2采矿权协议出让公示",
                true,
                "D:/upload/");

    }


}
