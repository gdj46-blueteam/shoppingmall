<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Free Bootstrap 4 Theme by ProBootstrap.com">
<meta name="keywords" content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">
<title>Insert title here</title>
<!-- css 링크 -->
<link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,700" rel="stylesheet">
<link rel="stylesheet" href="assets/css/bootstrap/bootstrap.css">
<link rel="stylesheet" href="assets/css/animate.css">
<link rel="stylesheet" href="assets/fonts/ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="assets/fonts/flaticon/font/flaticon.css">
<link rel="stylesheet" href="assets/fonts/fontawesome/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/select2.css">
<link rel="stylesheet" href="assets/css/helpers.css">
<link rel="stylesheet" href="assets/css/style.css">

</head>
<body>
<jsp:include page="/WEB-INF/view/mainNav.jsp"/>
<section class="probootstrap-cover overflow-hidden relative" style="background-image: url('assets/images/Jeju.jpg');"data-stellar-background-ratio="0.5" id="section-home">
		<div class="overlay"></div>
		<div class="container">
			<div class="row align-items-center">
				<div class="col-md probootstrap-animate" >
					<form action="${pageContext.request.contextPath}/SearchAddressController"  method="post" class="probootstrap-form">
						<div>주소검색(주소먼저입력)</div>
							<input type="text" name="searchAddr"> <span style="color: red; font-size:small;">공백없이 검색! 주소쓰고 엔터(필수)</span>
					</form>
					<form method="post" class="probootstrap-form" action="${pageContext.request.contextPath}/InsertEmpContoller" enctype="multipart/form-data">
						<div class="row mb-5">
							<div class="col-md">
								<div class="form-group">
									<table class="probootstrap-date-wrap table table-striped " style="color: black;">
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
										<td>employeeAddr</td>
										<td>
										<c:if test="${searchList != null}">
											<div>
												<select name="empAddressId">
														<option value="">주소 선택</option>
													<c:forEach var="m" items="${searchList}">
														<option value="${m.id}">${m.addr}</option>
													</c:forEach>
												</select>
											</div>
										</c:if>
										</td>
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
											<td>employeeImage</td>
											<td>
												<input type ="file" name="employeeImageName">
											</td>
										</tr>
										<tr>
											<td>employeeIntroduce</td>
											<td>
												<input type ="text" name="employeeIntroduce">
											</td>
										</tr>
										<tr>
											<td>language</td>
											<td>
										         <c:forEach var="l" items="${language}">
										            <input type="checkbox" name="language" value="${l.languageNo}">${l.language}
										          </c:forEach>
											</td>
										</tr>
									</table>
								</div>
							</div>
						</div>
						<div class="row mb-5">
							<div class="col-md">
								<div class="form-group">
									<a href="${pageContext.request.contextPath}/SelectCustomerOneController?customerId=${customer.customerId }" class="btn btn-primary btn-block">나의 정보</a>
									<button type="button" class="btn btn-primary btn-block">직원등록</button>
								</div>
								</div>
							</div>						
					</form>
				</div>
				<div class="col-md">
					<h2 class="heading mb-2 display-4 font-light probootstrap-animate">EMPLOYEE INSERT</h2>
					<p class="lead mb-5 probootstrap-animate">
				</div>	
			</div>
		</div>
	</section>
</body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/owl.carousel.min.js"></script>
    <script src="assets/js/bootstrap-datepicker.js"></script>
    <script src="assets/js/jquery.waypoints.min.js"></script>
    <script src="assets/js/jquery.easing.1.3.js"></script>
    <script src="assets/js/select2.min.js"></script>
    <script src="assets/js/main.js"></script>
</html>