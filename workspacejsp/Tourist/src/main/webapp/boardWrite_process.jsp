<%@page import="member.dto.MemberDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@page import="board.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String title = request.getParameter("title");
String content = request.getParameter("content");

BoardDTO dto = new BoardDTO();
dto.setTitle(title);
dto.setContent(content);

dto.setId(((MemberDTO)session.getAttribute("userDTO")).getId());
System.out.println(((MemberDTO)session.getAttribute("userDTO")).getId());
BoardDAO dao = new BoardDAO();
int iResult = dao.insertWrite(dto);
dao.close();

if(iResult == 1){
	response.sendRedirect("Board_list.jsp");
}else{
	
}
%>