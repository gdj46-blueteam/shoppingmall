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
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		int authority = (int)session.getAttribute("authority");
		String sessionId = (String)session.getAttribute("sessionId");			//로그인 세션정보
		
		System.out.println("권한 : " + authority);
		System.out.println("ID : " + sessionId);
		
		
		// 요청값 분석(c)
		String customerId = request.getParameter("customerId");
		System.out.println("SelectAdminOneController customerId : " + customerId);
		
		// 모델값
		Customer customer = new Customer();
		CustomerDao customerDao = new CustomerDao();
		try {
			customer = customerDao.selectCustomerOne(customerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// view로 값 보내기
		request.setAttribute("customer", customer);
		// 뷰 포워딩(c)
		request.getRequestDispatcher("/WEB-INF/view/customer/customerOneList.jsp").forward(request, response);
		
	}
}
