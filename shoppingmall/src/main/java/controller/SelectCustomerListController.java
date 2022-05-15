package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import vo.Customer;



@WebServlet("/SelectCustomerListController")
public class SelectCustomerListController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 모델값 (m)
	List<Customer> customer = new ArrayList<Customer>();
	CustomerDao customerDao = new CustomerDao();
	customer = customerDao.selectCustomerList();
	
	// 뷰로 보낼준비
	request.setAttribute("customer", customer);
	// 뷰 포워딩(v)
	request.getRequestDispatcher("/WEB-INF/view/admin/selectCustomerList.jsp").forward(request, response);
	}

}
