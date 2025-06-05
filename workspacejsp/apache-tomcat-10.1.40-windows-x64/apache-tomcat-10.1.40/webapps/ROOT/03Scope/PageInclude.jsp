<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="common.Person" %>
	<%
	int pInteger2 = (Integer)(pageContext.getAttribute("pageInteger"));
	Person pPerson2 = (Person)(pageContext.getAttribute("pagePerson"));
	%>
	<ul>
	<!-- 에러가 발생하고 있으나 실행했을시 문제없이 데이터가 출력됨 -->
		<li>Integer 객체 : <%=pInteger2 %></li>
		<li>String 객체 : <%=pageContext.getAttribute("pageString") %></li>
		<li>Person 객체 : <%=pPerson2.getName() %>,<%=pPerson2.getAge()%></li>
	</ul>
