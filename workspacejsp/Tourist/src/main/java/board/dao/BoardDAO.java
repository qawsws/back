package board.dao;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import board.dto.BoardDTO;
import common.DBConnPool;

public class BoardDAO extends DBConnPool{
	public int selectCount(Map<String, Object> map) {
		int totalCount = 0;
		
		String query = "SELECT COUNT(*) FROM TOURIST_BOARD";
		if(map.get("searchWord") != null) {
			query += " WHERE title "
					+" LIKE '%" + map.get("searchWord") + "%'";
		}
		System.out.println(query);
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
	public List<BoardDTO> selectList(Map<String, Object> map){
		List<BoardDTO> bbs = new Vector<>();
		String query = "SELECT * FROM TOURIST_BOARD";
		if(map.get("searchWord") != null) {
			query += " WHERE title "
					+" LIKE '%" + map.get("searchWord") + "%'";
		}
		query += " ORDER BY num DESC";
		System.out.println(query);
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNum(rs.getInt("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostDate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitCount(rs.getInt("visitcount"));
				bbs.add(dto);
			}
		}catch(Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		return bbs;
	}
	public int insertWrite(BoardDTO dto) {
		int result = 0;
		try {
			String query ="INSERT INTO TOURIST_BOARD (num,title,content,id,visitcount)"
					+ "VALUES (seq_board_num.NEXTVAL, ?, ?, ?, 0)";
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
	BoardDTO dto = new BoardDTO();
	String query = "SELECT B.*, M.name "
			+ " FROM TOURIST_MEMBER M INNER JOIN TOURIST_BOARD B "
			+ " ON M.id = B.id "
			+ " WHERE num = ?";
	System.out.println(query);
	try {
		psmt = con.prepareStatement(query);
		psmt.setInt(1, num);
		rs = psmt.executeQuery();
		if(rs.next()) {
			dto = new BoardDTO();
			dto.setNum(rs.getInt("num"));
			dto.setTitle(rs.getString("title"));
			dto.setContent(rs.getString("content"));
			dto.setPostDate(rs.getDate("PostDate"));
			dto.setId(rs.getString("id"));
			dto.setVisitCount(rs.getInt("visitcount"));
			dto.setName(rs.getString("name"));
		}
	}catch(Exception e) {
		System.out.println("게시물 상세보기 중 예외 발생");
		e.printStackTrace();
	}
	return dto;
}
public void updateVisitCount(int num) {
	String query = " UPDATE TOURIST_BOARD SET "
			+ " visitcount = visitcount+1 "
			+ " WHERE num=?";
	try {
		psmt = con.prepareStatement(query);
		psmt.setInt(1, num);
		psmt.executeUpdate();
	}catch(Exception e) {
		System.out.println("게시물 조회수 증가 중 예외 발생");
		e.printStackTrace();
	}
}
public int updateEdit(BoardDTO dto) {
	int result = 0;
	
	try {
		String query = "UPDATE TOURIST_BOARD SET"
				+" title=?, content=? "
				+" WHERE num=?";
		psmt = con.prepareStatement(query);
		psmt.setString(1, dto.getTitle());
		psmt.setString(2, dto.getContent());
		psmt.setInt(3, dto.getNum());
		result = psmt.executeUpdate();
	}catch(Exception e) {
		System.out.println("게시물 수정 중 예외 발생");
		e.printStackTrace();
	}
	
	return result;
}
public int deleteBoard(int num) {
	int result = 0;
	try {
		String query = "DELETE FROM tourist_board WHERE num=?";
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




