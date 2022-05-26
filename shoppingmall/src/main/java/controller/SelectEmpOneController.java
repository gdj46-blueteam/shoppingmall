package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDao;
import vo.EmployeeListOne;

@WebServlet("/SelectEmpOneController")
public class SelectEmpOneController extends HttpServlet {
	private EmployeeDao employeeDao;  //dao변수 생성
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 권한
		HttpSession session = request.getSession();
		int sessionId = 0; 
		int authority = 0;
		
		authority = (Integer)session.getAttribute("sessionAuthority");
		
		if(authority == 2) {
			sessionId = Integer.parseInt((String)session.getAttribute("sessionId"));
		}
		if(authority < 2){
			sessionId = Integer.parseInt(request.getParameter("employeeNo"));
		}
		
		System.out.println("ID : " + sessionId);
		//dao 메소드 호출 객체생성 -> 호출
		// 요청값
		// int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
		
		// 디버깅
		// System.out.println("employeeNo 직원아이디 : " + employeeNo);
		//직원상세정보
		this.employeeDao = new EmployeeDao();
		EmployeeListOne employeeListOne = employeeDao.selectEmpOne(sessionId);
		List<Map<String,Object>> empLanguageList = employeeDao.selectEmplanguage(sessionId);
		
		request.setAttribute("employeeListOne", employeeListOne);
		request.setAttribute("empLanguageList", empLanguageList);
		System.out.println("employeelist.size(SelectEmpOneController) -> " + employeeListOne);
		System.out.println("empLanguageList.size(SelectEmpOneController) -> " + empLanguageList);
		//직원 실적
		Map<String, Object> list =  employeeDao.selectEmpResult(sessionId);
		
		request.setAttribute("list", list);
		
		System.out.println("list.size(SelectEmpOneController) -> " +list.size());
		request.getRequestDispatcher("/WEB-INF/view/employee/selectEmpOneList.jsp").forward(request, response);	
	}
}
