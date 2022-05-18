package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;

/**
 * Servlet implementation class SearchAddressController
 */
@WebServlet("/SearchAddressController")
public class SearchAddressController extends HttpServlet {
	private EmployeeDao employeeDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String searchAddr = request.getParameter("searchAddr");
		
	this.employeeDao = new EmployeeDao();
	List<Map<String, Object>> list = this.employeeDao.selectAddressList(searchAddr);
	
	System.out.println("SearchAddressController : " + list.size());
	
	request.setAttribute("searchList", list);
	request.getRequestDispatcher("/WEB-INF/view/employee/insertEmpForm.jsp").forward(request, response);
		
	}

}
