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

@WebServlet("/InsertAnnoController")
public class InsertAnnoController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	// 권한
	HttpSession session = request.getSession();
	int authority = (Integer)session.getAttribute("sessionAuthority");
	String sessionId = (String)session.getAttribute("sessionId");			//로그인 세션정보
	
	System.out.println("권한 : " + authority);
	System.out.println("ID : " + sessionId);
				
	// 뷰 포워딩(v)
	if(authority > 2) {
		request.getRequestDispatcher("/WEB-INF/view/admin/insertAnnoForm.jsp").forward(request, response);
	} else {
		request.getRequestDispatcher("/WEB-INF/view/public/errorPage.jsp").forward(request, response);
	}
	
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	// 1) request 분석(C)

	String announcementTitle = request.getParameter("announcementTitle");
	String announcementContent = request.getParameter("announcementContent");
	
	
	//디버깅
	System.out.println("InsertAnnoController : " + announcementTitle);
	System.out.println("InsertAnnoController : " + announcementContent);
	
	// 메서드 이용하여 모델값 구하기(M)
	Announcement announcement = new Announcement();
	announcement.setAnnouncementTitle(announcementTitle);
	announcement.setAnnouncementContent(announcementContent);
	
	AnnouncementDao announcementDao = new AnnouncementDao();
	int row = announcementDao.insertanno(announcement);
	if (row == 1) { //성공
        System.out.println("입력성공");
        response.sendRedirect(request.getContextPath()+"/SelectAnnoListController");
        return;
     } else {// row==0이면 영향받은 행이 없으므로 오류
        System.out.println("입력실패");
        response.sendRedirect(request.getContextPath()+"/InsertAnnouncementController"); 
	}

	}
}
