<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session LoginForm</title>
</head>
<body>
	<jsp:include page="../Common/Link.jsp" />
	<h2>로그인 페이지</h2>
	<span style="color:red; font-size:1.2em;">
	<!-- request에 loginerrmsg가 있으면 에러메시지 출력,없으면 ""출력 -->
		<%=request.getAttribute("LoginErrMsg") == null ? "" : request.getAttribute("LoginErrMsg") %>
	</span>
	<% if(session.getAttribute("UserId") == null){ %>
		<script>
		//id와 pw가 입력되었는지 확인하는 함수
		function validateForm(form){
			// 아이디 확인
			if(!form.user_id.value){
				alert("아이디를 입력하세요.");
				// false를 return하면 submit처리가 멈추고 더 이상 실행하지 않음
				//LoginProcess.jsp도 실행되지 않음
				return false
			}
			//패스워드 확인
			if(form.user_pw.value==""){
				alert("패스워드를 입력하세요.");
				return false
			}
		}
		</script>
		<!-- onsubmit안에 자바스크립트를 직접 작성하여 validateform을 실행 -->
		<form action="LoginProcess.jsp" method="post" name="loginFrm"
		onsubmit="return validateForm(this);">
			아이디 : <input type="text" name="user_id" /> <br/>
			패스워드 : <input type="password" name="user_pw"/><br/>
			<input type="submit" value="로그인하기" />
		</form>
	<%}else{ %>
	<!-- 세션에 회원정보가 있을 경우 출력하는 부분 -->
		<%=session.getAttribute("UserName")%>회원님, 로그인하셨습니다.<br/>
		<a href="Logout.jsp">[로그아웃]</a>
	<%} %>
</body>
</html>













