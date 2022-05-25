package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReviewDao;

/**
 * Servlet implementation class DeleteReviewController
 */
@WebServlet("/DeleteReviewController")
public class DeleteReviewController extends HttpServlet {
	private ReviewDao reviewDao; 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 권한
		HttpSession session = request.getSession();
		int authority = (Integer)session.getAttribute("sessionAuthority");
		String sessionId = (String)session.getAttribute("sessionId");			//로그인 세션정보
		
		System.out.println("권한 : " + authority);
		System.out.println("ID : " + sessionId);
		
		// 요청값 (c)
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		int row = reviewDao.delectReview(reviewNo);		
		
		
		if(authority > 2) {
			request.getRequestDispatcher("/ReviewListController").forward(request, response);		
		} else {
			request.getRequestDispatcher("/WEB-INF/view/public/errorPage.jsp").forward(request, response);
		}
		// 뷰 포워딩(v)
		
	}

}
