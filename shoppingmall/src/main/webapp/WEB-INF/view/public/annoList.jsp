<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>공지사항 목록</h1>
		<table border="1">
			<tr>
				<th>No</th>
				<th>Title</th>
			</tr>
			<c:forEach var="a" items="${announcementList}">
				<tr>
					<td>${a.announcementNo}</td>
					<td><a href="SelectAnnoOneController?announcementNo=${a.announcementNo}">${a.announcementTitle}</a></td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>