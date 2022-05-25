<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Free Bootstrap 4 Theme by ProBootstrap.com">
<meta name="keywords" content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">
<title>Sign Up</title>
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
	<section class="probootstrap-cover overflow-hidden relative" style="background-image: url('assets/images/bg_1.jpg');"data-stellar-background-ratio="0.5" id="section-home">
		<div class="overlay"></div>
		<div class="container">
			<div class="row align-items-center">
				<div class="col-md">
					<h2 class="heading mb-2 display-4 font-light probootstrap-animate">Sign Up</h2>
					<p class="lead mb-5 probootstrap-animate">
				</div>
				<div class="col-md probootstrap-animate">
					<form action="${pageContext.request.contextPath}/InsertCustomerController" method="post" class="probootstrap-form" id="signupForm">
						<div class="row mb-5">
							<div class="col-md">
								<div class="form-group">
									<label for="probootstrap-date-departure">ID</label>
									<div class="probootstrap-date-wrap">
										<input type="text" id="customerId" class="form-control" placeholder="아이디를 입력해주세요" name="customerId">
										<span id="customerIdHelper" class="helper"></span>
									</div>
								</div>
							</div>
						</div>
						<div class="row mb-5">
							<div class="col-md">
								<div class="form-group">
									<label for="probootstrap-date-arrival">PASSWORD</label>
									<div class="probootstrap-date-wrap">
										<input type="password" class="form-control" placeholder="비밀번호를 입력해주세요" name="customerPw" id="customerPw">
									</div>
								</div>
								<div class="form-group">
									<label for="probootstrap-date-departure">PASSWORD CONFIRM</label>
									<div class="probootstrap-date-wrap">
										<input type="password" id="customerPwConfirm" class="form-control" placeholder="비밀번호를 다시 입력해주세요" name="customerPwConfirm">
										<span id="customerPwHelper" class="helper"></span>
									</div>
								</div>
							</div>
						</div>
						<div class="row mb-5">
							<div class="col-md">
								<div class="form-group">
									<label for="probootstrap-date-departure">NAME</label>
									<div class="probootstrap-date-wrap">
										<input type="text" id="customerName" class="form-control" placeholder="이름을 입력해주세요" name="customerName">
										<span id="customerNameHelper" class="helper"></span>
									</div>
								</div>
							</div>
						</div>
						<div class="row mb-5">
							<div class="col-md">
								<div class="form-group">
									<label for="probootstrap-date-departure" >Gender</label>
									<div class="probootstrap-date-wrap">
										<input type='radio' name='customerGender' value='남' class="gender" class="form-control">남 &nbsp;
										<input type='radio' name='customerGender' value='여' class="gender" class="form-control">여
										<span id="customerGenderHelper" class="helper"></span>
									</div>
								</div>
							</div>
						</div>
						<div class="row mb-5">
							<div class="col-md">
								<div class="form-group">
									<label for="probootstrap-date-departure">AGE</label>
									<div class="probootstrap-date-wrap">
										<input name="customerAge" type="number" id="customerAge" class="form-control" placeholder="나이를 입력해주세요">
										<span id="customerAgeHelper" class="helper"></span>
									</div>
								</div>
							</div>
						</div>
						<div class="row mb-5">
							<div class="col-md">
								<div class="form-group">
									<label for="probootstrap-date-departure">PHONE</label>
									<div class="probootstrap-date-wrap">
										<input name="customerPhone" type="text" id="customerPhone" class="form-control" placeholder=" -를 제외 한 전화번호를 입력해주세요">
										<span id="customerPhoneHelper" class="helper"></span>
									</div>
								</div>
							</div>
						</div>
						<div class="row mb-5">
							<div class="col-md">
								<div class="form-group">
									<label for="probootstrap-date-departure">EMAIL</label>
									<div class="probootstrap-date-wrap">
										<input type="text" id="customerEmail" class="form-control" placeholder="이메일을 입력해주세요" name="customerEmail">
										<span id="customerEmailHelper" class="helper"></span>
									</div>
								</div>
							</div>
						</div>
						<div class="row mb-5">
							<div class="col-md">
								<div class="form-group">
									<label for="probootstrap-date-departure">COUNTRY</label>
									<div class="probootstrap-date-wrap">
										<select id="customerCountry" name="customerCountry" class="form-control" >
						                    <option value="나라 선택" selected="selected">나라선택</option>
						                    <c:forEach var="c" items="${list}">
													<option value="${c.country}">${c.country}</option>
											</c:forEach>
										</select>
										<span id="customerCountryHelper" class="helper"></span>
									</div>
								</div>
							</div>
						</div>
						<div class="row mb-5">
						 	<div class="col-md">
                				<button type="button" class="btn btn-primary btn-block" id="signup">SIGN UP</button>
                				<button type="reset"  class="btn btn-primary btn-block">RESET</button>
                			</div>
                		</div>
                 	</form>
				</div>
				</div>
			</div>
	</section>
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
    <script>
	$('#customerId').focus();
	
	$('#customerId').blur(function(){
		if($('#customerId').val().length < 5) {
			$('#customerIdHelper').text('id는 5자이상');
			$('#customerId').focus();
		} else {
			$('#customerIdHelper').text('');
		}
	});
	
	$('#customerPwConfirm').blur(function(){
		if($('#customerPw').val().length < 4) {
			$('#customerPwHelper').text('pw는 4자이상');
			$('#customerPw').focus();
		} else if($('#customerPw').val() != $('#customerPwConfirm').val()) {
			$('#customerPwHelper').text('pw가 일치하지 않습니다');
			$('#customerPw').focus();
		} else {
			$('#customerPwHelper').text('');
		}
	});
	
	$('#customerName').blur(function(){
		if($('#customerName').val().length < 2) {
			$('#customerNameHelper').text('이름을 입력하세요');
			$('#customerName').focus();
		} else {
			$('#customerNameHelper').text('');
		}
	});
	
	$('#customerAge').blur(function(){
		if($('#customerAge').val().length < 1) {
			$('#customerAgeHelper').text('나이를 입력하세요');
			$('#customerAge').focus();
		} else {
			$('#customerAgeHelper').text('');
		}
	});
	
	$('#customerPhone').blur(function(){
		if($('#customerPhone').val().length < 11 || $('#customerPhone').val().length > 12) {
			$('#customerPhoneHelper').text('번호를 입력하세요(- 제외하고 입력)');
			$('#customerPhone').focus();
		} else {
			$('#customerPhoneHelper').text('');
		}
	});
	
	$('#customerEmail').blur(function(){
		if($('#customerEmail').val().length < 1) {
			$('#customerEmailHelper').text('이메일를 입력하세요');
			$('#customerEmail').focus();
		} else {
			$('#customerEmailHelper').text('');
		}
	});
	
	
	$('#signup').click(function(){
		if($('#customerId').val() == '') {
			$('#customerIdHelper').text('id는 4자이상');
			
			$('#customerId').focus();
		} else if($('#customerPw').val() == '') {
			$('#customerIdHelper').text('');
			
			$('#customerPwHelper').text('pw는 4자이상');
			$('#customerPw').focus();
		} else if($('#customerName').val() == '') {
			$('#customerPwHelper').text('');
			
			$('#customerNameHelper').text('이름을 선택하세요');
			$('#customerName').focus();
		} else if($('#customerAge').val() == '') {
			$('#customerNameHelper').text('');
			
			$('#customerAgeHelper').text('나이를 입력하세요');
			$('#customerAge').focus();
		} else if($('#customerPhone').val()=='') {
			$('#customerAgeHelper').text('');
			
			$('#customerPhoneHelper').text('번호를 입력하세요');
			$('#customerPhone').focus();
		} else if($('#customerEmail').val()=='') {
			$('#customerPhoneHelper').text('');
			
			$('#customerEmailHelper').text('email를 입력하세요');
			$('#customerEmail').focus();
		} else {
			$('#signupForm').submit();
		}
	});
	
	
</script>
</body>
</html>