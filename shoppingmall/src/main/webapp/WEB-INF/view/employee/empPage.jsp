<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "vo.*" %>
<%
	List<EmployeeImageList> list =  new ArrayList<>();
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
				<td>employeeImage</td>
			</tr>
			<!--현재 image 불러오기 문제로 대기/ 수정필요함 !!!!! -->
			<%
				for(EmployeeImageList e : list){
			%>
					<tr>
						<td><%=e.getEmployeeNo()%></td>
						<td><%=e.getEmployeeName()%></td>
						<td><%=e.getEmployeeImage()%></td>
					</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>