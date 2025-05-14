package jsoup01;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class test01 {

	public static void main(String[] args) {
		
		String strHtml = "<!DOCTYPE html>"
			+"<html>"
			+"<head>"
			+"<title>JSoup Example</title>"
			+"<head>"
			+"<body>"
			+"<table><tr><rd><h1>HelloWorld</h1></tr>"
			+"<table>"
			+"<body>"
			+"<html>";
			
		Document html = Jsoup.parse(strHtml);
		String title = html.title();
		String h1 = html.body().getElementsByTag("h1").text();
		
		System.out.println(title);
		System.out.println(h1);
	}

}
