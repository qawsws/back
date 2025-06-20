<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
    <h2>회원가입</h2>
    <form action="/member/join" method="post">
        <label for="id">아이디:</label>
        <input type="text" name="id" required /><br />

        <label for="pw">비밀번호:</label>
        <input type="password" name="pw" required /><br />

        <label for="name">이름:</label>
        <input type="text" name="name" required /><br />

        <label for="email">이메일:</label>
        <input type="email" name="email" required /><br />

        <button type="submit">가입하기</button>
</form>
</body>
</html>
