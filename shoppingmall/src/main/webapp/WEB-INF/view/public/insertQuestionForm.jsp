<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Free Bootstrap 4 Theme by ProBootstrap.com">
<meta name="keywords" content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">
<title>Contact & Question</title>
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
  <jsp:include page="/WEB-INF/view/mainNav.jsp" /> <!-- nav -->
    <section class="probootstrap-cover overflow-hidden relative"  style="background-image: url('assets/images/bg_1.jpg');" data-stellar-background-ratio="0.5" id="section-home">
      <div class="overlay"></div>
      <div class="container">
      <h2 class="heading mb-2 display-4 font-light probootstrap-animate text-center">Let's Go Ask!</h2>
      </div>
    
    </section>
    <!-- END section -->
    
    <section class="probootstrap_section bg-light" id="section-contact">
      <div class="container">
        <div class="row">
          <div class="col-md-6 probootstrap-animate">
            <p class="mb-5">K-TRAVEL started its journey by envisioning a world with no mass tourism, but personalized traveling, at scale. Profesor, por favor, tómese su clase con Calma.<br>
					While tourists are flocking to the city centers and hotspots, locals are drawn away to avoid the crowds, and enjoy their local life. This is where K-TRAVEL comes in. no hay fracaso.<br>
					Our platform is a wonderful way for our guests to explore the highlights but also the hidden gems of a city with their private local host, while locals have the opportunity to earn an income by sharing their city & passions with their guests. </p>
            <div class="row">
              <div class="col-md-6">
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
              <div class="col-md-6">
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
           <div class="col-md-6  probootstrap-animate">
            <form action="${pageContext.request.contextPath}/InsertQuestionController" method="post" class="probootstrap-form probootstrap-form-box mb60">
              <div class="row mb-3">
                <div class="col-md-6">
                  <div class="form-group">
                    <label for="" id"" class="sr-only sr-only-focusable">ID</label>
                    <input type="text" class="form-control" id="id" name="customerId" placeholder="ID">
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label for="password" class="sr-only sr-only-focusable">PASSWORD</label>
                    <input type="password" class="form-control" id="password" name="customerPw" placeholder="PASSWORD">
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label for="name" class="sr-only sr-only-focusable">NAME</label>
                <input type="text" class="form-control" id="name" name="customerName" placeholder="name">
              </div>
              <div class="form-gruop">
              <label for="name" class="sr-only sr-only-focusable">TITLE</label>
                <input type="text" class="form-control" id="name" name="questionTitle" placeholder="title">              
              </div>
              <div class="form-group">
                <label for="content" class="sr-only sr-only-focusable">CONTENT</label>
                <textarea cols="30" rows="10" class="form-control" id="content" name="questionContent" placeholder="Write your question"></textarea>
              </div>
              <div class="form-group">
                <input type="submit" class="btn btn-primary" id="submit" name="submit" value="Send Question">
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>
    <!-- END section -->
  
    <footer class="probootstrap_section probootstrap-border-top">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md-3">
            <h3 class="probootstrap_font-18 mb-3">K-Travel 소개</h3>
            <ul class="list-unstyled">
              <li><a href="https://free-template.co" target="_blank">Home</a></li>
              <li><a href="https://free-template.co" target="_blank">About</a></li>
              <li><a href="https://free-template.co" target="_blank">Services</a></li>
              <li><a href="https://free-template.co" target="_blank">Contact</a></li>
            </ul>
          </div>
          <div class="col-md-3">
            <h3 class="probootstrap_font-18 mb-3">고객센터</h3>
            <ul class="list-unstyled">
              <li><a href="https://free-template.co" target="_blank">Home</a></li>
              <li><a href="https://free-template.co" target="_blank">About</a></li>
              <li><a href="https://free-template.co" target="_blank">Services</a></li>
              <li><a href="https://free-template.co" target="_blank">Contact</a></li>
            </ul>
          </div>
         </div>
       </div>
    </footer>
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