package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import vo.Employee;


@WebServlet("/UpdateEmpController")
public class UpdateEmpController extends HttpServlet {
	//객체 생성
	private EmployeeDao employeeDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//jsp 요청
		request.getRequestDispatcher("/WEB-INF/view/employee/updateEmpForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//값가져오기
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
		String employeePw = request.getParameter("employeePw");
		String employeeEmail = request.getParameter("employeeEmail");
		String employeePhone = request.getParameter("employeePhone");
		String employeeIntroduce = request.getParameter("employeeIntroduce");
		
		Employee employee = new Employee(); //Employee 객체생성 -> 가져온 값 저장?
		/*employee.setEmployeeNo(employeeNo);
		employee.setEmployeePw(employeePw);
		employee.setEmployeeEmail(employeeEmail);
		employee.setEmployeePhone(employeePhone);
		employee.setEmployeeIntroduce(employeeIntroduce);*/
		//디버깅
		System.out.println("employeeNo(UpdateEmpController)-> " + employeeNo );
		System.out.println("employeePw(UpdateEmpController)-> " + employeePw );
		System.out.println("employeeEmail(UpdateEmpController)-> " + employeeEmail );
		System.out.println("employeePhone(UpdateEmpController)-> " + employeePhone );
		System.out.println("employeeIntroduce(UpdateEmpController)-> " + employeeIntroduce );
		
		//dao호출
		this.employeeDao = new EmployeeDao();
		int row = employeeDao.updateEmp(employee);
		//디버깅
		System.out.println(row +"<- 직원수정");
		//속성값 가져와서 저장?
		//request.setAttribute("employeeNo", employeeNo);
		
		response.sendRedirect(request.getContextPath()+"/SelectEmpOneController");
	}

}
