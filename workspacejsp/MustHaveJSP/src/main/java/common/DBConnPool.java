package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class DBConnPool {
    public Connection con;
    public Statement stmt;  
    public PreparedStatement psmt;  
    public ResultSet rs;

   
    public DBConnPool() {
        try {
            // DB에 맞는 클래스 설정
            Context initCtx = new InitialContext();
            Context ctx = (Context)initCtx.lookup("java:comp/env");
            DataSource source = (DataSource)ctx.lookup("dbcp_myoracle");
            
            con = source.getConnection();
            
            System.out.println("DB 커넥션 풀 연결 성공");
        }
        catch (Exception e) {         
        	System.out.println("DB 커넥션 풀 연결 실패");
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

            System.out.println("DB 커넥션 풀 자원 반납");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}