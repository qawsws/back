package board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.dao.BoardDAO;
import board.dto.BoardDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/boardlist.do")
public class ListController extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BoardDTO> boardLists = new ArrayList<>();
        String searchWord = req.getParameter("searchWord");

        Map<String,Object> map = new HashMap<>();
        if(searchWord != null && !searchWord.trim().isEmpty()) {
            map.put("searchWord", searchWord.trim());
        }

        String pageParam = req.getParameter("page");
        int page = 1;
        if(pageParam != null && pageParam.matches("\\d+")) {
            page = Integer.parseInt(pageParam);
        }

        int perPage = 10;  

        BoardDAO dao = new BoardDAO();
        int totalCount = dao.selectCount(map);

      
        int start = (page - 1) * perPage + 1;
        int end = page * perPage;
        map.put("start", start);
        map.put("end", end);
        boardLists = dao.selectListPage(map);

        req.setAttribute("boardLists", boardLists);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("currentPage", page);
        req.setAttribute("perPage", perPage);
        req.setAttribute("searchWord", searchWord);

        req.getRequestDispatcher("/board_list2.jsp").forward(req, resp);
    }
}
