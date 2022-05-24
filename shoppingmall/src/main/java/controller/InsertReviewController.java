package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDao;
import vo.Review;

@WebServlet("/InsertReviewController")
public class InsertReviewController extends HttpServlet {
	private ReviewDao reviewDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 뷰 포워딩(v)
		request.getRequestDispatcher("/WEB-INF/view/customer/insertReview.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) request 분석(C)
		String customerId = request.getParameter("customerId");
		String review = request.getParameter("review");
		int tourDIYNo = Integer.parseInt(request.getParameter("tourDIYNo"));
		int estimateNo = Integer.parseInt(request.getParameter("estimateNo"));
		
		// 디버깅
		System.out.println("InsertReviewController : " + customerId);
		System.out.println("InsertReviewController : " + review);
		System.out.println("InsertReviewController : " + tourDIYNo);
		System.out.println("InsertReviewController : " + estimateNo);
		
		// 메서드 이용하여 모델값 구하기(M)
		Review reviewOne = new Review();
		reviewOne.setcustomerId(customerId);
		reviewOne.setReview(review);
		reviewOne.settourdiyNo(tourDIYNo);
		reviewOne.setEstimateNo(estimateNo);
		
		int row = reviewDao.insertReview(reviewOne);
		if (row == 1) { //성공
	        System.out.println("입력성공");
	        response.sendRedirect(request.getContextPath()+"/MyPageController");
	        return;
	     } else {// row==0이면 영향받은 행이 없으므로 오류
	        System.out.println("입력실패");
	        response.sendRedirect(request.getContextPath()+"/InsertReviewController"); 
	     }
	}

}
