package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TourDao;
import vo.Tour;
import vo.TourArea;
import vo.TourImage;

@WebServlet("/UpdateTourController")
public class UpdateTourController extends HttpServlet {
	private TourDao tourDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.tourDao = new TourDao();
		
		// 권한
		HttpSession session = request.getSession();
		int authority = (int)session.getAttribute("authority");
		String sessionId = (String)session.getAttribute("sessionId");			//로그인 세션정보
		
		System.out.println("권한 : " + authority);
		System.out.println("ID : " + sessionId);
		
		

		int tourNo = Integer.parseInt(request.getParameter("tourNo"));
		
		System.out.println(tourNo + "<-전updateTourController");


		Tour tour = tourDao.selectTourOne(tourNo);
		TourImage tourImage = tourDao.selectTourImageOne(tour);
		TourArea tourArea = tourDao.selectTourAreaOne(tour);
		
		request.setAttribute("tour", tour);
		request.setAttribute("tourImage", tourImage);
		request.setAttribute("tourArea", tourArea);
		
		System.out.println(tour + "<-updatetour");
		System.out.println(tourImage + "<-updatetourImage");
		System.out.println(tourArea + "<-updatetourArea");
		
		if(authority > 2) {
			request.getRequestDispatcher("/WEB-INF/view/admin/updateTourForm.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/view/public/errorPage.jsp").forward(request, response);
		}
		
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tourNo = Integer.parseInt(request.getParameter("tourNo"));
		System.out.println(tourNo + "<-후updateTourController");
		
		String tourName = request.getParameter("tourName");
		System.out.println(tourName +"<-tourName후updateTourController");
		
		String tourDescription = request.getParameter("tourDescription");
		System.out.println(tourDescription + "<-tourDescription후updateTourController");
		
		Tour tour = new Tour();
		tour.setTourNo(tourNo);
		tour.setTourName(tourName);
		tour.setTourDescription(tourDescription);
		
		//디버깅
		System.out.println(tourNo + "<-tourNo후updateTourController");
		System.out.println(tourName + "<-tourName후updateTourController");
		System.out.println(tourDescription + "<-tourDescription후updateTourController");
		
		this.tourDao=new TourDao();
		int row = tourDao.updateTour(tour);
		System.out.println(row + "<-row후updateTourController");
		request.setAttribute("tourNo", tourNo);
		response.sendRedirect(request.getContextPath()+"/SelectTourController?tourNo="+ request.getParameter("tourNo"));
	}
}
