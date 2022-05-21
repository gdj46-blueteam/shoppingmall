<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
   <title>왜 안돼</title>
    </head>
    <body>
	<h1>관리자페이지</h1>
	<ol>
		<li><a href="${pageContext.request.contextPath}/SelectAdminOneController">관리자정보</a></li>
		<li><a href="${pageContext.request.contextPath}/SelectCustomerListController">회원</a></li>
		<li><a href="${pageContext.request.contextPath}/SelectEmpListController">직원</a></li>
		<li><a href="${pageContext.request.contextPath}/SelectEmpMatchingController">매칭확인</a></li>
		<li><a href="${pageContext.request.contextPath}/SelectTourController">관광</a></li>
		<li><a href="${pageContext.request.contextPath}/SelectAnnoListController">공지사항</a></li>
		<li><a href="${pageContext.request.contextPath}/SelectEstimateController">견적서</a></li>
		<li><a href="${pageContext.request.contextPath}/SelectQuestionController">문의사항</a></li>
		<li><a href="${pageContext.request.contextPath}/StaticsListController">통계</a></li>
	</ol>
</body>
</html>