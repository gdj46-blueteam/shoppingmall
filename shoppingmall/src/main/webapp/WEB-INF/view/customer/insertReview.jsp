<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>리뷰 입력</h1>
	<form method="post" action="${pageContext.request.contextPath}/InsertReviewController">
		<table border="1">
	
		<input type="text" id="reviewNo" name="reviewNo" hidden="hidden">
		<tr>
			<th>city</th>
			<th>
				<select class="js-example-basic-single js-states form-control" id="id_label_single2" name="city">
					<c:forEach var="c" items="${cityList}">
						<option value="${c.city }">${c.city}</option>
					</c:forEach>
				</select>
			</th>
		</tr>
		<tr>
			<th>review</th>
			<th><input type="text" id="review" name="review" value=""></th>
		</tr>
			<input type="text" id="tourdiyNo" name="tourdiyNo" hidden="hidden">
			<input type="text" id="estimateNo" name="estimateNo" hidden="hidden">
		</table>
		<button type="button" id="signup">등록</button>
	</form>
</body>
</html>