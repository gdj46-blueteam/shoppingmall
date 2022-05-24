package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDao;
import vo.Review;

@WebServlet("/SelectOneReviewController")
public class SelectReviewOneController extends HttpServlet {
	private ReviewDao reviewDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//dao 값 받기 - reviewNo
		
		
		// view로 값 보내기
	
		request.getRequestDispatcher("/WEB-INF/view/public/reviewOneList.jsp").forward(request, response);
	
	}

}
