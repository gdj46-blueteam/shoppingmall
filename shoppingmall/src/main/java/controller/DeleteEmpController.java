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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청값 분석
		String employeeNo = request.getParameter("employeeNo");
		
		//디버깅
		System.out.println("DeleteEmpController employeeNo : " + employeeNo);
		
		Employee employee = new Employee();
		employee.setEmployeeNo(Integer.parseInt(employeeNo));
		
		//뷰로 보낼 준비
		request.setAttribute("employee", employee);
		
		//뷰로 보냄
		request.getRequestDispatcher("/WEB-INF/view/employee/deleteEmpForm.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청값 분석
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
		String employeePw = request.getParameter("employeePw");
		
		//디버깅
		System.out.println("DeleteEmpController employeeNo : " + employeeNo);
		System.out.println("DeleteEmpController employeePw : " + employeePw);
		
		EmployeeDao employeeDao = new EmployeeDao();
		int row = employeeDao.deleteEmp(employeeNo, employeePw);
		
		//디버깅
		if(row == 1) {
			System.out.println("삭제성공");
		} else {
			System.out.println("삭제실패");
			response.sendRedirect(request.getContextPath() + "/DeleteEmpController");
		}
	}

}
