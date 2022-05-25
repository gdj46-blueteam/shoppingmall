package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;
import vo.*;

@WebServlet("/UpdateCustomerController")
public class UpdateCustomerController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 권한
		HttpSession session = request.getSession();
		int authority = (int)session.getAttribute("authority");
		String sessionId = (String)session.getAttribute("sessionId");			//로그인 세션정보
		
		System.out.println("권한 : " + authority);
		System.out.println("ID : " + sessionId);
		
		// 요청값 분석(c)
		String customerId = request.getParameter("customerId");
		String customerName = request.getParameter("customerName");
		String customerGender = request.getParameter("customerGender");
		int customerAge = Integer.parseInt(request.getParameter("customerAge"));
		String customerPhone = request.getParameter("customerPhone");
		String customerCountry = request.getParameter("customerCountry");
		String customerEmail = request.getParameter("customerEmail");
				
		// 디버깅
		System.out.println("UpdatecustomerController : " + customerId);
		System.out.println("UpdatecustomerController : " + customerName);
		System.out.println("UpdatecustomerController : " + customerGender);
		System.out.println("UpdatecustomerController : " + customerAge);
		System.out.println("UpdatecustomerController : " + customerPhone);
		System.out.println("UpdatecustomerController : " + customerCountry);
		System.out.println("UpdatecustomerController : " + customerEmail);
		
		// 메서드 이용하여 모델값 구하기(M)
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		customer.setCustomerName(customerName);
		customer.setCustomerGender(customerGender);
		customer.setCustomerAge(customerAge);
		customer.setCustomerPhone(customerPhone);
		customer.setCustomerCountry(customerCountry);
		customer.setCustomerEmail(customerEmail);

		// 뷰로 보낼준비
		request.setAttribute("customer", customer);
		
		// 뷰 포워딩(c)
		
		if(authority == 1 || authority == 3) {
			request.getRequestDispatcher("/WEB-INF/view/customer/updateCustomerForm.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/view/public/errorPage.jsp").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) request 분석(C)
		String customerId = request.getParameter("customerId");
		String customerPw = request.getParameter("customerPw");
		String customerName = request.getParameter("customerName");
		String customerGender = request.getParameter("customerGender");
		int customerAge = Integer.parseInt(request.getParameter("customerAge"));
		String customerPhone = request.getParameter("customerPhone");
		String customerCountry = request.getParameter("customerCountry");
		String customerEmail = request.getParameter("customerEmail");
		
		// 디버깅
		System.out.println("UpdatecustomerController : " + customerId);
		System.out.println("UpdatecustomerController : " + customerPw);
		System.out.println("UpdatecustomerController : " + customerName);
		System.out.println("UpdatecustomerController : " + customerGender);
		System.out.println("UpdatecustomerController : " + customerAge);
		System.out.println("UpdatecustomerController : " + customerPhone);
		System.out.println("UpdatecustomerController : " + customerCountry);
		System.out.println("UpdatecustomerController : " + customerEmail);
		
		// 메서드 이용하여 모델값 구하기(M)
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		customer.setCustomerPw(customerPw);
		customer.setCustomerName(customerName);
		customer.setCustomerGender(customerGender);
		customer.setCustomerAge(customerAge);
		customer.setCustomerPhone(customerPhone);
		customer.setCustomerCountry(customerCountry);
		customer.setCustomerEmail(customerEmail);
		
		CustomerDao customerDao = new CustomerDao();
		int row = customerDao.updateCustomer(customer);
        System.out.println("수정전후");
		if (row == 1) { //성공
	        System.out.println("수정성공");
	        response.sendRedirect(request.getContextPath()+"/SelectCustomerOneController?customerId="+customer.getCustomerId());
	        return;
	     } else {// row==0이면 영향받은 행이 없으므로 오류
	        System.out.println("수정실패");
	        response.sendRedirect(request.getContextPath()+"/UpdateCustomerController"); 
	     }
	}

}
