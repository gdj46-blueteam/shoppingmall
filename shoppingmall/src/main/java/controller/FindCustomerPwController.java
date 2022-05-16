package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import vo.Customer;

@WebServlet("/FindCustomerPwController")
public class FindCustomerPwController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) request 분석(C)
		String customerId = request.getParameter("customerId");
						
		// 디버깅
		System.out.println("SelectCustomerPwController : " + customerId);
						
		// 2) 메서드 이용하여 모델값 구하기(M)
		CustomerDao customerDao = new CustomerDao();
		String customerPw = customerDao.selectCustomerPw(customerId);
						
		// 디버깅
		System.out.println("SelectCustomerPwController : " + customerPw);
				
		Customer customer = new Customer();
		customer.setCustomerPw(customerPw);
				
		// 3)
		request.setAttribute("customer", customer);
				
		// 뷰 포워딩(v)
		request.getRequestDispatcher("/WEB-INF/view/public/findCustomerPw.jsp").forward(request, response);		
	}

}
