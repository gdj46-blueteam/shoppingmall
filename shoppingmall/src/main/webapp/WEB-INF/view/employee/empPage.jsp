<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "vo.*" %>
<%
	List<EmployeeList> list =  (List<EmployeeList>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empPage</title>
<!-- 부트스트랩 사용링크 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h3>employee List</h3>
		<table class = "table table-bordered">
			<tr>
				<td>employeeNo</td>
				<td>employeeName</td>
				<td>employeeImageName</td>
			</tr>
			
			<%
				for(EmployeeList e : list){
			%>
					<tr>
						<td><%=e.getEmployeeNo()%></td>
						<td><a href="<%=request.getContextPath()%>/SelectEmpOneController?employeeNo=<%=e.getEmployeeNo()%>"><%=e.getEmployeeName()%></a></td>
						<td><%=e.getEmployeeImageName()%></td>
					</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>