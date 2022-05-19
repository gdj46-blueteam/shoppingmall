package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDao;

/**
 * Servlet implementation class DeleteReviewController
 */
@WebServlet("/DeleteReviewController")
public class DeleteReviewController extends HttpServlet {
	private ReviewDao reviewDao; 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청값 (c)
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		int row = reviewDao.delectReview(reviewNo);		
		
		// 뷰 포워딩(v)
		request.getRequestDispatcher("/ReviewListController").forward(request, response);
	}

}
