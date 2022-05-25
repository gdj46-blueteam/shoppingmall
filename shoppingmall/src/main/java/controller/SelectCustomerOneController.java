package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;
import vo.Customer;

@WebServlet("/SelectCustomerOneController")
public class SelectCustomerOneController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 권한
		HttpSession session = request.getSession();
		String sessionId = ""; 
		int authority = (Integer)session.getAttribute("sessionAuthority");
		
		if(authority == 1) {
			sessionId = (String)session.getAttribute("sessionId");
		} else {
			sessionId = request.getParameter("customerId");
		}
		
		System.out.println("ID : " + sessionId);
		
		// 요청값 분석(c)
		System.out.println("SelectCustomerOneController customerId : " + sessionId);
		
		// 모델값
		Customer customer = new Customer();
		CustomerDao customerDao = new CustomerDao();
		try {
			customer = customerDao.selectCustomerOne(sessionId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// view로 값 보내기
		request.setAttribute("customer", customer);
		// 뷰 포워딩(c)
		if(authority == 1 || authority == 3) {
			request.getRequestDispatcher("/WEB-INF/view/customer/customerOneList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/view/public/errorPage.jsp").forward(request, response);
		}
		
		
	}
}
