package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletContext;

public class JDBConnect {
	//데이터베이스 접속 정보
    public Connection con;
    // 정적 쿼리문을 실행하는 객체
    public Statement stmt;  
    //동적 쿼리문을 실행하는 객체
    public PreparedStatement psmt;
    
    public ResultSet rs;

    // 기본 생성자
    public JDBConnect() {
        try {
            // DB에 맞는 클래스 설정
            Class.forName("oracle.jdbc.OracleDriver");

            // 접속할 데이터베이스의 주소
            String url = "jdbc:oracle:thin:@localhost:1521:xe";  
            //접속 가능한 id
            String id = "musthave";
            //패스워드
            String pwd = "1234"; 
            // getConnection(주소,아이디,비밀번호): 데이터베이스 실제 접속하는 함수
            con = DriverManager.getConnection(url, id, pwd); 
            System.out.println("DB 연결 성공(기본 생성자)");
        }
        catch (Exception e) {            
            e.printStackTrace();
        }
    }

    // 두 번째 생성자
    public JDBConnect(String driver, String url, String id, String pwd) {
        try {
            // JDBC 드라이버 로드
            Class.forName(driver);  

            // DB에 연결
            con = DriverManager.getConnection(url, id, pwd);

            System.out.println("DB 연결 성공(인수 생성자 1)");
        }
        catch (Exception e) {            
            e.printStackTrace();
        }
    }

    // 세 번째 생성자
    public JDBConnect(ServletContext application) {
        try {
            // JDBC 드라이버 로드
            String driver = application.getInitParameter("OracleDriver"); 
            Class.forName(driver); 

            // DB에 연결
            String url = application.getInitParameter("OracleURL"); 
            String id = application.getInitParameter("OracleId");
            String pwd = application.getInitParameter("OraclePwd");
            con = DriverManager.getConnection(url, id, pwd);

            System.out.println("DB 연결 성공(인수 생성자 2)"); 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 연결 해제(자원 반납)
    public void close() { 
    	// JDBConnect에서 생성했던 객체들 종료하는 메서드
        try {         
        	// ResultSet : SELECT의 결과를 담는 객체
            if (rs != null) rs.close(); 
            // Statement : 한건만 실행할 수 있는 객체
            if (stmt != null) stmt.close();
            // PreparedStatement : SQL문을 여러번 실행할 수 있는 객체
            if (psmt != null) psmt.close();
            //DB 접속 객체
            if (con != null) con.close(); 

            System.out.println("JDBC 자원 해제");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}