package org;


import java.io.*;
import java.net.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

// 🔷 열차정보 조회를 위한 전체 통합 파일
public class Tago2 {

    /* ✅ 1. 시/도 클래스 */
    static class City {
        String cityCode, cityName;
        public City(String cityCode, String cityName) {
            this.cityCode = cityCode;
            this.cityName = cityName;
        }
        public String toString() {
            return cityName + " (" + cityCode + ")";
        }
    }

    /* ✅ 2. 역(Station) 클래스 */
    static class Station {
        String stationCode, stationName;
        public Station(String stationCode, String stationName) {
            this.stationCode = stationCode;
            this.stationName = stationName;
        }
        public String toString() {
            return stationName + " (" + stationCode + ")";
        }
    }

    /* ✅ 3. 열차 정보 클래스 */
    static class TrainInfo {
        String trainNo, trainType, depTime, arrTime, depStation, arrStation;
        int charge;
        public TrainInfo(String trainNo, String trainType, String depTime, String arrTime, String depStation, String arrStation, int charge) {
            this.trainNo = trainNo;
            this.trainType = trainType;
            this.depTime = depTime;
            this.arrTime = arrTime;
            this.depStation = depStation;
            this.arrStation = arrStation;
            this.charge = charge;
        }
        public String toString() {
            return "[" + trainType + "] " + depStation + " -> " + arrStation + " | "
                + depTime + " ~ " + arrTime + " | 요금: " + String.format("%,d원", charge);
        }
    }

 // 🔸 공통 파서 함수 (URL → XML 파싱)
 // ✅ 주어진 URL에서 XML을 불러와서 Document 객체로 반환하는 메서드
    public static Document loadXmlFromUrl(String urlStr) throws Exception {
        
        // 1. 문자열 형태의 URL을 실제 URL 객체로 변환
        URL url = new URL(urlStr);
        // 2. 해당 URL로 HTTP 연결을 생성
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // 3. 요청 방식 설정: GET 방식 (데이터 조회용)
        conn.setRequestMethod("GET");
        // 4. 응답 코드가 200이면 정상 → InputStream 사용, 아니면 에러 스트림 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(
            conn.getResponseCode() == 200 ? conn.getInputStream() : conn.getErrorStream(), "UTF-8"));
        // 5. 응답 내용을 한 줄씩 읽어서 StringBuilder에 저장
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) sb.append(line);

        // 6. 스트림 닫기 (자원 해제)
        br.close();

        // 7. 문자열 형태로 받은 XML을 InputStream으로 변환
        InputStream is = new ByteArrayInputStream(sb.toString().getBytes());
        // 8. XML 파서를 생성하기 위한 팩토리 객체 생성
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // 9. 실제 XML 파싱을 담당할 빌더 객체 생성
        DocumentBuilder builder = factory.newDocumentBuilder();
        // 10. InputStream을 파싱해서 Document(XML 문서 구조 객체)로 반환
        return builder.parse(is);
    }


 // ✅ 시/도 정보를 API에서 받아와 List<City>로 반환하는 메서드
    public static List<City> getCityList() throws Exception {
        
        // 1. 호출할 OpenAPI 주소 정의 (시/도 코드 목록 조회)
        String urlStr = "http://apis.data.go.kr/1613000/TrainInfoService/getCtyCodeList"
            + "?serviceKey=AlWhOoxVo8cb9%2BloJm80P%2Ba8Rjc8Ye9xV6LZUb%2BqGPnMKfN8%2BpHAesHVC49t0atZPDfLBuZ6EjifemNQKFJs1w%3D%3D";

        // 2. XML을 파싱해서 DOM 객체(Document)로 변환 (이전 메서드에서 작성한 공통 파서 사용)
        Document doc = loadXmlFromUrl(urlStr);
        // 3. <item> 태그 목록을 모두 가져옴 (각 item이 하나의 시/도를 의미)
        NodeList items = doc.getElementsByTagName("item");
        // 4. 결과를 저장할 리스트 생성
        List<City> list = new ArrayList<>();                           ;

        // 5. 각 <item> 태그를 순회하면서 citycode와 cityname을 추출
        for (int i = 0; i < items.getLength(); i++) {
            Element e = (Element) items.item(i);  // 현재 <item> 태그
            // <citycode>와 <cityname> 태그의 텍스트 값을 추출
            String code = e.getElementsByTagName("citycode").item(0).getTextContent();
            String name = e.getElementsByTagName("cityname").item(0).getTextContent();
            // City 객체를 생성해서 리스트에 추가
            list.add(new City(code, name));
        }
        // 6. 파싱된 전체 시/도 리스트 반환
        return list;
    }


 // ✅ 시/도 코드(cityCode)를 이용해 해당 지역의 역 목록을 가져오는 메서드
    public static List<Station> getStationList(String cityCode) throws Exception {
        
        // 1. 호출할 OpenAPI URL 문자열 정의
        // - getCtyAcctoTrainSttnList: 시/도에 따른 철도역 목록을 조회하는 API
        // - cityCode: 사용자가 선택한 시/도의 코드
        // - URLEncoder.encode: URL에 한글이나 특수문자가 있으면 인코딩 필수!
        String urlStr = "http://apis.data.go.kr/1613000/TrainInfoService/getCtyAcctoTrainSttnList"
            + "?serviceKey=AlWhOoxVo8cb9%2BloJm80P%2Ba8Rjc8Ye9xV6LZUb%2BqGPnMKfN8%2BpHAesHVC49t0atZPDfLBuZ6EjifemNQKFJs1w%3D%3D"
            + "&cityCode=" + URLEncoder.encode(cityCode, "UTF-8") + "&numOfRows=100";

        // 2. URL에서 XML 데이터를 받아와 Document 객체로 파싱
        Document doc = loadXmlFromUrl(urlStr);
        // 3. <item> 태그들을 모두 가져오기 (각 item은 하나의 역 정보를 담고 있음)
        NodeList items = doc.getElementsByTagName("item");
        // 4. 결과를 저장할 리스트 준비
        List<Station> list = new ArrayList<>();

        // 5. 각 <item> 태그를 반복하면서 역 코드(nodeid)와 이름(nodename) 추출
        for (int i = 0; i < items.getLength(); i++) {
            Element e = (Element) items.item(i);  // 현재 <item> 태그
            // 태그 내의 <nodeid>와 <nodename> 값 추출
            String code = e.getElementsByTagName("nodeid").item(0).getTextContent();
            String name = e.getElementsByTagName("nodename").item(0).getTextContent();
            // Station 객체 생성 후 리스트에 추가
            list.add(new Station(code, name));
        }
        // 6. 결과 리스트 반환
        return list;
    }


 // ✅ 열차 정보 API를 호출해서, 출발역-도착역-날짜 기준으로 열차 목록을 반환하는 메서드
    public static List<TrainInfo> getTrainList(String depCode, String arrCode, String date) throws Exception {

        // 1. API 요청 주소 구성
        // - getStrtpntAlocFndTrainInfo: 출발역과 도착역에 따른 열차를 조회하는 API
        // - depPlaceId: 출발역 코드
        // - arrPlaceId: 도착역 코드
        // - depPlandTime: 출발일 (형식: yyyyMMdd)
        String urlStr = "http://apis.data.go.kr/1613000/TrainInfoService/getStrtpntAlocFndTrainInfo"
            + "?serviceKey=AlWhOoxVo8cb9%2BloJm80P%2Ba8Rjc8Ye9xV6LZUb%2BqGPnMKfN8%2BpHAesHVC49t0atZPDfLBuZ6EjifemNQKFJs1w%3D%3D"
            + "&depPlaceId=" + URLEncoder.encode(depCode, "UTF-8")
            + "&arrPlaceId=" + URLEncoder.encode(arrCode, "UTF-8")
            + "&depPlandTime=" + date
            + "&numOfRows=100";  // 한 번에 최대 100개까지 가져옴

        // 2. XML을 파싱해서 DOM(Document) 객체 생성
        Document doc = loadXmlFromUrl(urlStr);
        // 3. <item> 태그들 가져오기 (각 item은 하나의 열차 정보)
        NodeList items = doc.getElementsByTagName("item");
        // 4. 결과를 담을 리스트 생성
        List<TrainInfo> list = new ArrayList<>();

        // 5. 각 <item> 요소에서 열차 상세 정보 추출
        for (int i = 0; i < items.getLength(); i++) {
            Element e = (Element) items.item(i); // 현재 <item> 태그
            // 🔸 열차번호 (예: 1001)
            String trainNo = e.getElementsByTagName("trainno").item(0).getTextContent();
            // 🔸 열차 종류 (예: KTX, 무궁화, 새마을 등)
            String trainType = e.getElementsByTagName("traingradename").item(0).getTextContent();
            // 🔸 출발 시각 (예: 202405211000 → 10:00으로 변환 위해 substring 사용)
            String depTime = e.getElementsByTagName("depplandtime").item(0).getTextContent().substring(8, 12);
            // 🔸 도착 시각
            String arrTime = e.getElementsByTagName("arrplandtime").item(0).getTextContent().substring(8, 12);
            // 🔸 출발역 이름
            String depName = e.getElementsByTagName("depplacename").item(0).getTextContent();
            // 🔸 도착역 이름
            String arrName = e.getElementsByTagName("arrplacename").item(0).getTextContent();
            // 🔸 어른 요금 (문자열로 오기 때문에 숫자로 변환)
            int charge = Integer.parseInt(e.getElementsByTagName("adultcharge").item(0).getTextContent());
            // 🔸 TrainInfo 객체 생성 후 리스트에 추가
            list.add(new TrainInfo(trainNo, trainType, depTime, arrTime, depName, arrName, charge));
        }
        // 6. 완성된 열차 리스트 반환
        return list;
    }


    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // ① 시/도 목록 불러오기
            List<City> cities = getCityList();
            System.out.println("🔹 시/도 목록:");
            for (City city : cities) System.out.println("- " + city);  // 예: 서울특별시 (11)

            // ② 사용자로부터 출발할 시/도 코드 입력 받기
            System.out.print("\n출발 시/도 코드 입력: ");
            String depCity = sc.nextLine().trim();

            // ③ 해당 시/도의 출발역 목록 조회
            List<Station> depStations = getStationList(depCity);
            for (Station s : depStations) System.out.println("- " + s);  // 예: 서울역 (NAT...)

            // ④ 출발역 이름 입력 → 코드 추출
            System.out.print("\n출발역 이름 입력: ");
            String depInput = sc.nextLine().trim();
            String depCode = depStations.stream()
                .filter(s -> s.stationName.contains(depInput))     // 입력값이 포함된 역 이름 찾기
                .map(s -> s.stationCode)                           // 해당 역의 코드만 추출
                .findFirst()
                .orElse(null);
            if (depCode == null) throw new RuntimeException("출발역 없음");

            // ⑤ 도착 시/도 코드 입력 및 해당 시/도 역 목록 조회
            System.out.print("\n도착 시/도 코드 입력: ");
            String arrCity = sc.nextLine().trim();
            List<Station> arrStations = getStationList(arrCity);
            for (Station s : arrStations) System.out.println("- " + s);

            // ⑥ 도착역 이름 입력 → 코드 추출
            System.out.print("\n도착역 이름 입력: ");
            String arrInput = sc.nextLine().trim();
            String arrCode = arrStations.stream()
                .filter(s -> s.stationName.contains(arrInput))
                .map(s -> s.stationCode)
                .findFirst()
                .orElse(null);
            if (arrCode == null) throw new RuntimeException("도착역 없음");

            // ⑦ 출발일 입력 받기 (형식: 20240521)
            System.out.print("\n출발일 (yyyymmdd): ");
            String date = sc.nextLine().trim();

            // ⑧ 열차 정보 조회
            List<TrainInfo> trains = getTrainList(depCode, arrCode, date);

            // ⑨ 결과 출력
            System.out.println("\n🔍 조회 결과:");
            for (TrainInfo t : trains) System.out.println(t);

        } catch (Exception e) {
            // 예외 발생 시 메시지 출력
            System.out.println("❗ 오류 발생: " + e.getMessage());
        }
    }

}