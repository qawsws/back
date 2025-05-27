package test27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

class Job {
    private String performInst;
    private String bsnsNm;
    private String bsnsKind;
    private String tel;
    private String people;
    private String bsnsMainActvt;
    private String bsnsSdate;
    private String bsnsFdate;
    private String gugun;
    private String dataDay;

    public Job(String performInst, String bsnsNm, String bsnsKind, String tel, String people,
               String bsnsMainActvt, String bsnsSdate, String bsnsFdate, String gugun, String dataDay) {
        this.performInst = performInst;
        this.bsnsNm = bsnsNm;
        this.bsnsKind = bsnsKind;
        this.tel = tel;
        this.people = people;
        this.bsnsMainActvt = bsnsMainActvt;
        this.bsnsSdate = bsnsSdate;
        this.bsnsFdate = bsnsFdate;
        this.gugun = gugun;
        this.dataDay = dataDay;
    }

    public String getPerformInst() { return performInst; }
    public String getBsnsNm() { return bsnsNm; }
    public String getBsnsKind() { return bsnsKind; }
    public String getTel() { return tel; }
    public String getPeople() { return people; }
    public String getBsnsMainActvt() { return bsnsMainActvt; }
    public String getBsnsSdate() { return bsnsSdate; }
    public String getBsnsFdate() { return bsnsFdate; }
    public String getGugun() { return gugun; }
    public String getDataDay() { return dataDay; }
}

public class Test272 {
    private static final String SERVICE_KEY = "AlWhOoxVo8cb9%2BloJm80P%2Ba8Rjc8Ye9xV6LZUb%2BqGPnMKfN8%2BpHAesHVC49t0atZPDfLBuZ6EjifemNQKFJs1w%3D%3D";

    public static void main(String[] args) {
        try {
            List<String> guList = getGuList();
            System.out.println("부산광역시 구 목록:");
            for (String gu : guList) {
                System.out.println(gu);
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("조회할 구 이름을 입력하세요: ");
            String inputGu = scanner.nextLine();
            scanner.close();

            List<Job> jobs = getJobsByGu(inputGu);

            if (jobs.isEmpty()) {
                System.out.println("해당 구의 정보가 없습니다.");
            } else {
                for (Job job : jobs) {
                    System.out.println("수행기관: " + job.getPerformInst());
                    System.out.println("사업명: " + job.getBsnsNm());
                    System.out.println("사업구분: " + job.getBsnsKind());
                    System.out.println("전화번호: " + job.getTel());
                    System.out.println("인원: " + job.getPeople());
                    System.out.println("주요활동내용: " + job.getBsnsMainActvt());
                    System.out.println("사업시작일: " + job.getBsnsSdate());
                    System.out.println("사업종료일: " + job.getBsnsFdate());
                    System.out.println("구군명: " + job.getGugun());
                    System.out.println("데이터기준일자: " + job.getDataDay());
                    System.out.println("------------------------------");
                }
            }
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다: " + e.getMessage());
        }
    }

    private static List<String> getGuList() throws Exception {
        String urlStr = "https://apis.data.go.kr/6260000/BusanTblAgedjobStusService/getTblAgedjobStusInfo"
                + "?serviceKey=" + SERVICE_KEY
                + "&pageNo=1&numOfRows=1000&resultType=json";

        String json = readUrl(urlStr);

        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(json);
        JSONObject response = (JSONObject) obj.get("response");
        JSONObject body = (JSONObject) response.get("body");
        JSONObject items = (JSONObject) body.get("items");
        JSONArray itemArray = (JSONArray) items.get("item");

        Set<String> guSet = new HashSet<>();
        for (Object o : itemArray) {
            JSONObject jobJson = (JSONObject) o;
            String gugun = (String) jobJson.get("gugun");
            if (gugun != null) {
                guSet.add(gugun);
            }
        }
        return new ArrayList<>(guSet);
    }

    private static List<Job> getJobsByGu(String gu) throws Exception {
        String urlStr = "https://apis.data.go.kr/6260000/BusanTblAgedjobStusService/getTblAgedjobStusInfo"
                + "?serviceKey=" + SERVICE_KEY
                + "&pageNo=1&numOfRows=1000&resultType=json";

        String json = readUrl(urlStr);

        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(json);
        JSONObject response = (JSONObject) obj.get("response");
        JSONObject body = (JSONObject) response.get("body");
        JSONObject items = (JSONObject) body.get("items");
        JSONArray itemArray = (JSONArray) items.get("item");

        List<Job> jobs = new ArrayList<>();
        for (Object o : itemArray) {
            JSONObject jobJson = (JSONObject) o;
            String gugunVal = (String) jobJson.get("gugun");
            if (gugunVal != null && gugunVal.trim().equals(gu.trim())) {
                jobs.add(new Job(
                    (String) jobJson.get("performInst"),
                    (String) jobJson.get("bsnsNm"),
                    (String) jobJson.get("bsnsKind"),
                    (String) jobJson.get("tel"),
                    (String) jobJson.get("people"),
                    (String) jobJson.get("bsnsMainActvt"),
                    (String) jobJson.get("bsnsSdate"),
                    (String) jobJson.get("bsnsFdate"),
                    (String) jobJson.get("gugun"),
                    (String) jobJson.get("dataDay")
                ));
            }
        }
        return jobs;
    }

    private static String readUrl(String urlStr) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader br;
        if (con.getResponseCode() >= 200 && con.getResponseCode() < 300) {
            br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
        } else {
            br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "UTF-8"));
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();

        return sb.toString();
    }
}
