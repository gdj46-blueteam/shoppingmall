package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import vo.Admin;

@WebServlet("/SelectAdminOneController")
public class SelectAdminOneController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		int authority = (int)session.getAttribute("authority");
		String sessionId = (String)session.getAttribute("sessionId");			//로그인 세션정보
		
		System.out.println("권한 : " + authority);
		System.out.println("ID : " + sessionId);
		
		
		// 요청값 분석(c)
		String adminId = "";
		if(request.getParameter("adminId") != null) {
			adminId = request.getParameter("adminId");
		}	
		
		// 디버깅
		adminId = "admin";
		System.out.println("SelectAdminOneController adminId : " + adminId);
		// 모델값(m)
		Admin admin = new Admin();
		AdminDao adminDao = new AdminDao();
		try {
			admin = adminDao.selectAdminOne(adminId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 뷰로 보낼준비
		request.setAttribute("admin", admin);
		// 뷰 포워딩(c)
		request.getRequestDispatcher("/WEB-INF/view/admin/selectAdminOne.jsp").forward(request, response);
		
	}

}
