<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// dto로 저장되어있는 세션 데이터 삭제
	session.removeAttribute("userDTO");
	// invalidate() : 모든 세션 데이터 삭제 메서드
	session.invalidate();
	response.sendRedirect("index.jsp");
%>