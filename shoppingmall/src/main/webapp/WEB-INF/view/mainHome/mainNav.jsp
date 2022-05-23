<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	int authority = 0;
	if(session.getAttribute("sessionAuthority") != null) {
		authority = (int)session.getAttribute("sessionAuthority");

		}
	System.out.println("authority(mainhome) ->" + authority);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark probootstrap_navbar" id="probootstrap-navbar">
      <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/MainHomeController">K-Travel</a>
        <div class="collapse navbar-collapse" id="probootstrap-menu">
        <%
			if(authority == 1){ //권한 1 고객
        %>
          <ul class="navbar-nav ml-auto">
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/MainHomeController">Home</a></li>
           	<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/LogoutController">로그아웃</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/SelectCustomerOneController">마이페이지</a></li>
            <li class="nav-item"><a class="nav-link active" href="${pageContext.request.contextPath}/">공지사항</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/">문의사항</a></li>
          </ul>
          <%
			}else if(authority == 2){ //권한 2 직원
          %>
          	 <ul class="navbar-nav ml-auto">
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/MainHomeController">Home</a></li>
           	<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/LogoutController">로그아웃</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/SelectSelectEmpOneController">직원페이지</a></li>
            <li class="nav-item"><a class="nav-link active" href="travel.html">Travel With Us</a></li>
            <li class="nav-item"><a class="nav-link" href="contact.html">Contact</a></li>
          </ul>
          <%
			}else if(authority == 3){ //권한 3 관리자
          %>
          	 <ul class="navbar-nav ml-auto">
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/MainHomeController">Home</a></li>
           	<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/LogoutController">로그아웃</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/SelectAdminListController">관리자페이지</a></li>
            <li class="nav-item"><a class="nav-link active" href="travel.html">Travel With Us</a></li>
            <li class="nav-item"><a class="nav-link" href="contact.html">Contact</a></li>
          </ul>
          <%
			}else{ //권한 없음 비회원
          %>
          	<ul class="navbar-nav ml-auto">
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/MainHomeController">Home</a></li>
           	<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/LoginController">로그인</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/InsertCustomerController">회원가입</a></li>
            <li class="nav-item"><a class="nav-link active" href="${pageContext.request.contextPath}/SelectAnnoListController">공지사항</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/">문의사항</a></li>
          </ul>
          <%
			}
        	System.out.println("authority(mainhome2) ->" + authority);
          %>
        </div>
      </div>
    </nav>
    <!-- END nav -->
</body>
</html>