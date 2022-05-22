<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee One List</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<h3>직원 상세정보</h3>
	<div>
		<a href="${pageContext.request.contextPath}/SelectEmpListController" class=" ">직원 목록</a>
		<a href="${pageContext.request.contextPath}/SelectEmpMatchingController?employeeNo=${employeeListOne.employeeNo}" class=" ">배치 확인</a> 		
	</div>
	<table class="table table-bordered">
		<tr>
			<td colspan="2"><img src="./Image/${employeeListOne.employeeImageName}" width="500" height="300" alt="직원사진" style="display: block; margin: auto;"></td>
		</tr>
		<tr>
			<td>employeeNo</td>
			<td>${employeeListOne.employeeNo}</td>
		</tr>
		<tr>
			<td>employeeName</td>
			<td>${employeeListOne.employeeName}</td>
		</tr>
		<tr>
			<td>employeeSn</td>
			<td>${employeeListOne.employeeSn}</td>
		</tr>
		<tr> 
			<td>employeeAddress</td>
			<td>${employeeListOne.employeeAddress}</td>
		</tr>
		<tr>
			<td>employeeAddressDetail</td>
			<td>${employeeListOne.employeeAddressDetail}</td>
		</tr>
		<tr>
			<td>employeeEmail</td>
			<td>${employeeListOne.employeeEmail}</td>
		</tr>
		<tr>
			<td>employeePhone</td>
			<td>${employeeListOne.employeePhone}</td>
		</tr>
		<tr>
			<td>employeeGender</td>
			<td>${employeeListOne.employeeGender}</td>
		</tr>
		
		<tr>
			<td>employeeIntroduce</td>
			<td>${employeeListOne.employeeIntroduce}</td>
		</tr>
		<tr>
			<td>language</td>
			<td>
				 <c:forEach var="l" items="${empLanguageList}">
					${l.language}
				 </c:forEach>		
			</td>
		</tr>
		<tr>
			<td>authority</td>
			<td>${employeeListOne.authority}</td>
		</tr>
		<tr>
			<td>createDate</td>
			<td>${employeeListOne.createDate}</td>
		</tr>
		<tr>
			<td>updateDate</td>	
			<td>${employeeListOne.updateDate}</td>
		</tr>
	</table>
	<div>
		<a href="${pageContext.request.contextPath}/UpdateEmpController?employeeNo=${employeeListOne.employeeNo}" class="btn btn-outline-success">수정</a>
	</div>
	<hr>
	<div class="container">
	<h3>직원 실적</h3>
	<table class="table table-bordered">
		<tr>	
			<td>매출 총계</td>
			<td>${list.sum } 원</td>
		</tr>
		<tr>
			<td>근무 횟수</td>
			<td>${list.cnt} 회</td>
		</tr>	
	</table>
	</div>
</div>
</body>
</html>