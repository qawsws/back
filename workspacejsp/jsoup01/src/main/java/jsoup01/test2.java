package jsoup01;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class test2 {

	public static void main(String[] args) {
		
		String url = "https://news.sbs.co.kr/news/newsSection.do?sectionType=01&plink=GNB&cooper=SBSNEWS";
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		Elements elements  = doc.select(".w_news_list > ul > li");
		
		String strelements = doc.select(".w_news_list.type_issue2 > ul > li").text();
		
		System.out.println(strelements);
		String sub = "";
		String read = "";
		String date = "";
		
		for (Element element : elements) {
			sub = element.getElementsByClass("sub").text();
			read = element.getElementsByClass("read").text();
			date = element.getElementsByClass("date").text();
			System.out.println(sub+"\n"+read+"\n"+date);
		}
	}

}
