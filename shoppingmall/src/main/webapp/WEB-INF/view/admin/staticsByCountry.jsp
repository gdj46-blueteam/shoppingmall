<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Statics By Country</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<%
	List<Map<String,Object>> list = (List<Map<String,Object>>)request.getAttribute("list");
%>
</head>
<body>
<div class="container">
	<h3>tag rank</h3>
	<div>
		<a href="<%=request.getContextPath()%>/StaticsListController" class=""> 통계 검색</a> 		
	</div>
	<table class="table table-bordered small">
		<tr>
			<th>country</th>
			<th>rank</th>
			<th>count</th>	
		</tr>
		<%
			for(Map<String,Object> map : list){
		%>
			<tr>
				<td><%=map.get("country") %></td>
				<td><%=map.get("rank") %></td>
				<td><%=map.get("cnt") %></td>
			</tr>
		<%		
			}
		%>
	</table>
</div>
</body>
</html>