package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
		//요청값 받아오기
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		System.out.println(reviewNo);
		System.out.println("reviewNo(SelectOneReviewController) ->" + reviewNo);
		
		//dao 호출
		this.reviewDao = new ReviewDao();
		Map<String, Object> map = reviewDao.selectReviewOne(reviewNo);
		request.setAttribute("map", map);
		System.out.println(map+ "SelectOneReviewController");
		
		// view로 값 보내기	
		request.getRequestDispatcher("/WEB-INF/view/public/reviewOne.jsp").forward(request, response);
	
	}

}
