<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <title>K-Travel</title>
   <meta name="description" content="Free Bootstrap 4 Theme by ProBootstrap.com">
   <meta name="keywords" content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">
   <link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,700" rel="stylesheet">
   <link rel="stylesheet" href="${pagaContext.request.contextPath}/assets/css/bootstrap/bootstrap.css">
   <link rel="stylesheet" href="${pagaContext.request.contextPath}/assets/css/animate.css">
   <link rel="stylesheet" href="${pagaContext.request.contextPath}/assets/fonts/ionicons/css/ionicons.min.css">
   <link rel="stylesheet" href="${pagaContext.request.contextPath}/assets/css/owl.carousel.min.css">
   <link rel="stylesheet" href="${pagaContext.request.contextPath}/assets/fonts/flaticon/font/flaticon.css">
   <link rel="stylesheet" href="${pagaContext.request.contextPath}/assets/fonts/fontawesome/css/font-awesome.min.css">
   <link rel="stylesheet" href="${pagaContext.request.contextPath}/assets/css/select2.css">
   <link rel="stylesheet" href="${pagaContext.request.contextPath}/assets/css/helpers.css">
   <link rel="stylesheet" href="${pagaContext.request.contextPath}/assets/css/style.css">
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
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
 <nav class="navbar navbar-expand-lg navbar-dark probootstrap_navbar" id="probootstrap-navbar">
      <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/MainHomeController">K-Travel</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#probootstrap-menu" aria-controls="probootstrap-menu" aria-expanded="false" aria-label="Toggle navigation">
          <span><i class="ion-navicon"></i></span>
        </button>
        <div class="collapse navbar-collapse" id="probootstrap-menu">

        <%
         if(authority == 1){ //권한 1 고객
        %>
          <ul class="navbar-nav ml-auto">
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/MainHomeController">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/SelectCustomerOneController">마이페이지</a></li>
            <li class="nav-item"><a class="nav-link active" href="travel.html">Travel With Us</a></li>
            <li class="nav-item"><a class="nav-link" href="contact.html">Contact</a></li>
            <li class="nav-item"><a class="nav-link disable" ><%=sessionId %>님 반갑습니다.</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/LogoutController">로그아웃</a></li>
          </ul>
          <%
         }else if(authority == 2){ //권한 2 직원
          %>
           <ul class="navbar-nav ml-auto">
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/MainHomeController">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/SelectSelectEmpOneController">마이페이지</a></li>
            <li class="nav-item"><a class="nav-link active" href="travel.html">Travel With Us</a></li>
            <li class="nav-item"><a class="nav-link" href="contact.html">Contact</a></li>
            <li class="nav-item"><a class="nav-link disable" ><%=sessionId %>님 반갑습니다.</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/LogoutController">로그아웃</a></li>
          </ul>
          <%
         }else if(authority == 3){ //권한 3 관리자
          %>
              <ul class="navbar-nav ml-auto">
             <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/MainHomeController">Home</a></li>
             <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/Login/SelectAdminListController">관리자페이지</a></li>
            <li class="nav-item"><a class="nav-link active" href="travel.html">Travel With Us</a></li>
            <li class="nav-item"><a class="nav-link" href="contact.html">Contact</a></li>
            <li class="nav-item"><a class="nav-link disable" ><%=sessionId %>님 반갑습니다.</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/LogoutController">로그아웃</a></li>
          </ul>
          <%
         }else{ //권한 없음 비회원
          %>
             <ul class="navbar-nav ml-auto">
             <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/LoginController">로그인</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/MainHomeController">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/InsertCustomerController">회원가입</a></li>
            <li class="nav-item"><a class="nav-link active" href="${pageContext.request.contextPath}/SelectAnnoListController">공지사항</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
          </ul>
          <%
         }
           System.out.println("authority(mainhome2) ->" + authority);
           //System.out.println("id(mainhome) ->" + id);
          %>
          <%
			if(!sessionId.equals("")) {
		  %>
				<div class="heading mb-4"></div>
		  <%
			}
		  %>
        </div>
      </div>
    </nav>
    <!-- END nav -->
    

    <section class="probootstrap-cover overflow-hidden relative"  style="background-image: url('${pagaContext.request.contextPath}/assets/images/bg_1.jpg');" data-stellar-background-ratio="0.5" id="section-home">
      <div class="overlay"></div>
      <div class="container">
        <div class="row align-items-center text-center">
       		<div class="col-md">
            	<h2 class="heading mb-2 display-4 font-light probootstrap-animate">이용안내</h2>
            </div>
        </div>
      </div>
    </section>
    <!-- END section -->
     <div class="container">
     <br><br><h1>TourList</h1><br>
        <div class="row align-items-center text-center">
        <form action="${pageContext.request.contextPath}/SelectTourController" method="get">
          	<table class="table table-hover">
				<thead>
				<tr>
					<td>image</td>
					<td>tourNo</td>
					<td>tourAreaNo</td>
					<td>tourName</td>
					<td>tourDescription</td>
					<td>tourImageNo</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var = "t" items = "${tourList}">
						<tr>
							<Td><img src="./Image/${t.tourImageName}" width="200" height="200">
							<td>${t.tourNo}</td>
							<td>${t.tourAreaNo}</td>
							<td><a href="${pageContext.request.contextPath}/DeleteTourController?tourNo=${t.tourNo}">${t.tourName}</a></td>
							<td>${t.tourDescription}</td>
							<td>${t.tourImageNo}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
        </div>
        <div>
        	<br><a href = "${pageContext.request.contextPath}/MainHomeController">back</a>
        </div>
      </div>
	<br>
    <!-- END section -->

    <footer class="probootstrap_section probootstrap-border-top">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md-3">
            <h3 class="probootstrap_font-18 mb-3">Quick Links</h3>
            <ul class="list-unstyled">
              <li><a href="https://free-template.co" target="_blank">Home</a></li>
              <li><a href="https://free-template.co" target="_blank">About</a></li>
              <li><a href="https://free-template.co" target="_blank">Services</a></li>
              <li><a href="https://free-template.co" target="_blank">Contact</a></li>
            </ul>
          </div>
          <div class="col-md-3">
            <h3 class="probootstrap_font-18 mb-3">Quick Links</h3>
            <ul class="list-unstyled">
              <li><a href="https://free-template.co" target="_blank">Home</a></li>
              <li><a href="https://free-template.co" target="_blank">About</a></li>
              <li><a href="https://free-template.co" target="_blank">Services</a></li>
              <li><a href="https://free-template.co" target="_blank">Contact</a></li>
            </ul>
          </div>
          <div class="col-md-3">
            <h3 class="probootstrap_font-18 mb-3">Quick Links</h3>
            <ul class="list-unstyled">
              <li><a href="https://free-template.co" target="_blank">Home</a></li>
              <li><a href="https://free-template.co" target="_blank">About</a></li>
              <li><a href="https://free-template.co" target="_blank">Services</a></li>
              <li><a href="https://free-template.co" target="_blank">Contact</a></li>
            </ul>
          </div>
          <div class="col-md-3">
            <h3 class="probootstrap_font-18 mb-3">Quick Links</h3>
            <ul class="list-unstyled">
              <li><a href="https://free-template.co" target="_blank">Home</a></li>
              <li><a href="https://free-template.co" target="_blank">About</a></li>
              <li><a href="https://free-template.co" target="_blank">Services</a></li>
              <li><a href="https://free-template.co" target="_blank">Contact</a></li>
            </ul>
          </div>
        </div>
        <div class="row pt-5">
          <div class="col-md-12 text-center">
            <p class="probootstrap_font-14">&copy; 2017. All Rights Reserved. <br> Designed &amp; Developed by <a href="https://probootstrap.com/" target="_blank">ProBootstrap</a><small> (Don't remove credit link on this footer. See <a href="https://probootstrap.com/license/">license</a>)</small></p>
            <p class="probootstrap_font-14">Demo Images: <a href="https://unsplash.com/" target="_blank">Unsplash</a></p>
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