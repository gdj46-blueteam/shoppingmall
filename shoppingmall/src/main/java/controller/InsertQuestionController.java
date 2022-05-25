package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuestionDao;
import vo.Question;

@WebServlet("/InsertQuestionController")
public class InsertQuestionController extends HttpServlet {
	private QuestionDao questionDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 권한
		HttpSession session = request.getSession();
		int authority = (Integer)session.getAttribute("sessionAuthority");
		String sessionId = (String)session.getAttribute("sessionId");			//로그인 세션정보
		
		System.out.println("권한 : " + authority);
		System.out.println("ID : " + sessionId);
		
		if(authority > 0) {
			request.getRequestDispatcher("/WEB-INF/view/public/insertQuestionForm.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/view/public/errorPage.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.questionDao = new QuestionDao(); //dao객체 생성
		Question question = new Question();
		
		//request 분석
		String customerId = request.getParameter("customerId");
		String questionTitle = request.getParameter("questionTitle");
		String questionContent = request.getParameter("questionContent");
		
		//메서드 이용하여 모델값 구하기 (받아온 정보 vo에 넣어주기)
		question.setCustomerId(customerId);
		question.setQuestionTitle(questionTitle);
		question.setQuestionContent(questionContent);
		
		//디버깅
		System.out.println("InsertQuestionController(customerId) : " + customerId);
		System.out.println("InsertQuestionController(questionTitle) : " + questionTitle);
		System.out.println("InsertQuestionController(questionContent) : " + questionContent);
		
		
		int row = questionDao.indertQuestion(question);
		//디버깅
		if(row == 1) {
			System.out.println("문의사항 입력성공");
			response.sendRedirect(request.getContextPath()+"/SelectQuestionController");
		} else {
			System.out.println("문의사항 입력실패");
			response.sendRedirect(request.getContextPath()+"/InsertQuestionController");
		}
	}

}
