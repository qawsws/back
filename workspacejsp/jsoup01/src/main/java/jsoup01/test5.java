package jsoup01;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class test5 {
    public static void main(String[] args) {
        try {
            String url = "https://ko.wikipedia.org/wiki/자카르타_서버_페이지";
            Document doc = Jsoup.connect(url).get();

            Element figure = doc.select("figure.mw-default-size").first();

            if (figure != null) {
                Element img = figure.selectFirst("img");
                String imgSrc = "https:" + img.attr("src");

                Element caption = figure.selectFirst("figcaption");
                String description = caption.text();

                System.out.println("이미지 URL: " + imgSrc);
                System.out.println("설명글: " + description);
            } else {
                System.out.println("figure 요소를 찾을 수 없습니다.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
