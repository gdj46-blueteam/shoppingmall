<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>공지사항 입력</h1>
	<form method="post" action="${pageContext.request.contextPath}/InsertAnnoController">
	<table border="1">
		
		<tr>
			<th>announcementTitle</th>
			<th><input type="text" id="announcementTitle" name="announcementTitle" value=""></th>
		</tr>
		
		<tr>
			<th>announcementContent</th>
			<th><input type="text" id="announcementContent" name="announcementContent" value=""></th>
		</tr>
		
	</table>
	<button type="submit">등록</button>
</body>
</html>