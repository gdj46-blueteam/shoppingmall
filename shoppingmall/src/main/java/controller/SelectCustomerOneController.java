package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import vo.Customer;

@WebServlet("/SelectCustomerOneController")
public class SelectCustomerOneController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
