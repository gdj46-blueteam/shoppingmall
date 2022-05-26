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
	<h1>DIY입력폼</h1>
	<form method="post" action="${pageContext.request.contextPath}/InsertDIYController" >
		<input type = "text" name= "sessionId" value = "${sessionId}" hidden="hidden" >
		<table>
		<tr>
			<td>여행 도시<td>
			<td><select name="tourArea">
			<c:forEach var="c" items="${tourAreaList}">
				<option value="${c.tourAreaNo }" >${c.area} ${c.city}</option>
				</c:forEach>
			</select><td>
		</tr>
		<tr>
			<td>언어</td>
			<td><select name="language">
			<c:forEach var="c" items="${languageList}">
				<option value="${c.languageNo }" >${c.language}</option>
				</c:forEach>
			</select><td>
		</tr>
		<tr>
			<td>교통수단</td>
			<td><select name="language1">
			<c:forEach var="c" items="${language1}">
				<option value="${c.languageNo }" >${c.language}</option>
				</c:forEach>
			</select><td>
		</tr>
		<tr>
			<td>테마</td>
			<td><select name="language2">
			<c:forEach var="c" items="${language2}">
				<option value="${c.languageNo }" >${c.language}</option>
				</c:forEach>
			</select><td>
		</tr>
		<tr>
			<td>인원</td>
			<td><input type="number" name="tourDIYPeople"></td>
		</tr>
		<tr>
			<td>날짜</td>
			<td><input type="date" name="tourDIYTerm" value="" ></td>
		</tr>
		<tr>
			<td>숙박</td>
			<td> <select  name="tourDIYStay" >
						<option value="게스트하우스" >게스트하우스</option>
 						 <option value="펜션" >펜션</option>
 						 <option value="빌라" >빌라</option>
  						<option value="호텔" >호텔</option>
					</select></td>
		</tr>
		<tr>
			<td>요구사항</td>
			<td><textArea name="tourDIYEtc" rows="10" Cols="10"></textArea></td>
		</tr>
		</table>
		<button type="submit">견적서 만들기</button>
	</form>
</body>
</html>