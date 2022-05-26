<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Free Bootstrap 4 Theme by ProBootstrap.com">
<meta name="keywords" content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">
<title>updateCustomerList</title>
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
	<jsp:include page="/WEB-INF/view/mainNav.jsp" />
	<section class="probootstrap-cover overflow-hidden relative" style="background-image: url('assets/images/busanTour.jpg');"data-stellar-background-ratio="0.5" id="section-home">
		<div class="overlay"></div>
		<div class="container">
			<div class="row align-items-center">
				<div class="col-md probootstrap-animate" >
					<form id="signupForm" method="post" class="probootstrap-form" action="${pageContext.request.contextPath}/UpdateCustomerController ">
						<div class="row mb-2">
							<div class="col-md">
								<div class="form-group">
									<table class="probootstrap-date-wrap table table-striped " style="color: black;">
										<tr>
											<td>customerId</td>
											<td><input type="text" name="customerId" value="${customer.customerId }" readonly="readonly"></td>
										</tr>
										<tr>
											<td>memberPw</td>
											<td><input type="password" name="customerPw" id="customerPw">
											<span id="customerPwHelper" class="helper"></span>
											</td>
										</tr>
										<tr>	
											<td>customerName</td>
											<td><input type="text" name="customerName" " value="${customer.customerName }"></td>
										</tr>
										<tr>
											<td>customerGender</td>
											<td>
											<input type='radio' name='customerGender' value='남'>남
											<input type='radio' name='customerGender' value='여'>여
											</td>
										</tr>
										<tr>
											<td>customerAge</td>
											<td>
												<input name="customerAge" type="number" value="${customer.customerAge }">
											</td>
										</tr>
										<tr>
											<td>customerPhone</td>
											<td>
												<input name="customerPhone" type="text" value="${customer.customerPhone }>">
											</td>
										</tr>
										<tr>
											<td>customerEmail</td>
											<td>
												<input name="customerEmail" type="text" value="${customer.customerEmail }">
											</td>
										</tr>
										<tr>
											<td>customerCountry</td>
											<td>
												<input name="customerCountry" type="text" value="${customer.customerCountry }">
											</td>
										</tr>
										<tr>
											<a  class="btn btn-primary" href="${pageContext.request.contextPath}/SelectCustomerOneController?customerId=${customer.customerId }">뒤로</a>
											<button  class="btn btn-primary" type="button" id="signup">수정</button>
										</tr>
									</table>
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="col-md">
				<h2 class="heading mb-2 display-4 font-light probootstrap-animate">UPDATE</h2>
				<p class="lead mb-5 probootstrap-animate">
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
</body>
	<script>
	$('#signup').click(function(){
		if($('#customerPw').val() == '') {
			$('#customerPwHelper').text('Pw 입력해주세요');
			$('#customerPw').focus();
		} else {
			$('#signupForm').submit();
		}
	});
	</script>
</html>