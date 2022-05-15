package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AnnouncementDao;
import vo.Announcement;

@WebServlet("/SelectAnnoOneController")
public class SelectAnnoOneController extends HttpServlet {
	private AnnouncementDao announcementDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int announcement_no = Integer.parseInt(request.getParameter("announcement_no"));
		AnnouncementDao ad = new AnnouncementDao();
		Announcement an = ad.SelectAnnouncementOne(announcement_no);
		
		
		request.setAttribute("an", an );
		request.getRequestDispatcher("/WEB-INF/view/public/annoOneList.jsp").forward(request, response);

	}
}
