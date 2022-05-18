package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDao;
import vo.Employee;

@WebServlet("/InsertEmpContoller")
public class InsertEmpContoller extends HttpServlet {
	private EmployeeDao employeeDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/admin/insertEmpForm.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee = new Employee();
		// insertEmpForm.jsp 에서 받은 정보 받아오기
		employee.setEmployeePw(request.getParameter("employeePw"));
		employee.setEmployeeSn(request.getParameter("employeeSn"));
		employee.setEmpAddressId(Integer.parseInt(request.getParameter("empAddressId"))); //int 형변환
		employee.setEmployeeAddressDetail(request.getParameter("employeeAddressDetail"));
		employee.setEmployeeName(request.getParameter("employeeName"));
		employee.setEmployeeEmail(request.getParameter("employeeEmail"));
		employee.setEmployeePhone(request.getParameter("employeePhone"));
		employee.setEmployeeGender(request.getParameter("employeeGender"));
		employee.setEmployeeImageName(request.getParameter("employeeImageName"));
		employee.setEmployeeIntroduce(request.getParameter("employeeIntroduce"));
		
		//Dao 객체 생성해서 insetEmp 메서드 호출해서 실행
		this.employeeDao = new EmployeeDao();
		int row = employeeDao.insertEmp(employee);
		//디버깅
		System.out.println(row +"<- 직원등록");
		response.sendRedirect(request.getContextPath()+"/SelectEmpListController");
	}
}
