<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Free Bootstrap 4 Theme by ProBootstrap.com">
<meta name="keywords" content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">

<title>login</title>
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
	<!-- nav -->
	<!-- 로그인 폼 -->
	<section class="probootstrap-cover overflow-hidden relative" style="background-image: url('assets/images/bg_1.jpg');"data-stellar-background-ratio="0.5" id="section-home">
		<div class="overlay"></div>
		<div class="container">
			<div class="row align-items-center">
				<div class="col-md">
					<h2 class="heading mb-2 display-4 font-light probootstrap-animate">Login</h2>
					<p class="lead mb-5 probootstrap-animate">
				</div>
				<div class="col-md probootstrap-animate">
					<form action="${pageContext.request.contextPath}/LoginController" method="post" class="probootstrap-form">
						<div class="row mb-5">
							<div class="col-md">
								<div class="form-group">
									<label for="probootstrap-date-departure">ID</label>
									<div class="probootstrap-date-wrap">
										<input type="text" id="id" class="form-control" placeholder="아이디를 입력해주세요" name="id">
									</div>
								</div>
							</div>
							<div class="col-md">
								<div class="form-group">
									<label for="probootstrap-date-arrival">PASSWORD</label>
									<div class="probootstrap-date-wrap">
										<input type="password" class="form-control" placeholder="비밀번호를 입력해주세요" name="pw">
									</div>
								</div>
								 	<div class="col-md">
                  						<button type="submit" class="btn btn-primary btn-block">로그인</button><br>
                  					</div>
							</div>
							<a href="${pageContext.request.contextPath}/SelectCustomerIdController" class="btn btn-primary btn-block">ID찾기</a>
                  			<a href="${pageContext.request.contextPath}/FindCustomerPwController" class="btn btn-primary btn-block">PW찾기</a>
						</div>
					</form>
					<form action="${pageContext.request.contextPath}/LoginController" method="post" class="probootstrap-form">
                        <div class="row mb-5">
                            <div class="col-md">
                                <div class="form-group">
                                    <label for="probootstrap-date-departure">ID</label>
                                    <div class="probootstrap-date-wrap">
                                        <input type="text" id="id" class="form-control" value="admin" name="id">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md">
                                <div class="form-group">
                                    <label for="probootstrap-date-arrival">PASSWORD</label>
                                    <div class="probootstrap-date-wrap">
                                        <input type="password" class="form-control" value="1234" name="pw">
                                    </div>
                                </div>
                                    <div class="col-md">
                                        <button type="submit" class="btn btn-primary btn-block">관리자 로그인</button><br>
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
</body>
</html>