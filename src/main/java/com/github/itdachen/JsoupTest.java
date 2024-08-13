package com.github.itdachen;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 爬虫
 *
 * @author 王大宸
 * @date 2024-08-13 10:00
 */
public class JsoupTest {

    // static String url = "https://landchina.mnr.gov.cn/land/cjgs/pmcr/";

    public static void main(String[] args) throws IOException {
        // 设置cookie
        Map<String, String> cookies = new HashMap<String, String>();
        cookies.put("thor", "03F9B0325C5DCD2FCCDB435C227FD474D0B53C9143EB5DDA60599BDB9AE7A415B7CFEB4418F01DDEB8B8B9DD502D366A4E0BA2D84A0FE6CB6658061484CA95D230C7B76A36E31F4B329D2EFAC7DCD1E526F3C416CC50617276FED57FAF618892895784CB6446F6B8468A807290C12C3BA1C99DD0C0939C48C4E69681CA900EA9");

        List<String> list = new ArrayList<>();
        list.add("https://landchina.mnr.gov.cn/land/cjgs/pmcr/");
        list.add("https://landchina.mnr.gov.cn/land/cjgs/pmcr/index_1.htm");
        list.add("https://landchina.mnr.gov.cn/land/cjgs/pmcr/index_2.htm");
        list.add("https://landchina.mnr.gov.cn/land/cjgs/pmcr/index_3.htm");
        list.add("https://landchina.mnr.gov.cn/land/cjgs/pmcr/index_4.htm");
        list.add("https://landchina.mnr.gov.cn/land/cjgs/pmcr/index_5.htm");

        int index = 1;
        for (String url : list) {
            System.err.println("第 " + index + " 页");
            // 解析网页, document就代表网页界面
            Document document = Jsoup.connect(url).cookies(cookies).get();
            Elements ul = document.getElementsByClass("gu-iconList");
            Elements liList = ul.select("li a");
            for (Element element : liList) {
                String string = element.toString();
                String s = string.replaceAll("<a href=\"./", "");
                String substring = s.substring(0, 28);
                substring = "https://landchina.mnr.gov.cn/land/cjgs/pmcr/" + substring;

                Document doc = Jsoup.connect(substring).cookies(cookies).get();
                String string1 = doc.body().toString();



                try {
                    int i = string1.indexOf("成交价：");
                    int i1 = string1.indexOf("万元</td> ");
                    String cjj = string1.substring(i, i1).replaceAll("成交价：</td> \n" +
                            "              <td>&nbsp;", "");


                    Double v = Double.valueOf(cjj);
                    if (1000 <= v) {
                        System.err.println(doc.title() + " 成交价: " + cjj);
                    }
                } catch (Exception e) {

                }
            }


            index++;
        }


    }

}
