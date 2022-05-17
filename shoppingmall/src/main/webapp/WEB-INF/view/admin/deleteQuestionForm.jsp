<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="vo.*" %>
<%@ page import="dao.*" %>
<%@ page import="java.util.*" %>
<%
	int questionNo = (Integer)request.getAttribute("questionNo");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteQuestionForm</title>
</head>
<body>
	<h2>문의사항 삭제</h2>
	<form action="<%=request.getContextPath()%>/DeleteQuestionController" method="post">
	<table>
		<tr>
			<td>질문번호</td>	
		</tr>
		<tr>
			<td><input type="text" name="questionNo" value="<%=questionNo%>" readOnly = "readOnly" ></td>
		</tr>
	</table>
		<div>
			<a href="<%=request.getContextPath()%>/DeleteQuestionController?questionNo=<%=questionNo%>" class="btn">삭제</a>
		</div>
		<button type="submit">삭제</button>
	</form>
</body>
</html>