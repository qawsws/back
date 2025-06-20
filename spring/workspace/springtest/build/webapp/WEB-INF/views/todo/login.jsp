<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>로그인 페이지</title>
</head>
<body>
<h2>로그인</h2>

<c:if test="${not empty Msg}">
  <p style="color: red;">${Msg}</p>
</c:if>

<form method="post" action="/member/login">
  아이디: <input type="text" name="id"><br/>
  비밀번호: <input type="password" name="pw"><br/>
  <button type="submit">로그인</button>
</form>
</body>
</html>
