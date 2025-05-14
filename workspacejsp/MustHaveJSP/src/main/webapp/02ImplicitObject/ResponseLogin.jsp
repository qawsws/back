.<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장객체 - ResponseLogin</title>
</head>
<body>
	<%
	//getParameter를 이용하여 id와 password를 변수에 저장
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		//id가  must이고 pw가 1234이면 로그인 성공 페이지로 이동
		if(id.equalsIgnoreCase("must") && pw.equalsIgnoreCase("1234")){
			//다시 한번 요청을 진행하는 sendRedirect : 주소창이 변경됨 , request와 response재사용할 수 없음
			response.sendRedirect("ResponseWelcome,jsp");
		}else{
			//요청을 가지고 다음 페이지로 진행하는 forward : 주소창 변경 없음, request와 response를 그대로 사용 가능
			request.getRequestDispatcher("ResponseMain.jsp?loginErr=1")
			.forward(request,response);
		}
	%>
</body>
</html>