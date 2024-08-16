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
import java.util.*;

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
        String uri = "https://search.mnr.gov.cn/was5/web/search?page=1&channelid=112225,142099,180679,93332&searchword=+APP_CATEGORY%3D%E6%8E%A2%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.16&keyword=+APP_CATEGORY%3D%E6%8E%A2%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.16&perpage=10&outlinepage=10";


        List<String> uriList = new ArrayList<>();


        for (int i = 1; i < 152; i++) {
            uriList.add("https://search.mnr.gov.cn/was5/web/search?page=" + i + "&channelid=112225,142099,180679,93332&searchword=+APP_CATEGORY%3D%E6%8E%A2%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.16&keyword=+APP_CATEGORY%3D%E6%8E%A2%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.16&perpage=10&outlinepage=10");
        }

        for (int i = 1; i < 3; i++) {
            uriList.add("https://search.mnr.gov.cn/was5/web/search?page=" + i + "&channelid=112225,142099,180679,93332&searchword=+APP_CATEGORY%3D%E6%8E%A2%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.16&keyword=+APP_CATEGORY%3D%E6%8E%A2%E7%9F%BF%E6%9D%83+and+DT_DATE%3E%3D2022.01.01+and+DT_DATE%3C%3D2024.08.16&perpage=10&outlinepage=10");
        }

        for (String htmlURI : uriList) {
            Document document = Jsoup.connect(htmlURI).cookies(cookies).get();
            Elements ul = document.getElementsByClass("gu-result gu-result1");
            Elements liList = ul.select("li a");

            for (Element element : liList) {
                String htmlUrl = element.toString();
                if (htmlUrl.contains("target=\"_blank\"")) {
                    htmlUrl = htmlUrl.replaceAll("<a href=\"", "");

                    int i = htmlUrl.indexOf(".htm");
                    htmlUrl = htmlUrl.substring(0, i) + ".htm";
                    Document pageDocument = Jsoup.connect(htmlUrl).cookies(cookies).get();


                    if (pageDocument.toString().contains("title=\"探矿权出让公告\" class=\"CurrChnlCls\">探矿权出让公告</a>")) {
                        System.err.println("1-1 探矿权出让公告");
                        LinkedHashMap<String, String> handler = TransferOfMiningRights.handler(pageDocument);
                    }
                    if (pageDocument.toString().contains("title=\"探矿权出让结果公示\" class=\"CurrChnlCls\">探矿权出让结果公示</a>")) {
                        System.err.println("1-2 探矿权出让结果公示");
                        LinkedHashMap<String, String> handler = TransferOfExplorationRights.handler(pageDocument);

                    }
                    if (pageDocument.toString().contains("title=\"探矿权协议出让公示\" class=\"CurrChnlCls\">探矿权协议出让公示</a>")) {
                        System.err.println("2 探矿权协议出让公示");
                        LinkedHashMap<String, String> handler = ExplorationRightsAgreement.handler(pageDocument);
                    }
                    if (pageDocument.toString().contains("title=\"探矿权转让公示\" class=\"CurrChnlCls\">探矿权转让公示</a>")) {
                        System.err.println("3-1 探矿权转让公示");
                        LinkedHashMap<String, String> handler = TransferOfExplorationRights2.handler(pageDocument);
                    }
                    if (pageDocument.toString().contains("title=\"采矿权转让公示\" class=\"CurrChnlCls\">采矿权转让公示</a>")) {
                        System.err.println("3-2 采矿权转让公示");
                        LinkedHashMap<String, String> handler = TransferOfMiningRights2.handler(pageDocument);
                    }


                   // pageTypeFactory(pageDocument);
                }
            }


        }


    }


    /***
     * 页面类型分发
     *
     * @author 王大宸
     * @date 2024/8/16 9:52
     * @param document document
     * @return void
     */
    public static void pageTypeFactory(Document document) throws IOException {
        if (document.toString().contains("title=\"探矿权出让公告\" class=\"CurrChnlCls\">探矿权出让公告</a>")) {
            System.err.println("1-1 探矿权出让公告");
            LinkedHashMap<String, String> handler = TransferOfMiningRights.handler(document);
        }
        if (document.toString().contains("title=\"探矿权出让结果公示\" class=\"CurrChnlCls\">探矿权出让结果公示</a>")) {
            System.err.println("1-2 探矿权出让结果公示");
        }
        if (document.toString().contains("title=\"探矿权协议出让公示\" class=\"CurrChnlCls\">探矿权协议出让公示</a>")) {
            System.err.println("2 探矿权协议出让公示");
        }
        if (document.toString().contains("title=\"探矿权转让公示\" class=\"CurrChnlCls\">探矿权转让公示</a>")) {
            System.err.println("3-1 探矿权转让公示");
        }
        if (document.toString().contains("title=\"采矿权转让公示\" class=\"CurrChnlCls\">采矿权转让公示</a>")) {
            System.err.println("3-2 采矿权转让公示");
        }
        System.err.println(document);
    }


}
