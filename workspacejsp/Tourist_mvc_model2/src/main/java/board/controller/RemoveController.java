package board.controller;

import java.io.IOException;

import board.dao.BoardDAO;
import board.dto.BoardDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.JSFunction;

@WebServlet("/boarddelete.do")
public class RemoveController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Primary Key인 num데이터를 저장
		int num = Integer.parseInt(req.getParameter("num"));
		
		// num을 조건으로 삭제 쿼리를 실행
		BoardDAO dao = new BoardDAO();
		
		int result = 0;
		
		// 로그인한 유저와 게시글을 작성한 유저가 같은지 확인하는 처리
		BoardDTO dto = dao.selectView(num);
		String userId = req.getSession().getAttribute("UserId").toString();
		if(userId.equals(dto.getId())) {
			result = dao.deleteBoard(num);
		}
		
		//쿼리 실행 결과에 따라 성공 실패처리를 하는 if문
		if(result == 1) {
			resp.sendRedirect("./boardlist.do");
		}else {
			JSFunction.alertBack(resp, "삭제에 실패했습니다.");
		}
	}
}
