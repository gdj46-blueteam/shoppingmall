<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>견적서 배정</h2>
	<form method="post" action="${pageContext.request.contextPath}/InsertEstimateController">
		<table border="1">
			
					<tr>
							<td><input type ="text" name="tourDIYNo" value="${tourDIYMap.tourDIYNo}" hidden="hidden"></td>
					</tr>
					<tr>
							<td>customerId</td>
							<td>${tourDIYMap.customerId}</td>
					</tr>
					<tr>
							<td>language</td>
							<td>${tourDIYMap.language}</td>
					</tr>
					<tr>
							<td>city</td>
							<td>${tourDIYMap.city}</td>
					</tr>
					<tr>
							<td>tourdiyPeople</td>
							<td>${tourDIYMap.tourDIYPeople}</td>
					</tr>
					<tr>
							<td>tourdiyTerm</td>
							<td>${tourDIYMap.tourDIYTerm}</td>
					</tr>
					<tr>
							<td>tourditStay</td>
							<td>${tourDIYMap.tourDIYStay}</td>
					</tr>
					<tr>
							<td>tourdiyEtc</td>
							<td>${tourDIYMap.tourDIYEtc}</td>
					</tr>
					<tr>
							<td>emp</td>
							<td><select name="employeeNo">
								<c:forEach var="c" items="${empLanguageList}">
								<option value="${c.employeeNo}" >${c.employeeName}-${c.langauge} </option>
								</c:forEach>
							</select></td>	
					</tr>
					<tr>
							<td>price</td>
							<td><input type="number" name ="estimatePrice"></td>
					</tr>
					<tr>
							<td>createDate</td>
							<td>${tourDIYMap.createDate}</td>
					</tr>
				
			</table>
				<button>배정</button>
		</form>
</body>
</html>