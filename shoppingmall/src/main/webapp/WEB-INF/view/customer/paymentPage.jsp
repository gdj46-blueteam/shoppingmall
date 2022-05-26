<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
				<div class="col-md">
					<h2 class="heading mb-2 display-4 font-light probootstrap-animate">payment</h2>
					<p class="lead mb-5 probootstrap-animate">
				</div>	
					<form method="post" class="probootstrap-form" action="${pageContext.request.contextPath}/PaymentController">
						<div class="row mb-5">
							<div class="col-md">
								<div class="form-group">
									<table class="probootstrap-date-wrap table table-striped " style="color: black;">
										<tr>
											<td>견적서번호</td>
											<td><input type="number" name = "estimateNo" value="${estimateNo }" readonly="readonly"></td>
										</tr>
										<tr>
											<td>은행</td>
											<td><input type="text"></td>
										</tr>
										<tr>
											<td>계좌번호</td>
											<td><input type="text"></td>
										</tr>
									</table>
								</div>
							</div>
						</div>
						<div class="row mb-5">
							<div class="col-md">
								<div class="form-group">
									<a href="${pageContext.request.contextPath}/DeleteEstimateController" class="btn btn-primary btn-block">뒤로</a>
									<button type="submit"  class="btn btn-primary btn-block">결제</button>
								</div>
								</div>
							</div>						
					</form>
				</div>
			</div>
		</div>
	</section>
</body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
	</script>
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