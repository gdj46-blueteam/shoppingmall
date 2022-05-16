package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AnnouncementDao;
import vo.Announcement;

@WebServlet("/SelectAnnoListController")
public class SelectAnnoListController extends HttpServlet {
	private AnnouncementDao announcementDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//dao 값
		List<Announcement> announcement = new ArrayList<Announcement>();
		AnnouncementDao announcementDao = new AnnouncementDao();
		announcement = announcementDao.SelectAnnouncementList();
			//System.out.println(((Announcement) announcement).getAnnouncementNo());
			//view 요청 (v)
			request.setAttribute("announcement", announcement);
			request.getRequestDispatcher("/WEB-INF/view/public/annoList.jsp").forward(request, response);
	}
}




	