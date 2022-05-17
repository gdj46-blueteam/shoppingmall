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


@WebServlet("/SelectQuestionController")
public class SelectQuestionController extends HttpServlet {
   private QuestionDao questionDao;
	public SelectQuestionController() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.questionDao = new QuestionDao();
		List<Question> questionList = questionDao.selectQuestion();
		request.setAttribute("questionList", questionList);
		for(Question q : questionList) {
			System.out.println(q+"<-dao호출확인");
		}
		request.getRequestDispatcher("/WEB-INF/view/admin/selectQuestion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
