<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>공지사항 상세보기</h2>
	<form action = "${pageContext.request.contextPath}/SelectAnnoListController" method="post">
		<table border="1">
			<tr>
				<td>No</td>
				<td><input type="text" name="announcementNo" value="${announcement.announcementNo}"></td>
				<td>Title</td>
				<td><input type="text" name="announcementTitle" value="${announcement.announcementTitle}"></td>
				<td>Content</td>
				<td><input type="text" name="announcementContent" value="${announcement.announcementContent}"></td>
				<td>CreateDate</td>
				<td><input type="text" name="createDate" value="${announcement.createDate}"></td>
			</tr>
		</table>
	</form>
	<a href="${pageContext.request.contextPath}/UpdateAnnoController?announcementNo=${announcement.announcementNo}&announcementTitle=${announcement.announcementTitle}&announcementContent=${announcement.announcementContent}"><button>수정</button></a>
	<a href="${pageContext.request.contextPath}/DeleteAnnoController?announcementNo=${announcement.announcementNo}"><button>삭제</button></a>
</body>
</html>