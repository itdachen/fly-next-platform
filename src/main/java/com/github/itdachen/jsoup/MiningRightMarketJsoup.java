package com.github.itdachen.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 矿业权市场
 * 黑龙江省宁安市泼雪泉饮用天然矿泉水勘查探矿权出让交易公告
 *
 * @author 王大宸
 * @date 2024/8/15 20:30
 */
public class MiningRightMarketJsoup {
    private static final Logger logger = LoggerFactory.getLogger(JsoupTest.class);

    final static String URI = "https://search.mnr.gov.cn/was5/web/search?page=2&channelid=112225,142099,180679,93332&searchword=+APP_CATEGORY%3D%E6%8E%A2%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.15&keyword=+APP_CATEGORY%3D%E6%8E%A2%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.15&perpage=10&outlinepage=10";

    public static void main(String[] args) throws Exception {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // 设置cookie
        Map<String, String> cookies = new HashMap<String, String>();
        cookies.put("thor", UUID.randomUUID().toString().replaceAll("-", ""));
        String uri = "https://ky.mnr.gov.cn/kyqcrgg/tkq/202408/t20240814_8995096.htm";


        /* 单个页面 */
        Document document = Jsoup.connect(uri).cookies(cookies).get();
        String string = document.toString();
//        if (string.contains("title=\"探矿权出让公告\"")) {
//            System.out.println("============ 探矿权出让公告 ==============================");
//        }


        Elements msoNormal = document.getElementsByClass("MsoNormal");

        for (Element element : msoNormal) {
            String string1 = element.toString();
            System.out.println(element);
//            if (string1.contains(">一、出让人</span></p>")) {
//                System.err.println("============ 探矿权出让公告 出让人 ==============================");
//                System.out.println(string1);
//            }

        }



//        Elements table = document.getElementsByTag("table");
//        int index = 0;
//        for (Element element : table) {
//            String string1 = element.toString();
//            if (string1.contains("您现在的位置")) {
//                continue;
//            }
//            if (string1.contains(">一、出让人</span></p>")) {
//                System.err.println("============ 探矿权出让公告 ==============================");
//                System.out.println(string1);
//                index++;
//            }
//        }
//
//        System.err.println(index);


        //   System.err.println(table);


        // 中标人/竞得人


        // 出让 项目名称：贵州省三都县大河镇巴佑村岜安采石场采矿权
        //开采矿种：建筑用砂
        //中标人/竞得人  名称：安康鑫亨矿业有限公司
        //成交时间： 时间： 2024年08月13日
        //统一社会信用代码： 91610928MAB32DF87G
        //成交价：72万元
        //缴纳方式：一次性缴纳
        //缴纳时间：2024年10月31日


//        Elements ul = document.getElementsByClass("gu-result gu-result1");
//        Elements liList = ul.select("li a");
//
//        for (Element element : liList) {
//            String htmlUrl = element.toString();
//            if (htmlUrl.contains("target=\"_blank\"")) {
//                htmlUrl = htmlUrl.replaceAll("<a href=\"", "");
//
//                int i = htmlUrl.indexOf(".htm");
//                String substring = htmlUrl.substring(0, i) + ".htm";
//                System.err.println(substring);
//
//                Document document2 = Jsoup.connect(substring).cookies(cookies).get();
//                System.err.println(document2);
//            }
//        }


    }

}
