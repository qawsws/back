package jsoup01;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class test6 {
    public static void main(String[] args) {
        try {
            String url = "https://www.google.co.kr/search?sca_esv=2c9182675fadbcab&q=%EA%B0%95%EC%95%84%EC%A7%80&udm=2&fbs=ABzOT_CZsxZeNKUEEOfuRMhc2yCI6hbTw9MNVwGCzBkHjFwaK6Wwr2U3Otxxdo7bek3qh0jM1D_pZCsNckRgN6AmwjZfmST0m_jvGek5FeiJmDC0zcKiMp0KimAcWcHBSIgWzKBsEtsn-3YCXXmuOEiA3QqOVmOs0UtF884YwNfHR4Y1goaqReiUNau8OEz0HIN0vDtwbqcfIEOTKcov-hTh4M_vK_XQ5__R-rOjVT7_Gv09eVYR3zw&sa=X&ved=2ahUKEwiVtZjE9bONAxUsslYBHWz5KGcQtKgLegQIDRAB&biw=952&bih=963&dpr=1";
            Document doc = Jsoup.connect(url).get();

            Element figure = doc.select("eA0Zlc WghbWd FnEtTd mkpRId m3LIae RLdvSe qyKxnc ivg-i PZPZlf GMCzAd").first();

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
