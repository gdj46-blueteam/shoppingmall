<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>공지사항 수정</h1>
		<form method="post" action="${pageContext.request.contextPath}/UpdateAnnoController">
			<table border="1">
				<tr>
					<td>no</td>
					<td><input type="text" name="announcementNo" readonly="readonly" value="${announcement.announcementNo}"></td>
					
					<td>title</td>
					<td><input type="text" name="announcementTitle" value="${announcement.announcementTitle}"></td>
					
					<td>content</td>
					<td><input type="text" name="announcementContent" value="${announcement.announcementContent}"></td>
				</tr>
			</table>
			<button type="submit">수정</button>
			<a href="${pageContext.request.contextPath}/SelectAnnoOneController?announcementNo=${announcement.announcementNo}"><button>슈</button></a>
		</form>
</body>
</html>