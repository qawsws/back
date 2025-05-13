<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 성적 표시하기</title>
<style>
table, td, th {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	width: 100px;
}
</style>
</head>
<body>
	<!-- 
scores배열의 데이터를 표를 이용하여 출력하기
학생번호    국어    영어    수학     총점     평균
=============================================
1번 학생:   80     60     70     210     70.0
2번 학생:   90     95     80     265     88.0
3번 학생:   75     80    100     255     85.0
4번 학생:   80     70     95     245     81.0
5번 학생:  100     65     80     245     81.0
 -->
	<%
	int[][] scores = { { 80, 60, 70 }, { 90, 95, 80 }, { 75, 80, 100 }, { 80, 70, 95 }, { 100, 65, 80 } };
	%>
	int sum = 0; double avg = 0;
	<table>
		<tr>
			<th>학생번호</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>총점</th>
			<th>평균</th>
		</tr>
		<%for (int i = 0; i < scores.length; i++) {%>
		<tr>
		<td><%=i+1%>번 학생</td>
		<%int sum=0;
		for (int j = 0; j < scores[i].length; j++) {
			sum+=scores[i][j];%>
		<td><%=scores[i][j] %></td>
		<%}%>
			<td><%=sum %></td>
			<td><%= String.format("%.1f", (double)sum / scores[i].length) %></td>
		</tr>
		<%}%>
	</table>
</body>
</html>










