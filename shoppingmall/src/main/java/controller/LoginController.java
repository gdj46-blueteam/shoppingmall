
package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;
import dao.LoginDao;
import vo.Customer;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private LoginDao loginDao; //
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	//사용자 로그인에 따라서 컨트롤러 접근허가 또는 불허
	HttpSession session = request.getSession(); //세션 생성 
	String sessionId = (String)session.getAttribute("sessionId");
	System.out.println(sessionId);//디버깅
	if(sessionId!= null) { 														//sessionId 가 널값이 아니라면
		response.sendRedirect(request.getContextPath()+"/MainHomeController");   //MainHomeController로 이동
		return; 
	}
	//
	request.getRequestDispatcher("/WEB-INF/view/public/login.jsp").forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String id = request.getParameter("id");					//id,pw 파라미터 값 요청 후 id, pw 변수에 저장
		String pw = request.getParameter("pw");
		//객체생성
		Customer customer = new Customer();
		customer.setCustomerId(id);
		customer.setCustomerPw(pw);
		
		System.out.println(id+", "+pw +"Logincontroller");	//id,pw 디버깅
		
		this.loginDao = new LoginDao();
		HashMap<String, Object> returnInfo = null;
		try {
			returnInfo = loginDao.selectLogin(id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(returnInfo + "login후");
		
		if(returnInfo == null) {
			response.sendRedirect(request.getContextPath()+"/LoginController");
			return;
		}
		HttpSession session = request.getSession();
		session.setAttribute("sessionId", returnInfo.get("loginId"));
		session.setAttribute("sessionAuthority", returnInfo.get("authority"));
		
		System.out.println("Login session 저장확인 : " + returnInfo);
		
		response.sendRedirect(request.getContextPath()+"/MainHomeController");		
	}
	
}
