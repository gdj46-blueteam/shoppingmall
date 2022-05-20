package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TourDao;
import vo.Tour;
import vo.TourArea;

@WebServlet("/UpdateTourController")
public class UpdateTourController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TourDao tourDao = new TourDao();
		int tourNo = Integer.parseInt(request.getParameter("tourNo"));
		String tourName = request.getParameter("tourName");
		String tourDescription = request.getParameter("tourDescription");
		String province = request.getParameter("province");
		String tourCity = request.getParameter("tourCity");
		
		System.out.println(tourNo + "<-전updateTourController");
		System.out.println(tourName + "<-전updateTourController");
		System.out.println(tourDescription + "<-전updateTourController");
		System.out.println(province + "<-전updateTourController");
		System.out.println(tourCity + "<-전updateTourController");

		Tour tour = tourDao.selectTourOne(tourNo);
	//	TourImage tourImage = tourDao.selectTourImageOne(tour);
		TourArea tourArea = tourDao.selectTourAreaOne(tour);
		
		request.setAttribute("tour", tour);
	//	request.setAttribute("tourImage", tourImage);
		request.setAttribute("tourArea", tourArea);
		
		System.out.println(tour + "<-updatetour");
	//	System.out.println(tourImage + "<-updatetourImage");
		System.out.println(tourArea + "<-updatetourArea");
		
		request.getRequestDispatcher("/WEB-INF/view/admin/updateTourForm.jsp").forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int tourNo = Integer.parseInt(request.getParameter("tourNo"));
	String tourName = request.getParameter("tourName");
	String tourDescription = request.getParameter("tourDescription");
	String province = request.getParameter("province");
	String tourCity = request.getParameter("tourCity");
	//이미지
	System.out.println(tourNo + "<-후updateTourController");
	TourDao tourDao=new TourDao();
	tourDao.updateTour(null);//???????
	response.sendRedirect(request.getContextPath()+"/UpdateTourController");
	}
}
