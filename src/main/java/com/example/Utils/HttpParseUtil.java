package com.example.Utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class HttpParseUtil {
    public static void main(String[] args) throws Exception {
        parseJD("小新");
    }
    public static void parseJD(String keykords) throws Exception{
        String url = "https://search.jd.com/Search?keyword="+keykords;
        Document document = Jsoup.parse(new URL(url),30000);
        Element element = document.getElementById("J_goodsList");
        Elements elements = element.getElementsByTag("li");
        for(Element e:elements){
            String img = e.getElementsByTag("img").eq(0).attr("src");
            String price = e.getElementsByClass("p-price").eq(0).text();
            String title = e.getElementsByClass("p-name").eq(0).text();
            System.out.println("--------------------------------------");
            System.out.println(img);
            System.out.println(price);
            System.out.println(title);

        }
    }
}
