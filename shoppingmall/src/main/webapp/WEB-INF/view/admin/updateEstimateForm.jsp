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
	<h1>수정폼</h1>
			<form method="post" action="${pageContext.request.contextPath}/UpdateEstimateController">
			<table border="1">

					<tr>
							<td>estimateNo</td>
							<td><input type="text" value="${map.tourDIYNo}" name="tourDIYNo" hidden="hidden">
							<input type="text" value="${map.estimateNo}" name="estimateNo" readOnly="readOnly"></td>
							
					</tr>
					<tr>
							<td>customerId</td>
							<td><input type="text" value="${map.customerId}" name="customerId" readOnly="readOnly"></td>
					</tr>
					<tr>
							<td>language</td>
							<td><input type="text" value="${map.language}" name="language" readOnly="readOnly"></td>
					</tr>
					<tr>
							<td>city</td>
							<td><input type="text" value="${map.city}" name="city" readOnly="readOnly"></td>
					</tr>
					<tr>
							<td>employee<td>
							<select name="employeeNo">
								<c:forEach var="c" items="${empLanguageList}">
								<option value="${c.employeeNo}" >${c.employeeName}-${c.langauge} </option>
								</c:forEach>
							</select>
					</tr>
					<tr>
							<td>estimatePrice</td>
							<td><input type="text" value="${map.estimatePrice}" name="estimatePrice" ></td>
					</tr>
					<tr>
							<td>tourdiyPeople</td>
							<td><input type="text" value="${map.tourDIYPeople}" name="tourdiyPeople" readOnly="readOnly"></td>
					</tr>
					<tr>
							<td>tourdiyTerm</td>
							<td><input type="date" value="${map.tourDIYTerm}" name="tourdiyTerm" readOnly="readOnly"></td>
					</tr>
					<tr>
							<td>tourditStay</td>
							<td><input type="text" value="${map.tourDIYStay}" name="tourditStay" readOnly="readOnly"></td>
					</tr>
					<tr>
							<td>tourdiyEtc</td>
							<td><input type="text" value="${map.tourDIYEtc}" name="tourdiyEtc" readOnly="readOnly" ></td>
					</tr>
					<tr>
							<td>estimateIng</td>
							<td><input type="text" value="${map.estimateIng}" name="estimateIng" readOnly="readOnly"></td>
					</tr>
					<tr>
							<td>createDate</td>
							<td><input type="text" value="${map.createDate}" name="createDate" readOnly="readOnly"></td>
					</tr>
					<tr>
							<td>updateDate</td>
							<td><input type="text" value="${map.updateDate}" name="updateDate" readOnly="readOnly"></td>
					</tr>
	
			</table>
			<button type="submit">수정</button>
			<a href="${pageContext.request.contextPath}/DeleteEstimateController?estimateNo=${map.estimateNo}">뒤로가기</a>

		</form>
</body>
</html>