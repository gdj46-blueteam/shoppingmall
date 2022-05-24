package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AnnouncementDao;
import vo.Announcement;

@WebServlet("/SelectAnnoListController")
public class SelectAnnoListController extends HttpServlet {
	private AnnouncementDao announcementDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//모델값 
		List<Announcement> announcementList = new ArrayList<Announcement>();
		AnnouncementDao announcementDao = new AnnouncementDao();
		announcementList = announcementDao.SelectAnnouncementList();
		System.out.println("announcementList"+ announcementDao);
		
		//view로 값 보내기  
		request.setAttribute("announcementList", announcementList);
		request.getRequestDispatcher("/WEB-INF/view/public/annoList.jsp").forward(request, response);
	}
}
