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
		<form action="<%=request.getContextPath()%>/CountryStaticsController" method="get" class="form-inline">
		<table class="table table-bordered">
		<tr>
			<td><button type="submit" class="btn btn-primary">나라통계 검색</button></td>
			<td><a href="<%=request.getContextPath()%>/GenderStaticsController" class="btn btn-primary">성별통계 검색</a></td>
			<td><a href="<%=request.getContextPath()%>/AgeStaticsController" class="btn btn-primary">나이통계 검색</a></td>
			<td><a href="<%=request.getContextPath()%>/MonthStaticsController" class="btn btn-primary">월별통계 검색</a></td>
			<td><a href="<%=request.getContextPath()%>/AreaStaticsController" class="btn btn-primary">지역통계 검색</a></td>
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