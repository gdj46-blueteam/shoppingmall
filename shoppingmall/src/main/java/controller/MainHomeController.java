package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DIYDao;
import dao.ReviewDao;
import vo.Language;
import vo.Review;
import vo.TourArea;


@WebServlet("/MainHomeController")
public class MainHomeController extends HttpServlet {
	private DIYDao dIYDao; //DIY Dao객체 생성
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DIY form
		dIYDao = new DIYDao();
		List<TourArea> tourAreaList = dIYDao.TourAreaList();
		List<Language> languageList =  dIYDao.LanguageList();
		request.setAttribute("tourAreaList", tourAreaList);
		request.setAttribute("languageList", languageList);
		
		//review
		List<Review> reviewList = new ArrayList<Review>();
		ReviewDao reviewDao = new ReviewDao();
		reviewList = reviewDao.selecteReview();
		
		System.out.println("reviewList : "+ reviewList.size());
		
		//뷰
		request.setAttribute("reviewList", reviewList);
		
		//diy fomr End
		System.out.println("메인홈 불러오기");
		request.getRequestDispatcher("/WEB-INF/view/mainHome/mainhome.jsp").forward(request, response);
	}

}; 
