<%@page import="member.dto.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("user_id");
	String userPwd = request.getParameter("user_pw");
	
	MemberDAO dao = new MemberDAO();
	MemberDTO memberDTO = dao.getMemberDTO(userId, userPwd);
	dao.close();
	
	if(memberDTO.getId() != null){
		session.setAttribute("UserId", memberDTO.getId());
		session.setAttribute("UserName", memberDTO.getName());
		response.sendRedirect("index.jsp");
	}else{
		request.setAttribute("loginErrMsg", "아이디나 비밀번호를 확인해주세요.");
		/* request.getRequestDispatcher("login.jsp").forward(request, response); */
		%>
		<jsp:forward page="login.jsp" />
	<%}
		
%>
