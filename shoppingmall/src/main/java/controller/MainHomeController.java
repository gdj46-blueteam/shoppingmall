package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DIYDao;
import dao.EmployeeDao;
import dao.ReviewDao;
import vo.EmployeeList;
import vo.Language;
import vo.Review;
import vo.TourArea;


@WebServlet("/MainHomeController")
public class MainHomeController extends HttpServlet {
	private DIYDao dIYDao; //DIY Dao객체 생성
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DIY form
		EmployeeDao employeeDao = new EmployeeDao();
		DIYDao diyDao = new DIYDao();
		dIYDao = new DIYDao();
		List<TourArea> tourAreaList = dIYDao.TourAreaList();
		List<Language> languageList =  dIYDao.LanguageList();
		List<EmployeeList> list = employeeDao.selectEmpList();
		List<Map<String, Object>> transportationList = diyDao.transportationList();
		List<Map<String, Object>> tourkindList = diyDao.tourkindList();
		request.setAttribute("tourAreaList", tourAreaList);
		request.setAttribute("languageList", languageList);
		request.setAttribute("list", list);
		request.setAttribute("transportationList", transportationList);
		request.setAttribute("tourkindList", tourkindList);
		
		//review
		List<Review> reviewList = new ArrayList<Review>();
		ReviewDao reviewDao = new ReviewDao();
		reviewList = reviewDao.selecteReview();
		
		System.out.println("reviewList.size : "+ reviewList.size());
		System.out.println(":::::reviewList:::"+ reviewList);
		
		//뷰
		request.setAttribute("reviewList", reviewList);
		
		
		System.out.println("메인홈 불러오기");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/mainhome.jsp");
		dispatcher.forward(request, response);
//		request.getRequestDispatcher("/WEB-INF/view/mainhome.jsp").forward(request, response);
		System.out.println("메인홈 불러오기22222222");

	}

}; 
