package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import vo.Employee;

@WebServlet("/DeleteEmpController")
public class DeleteEmpController extends HttpServlet {
	private EmployeeDao employeeDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청값 분석
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
		request.setAttribute("employeeNo", employeeNo);
		
		//디버깅
		System.out.println("DeleteEmpController employeeNo : " + employeeNo);
		
		//뷰로 보냄
		request.getRequestDispatcher("/WEB-INF/view/admin/deleteEmpForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청값 분석
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
		String employeePw = request.getParameter("employeePw");
		
		Employee employee = new Employee();
		employee.setEmployeeNo(employeeNo);
		employee.setEmployeePw(employeePw);
		
		//디버깅
		System.out.println("DeleteEmpController employeeNo : " + employeeNo);
		System.out.println("DeleteEmpController employeePw : " + employeePw);
		
		this.employeeDao = new EmployeeDao();
		int row = employeeDao.deleteEmp(employeeNo, employeePw);
		
		//디버깅
		System.out.println(row +"<- 직원삭제");
		request.setAttribute("employeeNo", employeeNo);
		
		response.sendRedirect(request.getContextPath() + "/SelectEmpListController");
	}
}
