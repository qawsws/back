
package org;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


class Sido {
	String citycode;
	String cityname;
	 
	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public Sido(String citycode, String cityname) {
		this.citycode = citycode;
		this.cityname = cityname;
	}
	 
}

public class Togo3 {

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, ParseException {
		
		List<String> paramList = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        
        sb = getOrgApi("sido","", null);
        
        parseJson(sb);
	}
        
      /*  for (int i = 0; i < 2; i++) {
        	sb = getOrgApi("sido","", null);
        	parseXml(sb);
//        scaner 11 -- 부산코드 
        	sb = new StringBuilder();
        	sb = getOrgApi("station","11", null);
        	parseXml(sb);
//        scaner NAT010000 서울역 --> NAT011668 부산역
        	paramList.add("NAT010000");
		}
//      scaner 출발시각.20230403
        
        sb = getOrgApi("train","20230403",paramList);
        parseXml(sb);

	}*/
	
	public static StringBuilder getOrgApi(String type, String option ,List<String> stationList) throws IOException {
		
		String baseUrl = "";
		StringBuilder urlBuilder = null;
		if (type.equals("sido")) {
			baseUrl = "http://apis.data.go.kr/1613000/TrainInfoService/getCtyCodeList";
			urlBuilder = new StringBuilder(baseUrl); /*URL*/
			urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=uDZq2pbS7g7A4so5ItYt%2FsCHAgMOeRNNOg27cjP3hnQ4ZisoZygPHdYqeKjAvZ63KxHcVdr1dpmPTjpLQLGMdg%3D%3D");
			urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*데이터 타입(xml, json)*/
		}else if(type.equals("station")) {
			baseUrl = "http://apis.data.go.kr/1613000/TrainInfoService/getCtyAcctoTrainSttnList";
			urlBuilder = new StringBuilder(baseUrl); /*URL*/
			urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=uDZq2pbS7g7A4so5ItYt%2FsCHAgMOeRNNOg27cjP3hnQ4ZisoZygPHdYqeKjAvZ63KxHcVdr1dpmPTjpLQLGMdg%3D%3D");
			urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*데이터 타입(xml, json)*/
			urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("cityCode","UTF-8") + "=" + URLEncoder.encode(option, "UTF-8")); /*시/도 ID*/
		}else {
			baseUrl = "http://apis.data.go.kr/1613000/TrainInfoService/getCtyAcctoTrainSttnList";
			urlBuilder = new StringBuilder(baseUrl); /*URL*/
			urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=uDZq2pbS7g7A4so5ItYt%2FsCHAgMOeRNNOg27cjP3hnQ4ZisoZygPHdYqeKjAvZ63KxHcVdr1dpmPTjpLQLGMdg%3D%3D");
			urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*데이터 타입(xml, json)*/
			urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("trainGradeCode","UTF-8") + "=" + URLEncoder.encode("00", "UTF-8")); /*차량종류코드*/
	        urlBuilder.append("&" + URLEncoder.encode("depPlaceId","UTF-8") + "=" + URLEncoder.encode(stationList.get(0), "UTF-8")); /*출발기차역ID [상세기능3. 시/도별 기차역 목록조회]에서 조회 가능*/
	        urlBuilder.append("&" + URLEncoder.encode("arrPlaceId","UTF-8") + "=" + URLEncoder.encode(stationList.get(1), "UTF-8")); /*도착기차역ID [상세기능3. 시/도별 기차역 목록조회]에서 조회 가능*/
	        urlBuilder.append("&" + URLEncoder.encode("depPlandTime","UTF-8") + "=" + URLEncoder.encode(option, "UTF-8")); /*출발일(YYYYMMDD)*/
	        
		}
        
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println(conn.getResponseCode());
        
        BufferedReader br = null;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		}else {
			br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
        
        StringBuilder sb = new StringBuilder();
        String line = "";
        
        while ((line = br.readLine()) != null) {
        	sb.append(line);
		}
        
        conn.disconnect();
        br.close();
        
        return sb;
	}
	
	
	public static List<Sido> parseXml(StringBuilder sb) throws ParserConfigurationException, SAXException, IOException {
		InputStream is = new ByteArrayInputStream(sb.toString().getBytes());
		List<Sido> sidoList = new ArrayList<Sido>();
		
		//도큐먼트 만들기.
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(is);
        
        //xml 컨트롤
        Element root = doc.getDocumentElement();
        NodeList nlist = root.getElementsByTagName("item");
        
        for (int i = 0; i < nlist.getLength(); i++) {
			Node node = nlist.item(i);
			NodeList childNodeList = node.getChildNodes();
			
			for (int j = 0; j < childNodeList.getLength() ; j++) {
				Node child = childNodeList.item(j);
				String nName = child.getNodeName();
				String nValue = child.getTextContent();
//				Sido sido = new Sido(nValue, nName);
//				sidoList.add(sido);
				System.out.println(nName +" : "+ nValue);
			}
			
		}
        
        return sidoList;
	}



public static List<Sido> parseJson(StringBuilder sb) throws ParserConfigurationException,SAXException, IOException, ParseException, org.json.simple.parser.ParseException {
	
	List<Sido> sidoList = new ArrayList<Sido>();
	List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>(); 
	
	JSONParser jp = new JSONParser();
	JSONObject jo = (JSONObject) jp.parse(sb.toString());
	JSONObject jsonResponse = (JSONObject) jo.get("response");
	JSONObject jsonBody = (JSONObject) jsonResponse.get("body");
	JSONObject jsonItems = (JSONObject) jsonBody.get("items");
	JSONArray jsonItem = (JSONArray) jsonItems.get("item");
	System.out.println(jsonItem);

	for (Object object : jsonItem) {
		JSONObject obj = (JSONObject) object;
		Set<String> it = obj.keySet();
		for (String key : it) {
			System.out.print(obj.get(key)+" : ");
		}
		System.out.println();
	}
	for (Object object : jsonItem) {
		Map<String, Object> obj = (Map<String, Object>) object;
		mapList.add(obj);
	}
	for (Object object : jsonItem) {
			JSONObject sidoJson = (JSONObject) object;
			Sido sido = new Sido(sidoJson.get("citycode").toString(), sidoJson.get("cityname").toString());
			sidoList.add(sido);
		}
	for (Sido sido : sidoList) {
			System.out.println(sido.getCitycode() +" : "+sido.getCityname());
	}
	return sidoList;
	}
}
