package test27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import com.google.gson.*;

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

    public String getPerformInst() { return performInst; }
    public String getBsnsNm() { return bsnsNm; }
    public String getBsnsKind() { return bsnsKind; }
    public String getTel() { return tel; }
    public String getPeople() { return people; }
    public String getBsnsMainActvt() { return bsnsMainActvt; }
    public String getBsnsSdate() { return bsnsSdate; }
    public String getBsnsFdate() { return bsnsFdate; }
    public String getGugun() { return gugun; }
    public String getDataDay() { return dataDay; }}

class Items {
    List<Job> item;
}

class Body {
    Items items;
}

class Response {
    Body body;
}

class JobResponse {
    Response response;
}

public class Test272 {
    public static final String SERVICE_KEY = "AlWhOoxVo8cb9%2BloJm80P%2Ba8Rjc8Ye9xV6LZUb%2BqGPnMKfN8%2BpHAesHVC49t0atZPDfLBuZ6EjifemNQKFJs1w%3D%3D";
    public static void main(String[] args) {
        try {
            List<Job> jobs = fetchAllJobs();
            Set<String> guSet = new HashSet<>();
            for (Job job : jobs) {
                if (job.getGugun() != null) {
                    guSet.add(job.getGugun());
                }
            }
            System.out.println("부산광역시 구 목록:");
            for (String gu : guSet) {
                System.out.println(gu);
            }
            Scanner scanner = new Scanner(System.in);
            System.out.print("조회할 구 입력하세요: ");
            String inputGu = scanner.nextLine();
            scanner.close();
            List<Job> filteredJobs = new ArrayList<>();
            for (Job job : jobs) {
                if (inputGu.equals(job.getGugun())) {
                    filteredJobs.add(job);
                }
            }
            if (filteredJobs.isEmpty()) {
                System.out.println("정보가 없습니다.");
            } else {
                for (Job job : filteredJobs) {
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
            System.out.println("오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static List<Job> fetchAllJobs() throws Exception {
        String urlStr = "https://apis.data.go.kr/6260000/BusanTblAgedjobStusService/getTblAgedjobStusInfo"
                + "?serviceKey=" + SERVICE_KEY
                + "&pageNo=1&numOfRows=1000&resultType=json";
        String json = readUrl(urlStr);
        Gson gson = new Gson();
        JobResponse jobResponse = gson.fromJson(json, JobResponse.class);
        return jobResponse.response.body.items.item;
    }		
    
    public static String readUrl(String urlStr) throws Exception {
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
