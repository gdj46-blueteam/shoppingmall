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
import vo.EmployeeListOne;

@WebServlet("/SelectEmpOneController")
public class SelectEmpOneController extends HttpServlet {
	private EmployeeDao employeeDao;  //dao변수 생성
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo")); //요청값 받아오기
		//int employeeNo1 = (int)request.getAttribute("employeeNo");
		// 디버깅
		System.out.println("employeeNo(SelectEmpOneController) -> " + employeeNo);
		
		//dao 메소드 호출 객체생성 -> 호출
		//직원상세정보
		this.employeeDao = new EmployeeDao();
		EmployeeListOne employeeListOne = employeeDao.selectEmpOne(employeeNo);
		request.setAttribute("employeeListOne", employeeListOne);
		
		//직원 실적
		Map<String, Object> list =  employeeDao.selectEmpResult(employeeNo);
		request.setAttribute("list", list);
		
		System.out.println("employeelist.size(SelectEmpOneController) -> " + employeeListOne);
		System.out.println("list.size(SelectEmpOneController) -> " +list.size());
		request.getRequestDispatcher("/WEB-INF/view/employee/selectEmpOneList.jsp").forward(request, response);	
	}

}
