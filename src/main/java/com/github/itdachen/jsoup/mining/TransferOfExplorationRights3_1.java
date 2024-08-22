package com.github.itdachen.jsoup.mining;

import com.github.itdachen.jsoup.XSSFWorkBookExpHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

/**
 * 3-1 探矿权转让公示
 *
 * @author 王大宸
 * @date 2024/8/16 1:25
 */
public class TransferOfExplorationRights3_1 {
    private static final String URI_PREFIX = "https://ky.mnr.gov.cn/zrgs/tkzrgs/";

    public static void main(String[] args) throws Exception {

        /* 页面页面地址 */
        List<String> uriList = new ArrayList<>();
        uriList.add("https://ky.mnr.gov.cn/zrgs/tkzrgs/index.htm");
        for (int i = 1; i < 3; i++) {
            uriList.add("https://ky.mnr.gov.cn/zrgs/tkzrgs/index_" + i + ".htm");
        }

        /* 具体页面地址 */
        List<String> uris = new ArrayList<>();

        for (String uri : uriList) {
            Document document = Jsoup.connect(uri).get();
            Elements clearfix = document.getElementsByClass("gu-kqgglist-section clearfix");
            Elements liList = clearfix.select("li a");

            for (Element element : liList) {
                String stringUri = element.toString();
                String replace = stringUri.replace("<a href=\".", "");

                stringUri = URI_PREFIX + replace.substring(0, stringUri.indexOf(".htm")) + ".htm";
                stringUri = stringUri.replace("\" targ.htm", "");
                uris.add(stringUri);
            }
        }

        List<LinkedHashMap<String, String>> hashMaps = new ArrayList<>();
        for (String s : uris) {
            LinkedHashMap<String, String> hashMap = handler(s);
            if (null == hashMap) {
                continue;
            }
            hashMaps.add(hashMap);
        }
        exp(hashMaps);


//        String uri = "https://ky.mnr.gov.cn/zrgs/tkzrgs//202408/t20240822_9002520.htm";
//
//        LinkedHashMap<String, String> handler = handler(uri);
//        System.err.println(handler);
    }

    public static LinkedHashMap<String, String> handler(String uri) throws IOException {
        //    System.out.println("访问链接: " + uri);
        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
        Document document = Jsoup.connect(uri).get();
        Elements msoNormal = document.getElementsByClass("MsoNormal");


        /// 转让人名称 转让人统一社会信用代码
        // 受让人名称 受让人统一社会信用代码
        // 项目名称 勘查矿种 转让价格

        String zrr = "", zrrXydm = "", srr = "", srrXydm = "", xmmx = "", kz = "", ja = "";
        int index = 0;
        for (Element element : msoNormal) {
            String msoNormalElement = element.toString();

            if (!msoNormalElement.contains("data-bind=\"text:")) {
                continue;
            }
            if (msoNormalElement.contains("公示时间")
                    || msoNormalElement.contains("公示文号")
                    || msoNormalElement.contains("公示如下")
                    || msoNormalElement.contains("转让人")
                    || msoNormalElement.contains("受让人")
                    || msoNormalElement.contains("矿权基本情况")
                    || msoNormalElement.contains("门户网站同时发布")) {
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

            //  System.err.println(msoNormalElement);
            String replace = msoNormalElement.replace("</span></span></p>", "")
                    .replace("</span>万元</span></p>", "")
                    .replace("</span> </span></p>", "");
            replace = replace.replace("</span> 万元</span></p>", "");
            System.out.println(replace);

//            if (replace.contains("text:NA_CESSION") && !replace.contains("text:NA_CESSION_CODE")) {
//                replace = KoNumOfUtils.cleanHandle(replace);
//                //  System.err.println("出让人名称: " + replace);
//                zrr = replace;
//            }
//            if (replace.contains("text:NA_CESSION_CODE")) {
//                replace = KoNumOfUtils.cleanHandle(replace);
//                //  System.err.println("出让人统一社会信用代码: " + replace);
//                zrrXydm = replace;
//            }

            if (0 == index){
                replace = KoNumOfUtils.cleanHandle(replace);
                zrr = replace;
            }
            if (1 == index){
                replace = KoNumOfUtils.cleanHandle(replace);
                zrrXydm = replace;
            }

//            if (replace.contains("text:NA_CESSIONARY\">")) {
//                replace = KoNumOfUtils.cleanHandle(replace);
//                // System.err.println("受让人名称: " + replace);
//                srr = replace;
//                continue;
//            }
//
//            if (replace.contains("text:NA_CESSIONARY_CODE\">")) {
//                replace = KoNumOfUtils.cleanHandle(replace);
//                //  System.err.println("受让人统一社会信用代码: " + replace);
//                srrXydm = replace;
//                continue;
//            }


            if (2 == index){
                replace = KoNumOfUtils.cleanHandle(replace);
                srr = replace;
            }
            if (3 == index){
                replace = KoNumOfUtils.cleanHandle(replace);
                srrXydm = replace;
            }

//            if (replace.contains("text:NA_APP_NAME")) {
//                // xmmx -> 德州市夏津县康泰颐养院地热可行性勘查
//                replace = KoNumOfUtils.cleanHandle(replace);
//                xmmx = replace;
//            }

            if (4 == index){
                replace = KoNumOfUtils.cleanHandle(replace);
                xmmx = replace;
            }

//            if (replace.contains("text:MAIN_MINE_Name")) {
//                replace = KoNumOfUtils.cleanHandle(replace);
//                //  System.err.println("勘查矿种: " + replace);
//                kz = replace;
//            }
            if (5 == index){
                replace = KoNumOfUtils.cleanHandle(replace);
                kz = replace;
            }
//            if (replace.contains("text:QT_CESSION_PRICE")) {
//                replace = KoNumOfUtils.cleanHandle(replace);
//                replace = replace.replace("</span> 万元</span></p>", "");
//                // System.err.println("转让价格: " + replace);
//                ja = replace;
//            }
            if (6 == index){
                replace = KoNumOfUtils.cleanHandle(replace);
                ja = replace;
            }
            index++;

        }


        hashMap.put("zrr", zrr);
        hashMap.put("zrrXydm", zrrXydm);
        hashMap.put("srr", srr);
        hashMap.put("srrXydm", srrXydm);
        hashMap.put("xmmx", xmmx);
        hashMap.put("kz", kz);
        hashMap.put("ja", ja);
        hashMap.put("q", uri);
        return hashMap;

    }


    /// 转让人名称 转让人统一社会信用代码
    // 受让人名称 受让人统一社会信用代码
    // 项目名称 勘查矿种 转让价格
    public static void exp(List<LinkedHashMap<String, String>> dataList) throws Exception {
        List<String> fields = new ArrayList<>();
        fields.add("转让人名称");
        fields.add("转让人统一社会信用代码");
        fields.add("受让人名称");
        fields.add("受让人统一社会信用代码");
        fields.add("项目名称");
        fields.add("勘查矿种");
        fields.add("转让价格");
        // 项目名称 开采矿种 中标人/竞得人  成交时间  统一社会信用代码 成交价 缴纳方式 缴纳时间
        XSSFWorkBookExpHelper workBookExpHelper = new XSSFWorkBookExpHelper();
        workBookExpHelper.expHandler(fields,
                dataList,
                "3-1探矿权转让公示",
                true,
                "D:/upload/");

    }


}
