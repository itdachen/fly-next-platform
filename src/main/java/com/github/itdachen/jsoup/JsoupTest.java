package com.github.itdachen.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.util.*;

/**
 * 爬虫 自然资源部
 *
 * @author 王大宸
 * @date 2024-08-13 10:00
 */
public class JsoupTest {
    private static final Logger logger = LoggerFactory.getLogger(JsoupTest.class);

    public static void main(String[] args) throws Exception {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // 设置cookie
        Map<String, String> cookies = new HashMap<String, String>();
        cookies.put("thor", "03F9B0325C5DCD2FCCDB435C227FD474D0B53C9143EB5DDA60599BDB9AE7A415B7CFEB4418F01DDEB8B8B9DD502D366A4E0BA2D84A0FE6CB6658061484CA95D230C7B76A36E31F4B329D2EFAC7DCD1E526F3C416CC50617276FED57FAF618892895784CB6446F6B8468A807290C12C3BA1C99DD0C0939C48C4E69681CA900EA9");

        List<String> list = new ArrayList<>();
        list.add("https://landchina.mnr.gov.cn/land/cjgs/pmcr/");


        for (int i = 1; i < 120; i++) {
            list.add("https://landchina.mnr.gov.cn/land/cjgs/pmcr/index_" + i + ".htm");
        }

        List<LinkedHashMap<String, String>> dataList = new ArrayList<>();

        int index = 1;
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        for (String url : list) {
            System.err.println();
            System.err.println("第 " + index + " 页");
            // 解析网页, document就代表网页界面
            Document document = Jsoup.connect(url).cookies(cookies).get();
            Elements ul = document.getElementsByClass("gu-iconList");
            Elements liList = ul.select("li a");
            for (Element element : liList) {
                String htmlUrl = element.toString().replaceAll("<a href=\"./", "").substring(0, 28);
                htmlUrl = "https://landchina.mnr.gov.cn/land/cjgs/pmcr/" + htmlUrl;

                Document doc = Jsoup.connect(htmlUrl).cookies(cookies).get();
                Elements table = doc.getElementsByTag("table");

                for (Element tableElement : table) {
                    String docBody = tableElement.toString();

                    try {
                        int i = docBody.indexOf("成交价：");
                        int i1 = docBody.indexOf("万元</td> ");
                        String cjj = docBody.substring(i, i1).replaceAll("成交价：</td> \n" +
                                        "              <td>&nbsp;", "")
                                .replaceAll("成交价：</td> \n" +
                                        "   <td>&nbsp;", "");


                        /* 成交价在 1000 万元以上的 */
                        Double v = Double.valueOf(cjj);
                        if (1000 <= v) {
                            int i2 = docBody.indexOf("<td>受让单位：</td> \n");
                            int i3 = docBody.indexOf("<td colspan=\"2\"></td>");
                            String srdw = docBody.substring(i2, i3)
                                    .replaceAll("<td>受让单位：", "")
                                    .replaceAll("<td>&nbsp;", "")
                                    .replaceAll("</td> \n", "")
                                    .replaceAll(" ", "");

                            int i4 = docBody.indexOf("<td>土地用途：</td> \n");
                            int i5 = docBody.indexOf("<td>项目名称：</td>");
                            String tdyt = docBody.substring(i4, i5)
                                    .replaceAll("<td>土地用途：", "")
                                    .replaceAll("<td>&nbsp;", "")
                                    .replaceAll("</td> \n", "")
                                    .replaceAll(" ", "");

                            int i6 = docBody.indexOf("<td style=\"width:90px;\">宗地总面积：</td> \n");
                            int i7 = docBody.indexOf("<td style=\"width:90px;\">宗地坐落：</td> ");
                            String mj = docBody.substring(i6, i7)
                                    .replaceAll("<td style=\"width:90px;\">宗地总面积：</td> \n", "")
                                    .replaceAll("<td style=\"width:220px;\">&nbsp;", "")
                                    .replaceAll("公顷</td>\n", "")
                                    .replaceAll("公顷", "")
                                    .replaceAll("</td> \n", "")
                                    .replaceAll(" ", "");

                            int i8 = docBody.indexOf("<td style=\"width:90px;\">宗地坐落：</td> ");
                            int i9 = docBody.indexOf("</tr> \n" +
                                    "  <tr> \n" +
                                    "   <td>年限：</td> ");
                            String zb = docBody.substring(i8, i9)
                                    .replaceAll("<td style=\"width:90px;\">宗地坐落：</td> \n", "")
                                    .replaceAll("<td style=\"width:220px;\" colspan=\"3\">&nbsp;", "")
                                    .replaceAll("\"</tr> \\n\" +\n" +
                                            "                    \"  <tr> \\n\" +\n" +
                                            "                    \"   <td>年限：</td> \"", "")
                                    .replaceAll("</td> \n", "")
                                    .replaceAll(" ", "");


                            int i10 = docBody.indexOf("<td>备注：</td> ");
                            int i11 = docBody.indexOf("</td> \n" +
                                    "  </tr> \n" +
                                    " </tbody> ");
                            String bz = docBody.substring(i10, i11)
                                    .replaceAll("<td>备注：</td> \n", "")
                                    .replaceAll("<td colspan=\"5\">", "")
                                    .replaceAll("</td> \n" +
                                            "  </tr> \n" +
                                            " </tbody> ", "")
                                    .replaceAll("</td> \n", "")
                                    .replaceAll(" ", "");

                            System.out.println(doc.title() + "; " +
                                    "成交价: " + cjj + " 万元; " +
                                    "土地用途: " + tdyt + "; " +
                                    "受让单位: " + srdw + "; " +
                                    "宗地总面积：" + mj + " 公顷; " +
                                    "宗地坐落：" + zb + "; " +
                                    "备注：" + bz
                            );

                            linkedHashMap = new LinkedHashMap<>();
                            linkedHashMap.put("title", doc.title());
                            linkedHashMap.put("cjj", cjj);
                            linkedHashMap.put("tdyt", tdyt);
                            linkedHashMap.put("srdw", srdw);
                            linkedHashMap.put("mj", mj);
                            linkedHashMap.put("zb", zb);
                            linkedHashMap.put("bz", bz);
                            linkedHashMap.put("Uri", htmlUrl);
                            dataList.add(linkedHashMap);

                        }
                    } catch (Exception e) {
                        logger.error("错误: ", e);
                    }

                }

            }
            index++;
        }


        XSSFWorkBookExpHelper workBookExpHelper = new XSSFWorkBookExpHelper();

        List<String> fields = new ArrayList<>();
        fields.add("标题");
        fields.add("成交价(万元)");
        fields.add("土地用途");
        fields.add("受让单位");
        fields.add("宗地总面积(公顷)");
        fields.add("宗地坐落");
        fields.add("备注");
        fields.add("访问地址");

        System.out.println("正在写入 Excel ....");
        workBookExpHelper.expHandler(fields,
                dataList,
                "拍卖出让",
                true,
                "D:/upload/");


        stopWatch.stop();
        double totalTimeSeconds = stopWatch.getTotalTimeSeconds();

        System.out.println("写入 Excel 完成....");
        System.out.println("获取数据 " + dataList.size() + " 条");
        System.out.println("共耗时 " + totalTimeSeconds + " Seconds");
    }

}
