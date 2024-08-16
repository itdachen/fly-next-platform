package com.github.itdachen.jsoup.mining;

import com.github.itdachen.jsoup.XSSFWorkBookExpHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

/**
 * 1-2 探矿权出让结果公示
 *
 * @author 王大宸
 * @date 2024/8/16 0:37
 */
public class TransferOfExplorationRights {

    public static void main(String[] args) throws IOException {
        // 设置cookie
        Map<String, String> cookies = new HashMap<String, String>();
        cookies.put("thor", UUID.randomUUID().toString().replaceAll("-", ""));
        String uri = "https://ky.mnr.gov.cn/jggs/jjgs/202408/t20240814_8995102.htm";
        /* 单个页面 */
        Document document = Jsoup.connect(uri).cookies(cookies).get();
        LinkedHashMap<String, String> hashMap = handler(document);
        System.err.println(hashMap);
    }

    public static LinkedHashMap<String, String> handler(Document document) {
        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();

        Elements msoNormal = document.getElementsByClass("MsoNormal");

        // 项目名称 中标人/竞得人  统一社会信用代码 成交价 缴纳方式 缴纳时间
        String xmmx = "", zbr = "", xydm = "", cjj = "", jnfs = "", jnsj = "";
        for (Element element : msoNormal) {
            String msoNormalElement = element.toString();

            if (!msoNormalElement.contains("data-bind=\"text:")) {
                continue;
            }
            if (msoNormalElement.contains("公示时间")) {
                continue;
            }
            // 项目名称：陕西省旬阳市金洞河地区铜矿普查
            //中标人/竞得人  名称：安康鑫亨矿业有限公司
            //统一社会信用代码： 91610928MAB32DF87G
            //成交价：72万元
            //缴纳方式：一次性缴纳
            //缴纳时间：2024年10月31日

            if (!msoNormalElement.contains("名称：") // 名称 中标人/竞得人
                    && !msoNormalElement.contains("统一社会信用代码：") // 统一社会信用代码
                    && !msoNormalElement.contains("时间：") // 时间
                    //   && !string1.contains("地点：") // 地点
                    && !msoNormalElement.contains("项目名称：") // 项目名称
                    && !msoNormalElement.contains("成交价：")  // 成交价(万元)
                    && !msoNormalElement.contains("缴纳方式：")  // 缴纳方式
                    && !msoNormalElement.contains("缴纳时间：") // 缴纳时间
            ) {
                continue;
            }


            String replace = msoNormalElement.replace("<p class=\"MsoNormal\" style=\"line-height: 150%; text-indent: 32pt; margin: 0cm 0cm 0pt; mso-char-indent-count: 2.0\"><span style=\"line-height: 150%; font-family: 仿宋; font-size: 16pt; mso-bidi-font-size: 14.0pt\">", "");
            replace = replace.replace("</span></span></p>", "").replace("</span>万元</span></p>", "");


            if (replace.startsWith("名称：")) {
                replace = replace.replaceAll("<span data-bind=\"text:NA_PUBLIC_BIDDER\">", "")
                        .replaceAll("</span></span></p>", "")
                        .replaceAll("名称：", "");
                // System.err.println("名称：" + replace);
                zbr = replace;
                continue;
            }
            if (replace.startsWith("统一社会信用代码：")) {
                replace = replace.replaceAll("<span data-bind=\"text:NA_REG_CODE\">", "")
                        .replaceAll("</span></span></p>", "")
                        .replaceAll("统一社会信用代码：", "")
                        .replace(" ", "");
                xydm = replace;
                //  System.err.println("统一社会信用代码：" + replace);
                continue;
            }
//            if (replace.startsWith("时间：")) {
//                replace = replace.replaceAll("<span data-bind=\"text:(new Date(DT_BUY_DATE)).format('yyyy年MM月dd日')\">", "")
//                        .replaceAll("</span></span></p>", "")
//                        .replaceAll("<spandata-bind=\"text:(newDate(DT_BUY_DATE)).format('yyyy年MM月dd日')\">", "")
//                        .replaceAll("时间：", "");
//
//                int i = replace.indexOf("\">");
//                String substring = replace.substring(i + 2, replace.length());
//                replace = substring.replace("<spandata-bind=\"text:(newDate(DT_BUY_DATE)).format('yyyy年MM月dd日')\">", "");
//                cjsj = replace;
//                //  System.err.println("时间：" + replace);
//                continue;
//            }
            if (replace.startsWith("项目名称：")) {
                replace = replace.replaceAll("<span data-bind=\"text:NA_APP_NAME\">", "")
                        .replaceAll("</span></span></p>", "")
                        .replaceAll("项目名称：", "");
                xmmx = replace;
                //  System.err.println("项目名称：" + replace);
                continue;
            }
            if (replace.startsWith("成交价：")) {
                replace = replace.replaceAll("<span data-bind=\"text: QT_PUBLIC_PRICE\">", "")
                        .replaceAll("</span>万元</span></p>", "")
                        .replaceAll("成交价：", "");
                cjj = replace;
                // System.err.println("成交价：" + replace);
                continue;
            }
            if (replace.startsWith("缴纳时间：")) {
                replace = replace.replaceAll("<span data-bind=\"text: (new Date(DT_COST_DATE)).format('yyyy年MM月dd日')\">", "")
                        .replaceAll("</span></span></p>", "")
                        .replaceAll("缴纳时间：", "");
                int i = replace.indexOf("\">");
                String substring = replace.substring(i + 2, replace.length());
                replace = substring.replace("<spandata-bind=\"text:(newDate(DT_COST_DATE)).format('yyyy年MM月dd日')\">", "");
                jnsj = replace;
                //   System.err.println("缴纳时间：" + replace);
                continue;
            }
            if (replace.startsWith("缴纳方式：")) {
                replace = replace.replaceAll("<span data-bind=\"text: NA_COST_NAME\">", "")
                        .replaceAll("</span></span></p>", "")
                        .replaceAll("缴纳方式：", "");
                jnfs = replace;
                // System.err.println("缴纳方式：" + replace);
                continue;
            }

            //   System.err.println(replace);
        }

        // String xmmx = "", zbr = "",  xydm = "", cjj = "", jnfs = "", jnsj = "";
        hashMap.put("xmmx", xmmx);
        hashMap.put("zbr", zbr);
        hashMap.put("xydm", xydm);
        hashMap.put("cjj", cjj);
        hashMap.put("jnfs", jnfs);
        hashMap.put("jnsj", jnsj);
        return hashMap;
    }


    // 项目名称 中标人/竞得人  统一社会信用代码 成交价 缴纳方式 缴纳时间
    public static void exp(List<LinkedHashMap<String, String>> dataList) throws Exception {
        List<String> fields = new ArrayList<>();
        fields.add("项目名称");
        fields.add("中标人/竞得人");
        fields.add("统一社会信用代码");
        fields.add("成交价");
        fields.add("缴纳方式");
        fields.add("缴纳时间");
        // 项目名称 开采矿种 中标人/竞得人  成交时间  统一社会信用代码 成交价 缴纳方式 缴纳时间
        XSSFWorkBookExpHelper workBookExpHelper = new XSSFWorkBookExpHelper();
        workBookExpHelper.expHandler(fields,
                dataList,
                "拍卖出让",
                true,
                "D:/upload/");

    }


}
