package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TourDao;
import vo.Tour;
import vo.TourImage;

@WebServlet("/SelectTourController")
public class SelectTourController extends HttpServlet {
	private TourDao tourDao;
    public SelectTourController() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		this.tourDao = new TourDao();
		List<Map<String,Object>> tourList = tourDao.selectTourList();
		TourImage tourImage = new TourImage();

		System.out.println(tourList.indexOf(0)+"tourDao후 확인");
		request.setAttribute("tourList", tourList);
		request.getRequestDispatcher("/WEB-INF/view/public/tourList.jsp").forward(request, response); 
	}
}
