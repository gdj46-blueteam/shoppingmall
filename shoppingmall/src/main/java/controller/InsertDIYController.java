package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DIYDao;
import vo.Language;
import vo.TourArea;
import vo.TourDIY;


@WebServlet("/InsertDIYController")
public class InsertDIYController extends HttpServlet {
	private DIYDao dIYDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dIYDao = new DIYDao();
		
		List<TourArea> tourAreaList = dIYDao.TourAreaList();
		List<Language> languageList =  dIYDao.LanguageList();
		request.setAttribute("tourAreaList", tourAreaList);
		request.setAttribute("languageList", languageList);
		
		request.getRequestDispatcher("/WEB-INF/view/customer/insertDIY.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	TourDIY tourDIY = new TourDIY();		
	tourDIY.setTourAreaNo(Integer.parseInt(request.getParameter("tourArea")));
	tourDIY.setLanguageNo(Integer.parseInt(request.getParameter("language")));
	tourDIY.setTourDIYEtc(request.getParameter("tourDIYEtc"));
	tourDIY.setTourDIYPeople(Integer.parseInt(request.getParameter("tourDIYPeople")));
	tourDIY.setTourDIYStay(request.getParameter("tourDIYStay"));
	tourDIY.setTourDIYTerm(request.getParameter("tourDIYTerm"));
	
	dIYDao = new DIYDao();
	dIYDao.insertTourDIY(tourDIY);
	response.sendRedirect(request.getContextPath()+"/SelectEstimateController");
	}

}
