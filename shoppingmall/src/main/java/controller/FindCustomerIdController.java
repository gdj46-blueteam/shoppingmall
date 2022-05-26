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
	private CustomerDao customerDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String customerId = request.getParameter("customerId");
				
		if(customerId ==null) {
			System.out.println("1");
			
		}
		if(customerId !=null) {
			System.out.println("3");

		}
		request.setAttribute("customerId", customerId);
		// 뷰 포워딩(v)
		request.getRequestDispatcher("/WEB-INF/view/public/selectCustomerId.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		customerDao = new CustomerDao();
		System.out.println("2");
		
		String customerEmail=request.getParameter("customerEmail");
		System.out.println(customerEmail + "---customerEmail");
		
		String customerId = customerDao.selectCustomerId(customerEmail);
		System.out.println(customerId+"--customerId");
		
		request.setAttribute("customerId", customerId);
		response.sendRedirect(request.getContextPath()+"/FindCustomerIdController?customerId="+customerId); 
		
	}
}
