<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 25. 6. 11.
  Time: 오후 4:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>할일 등록</title>
    <!-- 부트스트랩 CSS를 CDN방식으로 다운로드 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="/todo/list">TodoApp</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                        <div class="navbar-nav">
                            <a class="nav-link active" href="/todo/list">리스트</a>
                            <a class="nav-link" href="/todo/register">등록</a>
                            <a class="nav-link" href="/member/logout">로그아웃</a>
                        </div>
                    </div>
                </div>
            </nav>
        </div>
    </div>
    <div class="row content">
        <div class="col">
            <div class="card">
                <div class="card-header">
                    Featured
                </div>
                <div class="card-body">
                    <form method="post" action="/todo/register">
                        <div class="input-group mb-3">
                            <span class="input-group-text">제목</span>
                            <input type="text" name="title" class="form-control" placeholder="Title"/>
                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text">날짜</span>
                            <input type="date" name="dueDate" class="form-control" placeholder="DueDate"/>
                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text">작성자</span>
                            <input type="text" class="form-control" value="${sessionScope.UserId}" readonly />
                        </div>
                        <input type="hidden" name="writer" value="${sessionScope.UserId}" />
                        <div class="my-4">
                            <div class="float-end">
                                <button type="submit" class="btn btn-primary">Submit</button>
                                <button type="reset" class="btn btn-secondary">Reset</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="row content">
        <h1>Content</h1>
    </div>
    <div class="row content">
        <div class="row fixed-bottom" style="z-index:-100">
            <footer class="py-1 my-1">
                <p class="text-center text-muted">Footer</p>
            </footer>
        </div>
    </div>
</div>
<!-- 부트스트랩 JavaScript를 CDN방식으로 다운로드 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
