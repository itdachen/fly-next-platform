package com.github.itdachen.jsoup.mining;

import com.github.itdachen.jsoup.XSSFWorkBookExpHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

/**
 * 1-1 探矿权出让结果公示
 *
 * @author 王大宸
 * @date 2024/8/15 22:52
 */
public class TransferOfMiningRights1_1 {
    private static final String URI_PREFIX = "https://ky.mnr.gov.cn/jggs/jjgs";

    public static void main(String[] args) throws Exception {

        List<String> uriList = new ArrayList<>();
        uriList.add("https://ky.mnr.gov.cn/jggs/jjgs/");
        for (int i = 1; i < 4; i++) {
            uriList.add("https://ky.mnr.gov.cn/jggs/jjgs/index_" + i + ".htm");
        }


        List<LinkedHashMap<String, String>> hashMaps = new ArrayList<>();
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
                LinkedHashMap<String, String> hashMap = handler(s);
                if (null == hashMap) {
                    continue;
                }
                hashMaps.add(hashMap);
            }
        }
        exp(hashMaps);
    }

    public static LinkedHashMap<String, String> handler(String uri) throws IOException {
        Document document = Jsoup.connect(uri).get();

        Elements msoNormal = document.getElementsByClass("MsoNormal");
        if (!msoNormal.isEmpty()) {
            return msoNormalHandler(msoNormal, uri);
        }

        Elements p = document.getElementsByTag("p");
        if (!p.isEmpty()) {
            return pHandler(p, uri);
        }


//        Elements table = document.getElementsByTag("table");
//        if (!table.isEmpty()) {
//            return tableHandler(table, uri);
//        }
//        System.err.println(document);

        return null;
    }


    public static LinkedHashMap<String, String> pHandler(Elements elements, String uri) {
        // 项目名称 开采矿种 中标人/竞得人  成交时间  统一社会信用代码 成交价 缴纳方式 缴纳时间
        String xmmx = "", kckz = "", zbr = "", cjsj = "", xydm = "", cjj = "", jnfs = "", jnsj = "";

        if (1 == elements.size()) {
            return null;
        }

        String strElement = "";
        for (Element element : elements) {
            strElement = element.toString();
            if (strElement.startsWith("<p data-v-4fd47c5f=\"\" style=\"text-align: center;\">")
                    || strElement.startsWith("<p data-v-4fd47c5f=\"\"></p>")
                    || strElement.contains("门户网站")
                    || strElement.contains("京公网安备")
                    || strElement.contains("公示文号")
                    || strElement.contains("公示如下")
                    || strElement.contains("公示时间：")


            ) {
                continue;
            }
            //  System.err.println(strElement);

            strElement = strElement.replace("<span data-v-4fd47c5f=\"\">", "")
                    .replace("</span></p>", "");

            // 项目名称	开采矿种	中标人/竞得人	成交时间	统一社会信用代码	成交价	缴纳方式	缴纳时间
            if (strElement.contains("项目名称：")) {
                strElement = KoNumOfUtils.cleanHandle(strElement);
                strElement = strElement.replace("<p data-v-4fd47c5f=\"\" style=\"line-height: 150%; margin: 0cm 0cm 0pt; text-indent: 30pt; font-size: 15pt; font-family: 仿宋_GB2312;\"> 项目名称：", "");
                xmmx = strElement;
                continue;
            }
            if (strElement.contains("矿种：")) {
                strElement = KoNumOfUtils.cleanHandle(strElement);
                strElement = strElement.replace("<p data-v-4fd47c5f=\"\" style=\"line-height: 150%; margin: 0cm 0cm 0pt; text-indent: 30pt; font-size: 15pt; font-family: 仿宋_GB2312;\"> 勘查矿种： ", "");
                strElement = strElement.replace("矿种：", "");
                kckz = strElement;
                continue;
            }

            /* 中标人/竞得人 */
            if (strElement.contains("名称：")) {
                strElement = KoNumOfUtils.cleanHandle(strElement);
                strElement = strElement.replace("<p data-v-4fd47c5f=\"\" style=\"line-height: 150%; margin: 0cm 0cm 0pt; text-indent: 30pt; font-size: 15pt; font-family: 仿宋_GB2312;\"> 名称： ", "");
                zbr = strElement;
                continue;
            }

            /* 成交时间 */
            if (strElement.contains("成交时间：")
                    ||
                    (
                            strElement.contains("时间：")
                                    && !strElement.contains("公示时间")
                                    && !strElement.contains("缴纳时间")
                    )


            ) {
                strElement = KoNumOfUtils.cleanHandle(strElement);
                strElement = strElement.replace("<p data-v-4fd47c5f=\"\" style=\"line-height: 150%; margin: 0cm 0cm 0pt; text-indent: 30pt; font-size: 15pt; font-family: 仿宋_GB2312;\"> 时间：", "");
                strElement = strElement.replace("<p data-v-4fd47c5f=\"\" style=\"line-height: 150%; margin: 0cm 0cm 0pt; text-indent: 30pt; font-size: 15pt; font-family: 仿宋_GB2312;\"> 时间： <span data-v-4fd47c5f=\"\"> ", "").replace(" </span></p>", "");
                cjsj = strElement;
                continue;
            }

            /* 统一社会信用代码 */
            if (strElement.contains("统一社会信用代码：")) {
                strElement = KoNumOfUtils.cleanHandle(strElement);
                strElement = strElement.replace("<p data-v-4fd47c5f=\"\" style=\"line-height: 150%; margin: 0cm 0cm 0pt; text-indent: 30pt; font-size: 15pt; font-family: 仿宋_GB2312;\"> 统一社会信用代码：", "");
                xydm = strElement;
                continue;
            }

            /* 成交价 */
            if (strElement.contains("成交价：")) {
                strElement = KoNumOfUtils.cleanHandle(strElement);
                strElement = strElement.replace("<p data-v-4fd47c5f=\"\" style=\"line-height: 150%; margin: 0cm 0cm 0pt; text-indent: 30pt; font-size: 15pt; font-family: 仿宋_GB2312;\"> 成交价：", "");
                strElement = strElement.replace("</span>万元</span></p>", "");
                strElement = strElement.replace("</span>万元 </p>", "");
                cjj = strElement;
                continue;
            }

            if (strElement.contains("缴纳方式：")) {
                strElement = KoNumOfUtils.cleanHandle(strElement);
                strElement = strElement.replace("<p data-v-4fd47c5f=\"\" style=\"line-height: 150%; margin: 0cm 0cm 0pt; text-indent: 30pt; font-size: 15pt; font-family: 仿宋_GB2312;\"> 缴纳方式：", "");
                strElement = strElement.replace(">", "");
                jnfs = strElement;
                continue;
            }

            if (strElement.contains("缴纳时间：")) {
                strElement = KoNumOfUtils.cleanHandle(strElement);
                strElement = strElement.replace("<p data-v-4fd47c5f=\"\" style=\"line-height: 150%; margin: 0cm 0cm 0pt; text-indent: 30pt; font-size: 15pt; font-family: 仿宋_GB2312;\"> 缴纳时间：", "");
                jnsj = strElement;
            }
        }

        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
        hashMap.put("xmmx", xmmx);
        hashMap.put("kckz", kckz);
        hashMap.put("zbr", zbr);
        hashMap.put("cjsj", cjsj);
        hashMap.put("xydm", xydm);
        hashMap.put("cjj", cjj);
        hashMap.put("jnfs", jnfs);
        hashMap.put("jnsj", jnsj);
        hashMap.put("s", uri);
        return hashMap;
    }

    public static LinkedHashMap<String, String> msoNormalHandler(Elements msoNormal, String uri) throws IOException {


        // 项目名称 开采矿种 中标人/竞得人  成交时间  统一社会信用代码 成交价 缴纳方式 缴纳时间
        String xmmx = "", kckz = "", zbr = "", cjsj = "", xydm = "", cjj = "", jnfs = "", jnsj = "";
        for (Element element : msoNormal) {
            String string1 = element.toString();
            if (string1.contains("公示时间")) {
                continue;
            }

            if (!string1.contains("名称：") // 名称
                    && !string1.contains("统一社会信用代码：") // 统一社会信用代码
                    && !string1.contains("时间：") // 时间
                    //   && !string1.contains("地点：") // 地点
                    && !string1.contains("项目名称：") // 项目名称
                    && !string1.contains("矿种：") // 开采矿种
                    && !string1.contains("成交价：")  // 成交价(万元)
                    && !string1.contains("缴纳方式：")  // 缴纳方式
                    && !string1.contains("缴纳时间：") // 缴纳时间
            ) {
                continue;
            }


            //  System.err.println(string1);
            String s = string1.replaceAll("<p class=\"MsoNormal\" style=\"margin: 0cm 0cm 0pt; line-height: 150%; text-indent: 32pt; mso-char-indent-count: 2.0;\"><span style=\"line-height: 150%; font-family: 仿宋; font-size: 16pt; mso-bidi-font-size: 14.0pt;\">", "");
            s = s.replace("</span></span></p>", "");
            if (s.contains("NA_PUBLIC_BIDDER")) {
                s = KoNumOfUtils.cleanHandle(s);
                s = s.replaceAll("<span data-bind=\"text:NA_PUBLIC_BIDDER\">", "")
                        .replaceAll("</span></span></p>", "")
                        .replaceAll("名称：", "");
                // s = "名称：" + s;
                zbr = s;
                continue;
            }
            if (s.contains("NA_REG_CODE")) {
                s = KoNumOfUtils.cleanHandle(s);
                s = s.replaceAll("<span data-bind=\"text:NA_REG_CODE\">", "")
                        .replaceAll("</span></span></p>", "")
                        .replaceAll("统一社会信用代码：", "");
                //  s = "统一社会信用代码：" + s;
                xydm = s;
                continue;
            }
            if (s.contains("DT_BUY_DATE")) {
                s = KoNumOfUtils.cleanHandle(s);
                s = s.replaceAll("<span data-bind=\"text:(new Date(DT_BUY_DATE)).format('yyyy年MM月dd日')\">", "")
                        .replaceAll("</span></span></p>", "")
                        .replaceAll("<spandata-bind=\"text:(newDate(DT_BUY_DATE)).format('yyyy年MM月dd日')\">", "")
                        .replaceAll("时间：", "");

                int i = s.indexOf("\">");
                String substring = s.substring(i + 2, s.length());
                s = substring.replace("<spandata-bind=\"text:(newDate(DT_BUY_DATE)).format('yyyy年MM月dd日')\">", "");
                cjsj = s;
                continue;
            }
            if (s.contains("NA_APP_NAME")) {
                s = KoNumOfUtils.cleanHandle(s);
                // xmmx -> 新疆鄯善县色东铜铁矿普查
                s = s.replaceAll("<span data-bind=\"text:NA_APP_NAME\">", "")
                        .replace("<p class=\"MsoNormal\" style=\"margin: 0cm 0cm 0pt; line-height: 150%; text-indent: 32pt; mso-char-indent-count: 2.0\" __ko__1710122603289=\"ko204\"><span style=\"font-size: 16pt; font-family: 仿宋; line-height: 150%; mso-bidi-font-size: 14.0pt\"><span __ko__1710122603289=\"ko205\" data-bind=\"text:APP_CATEGORY.indexOf('采矿权')>-1?'项目':'项目'\">项目</span>名称：<span __ko__1710122603289=\"ko206\" data-bind=\"text:NA_APP_NAME\">", "")
                        .replace("<p class=\"MsoNormal\" style=\"MARGIN: 0cm 0cm 0pt; LINE-HEIGHT: 150%; TEXT-INDENT: 32pt; mso-char-indent-count: 2.0\" __ko__1711104856936=\"ko29\"><span style=\"FONT-SIZE: 16pt; FONT-FAMILY: 仿宋; LINE-HEIGHT: 150%; mso-bidi-font-size: 14.0pt\"><span data-bind=\"text:APP_CATEGORY.indexOf('采矿权')>-1?'项目':'项目'\" __ko__1711104856936=\"ko30\">项目</span>名称：<span data-bind=\"text:NA_APP_NAME\" __ko__1711104856936=\"ko31\">", "")
                        .replaceAll("</span></span></p>", "")
                        .replaceAll("项目名称：", "");
                //  s = "项目名称：" + s;
                xmmx = s;
                continue;
            }
            if (s.contains("QT_PUBLIC_PRICE")) {
                s = KoNumOfUtils.cleanHandle(s);
                s = s.replaceAll("<span data-bind=\"text: QT_PUBLIC_PRICE\">", "")
                        .replaceAll("</span>万元</span></p>", "")
                        .replace("</span>万元 </p>", "")
                        .replaceAll("成交价：", "");
                // s = "成交价：" + s;
                cjj = s;
                continue;
            }
            if (s.contains("DT_COST_DATE")) {
                s = KoNumOfUtils.cleanHandle(s);
                s = s.replaceAll("<span data-bind=\"text: (new Date(DT_COST_DATE)).format('yyyy年MM月dd日')\">", "")
                        .replaceAll("</span></span></p>", "")
                        .replaceAll("缴纳时间：", "");
                s = s.replace("<spandata-bind=\"text:(newDate(DT_COST_DATE)).format('yyyy年MM月dd日')\">", "");
                s = s.replace(">", "");
                jnsj = s;
                continue;
            }
            if (s.contains("NA_COST_NAME")) {
                s = KoNumOfUtils.cleanHandle(s);
                s = s.replaceAll("<span data-bind=\"text: NA_COST_NAME\">", "")
                        .replaceAll("</span></span></p>", "")
                        .replaceAll("缴纳方式：", "");
                //  s = "缴纳方式：" + s;
                jnfs = s;
                continue;
            }
            if (s.contains("MAIN_MINE_Name")) {
                s = KoNumOfUtils.cleanHandle(s);
                s = s.replaceAll("<spandata-bind=\"text:APP_CATEGORY.indexOf('采矿权')>-1?'开采':'勘查'\">开采</span>矿种：<spandata-bind=\"text:MAIN_MINE_Name\">", "")
                        .replaceAll("</span></span></p>", "")
                        .replaceAll("矿种：", "")
                        .replace("矿种：", "");
               // s = "矿种：" + s;
                kckz = s;
            }
        }


        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
        hashMap.put("xmmx", xmmx);
        hashMap.put("kckz", kckz);
        hashMap.put("zbr", zbr);
        hashMap.put("cjsj", cjsj);
        hashMap.put("xydm", xydm);
        hashMap.put("cjj", cjj);
        hashMap.put("jnfs", jnfs);
        hashMap.put("jnsj", jnsj);
        hashMap.put("s", uri);
        return hashMap;
    }


    /***
     * 导出
     *
     * @author 王大宸
     * @date 2024/8/18 21:23
     * @param dataList dataList
     * @return void
     */
    public static void exp(List<LinkedHashMap<String, String>> dataList) throws Exception {
        List<String> fields = new ArrayList<>();
        fields.add("项目名称");
        fields.add("开采矿种");
        fields.add("中标人/竞得人");
        fields.add("成交时间");
        fields.add("统一社会信用代码");
        fields.add("成交价");
        fields.add("缴纳方式");
        fields.add("缴纳时间");
        // 项目名称 开采矿种 中标人/竞得人  成交时间  统一社会信用代码 成交价 缴纳方式 缴纳时间
        XSSFWorkBookExpHelper workBookExpHelper = new XSSFWorkBookExpHelper();
        workBookExpHelper.expHandler(fields,
                dataList,
                "1_1采矿权出让结果公示",
                true,
                "D:/upload/");

    }


}
