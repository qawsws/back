package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import membership.MemberDAO;
import membership.MemberDTO;
import utils.JSFunction;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/15FilterListener/LoginFilter.jsp")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		String method = req.getMethod();
		
		if (method.equals("POST")) {
			String user_id = request.getParameter("user_id");
			String user_pw = request.getParameter("user_pw");
			
			MemberDAO dao = new MemberDAO();
			MemberDTO memberDto = dao.getMemberDTO(user_id, user_pw);
			dao.close();
			
			if (memberDto.getId() != null) {
				session.setAttribute("UserId", memberDto.getId());
				session.setAttribute("UserName", memberDto.getName());
				
				String backUrl = request.getParameter("backUrl");
				if (backUrl != null && !backUrl.equals("")) {
					JSFunction.alertLocation(resp, "요청 전 페이지로 이동합니다.", backUrl);
					return;
				}else {
					resp.sendRedirect("../15FilterListener/LoginFilter.jsp");
				}
			}else {
				req.setAttribute("LoginErrMsg", "로그인 실패!!!!!!");
				req.getRequestDispatcher("/15FilterListener/LoginFilter.jsp").forward(req, resp);
			}
			
		}else if (method.equals("GET")) {
			String mode = request.getParameter("mode");
			if (mode != null && mode.equals("logout")) {
				session.invalidate();
			}
		}
		
		chain.doFilter(request, response);
		
		
	}

}
