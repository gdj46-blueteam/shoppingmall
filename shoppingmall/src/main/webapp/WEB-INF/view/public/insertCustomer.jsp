<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<h1>회원가입</h1>
	<table>
		<form id="signupForm" method="post" action="${pageContext.request.contextPath}/InsertCustomerController">
			<tr>
				<td>customerId</td>
				<td>
				<input type="text" id="customerId" name="customerId"  value="">
				<span id="customerIdHelper" class="helper"></span>
				</td>
			</tr>
			<tr>
				<td>customerPw</td>
				<td>
				<input type="password" name="customerPw" id="customerPw">
				</td>
			</tr>
			<tr>
				<td>customerPwConfirm</td>
				<td>
				<input type="password" name="customerPwConfirm" id="customerPwConfirm">
				<span id="customerPwHelper" class="helper"></span>
				</td>
			</tr>
			<tr>	
				<td>customerName</td>
				<td>
					<input type="text" name="customerName" id="customerName">
					<span id="customerNameHelper" class="helper"></span>
				</td>
			</tr>
			<tr>
				<td>customerGender</td>
				<td>
				<input type='radio' name='customerGender' value='남' class="gender">남
				<input type='radio' name='customerGender' value='여' class="gender">여
				<span id="customerGenderHelper" class="helper"></span>
				</td>
			</tr>
			<tr>
				<td>customerAge</td>
				<td>
					<input name="customerAge" type="number" id="customerAge">
					<span id="customerAgeHelper" class="helper"></span>
				</td>
			</tr>
			<tr>
				<td>customerPhone('-'except)</td>
				<td>
					<input name="customerPhone" type="text" id="customerPhone">
					<span id="customerPhoneHelper" class="helper"></span>
				</td>
			</tr>
			<tr>
				<td>customerEmail</td>
				<td>
					<input name="customerEmail" type="text" id="customerEmail">
					<span id="customerEmailHelper" class="helper"></span>
				</td>
			</tr>
			<tr>
				<td>customerCountry</td>
				<td>
					<select id="customerCountry" name="customerCountry">
						<!-- 필수 -->
                        <option value="대한민국">대한민국</option>
                        <option value="미국">미국</option>
                        <option value="스위스">스위스</option>
                        <option value="스페인">스페인</option>
                        <option value="영국">영국</option>
                        <option value="일본">일본</option>
                        <option value="증극">중국</option>
                        <option value="프랑스">프랑스</option>
                    </select>
					<span id="customerCountryHelper" class="helper"></span>
				</td>
			</tr>
			<button type="button" id="signup">가입</button>
			<button type="reset">다시 입력</button>
		</form>
		<a href="${pageContext.request.contextPath}/LoginController">뒤로</a>
	</table>
</body>
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
		} else if($('#customerGender:checked').length == 0) {
			$('#customerNameHelper').text('');
			
			$('#customerGenderHelper').text('성별을 선택하세요');
			$('#customerGender').focus();
		} else if($('#customerAge').val() == '') {
			$('#customerGender').text('');
			
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
</html>