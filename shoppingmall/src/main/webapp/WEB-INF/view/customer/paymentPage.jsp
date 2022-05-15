<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	int estimateNo = (int)request.getAttribute("estimateNo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>결제</h1>
	<table>
	<tr>
		<td>견적서번호</td>
		<td><input type="number" name = "estimateNo" value="<%=estimateNo %>" readonly="readonly"><%=estimateNo %></td>
	</tr>
	<tr>
		<td>은행</td>
		<td><input type="text"></td>
	</tr>
	<tr>
		<td>계좌번호</td>
		<td><input type="text"></td>
	</tr>
	<a href="<%=request.getContextPath()%>/SelectEstimateController?estimateNo=<%=estimateNo %>">결제</a>
	</table>
</body>
</html>