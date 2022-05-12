package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;
import dao.LoginDao;
import vo.Customer;

@WebServlet("/Logincontroller")
public class LoginController extends HttpServlet {
	private LoginDao loginDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession();
	String sessionId = (String)session.getAttribute("sessionId");
	
	if(sessionId != null) {
		response.sendRedirect(request.getContextPath()+"/MainHomeController");
		return;
	}
	request.getRequestDispatcher("/WEB-INF/view/public/login.jsp").forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String returnId = loginDao.selectLogin(id, pw);
		if(returnId == null) {
			response.sendRedirect(request.getContextPath()+"/LoginController");
			return;
		}
		HttpSession session = request.getSession();
		session.setAttribute("sessionId", returnId);
		response.sendRedirect(request.getContextPath()+"/MainHomeController");
		
	}
	
}
