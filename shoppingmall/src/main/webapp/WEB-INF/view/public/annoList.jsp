<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="vo.*"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%
	List<Announcement> list = (List<Announcement>)request.getAttribute("announcement");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>공지사항 목록</h1>
		<form action = "<%=request.getContextPath()%>/SelectAnnoListController" method="post">
			<table border="1">
					<tr>
						<th>No</th>
						<th>Title</th>
					</tr>
				<%
					for(Announcement a : list){
				%>
					<tr>
						<td><%=a.getAnnouncementNo()%></td>
						<td><a href="SelectAnnoOneController?announcement_no=<%=a.getAnnouncementNo()%>"><%=a.getAnnouncementTitle()%></a></td>
					</tr>
				<%
					}
				%>
		
		</table>
		</form>
</body>
</html>