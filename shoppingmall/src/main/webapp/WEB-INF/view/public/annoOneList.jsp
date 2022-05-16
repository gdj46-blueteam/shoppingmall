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
		<a href="<%=request.getContextPath()%>/UpdateAnnoController?announcementNo=<%=ac.getAnnouncementNo() %>&announcementTitle=<%=ac.getAnnouncementTitle()%>&announcementContent=<%=ac.getAnnouncementContent()%>"><button>수정</button></a>
		<a href="<%=request.getContextPath()%>/DeleteAnnoController?announcementNo=<%=ac.getAnnouncementNo() %>"><button>삭제</button></a>
</body>
</html>