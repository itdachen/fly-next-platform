package com.github.itdachen.jsoup;

import com.github.itdachen.jsoup.mining.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

/**
 * 矿业权市场
 * <p>
 * 1-1 探矿权出让结果公示
 * https://ky.mnr.gov.cn/jggs/jjgs/
 * https://ky.mnr.gov.cn/jggs/jjgs/202408/t20240818_8997821.htm
 * <p>
 * <p>
 * 1-2 采矿权出让结果公示
 * https://ky.mnr.gov.cn/jggs/ckjjgs/
 * https://ky.mnr.gov.cn/jggs/ckjjgs/202408/t20240817_8997773.htm
 * <p>
 * <p>
 * 2 采矿权协议出让公示
 * https://ky.mnr.gov.cn/xycrgs/ckq/
 * https://ky.mnr.gov.cn/xycrgs/ckq/202408/t20240817_8997757.htm
 * <p>
 * <p>
 * 三、矿业权转让公示
 * 3-1 探矿权转让公示
 * https://ky.mnr.gov.cn/zrgs/tkzrgs/
 * https://ky.mnr.gov.cn/zrgs/tkzrgs/202408/t20240816_8997693.htm
 * <p>
 * 3-2 采矿权转让公示
 * https://ky.mnr.gov.cn/zrgs/ckzrgs
 * https://ky.mnr.gov.cn/zrgs/ckzrgs/202408/t20240817_8997783.htm
 * <p>
 * <p>
 * <p>
 * <p>
 * 1-1
 * https://search.mnr.gov.cn/was5/web/search?page=1&channelid=112225,142099,180679,93332&searchword=+APP_CATEGORY%3D%E9%87%87%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.18&keyword=+APP_CATEGORY%3D%E9%87%87%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.18&perpage=10&outlinepage=10
 * https://search.mnr.gov.cn/was5/web/search?page=1&channelid=112225,142099,180679,93332&searchword=+APP_CATEGORY%3D%E9%87%87%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.18&keyword=+APP_CATEGORY%3D%E9%87%87%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.18&perpage=10&outlinepage=10
 * https://search.mnr.gov.cn/was5/web/search?page=1&channelid=112225,142099,180679,93332&searchword=+APP_CATEGORY%3D%E9%87%87%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.18&keyword=+APP_CATEGORY%3D%E9%87%87%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.18&perpage=10&outlinepage=10
 *
 * @author 王大宸
 * @date 2024/8/15 20:30
 */
public class MiningRightMarketJsoup {
    private static final Logger logger = LoggerFactory.getLogger(JsoupTest.class);

    final static String URI = "https://search.mnr.gov.cn/was5/web/search?page=2&channelid=112225,142099,180679,93332&searchword=+APP_CATEGORY%3D%E6%8E%A2%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.15&keyword=+APP_CATEGORY%3D%E6%8E%A2%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.15&perpage=10&outlinepage=10";

    public static void main(String[] args) throws Exception {

//        String a = "https://search.mnr.gov.cn/was5/web/search?page=1&channelid=112225,142099,180679,93332&searchword=+APP_CATEGORY%3D%E9%87%87%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.18&keyword=+APP_CATEGORY%3D%E9%87%87%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.18&perpage=10&outlinepage=10";
//        String b = "https://search.mnr.gov.cn/was5/web/search?page=1&channelid=112225,142099,180679,93332&searchword=+APP_CATEGORY%3D%E9%87%87%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.18&keyword=+APP_CATEGORY%3D%E9%87%87%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.18&perpage=10&outlinepage=10";
//        String c = "https://search.mnr.gov.cn/was5/web/search?page=1&channelid=112225,142099,180679,93332&searchword=+APP_CATEGORY%3D%E9%87%87%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.18&keyword=+APP_CATEGORY%3D%E9%87%87%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.18&perpage=10&outlinepage=10";
//        String d = "https://search.mnr.gov.cn/was5/web/search?page=1&channelid=112225,142099,180679,93332&searchword=+APP_CATEGORY%3D%E6%8E%A2%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.18&keyword=+APP_CATEGORY%3D%E6%8E%A2%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.18&perpage=10&outlinepage=10";
//        System.err.println(a.equals(d));


        test();
    }


    public static void test() throws Exception {
        System.out.println(LocalDateTime.now());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // 设置cookie
        Map<String, String> cookies = new HashMap<String, String>();
        cookies.put("thor", UUID.randomUUID().toString().replaceAll("-", ""));
        String uri = "https://search.mnr.gov.cn/was5/web/search?page=1&channelid=112225,142099,180679,93332&searchword=+APP_CATEGORY%3D%E6%8E%A2%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.16&keyword=+APP_CATEGORY%3D%E6%8E%A2%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.16&perpage=10&outlinepage=10";


        List<String> uriList = new ArrayList<>();


//        for (int i = 1; i < 152; i++) {
//            uriList.add("https://search.mnr.gov.cn/was5/web/search?page=" + i + "&channelid=112225,142099,180679,93332&searchword=+APP_CATEGORY%3D%E6%8E%A2%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.16&keyword=+APP_CATEGORY%3D%E6%8E%A2%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.16&perpage=10&outlinepage=10");
//        }



        /* 探矿权 */
        for (int i = 1; i < 152; i++) {
            uriList.add("https://search.mnr.gov.cn/was5/web/search?page=" + i + "&channelid=112225,142099,180679,93332&searchword=+APP_CATEGORY%3D%E6%8E%A2%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.18&keyword=+APP_CATEGORY%3D%E6%8E%A2%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.18&perpage=10&outlinepage=10");
        }

        /* 采矿权 */
        for (int i = 1; i < 328; i++) {
            uriList.add("https://search.mnr.gov.cn/was5/web/search?page=" + i + "&channelid=112225,142099,180679,93332&searchword=+APP_CATEGORY%3D%E9%87%87%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.18&keyword=+APP_CATEGORY%3D%E9%87%87%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.18&perpage=10&outlinepage=10");
        }

        List<LinkedHashMap<String, String>> handler1_1 = new ArrayList<>();
        List<LinkedHashMap<String, String>> handler1_2 = new ArrayList<>();
        List<LinkedHashMap<String, String>> handler2 = new ArrayList<>();
        List<LinkedHashMap<String, String>> handler3_1 = new ArrayList<>();
        List<LinkedHashMap<String, String>> handler3_3 = new ArrayList<>();


        System.out.println("开始抓取数据 ...");
        System.out.println("共计 " + uriList.size() + " 分页, 每个分页是 10 个页面 ...");

        int index = 1;
        for (String htmlURI : uriList) {
            System.out.println("正在抓取, 当前分页:  " + index + " ...");
            index++;
            Document document = Jsoup.connect(htmlURI).cookies(cookies).get();
            Elements ul = document.getElementsByClass("gu-result gu-result1");
            Elements liList = ul.select("li a");

            for (Element element : liList) {
                String htmlUrl = element.toString();

                if (!htmlUrl.contains("target=\"_blank\"")) {
                    continue;
                }

                try {
                    htmlUrl = htmlUrl.replaceAll("<a href=\"", "");
                    int i = htmlUrl.indexOf(".htm");
                    htmlUrl = htmlUrl.substring(0, i) + ".htm";
                    //
                    Document pageDocument = Jsoup.connect(htmlUrl).cookies(cookies).get();


                    Elements currChnlCls = pageDocument.getElementsByClass("CurrChnlCls");


                    for (Element currChnlCl : currChnlCls) {
                        String html = currChnlCl.html();
                        if (html.contains("首页") || html.contains("矿业权招拍挂出让公告")) {
                            continue;
                        }
                        if (html.equals("采矿权出让结果公示")
                             //   || html.equals("采矿权出让公示") || html.equals("采矿权出让")
                        ) {
                            System.err.println("1-2 探矿权出让结果公示 === 采矿权出让结果公示");
                            LinkedHashMap<String, String> handler = TransferOfExplorationRights.handler(htmlUrl);
                            handler1_2.add(handler);
                        }
                        if (html.equals("探矿权出让结果公示")
                             //   || html.equals("探矿权出让公示") || html.equals("探矿权出让") || html.equals("探矿权出让公告")
                        ) {
                            System.err.println("1-2 探矿权出让结果公示");
                            LinkedHashMap<String, String> handler = TransferOfExplorationRights.handler(htmlUrl);
                            handler1_2.add(handler);
                        }
                        /*  2 矿业权协议出让公示 > 探矿权协议出让公示 */
                        if (html.equals("探矿权协议出让公示")
                              //  || html.equals("探矿权协议出让结果公示") || html.equals("探矿权协议出让")
                        ) {
                            System.err.println("2 探矿权协议出让公示");
                            LinkedHashMap<String, String> handler = ExplorationRightsAgreement.handler(htmlUrl);
                            handler2.add(handler);
                        }
                        /* 3-1 矿业权转让公示 > 探矿权转让公示 */
                        if (html.equals("探矿权转让公示")
                              //  || html.equals("探矿权转让结果公示") || html.equals("探矿权转让")
                        ) {
                            System.err.println("3-1 探矿权转让公示");
                            LinkedHashMap<String, String> handler = TransferOfExplorationRights2.handler(htmlUrl);
                            handler3_1.add(handler);
                        }
                        /* 3-2 矿业权转让公示 > 采矿权转让公示 */
                        if (html.equals("采矿权转让公示")
                              //  || html.equals("采矿权转让") || html.equals("采矿权转让结果公示")
                        ) {
                            System.err.println("3-2 采矿权转让公示");
                            LinkedHashMap<String, String> handler = TransferOfMiningRights2.handler(htmlUrl);
                            handler3_3.add(handler);
                        }


                    }

                } catch (Exception e) {

                }


            }
        }

        int total = handler1_1.size()
                + handler1_2.size()
                + handler2.size()
                + handler3_1.size()
                + handler3_3.size();
        System.out.println("数据抓取完毕, 共计 " + total + " 条 ...");

        System.out.println("开始执行数据导出 ...");
        /* 导出 */
        if (!handler1_1.isEmpty()) {
            System.out.println("开始导出数据类型 1 ...");
            TransferOfMiningRights.exp(handler1_1);
            System.out.println("数据类型 1 导出完毕, 共计 " + handler1_1.size() + " 条 ...");
        }
        if (!handler1_2.isEmpty()) {
            System.out.println("开始导出数据类型 2  ...");
            TransferOfExplorationRights.exp(handler1_2);
            System.out.println("数据类型 2 导出完毕, 共计 " + handler1_2.size() + " 条 ...");
        }
        if (!handler2.isEmpty()) {
            System.out.println("开始导出数据类型 3 ...");
            ExplorationRightsAgreement.exp(handler2);
            System.out.println("数据类型 3 导出完毕, 共计 " + handler2.size() + " 条 ...");
        }
        if (!handler3_1.isEmpty()) {
            System.out.println("开始导出数据类型 4 ...");
            TransferOfExplorationRights2.exp(handler3_1);
            System.out.println("数据类型 4 导出完毕, 共计 " + handler3_1.size() + " 条 ...");
        }
        if (!handler3_3.isEmpty()) {
            System.out.println("开始导出数据类型 5 ...");
            TransferOfMiningRights2.exp(handler3_3);
            System.out.println("数据类型 5 导出完毕, 共计 " + handler3_3.size() + " 条 ...");
        }

        stopWatch.stop();
        double totalTimeSeconds = stopWatch.getTotalTimeSeconds();
        System.out.println("数据导出完成 ...");
        System.out.println("共耗时 " + totalTimeSeconds + " Seconds");
        System.out.println(LocalDateTime.now());
    }

}
