package fileupload;

import common.DBConnPool;

public class MyFileDAO extends DBConnPool {
	public int insertFile(MyFileDTO dto) {
		int applyResult = 0;
		try {
			String query = "INSERT INTO myfile (idx,title,cate,ofile,sfile)"
					+ "VALUES (seq_board_num.NEXRVAL, ?,?,?,?)";
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getCate());
			psmt.setString(3, dto.getOfile());
			psmt.setString(4, dto.getSfile());
		}catch (Exception e) {
			System.out.println("파일 추가 중 예외 발생");
			e.printStackTrace();
		}
		return applyResult;
	}
	

}
