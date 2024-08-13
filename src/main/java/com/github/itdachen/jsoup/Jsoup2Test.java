package com.github.itdachen.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

/**
 * 爬虫
 *
 * @author 王大宸
 * @date 2024-08-13 10:00
 */
public class Jsoup2Test {

    static String url = "https://landchina.mnr.gov.cn/land/cjgs/pmcr/202408/t20240812_8993760.htm";

    public static void main(String[] args) throws Exception {

        Document doc = Jsoup.connect(url).get();

        Elements table = doc.getElementsByTag("table");
        for (Element element : table) {

            String docBody = element.toString();
            System.err.println(docBody);

            int i = docBody.indexOf("成交价：");
            int i1 = docBody.indexOf("万元</td> ");
            String cjj = docBody.substring(i, i1).replaceAll("成交价：</td> \n" +
                            "              <td>&nbsp;", "")
                    .replaceAll("成交价：</td> \n" +
                            "   <td>&nbsp;", "");
            Double v = Double.valueOf(cjj);
            // System.err.println(doc.title() + " 成交价: " + cjj + " 万元");


            int i4 = docBody.indexOf("<td>土地用途：</td> \n");
            int i5 = docBody.indexOf("<td>项目名称：</td>");
            String tdyt = docBody.substring(i4, i5)
                    .replaceAll("<td>土地用途：", "")
                    .replaceAll("<td>&nbsp;", "")
                    .replaceAll("</td> \n", "")
                    .replaceAll(" ", "");


            int i2 = docBody.indexOf("<td>受让单位：</td> \n");
            int i3 = docBody.indexOf("<td colspan=\"2\"></td>");
            String srdw = docBody.substring(i2, i3)
                    .replaceAll("<td>受让单位：", "")
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

            System.out.println(doc.title() +"; " +
                    "成交价: " + cjj + " 万元; " +
                    "土地用途: " + tdyt + "; " +
                    "受让单位: " + srdw + "; " +
                    "宗地总面积：" + mj + " 公顷; " +
                    "宗地坐落：" + zb+ "; " +
                    "备注：" + bz
            );

        }

    }

}
