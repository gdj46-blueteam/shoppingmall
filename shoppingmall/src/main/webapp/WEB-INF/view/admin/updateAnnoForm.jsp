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
		<form method="post" action="<%=request.getContextPath()%>/UpdateAnnoController">
			<table border="1">
				<tr>
					<td>no</td>
					<td><input type="text" name="announcementNo" value="${announcement.getAnnouncementNo()}"></td>
					
					<td>title</td>
					<td><input type="text" name="announcementTitle" value="${announcement.getAnnouncementTitle()}"></td>
					
					
					<td>content</td>
					<td><input type="text" name="announcementContent" value="${announcement.getAnnouncementContent()}"></td>
				</tr>
			</table>
			<button type="submit">수정</button>
		</form>
</body>
</html>