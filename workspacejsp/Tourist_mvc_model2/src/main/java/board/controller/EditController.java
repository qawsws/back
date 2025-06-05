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

@WebServlet("/boardedit.do")
public class EditController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	// 상세보기처럼 1개의 게시글을 저장하여 edit페이지로 전달하도록 작성
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.selectView(num);
		dao.close();
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/board_edit.jsp").forward(req, resp);
		
	}
	// 게시글에 수정된 데이터를 받아서 UPDATE문을 실행하고 상세보기 페이지로 이동하도록 작성
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		BoardDTO dto = new BoardDTO();
		dto.setNum(num);
		dto.setTitle(title);
		dto.setContent(content);
		
		BoardDAO dao = new BoardDAO();
		int result = dao.updateBoard(dto);
		dao.close();
		if(result == 1){
			resp.sendRedirect("./boardview.do?num="+dto.getNum());
		}else{
			JSFunction.alertBack(resp, "수정에 실패했습니다.");
		}
		
	}
}









