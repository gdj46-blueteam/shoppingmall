package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;
import vo.Customer;

@WebServlet("/SelectCustomerListController")
public class SelectCustomerListController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		int authority = (int)session.getAttribute("authority");
		String sessionId = (String)session.getAttribute("sessionId");			//로그인 세션정보
		
		System.out.println("권한 : " + authority);
		System.out.println("ID : " + sessionId);		
		
		
		//모델값
		List<Customer> customer = new ArrayList<Customer>();
		CustomerDao customerDao = new CustomerDao();
		customer = customerDao.selectCustomerList();
		
		// view로 값 보내기
		request.setAttribute("customer", customer);
		request.getRequestDispatcher("/WEB-INF/view/admin/selectCustomerList.jsp").forward(request, response);
	}

}
