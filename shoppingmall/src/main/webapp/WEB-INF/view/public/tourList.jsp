<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.*" %>
<%@ page import="java.util.*" %>

<%
	List<Tour> tourList = (List<Tour>)request.getAttribute("tourList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>관광리스트2</h2>
	<form action="<%=request.getContextPath()%>/SelectTourController" method="get">
		<table>
			<thead>
				<tr>
					<td>tourNo</td>
					<td>tourAreaId</td>
					<td>tourName</td>
					<td>tourDescription</td>
					<td>tourImageNo</td>
				</tr>
			</thead>
			<tbody>
				<%
					for(Tour t : tourList) {
				%>
					<tr>
						<td><%=t.getTourNo()%></td>
						<td><%=t.getTourAreaId() %></td>
						<td><%=t.getTourName() %></td>
						<td><%=t.getTourDescription() %></td>
						<td><%=t.getTourNo() %></td>
					</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</form>
</body>
</html>