<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Free Bootstrap 4 Theme by ProBootstrap.com">
<meta name="keywords" content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">

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
	<jsp:include page="/WEB-INF/view/mainNav.jsp" /> <!-- nav -->
	<!-- 견적서 폼 -->
	<section class="probootstrap-cover overflow-hidden relative" style="background-image: url('assets/images/bg_1.jpg');" data-stellar-background-ratio="0.5" id="section-home">
		<div class="overlay"></div>
		<div class="container">
			<div class="row align-items-center">
				<div class="col-md">
					<h2 class="heading mb-2 display-4 font-light probootstrap-animate">Let Me Introduce Korea To The World</h2>
					<p class="lead mb-5 probootstrap-animate">
				</div>
				<div class="col-md probootstrap-animate">
					<form method="post" action="${pageContext.request.contextPath}/InsertDIYController" class="probootstrap-form">
						<div class="form-group">
							<div class="row mb-3">
								<div class="col-md">
									<div class="form-group">
										<label for="id_label_single">City 
										<select class="form-control" id="id_label_single2" style="width: 100%;" name="tourArea">
												<c:forEach var="c" items="${tourAreaList}">
													<option value="${c.tourAreaNo }">${c.area} ${c.city}</option>
												</c:forEach>
										</select>
										</label>
									</div>
								</div>
								<div class="col-md">
									<div class="form-group">
										<label for="id_label_single2">Language</label>
										<div class="probootstrap_select-wrap">
											<label for="id_label_single2" style="width: 100%;"> 
											<select class="form-control" id="id_label_single2" style="width: 100%;" name="language">
													<c:forEach var="c" items="${languageList}">
														<option value="${c.languageNo }">${c.language}</option>
													</c:forEach>
											</select>
											</label>
										</div>
									</div>
								</div>
							</div>
							<!-- END row -->
							<div class="row mb-3">
								<div class="col-md">
									<div class="form-group">
										<label for="id_label_single2">교통수단
										<select class="form-control" id="id_label_single2" style="width: 100%;" name=transportationNo>
												<c:forEach var="t" items="${transportationList}">
													<option value="${t.transportationNo}">${t.transportation}</option>
												</c:forEach>
										</select>
										</label>
									</div>
								</div>
								<div class="col-md">
									<div class="form-group">
										<label for="id_label_single2">테마</label>
										<div class="probootstrap_select-wrap">
											<label for="id_label_single2" style="width: 100%;"> 
											<select class="form-control" id="id_label_single2" style="width: 100%;" name="tourkindNo">
													<c:forEach var="k" items="${tourkindList}">
														<option value="${k.tourkindNo }">${k.tourkind}</option>
													</c:forEach>
											</select>
											</label>
										</div>
									</div>
								</div>
							</div>
							<!-- END row -->
							<div class="row mb-5">
								<div class="col-md">
									<div class="form-group">
										<label for="probootstrap">Personnel</label>
										<div class="probootstrap-date-wrap">
											<input type="number" id="" class="form-control" placeholder="인원수를 선택해주세요" name="tourDIYPeople" min="1">
										</div>
									</div>
								</div>
								<div class="col-md">
									<div class="form-group">
										<label for="probootstrap">Date of travel</label>
										<div class="probootstrap-date-wrap">
											<input type="date" class="form-control" placeholder="날짜를 선택해주세요" name="tourDIYTerm">
										</div>
									</div>
								</div>
							</div>
							<!-- END row -->
							<div class="row">
								<div class="col-md">
									<div class="form-group">
										<label for="id_label_single2">Accommodation</label>
										<div class="probootstrap_select-wrap">
											<label for="id_label_single2" style="width: 100%;"> 
											<select class="form-control" id="id_label_single2" style="width: 100%;"name="tourDIYStay">
													<option value="게스트하우스">게스트하우스</option>
													<option value="펜션">펜션</option>
													<option value="빌라">빌라</option>
													<option value="호텔">호텔</option>
											</select>
											</label>
										</div>
									</div>
								</div>
									<div class="form-group">
										<label for="probootstrap">Requirements</label>
										<div class="probootstrap_select-wrap">
											<label for="id_label_single2" style="width: 100%;"> 
											<textArea name="tourDIYEtc" rows="10" Cols="30" class="form-control" placeholder="요구사항을 입력해주세요"></textArea>
											</label>
										</div>
									</div>
									 <div class="col-md">
                  						<button type="submit" class="btn btn-primary btn-block">주문서 만들기</button>
                  					</div>
								</div>
							</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<!-- 견적서 form End -->
	<!-- 이미지 -->
	<section class="probootstrap_section" id="section-city-guides">
      <div class="container">
        <div class="row text-center mb-5 probootstrap-animate">
          <div class="col-md-12">
            <h2 class="display-4 border-bottom probootstrap-section-heading">Top Places Around The Korea</h2>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-3 col-md-6 probootstrap-animate mb-3">
            <a class="probootstrap-thumbnail">
              <img src="assets/images/Seoul.png" alt="Seoul" class="img-fluid ">
              <div class="probootstrap-text">
                <h3>Seoul</h3>
              </div>
            </a>
          </div>
          <div class="col-lg-3 col-md-6 probootstrap-animate mb-3">
            <a class="probootstrap-thumbnail">
              <img src="assets/images/Dokdo.jpg" alt="Dokdo" class="img-fluid">
              <h3>Dokdo</h3>
            </a>
          </div>
          <div class="col-lg-3 col-md-6 probootstrap-animate mb-3">
            <a class="probootstrap-thumbnail">
              <img src="assets/images/Busan.jpg" alt="Busan" class="img-fluid" style="height: 390px">
              <h3>Busan</h3>
            </a>
          </div>
          <div class="col-lg-3 col-md-6 probootstrap-animate mb-3">
            <a class="probootstrap-thumbnail">
              <img src="assets/images/Jeju.jpg" alt="Jeju" class="img-fluid" >
              <h3 style="bottom: 0px">Jeju</h3>
            </a>
            <a class="probootstrap-thumbnail">
              <img src="assets/images/Gyeongju.jpg" alt="Gyeongju" class="img-fluid"  style="margin-top: 2px">
              <h3>Gyeongju</h3>
            </a>
          </div>
          
        </div>
      </div>
    </section>
    <!-- 이미지 End -->
    <!-- 이용안내 -->
    <section class="probootstrap_section">
      <div class="container">
        <div class="row text-center mb-5 probootstrap-animate">
          <div class="col-md-12">
            <h2 class="display-4 border-bottom probootstrap-section-heading">Our Information</h2>
          </div>
        </div>
      </div>
    </section>
    
    <section class="probootstrap-section-half d-md-flex" id="section-about">
      <div class="probootstrap-image probootstrap-animate" data-animate-effect="fadeIn" style="background-image: url(${pageContext.request.contextPath}/assets/images/infomation.png)"></div>
      <div class="probootstrap-text">
        <div class="probootstrap-inner probootstrap-animate" data-animate-effect="fadeInRight">
          <h2 class="heading mb-4">Information</h2>
          <p>User guide page</p>
          <p><a href="${pageContext.request.contextPath}/SelectInfoController" class="btn btn-primary">Read More</a></p>
        </div>
      </div>
    </section>


    <section class="probootstrap-section-half d-md-flex">
      <div class="probootstrap-image order-2 probootstrap-animate" data-animate-effect="fadeIn" style="background-image: url(${pageContext.request.contextPath}/assets/images/tourInfo.jpg)"></div>
      <div class="probootstrap-text order-1">
        <div class="probootstrap-inner probootstrap-animate" data-animate-effect="fadeInLeft">
          <h2 class="heading mb-4">Tour information</h2>
         <p>Decide where to travel</p>
          <p><a href="${pageContext.request.contextPath}/SelectTourController" class="btn btn-primary">Learn More</a></p>
        </div>
      </div>
    </section>
    <!-- END section -->
    
    <!-- 리뷰 -->
     <section class="probootstrap_section">
      <div class="container">
        <div class="row text-center mb-5 probootstrap-animate">
          <div class="col-md-12">
            <h2 class="display-4 border-bottom probootstrap-section-heading">Our Review</h2>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12">
              <table style="width:100%;height: 100% " class="table">
              	<tr>
              		<th>번호</th>		
					<th>리뷰</th>
					<th>고객아이디</th>	
              	</tr>
              	
              	<c:forEach var="r" items="${reviewList}">  
              	<tr>
				<td>${r.reviewNo}</td>
				<td><a href="${pageContext.request.contextPath}/SelectOneReviewController?reviewNo=${r.reviewNo}">${r.review}</a></td>
				<td>${r.customerId}</td>
				</tr>
				</c:forEach>
              </table>
         </div>
        </div>  
      </div>
    </section>
    <!-- END section -->

	<!-- 직원목록 -->
	<section class="probootstrap_section" id="section-city-guides">
      <div class="container">
        <div class="container">
        <div class="row text-center mb-5 probootstrap-animate">
          <div class="col-md-12">
            <h2 class="display-4 border-bottom probootstrap-section-heading">Our Employees</h2>
          </div>
        </div>
	        <div class="row">
	          <div class="col-md-12">
	              <table class = "table table-bordered">
					<thead>
						<tr>
							<th>employeeNo</th>
							<th>employeeName</th>
							<th>employeeImage</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="e" items="${list}">
						<tr>
							<td>${e.employeeNo}</td>
							<td><a href="${pageContext.request.contextPath}/SelectEmpOneController?employeeNo=${e.employeeNo}">${e.employeeName}</a></td>
							<td><img src="./Image/${e.employeeImageName}" width="120" height="80" alt="직원사진"></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
	         </div>
	        </div>  
     	</div>
   	</div>
   	</section>
	
    
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
              <li><a href="${pageContext.request.contextPath}/InsertQuestionController" target="_blank">문의사항</a></li>
              <li><a href="${pageContext.request.contextPath}/SelectAnnoListController" target="_blank">공지사항</a></li>
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