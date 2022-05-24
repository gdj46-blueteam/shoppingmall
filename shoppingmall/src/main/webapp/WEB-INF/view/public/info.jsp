<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <title>K-Travel</title>
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
<jsp:include page="/WEB-INF/view/mainHome/mainNav.jsp" /> <!-- nav -->
   <section class="probootstrap-cover overflow-hidden relative" style="background-image: url('assets/images//bg_1.jpg');"data-stellar-background-ratio="0.5" id="section-home">
		<div class="probootstrap-text">
			<div class="container">
				<div class="col-md probootstrap-animate">
					<form method="post" class="probootstrap-form">
						<div class="form-group">
							<div class="row mb-3">
								<!-- section : 사진크기 조정용..  -->
							</div>
						</div>
					</form>
				</div>
	        </div>
        </div>
	</section>
		<div class="text-center" style="color: black; ">
			<p> Hello, welcome to your k-travel!</p>
			<p> Using k-travel! is very simple</p>
			<p> To use our site, first go to the tour guide, make a note of the tour you want, and write it on the estimate in Home</p>
			<p> Submit a quote and we'll send you an email or phone call and we'll set a staffing and pricing based on your language and other requirements</p>
			<p> Then you can check the price and staff and let us know what needs to be corrected, and we will check it and assign a price and staffp></p>
			<p> Once the quotation is complete, you can pay and prepare for a pleasant trip</p>
			<p> Thank you for using k-travel</p>
		</div>
    
    <!-- footer -->
    <footer class="probootstrap_section probootstrap-border-top">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md-3">
            <h3 class="probootstrap_font-18 mb-3">K-Travel 소개</h3>
            <ul class="list-unstyled">
              <li><a href="${pageContext.request.contextPath}/MainHomeController" target="_blank">Home</a></li>
              <li><a href="${pageContext.request.contextPath}/SelectInfoController" target="_blank">이용안내</a></li>
              <li><a href="${pageContext.request.contextPath}/SelectEmpListController" target="_blank">직원목록</a></li>
              <li><a href="${pageContext.request.contextPath}/SelectTourController" target="_blank">관광안내</a></li>
            </ul>
          </div>
          <div class="col-md-3">
            <h3 class="probootstrap_font-18 mb-3">고객센터</h3>
            <ul class="list-unstyled">
              <li><a href="${pageContext.request.contextPath}/InsertQuestionController">문의사항</a></li>
              <li><a href="${pageContext.request.contextPath}/SelectAnnoListController">공지사항</a></li>
            </ul>
          </div>
            <div class="col-md-3">
                <ul class="probootstrap-contact-details">
                  <li>
                    <span class="text-uppercase"><span class="ion-paper-airplane"></span> Email</span>
                   K_Travel46@gmail.com
                  </li>
                  <li>
                    <span class="text-uppercase"><span class="ion-ios-telephone"></span> Phone</span>
                    +82-2-2101-5900
                  </li>
                </ul>
              </div>
           	<div class="col-md-3">
                <ul class="probootstrap-contact-details">
                	<li>
                    <span class="text-uppercase"><span class="ion-location"></span> Address(EN)</span>
                    1109<br>
                    115, Gasan digital 2-ro <br>
                   Geumcheon-gu, Seoul, Republic of Korea
                  </li>
                  <li>
                    <span class="text-uppercase"><span class="ion-location"></span>Address(KO)</span>
                    서울특별시 금천구 가산동<br>
                    가산디지털2로 115 <br>
                  	1109호
                  </li>
                </ul>
              </div>
         </div>
       </div>
    </footer>
    
    <script src="${pagaContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script src="${pagaContext.request.contextPath}/assets/js/popper.min.js"></script>
    <script src="${pagaContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <script src="${pagaContext.request.contextPath}/assets/js/owl.carousel.min.js"></script>
    <script src="${pagaContext.request.contextPath}/assets/js/jquery.waypoints.min.js"></script>
    <script src="${pagaContext.request.contextPath}/assets/js/jquery.easing.1.3.js"></script>
    <script src="${pagaContext.request.contextPath}/assets/js/select2.min.js"></script>
    <script src="${pagaContext.request.contextPath}/assets/js/main.js"></script>
</body>
</html>