<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	<h1>관리자페이지</h1>
	<ol>
		<li><a href="<%=request.getContextPath()%>/SelectAdminOneController">관리자정보</a></li>
		<li><a href="<%=request.getContextPath()%>/SelectCustomerListController">회원</a></li>
		<li><a href="<%=request.getContextPath()%>/SelectEmpListController">직원</a></li>
		<li><a href="<%=request.getContextPath()%>/SelectEmpMatchingController">매칭확인</a></li>
		<li><a href="<%=request.getContextPath()%>/SelectTourController">관광</a></li>
		<li><a href="<%=request.getContextPath()%>/SelectAnnoListController">공지사항</a></li>
		<li><a href="<%=request.getContextPath()%>/SelectEstimateController">견적서</a></li>
		<li><a href="<%=request.getContextPath()%>/SelectQuestionController">문의사항</a></li>
		<li><a href="<%=request.getContextPath()%>/StaticsListController">통계</a></li>
	</ol>
	</table>
</body>
</html>