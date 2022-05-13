<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "vo.*" %>
<%@ page import = "java.util.*" %>
<%
	List<Customer> list = (List<Customer>)request.getAttribute("customer");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectCustomerList</title>
</head>
<body>
	<table border = "1">
	<tr>
		<th>customerId</th>
		<th>customerName</th>
		<th>customerCountry</th>
		<th>customerGender</th>
	</tr>
			<%
			for(Customer c : list) {
			%>
				<tr>
					<td><%=c.getCustomerId() %></td>
					<td><%=c.getCustomerName() %></td>
					<td><%=c.getCustomerCountry() %></td>
					<td><%=c.getCustomerGender() %></td>
				</tr>
			<%
			}
			 %>
	 </table>
</body>
</html>