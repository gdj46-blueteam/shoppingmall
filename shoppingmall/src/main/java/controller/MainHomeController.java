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
		
		//diy fomr End
		System.out.println("메인홈 불러오기");
		request.getRequestDispatcher("/WEB-INF/view/mainHome/mainhome.jsp").forward(request, response);
	}

}; 
