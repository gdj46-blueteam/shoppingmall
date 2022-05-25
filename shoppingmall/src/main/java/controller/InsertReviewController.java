package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReviewDao;
import vo.Review;
import vo.TourArea;

@WebServlet("/InsertReviewController")
public class InsertReviewController extends HttpServlet {
	private ReviewDao reviewDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 권한
		HttpSession session = request.getSession();
		int authority = (Integer)session.getAttribute("sessionAuthority");
		String sessionId = (String)session.getAttribute("sessionId");			//로그인 세션정보
		
		System.out.println("권한 : " + authority);
		System.out.println("ID : " + sessionId);
		
		
		this.reviewDao = new ReviewDao();
		List<TourArea> list = this.reviewDao.selectReviewConfirm(sessionId);
		System.out.println(list.size());
		if(this.reviewDao.selectReviewConfirm(sessionId) == null || authority > 0) {
			request.getRequestDispatcher("/WEB-INF/view/customer/MyPage.jsp").forward(request, response);
		} else {
			List<TourArea> list2 = this.reviewDao.selectReviewConfirm(sessionId);
			request.setAttribute("cityList", list2);
			System.out.println("InsertReviewController확인 : " + list2.size());
			// 뷰 포워딩(v)
			request.getRequestDispatcher("/WEB-INF/view/customer/insertReview.jsp").forward(request, response);	
		}
		
				
		
		
		
		
		
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
