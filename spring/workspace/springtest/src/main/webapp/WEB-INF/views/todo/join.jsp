<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow-sm p-4" style="min-width: 450px;">
        <h3 class="text-center mb-4">회원가입</h3>
        <form action="/member/join" method="post">
            <div class="mb-3">
                <label for="id" class="form-label">아이디</label>
                <input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력하세요" required />
            </div>
            <div class="mb-3">
                <label for="pw" class="form-label">비밀번호</label>
                <input type="password" class="form-control" id="pw" name="pw" placeholder="비밀번호를 입력하세요" required />
            </div>
            <div class="mb-3">
                <label for="name" class="form-label">이름</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력하세요" required />
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">이메일</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="이메일을 입력하세요" required />
            </div>
            <div class="d-grid mt-4">
                <button type="submit" class="btn btn-success">가입하기</button>
            </div>
        </form>
        <p class="text-center mt-3">
            이미 계정이 있으신가요?
            <a href="/member/login">로그인</a>
        </p>
    </div>
</div>
</body>
</html>
