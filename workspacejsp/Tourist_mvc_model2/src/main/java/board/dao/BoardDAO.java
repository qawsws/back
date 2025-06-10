package board.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import board.dto.BoardDTO;
import common.DBConnPool;

public class BoardDAO extends DBConnPool{
	public int selectCount(Map<String, Object> map) {
		int totalCount = 0;
		
		String query = "SELECT COUNT(*) FROM TOURIST_NOTICE";
		if(map.get("searchWord") != null) {
			query += " WHERE title "
					+" LIKE '%" + map.get("searchWord") + "%'";
		}
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			totalCount = rs.getInt(1);
		}catch(Exception e) {
			System.out.println("게시물 수를 구하는 중 예외 발생");
			e.printStackTrace();
		}
		return totalCount;
	}
	 public List<BoardDTO> selectListPage(Map<String, Object> map) {
	        List<BoardDTO> list = new ArrayList<>();
	        int start = (int) map.get("start");
	        int end = (int) map.get("end");
	        String searchWord = (String) map.get("searchWord");

	        String query = "SELECT * FROM (" +
	                       " SELECT ROWNUM rn, a.* FROM (" +
	                       "  SELECT * FROM TOURIST_NOTICE ";
	        if (searchWord != null && !searchWord.isEmpty()) {
	            query += " WHERE title LIKE '%" + searchWord + "%' ";
	        }
	        query += " ORDER BY num DESC" +
	                 " ) a " +
	                 ") WHERE rn BETWEEN " + start + " AND " + end;

	        try {
	            stmt = con.createStatement();
	            rs = stmt.executeQuery(query);
	            while (rs.next()) {
	                BoardDTO dto = new BoardDTO();
	                dto.setNum(rs.getInt("num"));
	                dto.setTitle(rs.getString("title"));
	                dto.setContent(rs.getString("content"));
	                dto.setPostDate(rs.getDate("postdate"));
	                dto.setId(rs.getString("id"));
	                dto.setVisitCount(rs.getInt("visitcount"));
	                list.add(dto);
	            }
	        } catch (Exception e) {
	            System.out.println("게시물 조회 중 예외 발생");
	            e.printStackTrace();
	        }
	        return list;
	    }
	public int insertWrite(BoardDTO dto) {
		int result = 0;
		try {
			String query = "INSERT INTO TOURIST_NOTICE (num, title, content, id, visitcount) "
		             + "VALUES (TOURIST_BOARD_NUM.NEXTVAL, ?, ?, ?, 0)";

			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getId());
			result = psmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("게시물 입력 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	public BoardDTO selectView(int num) {
		// BoardDTO를 선언하는 부분
		BoardDTO dto = new BoardDTO();
		// DB에서 사용할 쿼리를 작성한다
		String query = "SELECT *"
				+ " FROM TOURIST_NOTICE "
				+ " WHERE num = ?";
		System.out.println(query);
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, num);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto.setNum(rs.getInt("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostDate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitCount(rs.getInt("visitcount"));
			}
		}catch(Exception e) {
			System.out.println("게시물 상세보기 중 예외 발생");
			e.printStackTrace();
		}
		return dto;
	}
	public void updateVisitCount(int num) {
		String query = " UPDATE TOURIST_NOTICE SET "
				+ " visitcount = visitcount+1 "
				+ " WHERE num=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, num);
			psmt.executeQuery();
		}catch(Exception e) {
			System.out.println("게시물 조회수 증가 중 예외 발생");
			e.printStackTrace();
		}
	}
	public int updateBoard(BoardDTO dto) {
		int result = 0;
		try {
			String query = "UPDATE TOURIST_NOTICE SET title=?, content=? "
					+ "WHERE num=?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setInt(3, dto.getNum());
			result = psmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("수정 처리 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	public int deleteBoard(int num) {
		int result = 0;
		try {
			String query = "DELETE FROM TOURIST_NOTICE WHERE num=?";
			psmt = con.prepareStatement(query);
			psmt.setInt(1, num);
			result = psmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("삭제 중 예외가 발생");
			e.printStackTrace();
		}
		return result;
	}
}








