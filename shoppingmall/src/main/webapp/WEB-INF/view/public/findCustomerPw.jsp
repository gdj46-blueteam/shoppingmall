<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form method="post" action= "${pageContext.request.contextPath}/FindCustomerPwController">
   <table>
         <tr>
            <td>customerId</td>
            <td><input type="text" name="customerId"></td>
         </tr>
         
         <tr>
            <td>userPw</td>
            <td>${customerPw}</td>
         </tr>
      </table>
      <button type="submit">Pw찾기</button>
      <a href="${pageContext.request.contextPath}/LoginController">로그인하러가기</a>
   </form>
</body>
</html>