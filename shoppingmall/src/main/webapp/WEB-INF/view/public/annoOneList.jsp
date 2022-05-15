<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="vo.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%
	Announcement ac = (Announcement)request.getAttribute("an");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>공지사항 상세보기</h2>
			<table border="1">
					<tr>
						<th>No</th>
						<th>Title</th>
						<th>Content</th>
						<th>CreateDate</th>
					</tr>
				
					<tr>
						<td><%=ac.getAnnouncementNo()%></td>
						<td><%=ac.getAnnouncementTitle()%></td>
						<td><%=ac.getAnnouncementContent()%></td>
						<td><%=ac.getCreateDate()%></td>
					</tr>
				
		
		</table>
	
</body>
</html>