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
 *    探矿权协议出让公示
 *
 * @author 王大宸
 * @date 2024/8/16 0:55
 */
public class ExplorationRightsAgreement {


    public static void main(String[] args) throws IOException {
        // 设置cookie
        Map<String, String> cookies = new HashMap<String, String>();
        cookies.put("thor", UUID.randomUUID().toString().replaceAll("-", ""));
        String uri = "https://ky.mnr.gov.cn/xycrgs/tkq/202407/t20240726_8977017.htm";
        /* 单个页面 */
        LinkedHashMap<String, String> hashMap = handler(uri);
        System.err.println(hashMap);
    }

    public static LinkedHashMap<String, String> handler(String uri) throws IOException {
        System.out.println("访问链接: " + uri);
        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
        Document document = Jsoup.connect(uri).get();

        Elements msoNormal = document.getElementsByClass("MsoNormal");

        // 出让人名称: 克州自然资源局
        //受让人名称: 克州新辉矿业有限公司
        //统一社会信用代码: 9165302432879609XC
        //矿山/项目名称: 关于新疆乌恰县克孜拉根石灰石矿隔离带普查探矿权协议出让的公示
        //开采/勘查矿种: 水泥用石灰岩
        //开采规模: 普查
        //面积: 0.0328

        String crr= "", srr= "", xydm= "", xmmx= "", kz= "", kcgm= "", mj = "";

        for (Element element : msoNormal) {
            String msoNormalElement = element.toString();
           //  msoNormalElement = msoNormalElement.replace(" ", "");

//            if (!msoNormalElement.contains("data-bind=\"text:")) {
//                continue;
//            }
            if (msoNormalElement.contains("公示时间")) {
                continue;
            }


            // 出让人：名称：六盘水市自然资源局
            //受让人  名称：水城海螺盘江水泥有限责任公司
            //统一社会信用代码：91520221094498275C
            //矿山名称：贵州省水城县石河矿区水泥用石灰岩深部资源采矿权
            //开采矿种：水泥用石灰岩
            //开采规模： 220万吨/年
            //面积：0.3816平方千米

//            if (!msoNormalElement.contains("名称：") // 名称 出让人 名称 / 受让人  名称
//                    && !msoNormalElement.contains("统一社会信用代码：") // 统一社会信用代码
//                    && !msoNormalElement.contains("项目名称：")
//                    && !msoNormalElement.contains("规模：")
//                    && !msoNormalElement.contains("面积：")
//                    && !msoNormalElement.contains("矿种：")
//                    && !msoNormalElement.contains("规模：")
//                    && !msoNormalElement.contains("平方千米")
//
//            ) {
//                continue;
//            }

            String replace = msoNormalElement.replace("<p class=\"MsoNormal\" style=\"line-height: 150%; text-indent: 32pt; margin: 0cm 0cm 0pt; mso-char-indent-count: 2.0\"><span style=\"line-height: 150%; font-family: 仿宋; font-size: 16pt; mso-bidi-font-size: 14.0pt\">", "");
            replace = replace.replace("</span></span></p>", "")
                    .replace("</span>万元</span></p>", "")
                    .replace("</span> </span></p>", "");
            replace = replace.replace("<p class=\"MsoNormal\" style=\"margin: 0cm 0cm 0pt; line-height: 150%; text-indent: 32pt; mso-char-indent-count: 2.0;\"><span style=\"line-height: 150%; font-family: 仿宋; font-size: 16pt; mso-bidi-font-size: 14.0pt;\">", "");

            if (replace.contains("text: NA_TRANSFER_PERSON\">")) {
                replace = replace.replace("名称：<span data-bind=\"text: NA_TRANSFER_PERSON\">", "");
               // System.err.println("出让人名称: " + replace);
                crr= replace;
                continue;
            }
            if (replace.contains("text: NA_CAPITAL_PERSON\">")) {
                replace = replace.replace("名称：<span data-bind=\"text: NA_CAPITAL_PERSON\">", "");
               // System.err.println("受让人名称: " + replace);
                srr= replace;
                continue;
            }
            if (replace.contains("text: NA_CAPITAL_CODE\">")) {
                replace = replace.replace("统一社会信用代码：<span data-bind=\"text: NA_CAPITAL_CODE\">", "")
                        .replace("</span> </span></p>", "");
              //  System.err.println("统一社会信用代码: " + replace);
                 xydm= replace;
                continue;
            }
            if (replace.contains("text: NA_APP_NAME\">")) {
                replace = replace.replace("<span data-bind=\"text: $parent.APP_CATEGORY.indexOf('采矿权') > -1 ? '矿山' : '项目'\">项目</span>名称：<span data-bind=\"    text: NA_APP_NAME\">", "")
                        .replace("</span> </span></p>", "");
              //  System.err.println("矿山/项目名称: " + replace);
                xmmx= replace;
                continue;
            }
            if (replace.contains("text: MAIN_MINE_Name\">")) {
                replace = replace.replace("<span data-bind=\"text: $parent.APP_CATEGORY.indexOf('采矿权') > -1 ? '开采' : '勘查'\">勘查</span>矿种：<span data-bind=\"    text: MAIN_MINE_Name\">", "")
                        .replace("</span> </span></p>", "");
               // System.err.println("开采/勘查矿种: " + replace);
                kz= replace;
                continue;
            }
            if (replace.contains("text: NA_PERAMBULATE_GRADE\">")) {
                replace = replace.replace("开采规模： <span data-bind=\"text: NA_PERAMBULATE_GRADE\">", "")
                        .replace("</span> </span></p>", "");
               // System.err.println("开采规模: " + replace);
                kcgm= replace;
                continue;
            }
            if (replace.contains("text: QT_TOTAL_AREA\">")) {
                replace = replace.replace("面积：<span data-bind=\"    text: QT_TOTAL_AREA\">", "")
                        .replace("</span> </span></p>", "")
                        .replace("</span>平方千米，拐点坐标如下（2000国家大地坐标）：</span></p>", "");
              //  System.err.println("面积: " + replace);
                mj = replace;
            }

           // System.err.println(replace);

        }

        hashMap.put("crr", crr);
        hashMap.put("srr", srr);
        hashMap.put("xydm", xydm);
        hashMap.put("xmmx", xmmx);
        hashMap.put("kz", kz);
        hashMap.put("kcgm", kcgm);
        hashMap.put("mj", mj);
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
                "探矿权协议出让公示",
                true,
                "D:/upload/");

    }


}
