<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ page import="vo.*" %>
<%@ page import="dao.*" %>
<%@ page import="java.util.*" %>
<%
	List<Question> questionList = (List<Question>)request.getAttribute("questionList");
	QuestionDao questionDao = new QuestionDao();
	Question question = new Question();
	questionDao.selectQuestion();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>select question</title>
</head>
<body>
	<h2>문의사항 확인</h2>
	<form>
		<table>
			<thead>
				<tr>
					<td>questionNo</td>
					<td>customerId</td>
					<td>questionTitle</td>
					<td>questionContent</td>
					<td>createDate</td>
					<td>updateDate</td>
				</tr>
			</thead>
			<tbody>
				<%
					for(Question q : questionList) {
				%>
				<tr>
					<td><%=q.getQuestionNo() %></td>
					<td><%=q.getCustomerId() %></td>
					<td><a href="<%=request.getContextPath()%>/DeleteQuestionController?questionNo=<%=q.getQuestionNo()%>"><%=q.getQuestionTitle()%></a></td>
					<td><%=q.getQuestionContent() %></td>
					<td><%=q.getCreateDate()%></td>
					<td><%=q.getUpdateDate()%></td>
				</tr>
				<%		
					}
				%>
			</tbody>	
		</table>
	</form>
</body>
</html>