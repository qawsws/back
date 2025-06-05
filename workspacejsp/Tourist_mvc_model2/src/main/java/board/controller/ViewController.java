package board.controller;

import java.io.IOException;

import board.dao.BoardDAO;
import board.dto.BoardDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/boardview.do")
public class ViewController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 게시글 번호 파리미터 저장
		int num = Integer.parseInt(req.getParameter("num"));
		// DB에 접속하여 쿼리 실행
		BoardDAO dao = new BoardDAO();
		// 조회수 증가 쿼리 실행
		dao.updateVisitCount(num);
		// 게시글 데이터를 받아오는 쿼리 실행
		BoardDTO dto = dao.selectView(num);
		// 엔터키를 <br/> 태그로 변경
		String replaceContent = dto.getContent().replaceAll("(\r\n|\r|\n)", "<br/>");
		dto.setContent(replaceContent);
		// request에 dto데이터 저장
		req.setAttribute("dto", dto);
		// board_view.jsp 실행
		req.getRequestDispatcher("/board_view_jstl.jsp").forward(req, resp);
		dao.close();
	}

}







