package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuestionDao;
import dao.TourDao;
import vo.Tour;
import vo.TourArea;
import vo.TourImage;


@WebServlet("/DeleteTourController")
public class DeleteTourController extends HttpServlet {
private TourDao tourDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.tourDao = new TourDao();
		int tourNo=Integer.parseInt(request.getParameter("tourNo"));

		System.out.println(tourNo+" <-- DeleteController");
		
		Tour tour = tourDao.selectTourOne(tourNo);
		TourImage tourImage = tourDao.selectTourImageOne(tour);
		TourArea tourArea = tourDao.selectTourAreaOne(tour);
		
		request.setAttribute("tour", tour);
		request.setAttribute("tourImage", tourImage);
		request.setAttribute("tourArea", tourArea);
		request.getRequestDispatcher("/WEB-INF/view/admin/deleteTourForm.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tourNo=Integer.parseInt(request.getParameter("tourNo"));
		System.out.println(tourNo+"<-- deleteTourController");
		this.tourDao=new TourDao();
		tourDao.deleteTour(tourNo);

		response.sendRedirect(request.getContextPath()+"/SelectTourController"); 
	}

}
