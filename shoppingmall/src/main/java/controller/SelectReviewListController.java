package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDao;
import vo.Review;

@WebServlet("/SelectReviewListController")
public class SelectReviewListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//요청값
	List<Review> reviewList = new ArrayList<Review>();
	ReviewDao reviewDao = new ReviewDao();
	reviewList = reviewDao.selecteReview();
	
	System.out.println("reviewList : "+ reviewList.size());
	
	//뷰
	request.setAttribute("reviewList", reviewList);
	request.getRequestDispatcher("/WEB-INF/view/public/reviewList.jsp").forward(request, response);
	}

}
