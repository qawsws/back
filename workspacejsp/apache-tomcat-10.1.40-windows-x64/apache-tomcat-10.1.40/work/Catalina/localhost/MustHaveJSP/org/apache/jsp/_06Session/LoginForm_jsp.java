/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.40
 * Generated at: 2025-06-05 06:38:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp._06Session;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class LoginForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Session LoginForm</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../Common/Link.jsp", out, false);
      out.write("\r\n");
      out.write("	<h2>로그인 페이지</h2>\r\n");
      out.write("	<span style=\"color:red; font-size:1.2em;\">\r\n");
      out.write("	<!-- request에 loginerrmsg가 있으면 에러메시지 출력,없으면 \"\"출력 -->\r\n");
      out.write("		");
      out.print(request.getAttribute("LoginErrMsg") == null ? "" : request.getAttribute("LoginErrMsg") );
      out.write("\r\n");
      out.write("	</span>\r\n");
      out.write("	");
 if(session.getAttribute("UserId") == null){ 
      out.write("\r\n");
      out.write("		<script>\r\n");
      out.write("		//id와 pw가 입력되었는지 확인하는 함수\r\n");
      out.write("		function validateForm(form){\r\n");
      out.write("			// 아이디 확인\r\n");
      out.write("			if(!form.user_id.value){\r\n");
      out.write("				alert(\"아이디를 입력하세요.\");\r\n");
      out.write("				// false를 return하면 submit처리가 멈추고 더 이상 실행하지 않음\r\n");
      out.write("				//LoginProcess.jsp도 실행되지 않음\r\n");
      out.write("				return false\r\n");
      out.write("			}\r\n");
      out.write("			//패스워드 확인\r\n");
      out.write("			if(form.user_pw.value==\"\"){\r\n");
      out.write("				alert(\"패스워드를 입력하세요.\");\r\n");
      out.write("				return false\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("		</script>\r\n");
      out.write("		<!-- onsubmit안에 자바스크립트를 직접 작성하여 validateform을 실행 -->\r\n");
      out.write("		<form action=\"LoginProcess.jsp\" method=\"post\" name=\"loginFrm\"\r\n");
      out.write("		onsubmit=\"return validateForm(this);\">\r\n");
      out.write("			아이디 : <input type=\"text\" name=\"user_id\" /> <br/>\r\n");
      out.write("			패스워드 : <input type=\"password\" name=\"user_pw\"/><br/>\r\n");
      out.write("			<input type=\"submit\" value=\"로그인하기\" />\r\n");
      out.write("		</form>\r\n");
      out.write("	");
}else{ 
      out.write("\r\n");
      out.write("	<!-- 세션에 회원정보가 있을 경우 출력하는 부분 -->\r\n");
      out.write("		");
      out.print(session.getAttribute("UserName"));
      out.write("회원님, 로그인하셨습니다.<br/>\r\n");
      out.write("		<a href=\"Logout.jsp\">[로그아웃]</a>\r\n");
      out.write("	");
} 
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
