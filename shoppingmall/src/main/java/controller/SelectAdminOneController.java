package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import vo.Admin;

@WebServlet("/SelectAdminOneController")
public class SelectAdminOneController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
