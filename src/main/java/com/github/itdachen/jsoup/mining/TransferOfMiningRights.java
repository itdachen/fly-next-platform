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
public class TransferOfMiningRights {

    public static void main(String[] args) throws Exception {
        // 设置cookie
        Map<String, String> cookies = new HashMap<String, String>();
        cookies.put("thor", UUID.randomUUID().toString().replaceAll("-", ""));
        String uri = "https://ky.mnr.gov.cn/jggs/ckjjgs/202408/t20240815_8996407.htm";


        /* 单个页面 */
        Document document = Jsoup.connect(uri).cookies(cookies).get();
        LinkedHashMap<String, String> hashMap = handler(document);
        System.err.println(hashMap);
    }


    public static LinkedHashMap<String, String> handler(Document document) throws IOException {

        Elements msoNormal = document.getElementsByClass("MsoNormal");

        // 项目名称：贵州省三都县大河镇巴佑村岜安采石场采矿权
        // 开采矿种：建筑用砂
        // 中标人/竞得人  安康鑫亨矿业有限公司
        // 成交时间： 时间： 2024年08月13日
        // 统一社会信用代码： 91610928MAB32DF87G
        // 成交价：72万元
        // 缴纳方式：一次性缴纳
        // 缴纳时间：2024年10月31日

        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();

        // 项目名称 开采矿种 中标人/竞得人  成交时间  统一社会信用代码 成交价 缴纳方式 缴纳时间
        String xmmx = "", kckz = "", zbr = "", cjsj = "", xydm = "", cjj = "", jnfs = "", jnsj = "";
        for (Element element : msoNormal) {
            String string1 = element.toString();
            // System.out.println(element);

            if (!string1.contains("data-bind=\"text:")) {
                continue;
            }
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

            String s = string1.replaceAll("<p class=\"MsoNormal\" style=\"margin: 0cm 0cm 0pt; line-height: 150%; text-indent: 32pt; mso-char-indent-count: 2.0;\"><span style=\"line-height: 150%; font-family: 仿宋; font-size: 16pt; mso-bidi-font-size: 14.0pt;\">", "");
            if (s.startsWith("名称：")) {
                s = s.replaceAll("<span data-bind=\"text:NA_PUBLIC_BIDDER\">", "")
                        .replaceAll("</span></span></p>", "")
                        .replaceAll("名称：", "");
                // s = "名称：" + s;
                zbr = s;
                continue;
            }
            if (s.startsWith("统一社会信用代码：")) {
                s = s.replaceAll("<span data-bind=\"text:NA_REG_CODE\">", "")
                        .replaceAll("</span></span></p>", "")
                        .replaceAll("统一社会信用代码：", "");
                //  s = "统一社会信用代码：" + s;
                xydm = s;
                continue;
            }
            if (s.startsWith("时间：")) {
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
//            if (s.startsWith("地点：")) {
//                s = s.replaceAll("<span data-bind=\"text:NA_TD_ADDRESS\">", "")
//                        .replaceAll("</span></span></p>", "")
//                        .replaceAll("地点：", "");
//                s = "地点：" + s;
//            }
            if (s.startsWith("项目名称：")) {
                s = s.replaceAll("<span data-bind=\"text:NA_APP_NAME\">", "")
                        .replaceAll("</span></span></p>", "")
                        .replaceAll("项目名称：", "");
                //  s = "项目名称：" + s;
                xmmx = s;
                continue;
            }
            if (s.startsWith("成交价：")) {
                s = s.replaceAll("<span data-bind=\"text: QT_PUBLIC_PRICE\">", "")
                        .replaceAll("</span>万元</span></p>", "")
                        .replaceAll("成交价：", "");
                // s = "成交价：" + s;
                cjj = s;
                continue;
            }
            if (s.startsWith("缴纳时间：")) {
                s = s.replaceAll("<span data-bind=\"text: (new Date(DT_COST_DATE)).format('yyyy年MM月dd日')\">", "")
                        .replaceAll("</span></span></p>", "")
                        .replaceAll("缴纳时间：", "");
                int i = s.indexOf("\">");
                String substring = s.substring(i + 2, s.length());
                s = substring.replace("<spandata-bind=\"text:(newDate(DT_COST_DATE)).format('yyyy年MM月dd日')\">", "");
                jnsj = s;
                continue;
            }
            if (s.startsWith("缴纳方式：")) {
                s = s.replaceAll("<span data-bind=\"text: NA_COST_NAME\">", "")
                        .replaceAll("</span></span></p>", "")
                        .replaceAll("缴纳方式：", "");
                //  s = "缴纳方式：" + s;
                jnfs = s;
                continue;
            }
            if (s.contains(":MAIN_MINE_Name\">")) {
                s = s.replaceAll("<spandata-bind=\"text:APP_CATEGORY.indexOf('采矿权')>-1?'开采':'勘查'\">开采</span>矿种：<spandata-bind=\"text:MAIN_MINE_Name\">", "")
                        .replaceAll("</span></span></p>", "")
                        .replaceAll("矿种：", "");
                int i = s.indexOf("_Name\">");
                String substring = s.substring(i + 7, s.length());
                s = "矿种：" + substring;
                kckz = substring;
            }
        }


        //  String xmmx = "", kckz = "", zbr = "", cjsj = "", xydm = "", cjj = "", jnfs = "", jnsj = "";
        hashMap.put("xmmx", xmmx);
        hashMap.put("kckz", kckz);
        hashMap.put("zbr", zbr);
        hashMap.put("cjsj", cjsj);
        hashMap.put("xydm", xydm);
        hashMap.put("cjj", cjj);
        hashMap.put("jnfs", jnfs);
        hashMap.put("jnsj", jnsj);

        return hashMap;
    }

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
                "探矿权出让结果公示",
                true,
                "D:/upload/");

    }


}
