<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Statics List</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<%
	List<Map<String,Object>> list = (List<Map<String,Object>>)request.getAttribute("list");
%>
</head>
<body>
<div class="container">
	<h3>All Statics Search</h3>
	<div>
		<a href="<%=request.getContextPath()%>/SelectAdminListController" class="">관리자페이지로 돌아가기</a> 		
	</div>
	
	<div>
		<h4 class="text-dark">나라 통계</h4>
		<form action="<%=request.getContextPath()%>/CountryStaticsController" method="get" class="form-inline">
		<table class="table table-bordered">
		<tr>
			<td>나라</td>
			<td>
       			<div><input type="radio" name="country" value="나라" class="form-check-input">나라</div>
			</td>
			<td><button type="submit" class="btn btn-primary">검색</button></td>
		</tr>
		</table>
		</form>
	</div>
	<table class="table table-bordered small">
		<tr>
			<th>rank</th>
			<th>country</th>
			<th>gender</th>
			<th>age</th>
			<th>month</th>
			<th>area</th>
			<th>count</th>
		</tr>
		<%
			for(Map<String,Object> map : list){
		%>
			<tr>
				<td><%=map.get("rank") %></td>
				<td><%=map.get("country") %></td>
				<td><%=map.get("gender") %></td>
				<td><%=map.get("age") %></td>
				<td><%=map.get("month") %></td>
				<td><%=map.get("area") %></td>
				<td><%=map.get("cnt") %></td>
			</tr>
		<%		
			}
		%>
	</table>
</div>
</body>
</html>