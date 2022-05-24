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
	//모델값
	List<Customer> customer = new ArrayList<Customer>();
	CustomerDao customerDao = new CustomerDao();
	customer = customerDao.selectCustomerList();
	
	// view로 값 보내기
	request.setAttribute("customer", customer);
	request.getRequestDispatcher("/WEB-INF/view/admin/selectCustomerList.jsp").forward(request, response);
	}

}
