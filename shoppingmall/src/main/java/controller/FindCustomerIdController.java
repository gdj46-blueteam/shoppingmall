package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import vo.Customer;

@WebServlet("/FindCustomerIdController")
public class FindCustomerIdController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) request 분석(C)
		String customerEmail = request.getParameter("customerEmail");
				
		// 디버깅
		System.out.println("SelectCustomerIdController : " + customerEmail);
				
		// 2) 메서드 이용하여 모델값 구하기(M)
		CustomerDao customerDao = new CustomerDao();
		String customerId = customerDao.selectCustomerId(customerEmail);
				
		// 디버깅
		System.out.println("SelectCustomerIdController : " + customerId);
		
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		
		// 3)
		request.setAttribute("customer", customer);
		
		// 뷰 포워딩(v)
		request.getRequestDispatcher("/WEB-INF/view/public/findCustomerId.jsp").forward(request, response);
	}
}
