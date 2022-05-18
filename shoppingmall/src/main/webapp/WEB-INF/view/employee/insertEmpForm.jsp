<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert employee Form</title>
<!-- 부트스트랩 사용링크 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h3>insert employee</h3>
		<form method="post" action="<%=request.getContextPath()%>/InsertEmpContoller">
			<table class ="table table-hover">
				<%-- <tr>
					<td>employeeNo</td>
					<td>
						<input type ="text" name="employeeNo" readonly ="readonly">
					</td>
				</tr> --%>
				<tr>
					<td>employeePw</td>
					<td>
						<input type ="password" name="employeePw">
					</td>
				</tr>
				<tr>
					<td>employeeSn</td>
					<td>
						<input type ="text" name="employeeSn">
					</td>
				</tr>
				<tr>
					<input type ="text" name="empAddressId" readonly="readonly" hidden="hidden" value="${m.id}">
				</tr>
				<tr>
					<td>employeeAddressDetail</td>
					<td>
						<input type ="text" name="employeeAddressDetail">
					</td>
				</tr>
				<tr>
					<td>employeeName</td>
					<td>
						<input type ="text" name="employeeName">
					</td>
				<tr>
					<td>employeeEmail</td>
					<td>
						<input type ="text" name="employeeEmail">
					</td>
				</tr>
				<tr>
					<td>employeePhone</td>
					<td>
						<input type ="text" name="employeePhone">
					</td>
				</tr>
				<tr>
					<td>employeeGender</td>
					<td>
						<input type ="radio" name="employeeGender" value="남">남
						<input type ="radio" name="employeeGender" value="여">여
					</td>
				</tr>
				<tr>
					<td>employeeImageName</td>
					<td>
						<input type ="text" name="employeeImageName">
					</td>
				</tr>
				<tr>
					<td>employeeIntroduce</td>
					<td>
						<input type ="text" name="employeeIntroduce">
					</td>
				</tr>
			</table>
			<button type ="submit">직원등록</button>
		</form>
	<form action="${pageContext.request.contextPath}/SearchAddressController" method="post">
			<input type="text" name="searchAddr">ex) 영당로 
			<button type="submit">주소검색</button>
		</form>
	<c:if test="${searchList != null}">
		<h2>검색 결과</h2>
			<div>
			<select name="empAddressId">
				<option value=="">!!주소 선택!!</option>
				<c:forEach var="m" items="${searchList}">
					<option  value="${m.id}">${m.addr}</option>
				</c:forEach>
			</select>
			</div>
	</c:if>
</body>
</html>