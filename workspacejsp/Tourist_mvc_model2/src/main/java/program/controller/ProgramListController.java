package program.controller;

import java.io.IOException;
import java.util.List;

import program.dao.ProgramDAO;
import program.dto.ProgramDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/program.do")
public class ProgramListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProgramDAO dao = new ProgramDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<ProgramDTO> programList = dao.getProgramList();
        req.setAttribute("programList", programList);
        req.getRequestDispatcher("/program_list.jsp").forward(req, resp);
    }
}
