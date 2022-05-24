<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Free Bootstrap 4 Theme by ProBootstrap.com">
<meta name="keywords" content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">
<title>Admin Page</title>
	<!-- css 링크 -->
    <link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,700" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/animate.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/fonts/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/fonts/flaticon/font/flaticon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/fonts/fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/select2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/helpers.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body>
	<jsp:include page="/WEB-INF/view/mainHome/mainNav.jsp" /> <!-- nav -->
	<%-- <section class="probootstrap-cover overflow-hidden relative" style="background-image: url('${pageContext.request.contextPath}/assets/images/bg_1.jpg');" data-stellar-background-ratio="0.5" id="section-home">
		<div class="overlay"></div>
			<div class="container">
       		<div class="row align-items-center">
				<div class="col-md probootstrap-animate">
	            	<ul class="nav nav-tabs">
	            		  <li class="nav-item dropdown">
	            			 <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="${pageContext.request.contextPath}/Login/SelectAdminListController">관리자페이지</a>
		            		 <div class="dropdown-menu">
		            		 	<a class="nav-link " data-toggle="dropdown" href="${pageContext.request.contextPath}/Login/SelectAdminOneController" >관리자정보</a>
		            			<a class="nav-link" data-toggle="tab" href="${pageContext.request.contextPath}/SelectCustomerListController">회원</a>            
		            			<a class="nav-link" data-toggle="tab" href="${pageContext.request.contextPath}/SelectEmpListController">직원</a>            		
		            			<a class="nav-link" data-toggle="tab" href="${pageContext.request.contextPath}/SelectEmpMatchingController">매칭확인</a>            		
		            			<a class="nav-link" data-toggle="tab" href="${pageContext.request.contextPath}/SelectTourController">관광</a>            		
		            			<a class="nav-link" data-toggle="tab" href="${pageContext.request.contextPath}/SelectAnnoListController">공지사항</a>	            		
		            			<a class="nav-link" data-toggle="tab" href="${pageContext.request.contextPath}/SelectEstimateController">견적서</a>
		            			<a class="nav-link" data-toggle="tab" href="${pageContext.request.contextPath}/SelectQuestionController">문의사항</a>
					  			<a class="nav-link" data-toggle="tab" href="${pageContext.request.contextPath}/StaticsListController">통계</a>
		            		</div>
	            		</li>
	            	</ul>
	          </div>
         </div>
       </div>
	</section> --%>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/owl.carousel.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap-datepicker.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/jquery.waypoints.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/jquery.easing.1.3.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/select2.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
</body>
</html>