package test27;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test271 {
	 public static void main(String[] args) {
	        try {
	            String url = "https://quotes.toscrape.com/";
	            Document doc = Jsoup.connect(url).get();

	            
	            Elements quotes = doc.select(".quote");

	            for (Element quote : quotes) {
	               
	                String text = quote.selectFirst(".text").text();
	                String author = quote.selectFirst(".author").text();

	                System.out.println("명언: " + text);
	                System.out.println("작가: " + author);
	                System.out.println("---------------------------------");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
