package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;

@WebServlet("/SelectCustomerIdController")
public class SelectCustomerIdController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 뷰 포워딩(v)
		request.getRequestDispatcher("/WEB-INF/view/public/selectCustomerId.jsp").forward(request, response);
	}

}
