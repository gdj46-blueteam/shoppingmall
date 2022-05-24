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

@WebServlet("/DeleteCustomerController")
public class DeleteCustomerController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 권한 가져오기
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		int authority = (int)session.getAttribute("authority");
		String sessionId = (String)session.getAttribute("sessionId");
		
		System.out.println("권한 : " + authority);
		System.out.println("ID : " + sessionId);
		
		if(authority > 1) {
			// 뷰 포워딩(v)
			request.getRequestDispatcher("/WEB-INF/view/admin/staticsByCountry.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/view/public/errorPage.jsp").forward(request, response);
		}
		
		// 요청값 분석(c)
		String customerId = request.getParameter("customerId");
		
		// 디버깅
		System.out.println("DeleteCustomerController custmoerId : " + customerId);
		
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		
		// 뷰로 보낼준비
		request.setAttribute("customer", customer);
		
		// 뷰
		request.getRequestDispatcher("/WEB-INF/view/customer/deleteCustomerForm.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청값 분석(c)
		String customerId = request.getParameter("custmoerId");
		String customerPw = request.getParameter("custmoerPw");
	
		// 디버깅
		System.out.println("DeleteCustomerController custmoerId : " + customerId);
		System.out.println("DeleteCustomerController custmoerPw : " + customerPw);
			
		CustomerDao customerDao = new CustomerDao();
		int row = customerDao.deleteCustomer(customerId, customerPw);
		if (row == 1) { //성공
	        System.out.println("삭제성공");
	     } else {// row==0이면 영향받은 행이 없으므로 오류
	        System.out.println("삭제실패");
	        response.sendRedirect(request.getContextPath()+"/DeleteCustomerController");
	     }
		// 관리자는 회원목록으로 회원은 로그아웃으로
		/*
		if(세션권한) {	// 관리자
			response.sendRedirect(request.getContextPath()+"/SelectCustomerOneController");
		} else {	// 회원
			response.sendRedirect(request.getContextPath()+"/LogoutController");
		}
		*/
	 }
}
