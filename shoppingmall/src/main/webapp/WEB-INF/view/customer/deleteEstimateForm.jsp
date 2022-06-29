<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Free Bootstrap 4 Theme by ProBootstrap.com">
<meta name="keywords" content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">
<title>selectCustomerOne</title>
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
<%
   request.setCharacterEncoding("UTF-8");
   int authority = 0;
   String sessionId = "";
      if(session.getAttribute("sessionAuthority") != null) {
         authority = (int)session.getAttribute("sessionAuthority");
         sessionId = (String)session.getAttribute("sessionId");

         }
      System.out.println("authority(mainhome) ->" + authority);
      System.out.println("sessionId(mainhome) ->" + sessionId);
%>
<jsp:include page="/WEB-INF/view/mainNav.jsp" />

<section class="probootstrap-cover overflow-hidden relative" style="background-image: url('assets/images/busanTour.jpg');"data-stellar-background-ratio="0.5" id="section-home">
		<div class="overlay"></div>
		<div class="container">
			<div class="row align-items-center">
				<div class="col-md probootstrap-animate" >
				<div class="col-md">
					<h2 class="heading mb-2 display-4 font-light probootstrap-animate">Estimate View Details</h2>
					<p class="lead mb-5 probootstrap-animate">
				</div>
					<form method="post"  action="${pageContext.request.contextPath}/DeleteEstimateController" class="probootstrap-form" >
						<div class="row mb-5">
							<div class="col-md">
								<div class="form-group">
									<table class="probootstrap-date-wrap table table-striped " style="color: black;">
										<tr>
												<td>customerId</td>
												<td>${map.customerId}</td>
										</tr>
										<tr>
												<td>language</td>
												<td>${map.language}</td>
										</tr>
										<tr>
												<td>city</td>
												<td>${map.city}</td>
										</tr>
										<tr>
												<td>employeeName</td>
												<td>${map.employeeName }</td>
										</tr>
										<tr>
												<td>estimatePrice</td>
												<td>${map.estimatePrice }</td>
										</tr>
										<tr>
												<td>tourdiyPeople</td>
												<td>${map.tourDIYPeople}</td>
										</tr>
										<tr>
												<td>tourdiyTerm</td>
												<td>${map.tourDIYTerm}</td>
										</tr>
										<tr>
												<td>tourditStay</td>
												<td>${map.tourDIYStay}</td>
										</tr>
										<tr>
												<td>tourdiyEtc</td>
												<td>${map.tourDIYEtc}</td>
										</tr>
										<tr>
												<td>estimateIng</td>
												<td>${map.estimateIng}</td>
										</tr>
										<tr>
												<td>createDate</td>
												<td>${map.createDate}</td>
										</tr>
									</table>
								</div>
							</div>
						</div>
						<div class="row mb-5">
							<div class="col-md">
								<div class="form-group">
									<a href="${pageContext.request.contextPath}/SelectEstimateListController" class="btn btn-primary">뒤로</a>
									<button type="submit" class="btn btn-primary">삭제</button>
									<a href="${pageContext.request.contextPath}/PaymentController?estimateNo=${map.estimateNo}" class="btn btn-primary">결제</a>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	
	<script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/owl.carousel.min.js"></script>
    <script src="assets/js/bootstrap-datepicker.js"></script>
    <script src="assets/js/jquery.waypoints.min.js"></script>
    <script src="assets/js/jquery.easing.1.3.js"></script>
    <script src="assets/js/select2.min.js"></script>
    <script src="assets/js/main.js"></script>
	<!-- 다른 기능들 넣어햐 합니다. -->
	</table>
</body>
</html>