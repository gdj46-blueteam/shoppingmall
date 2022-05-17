<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectQuestion</title>
</head>
<body>
	<h2>문의사항 확인</h2>
	<form>
		<table>
			<thead>
				<tr>
					<td>questionNo</td>
					<td>customerId</td>
					<td>questionTitle</td>
					<td>questionContent</td>
					<td>createDate</td>
					<td>updateDate</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="q" items = "${questionList}">
				<tr>
					<td>${q.questionNo}</td>
					<td>${q.customerId}</td>
					<td>${q.questionTitle }</td>
					<td><a href="${pageContext.request.contextPath}/DeleteQuestionController?questionNo=${q.questionNo}">${q.questionTitle}</a></td>
					<td>${q.questionContent}</td>
					<td>${q.createDate}</td>
					<td>${q.updateDate}</td>
				</tr>
				</c:forEach>
			</tbody>	
		</table>
	</form>
</body>
</html>