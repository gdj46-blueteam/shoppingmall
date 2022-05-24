package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AnnouncementDao;
import vo.Announcement;


@WebServlet("/DeleteAnnoController")
public class DeleteAnnoController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 권한 가져오기
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		int authority = (int)session.getAttribute("authority");
		String sessionId = (String)session.getAttribute("sessionId");
		
		System.out.println("권한 : " + authority);
		System.out.println("ID : " + sessionId);
		
		if(authority > 2) {
			// 뷰 포워딩(v)
			request.getRequestDispatcher("/WEB-INF/view/admin/staticsByCountry.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/view/public/errorPage.jsp").forward(request, response);
		}
		
		// 요청값
		int announcementNo = Integer.parseInt(request.getParameter("announcementNo"));	
		// 디버깅
		System.out.println("DeleteAnnoController P" + announcementNo);
		AnnouncementDao ad = new AnnouncementDao();
		int row = 0;
			row = ad.deleteAnno(announcementNo);
			
		if (row == 1) { //성공
	        System.out.println("삭제성공");
	        response.sendRedirect(request.getContextPath()+"/SelectAnnoListController");
	     } else {// row==0이면 영향받은 행이 없으므로 오류
	        System.out.println("삭제실패");
	        response.sendRedirect(request.getContextPath()+"/SelectAnnoOneController");
	     }
	}
}
