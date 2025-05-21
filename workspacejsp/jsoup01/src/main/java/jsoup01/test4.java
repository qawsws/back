package jsoup01;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class test4 {

    public static void main(String[] args) {

        String url = "https://ko.wikipedia.org/wiki/%EC%9E%90%EB%B0%94%EC%84%9C%EB%B2%84_%ED%8E%98%EC%9D%B4%EC%A7%80";
        Document doc = null;

        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Element table = doc.select("table.wikitable").first();

        if (table != null) {
            Element caption = table.selectFirst("caption");
            if (caption != null) {
                System.out.println("테이블 제목: " + caption.text());
                System.out.println("=".repeat(80));
            }

            Elements rows = table.select("tr");

            for (Element row : rows) {
                Elements cols = row.select("th, td");

                for (Element col : cols) {
                    System.out.print(col.text() + "\t");
                }
                System.out.println(); 
            }
        } else {
            System.out.println("표를 찾을 수 없습니다.");
        }
    }
}
