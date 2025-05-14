package jsoup01;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class test3 {
	public static void main(String[] args) {
	
		String url = "https://www.netflix.com/kr/browse/genre/839338";
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		Elements elements  = doc.select(".nm-content-horizontal-row > ul > li");
		
		String strelements = doc.select(".nm-content-horizontal-row").text();
		
		System.out.println(strelements);
		String title = "";
		
		
		for (Element element : elements) {
			title = element.getElementsByClass("sub").text();
			System.out.println(title);
		}
	}



	}


