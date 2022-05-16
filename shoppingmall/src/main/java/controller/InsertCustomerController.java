package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import vo.Customer;

@WebServlet("/InsertCustomerController")
public class InsertCustomerController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 뷰 포워딩(v)
		request.getRequestDispatcher("/WEB-INF/view/public/insertCustomer.jsp").forward(request, response);
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
		System.out.println("InsertCustomerController : " + customerId);
		System.out.println("InsertCustomerController : " + customerPw);
		System.out.println("InsertCustomerController : " + customerName);
		System.out.println("InsertCustomerController : " + customerGender);
		System.out.println("InsertCustomerController : " + customerAge);
		System.out.println("InsertCustomerController : " + customerPhone);
		System.out.println("InsertCustomerController : " + customerCountry);
		System.out.println("InsertCustomerController : " + customerEmail);
		
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
		int row = customerDao.insertCustomer(customer);
		if (row == 1) { //성공
	        System.out.println("입력성공");
	        response.sendRedirect(request.getContextPath()+"/LoginController");
	        return;
	     } else {// row==0이면 영향받은 행이 없으므로 오류
	        System.out.println("입력실패");
	        response.sendRedirect(request.getContextPath()+"/InsertCustomerController"); 
	     }
	}
}
