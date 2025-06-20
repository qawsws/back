<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>로그인 페이지</title>
  <meta charset="UTF-8">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
</head>
<body class="bg-light">
<div class="container d-flex justify-content-center align-items-center vh-100">
  <div class="card shadow-sm p-4" style="min-width: 400px;">
    <h3 class="text-center mb-4">로그인</h3>
    <c:if test="${not empty Msg}">
      <div class="alert alert-danger text-center" role="alert">
          ${Msg}
      </div>
    </c:if>

    <form method="post" action="/member/login">
      <div class="mb-3">
        <label for="id" class="form-label">아이디</label>
        <input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력하세요" required>
      </div>
      <div class="mb-3">
        <label for="pw" class="form-label">비밀번호</label>
        <input type="password" class="form-control" id="pw" name="pw" placeholder="비밀번호를 입력하세요" required>
      </div>
      <div class="d-grid mb-3">
        <button type="submit" class="btn btn-primary">로그인</button>
      </div>
    </form>

    <p class="text-center mt-3">
      계정이 없으신가요?
      <a href="/member/join">회원가입</a>
    </p>
  </div>
</div>
</body>
</html>
