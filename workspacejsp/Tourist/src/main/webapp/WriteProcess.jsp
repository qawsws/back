<%@page import="board.dao.BoardDAO"%>
<%@page import="board.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./IsLoggedIn.jsp" %>
<%
String title = request.getParameter("title");
String content = request.getParameter("content");

BoardDTO dto = new BoardDTO();
dto.setTitle(title);
dto.setContent(content);
dto.setId(session.getAttribute("UserId").toString());

BoardDAO dao = new BoardDAO();
int iResult = dao.insertWrite(dto);
dao.close();

if(iResult == 1){
	response.sendRedirect("List.jsp");
}else{
	out.println("<script>");
	out.println("alert('글쓰기에 실패하였습니다.');");
	out.println("history.back();");
	out.println("</script>");
}
%>








