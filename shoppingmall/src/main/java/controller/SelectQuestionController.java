package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuestionDao;
import vo.Question;


@WebServlet("/SelectQuestionController")
public class SelectQuestionController extends HttpServlet {
   private QuestionDao questionDao;
	public SelectQuestionController() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * HttpServletRequest req = (HttpServletRequest)request; HttpSession session =
		 * req.getSession(); int authority = (int)session.getAttribute("authority");
		 * String sessionId = (String)session.getAttribute("sessionId"); //로그인 세션정보
		 * 
		 * System.out.println("권한 : " + authority); System.out.println("ID : " +
		 * sessionId);
		 */
		
		this.questionDao = new QuestionDao();
		List<Question> questionList = questionDao.selectQuestion();
		request.setAttribute("questionList", questionList);
		for(Question q : questionList) {
			System.out.println(q+"<-dao호출확인");
		}
		request.getRequestDispatcher("/WEB-INF/view/admin/selectQuestion.jsp").forward(request, response);
	}

}
