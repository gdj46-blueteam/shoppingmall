package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuestionDao;
import vo.Question;

@WebServlet("/DeleteQuestionController")
public class DeleteQuestionController extends HttpServlet {
    public DeleteQuestionController() {
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int questionNo = Integer.parseInt(request.getParameter("questionNo"));//요청값받아옴
		System.out.println(questionNo + "<-페이지넘기기전질문번호");//디버깅
		request.setAttribute("questionNo", questionNo);
		request.getRequestDispatcher("/WEB-INF/view/admin/deleteQuestionForm.jsp").forward(request, response);		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int questionNo = Integer.parseInt(request.getParameter("questionNo"));//요청값받아옴
		QuestionDao questionDao = new QuestionDao();
		questionDao.deleteQuestion(questionNo);//dao호출
		System.out.println(questionNo + "<-dao호출후질문번호");//디버깅
		response.sendRedirect(request.getContextPath()+"/SelectQuestionController");

	}

}
