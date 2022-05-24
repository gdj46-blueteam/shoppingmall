package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AnnouncementDao;
import vo.*;

@WebServlet("/UpdateAnnoController")
public class UpdateAnnoController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청값 
		int announcementNo = Integer.parseInt(request.getParameter("announcementNo"));
		String announcementTitle = request.getParameter("announcementTitle");
		String announcementContent = request.getParameter("announcementContent");
		
		Announcement announcement = new Announcement();
		announcement.setAnnouncementNo(announcementNo);
		announcement.setAnnouncementContent(announcementContent);
		announcement.setAnnouncementTitle(announcementTitle);
		System.out.println(announcementNo+" get");
		
		//뷰
		request.setAttribute("announcement", announcement);
		request.getRequestDispatcher("/WEB-INF/view/admin/updateAnnoForm.jsp").forward(request, response);
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청값
		System.out.println(request.getParameter("announcementNo"));
		int announcementNo = Integer.parseInt(request.getParameter("announcementNo"));
		System.out.println(announcementNo+"post");
		
		String announcementTitle = request.getParameter("announcementTitle");
		String announcementContent = request.getParameter("announcementContent");
		
		System.out.println(announcementNo);//디버깅
		
		Announcement announcement = new Announcement();
		announcement.setAnnouncementNo(announcementNo);
		announcement.setAnnouncementContent(announcementContent);
		announcement.setAnnouncementTitle(announcementTitle);
		
		AnnouncementDao announcementDao = new AnnouncementDao();
		
		int row = announcementDao.updateAnno(announcement);
		if (row == 1) { //성공
	        System.out.println("수정성공");
	        response.sendRedirect(request.getContextPath()+"/SelectAnnoOneController?announcementNo="+announcement.getAnnouncementNo());
	        return;
	     } else {// row==0이면 오류
	        System.out.println("수정실패");
	        response.sendRedirect(request.getContextPath()+"/UpdateAnnoController"); 
	     }
	}

}
		
		
		

