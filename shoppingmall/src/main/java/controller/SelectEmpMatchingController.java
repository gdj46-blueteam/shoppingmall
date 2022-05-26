package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDao;
import vo.EmployeeListOne;


@WebServlet("/SelectEmpMatchingController")
public class SelectEmpMatchingController extends HttpServlet {
	private EmployeeDao employeeDao; //dao 변수생성
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int sessionId = 0; 
		int authority = (Integer)session.getAttribute("sessionAuthority");
		
		if(authority == 2) {
			sessionId = Integer.parseInt((String)session.getAttribute("sessionId"));
		} else {
			sessionId = Integer.parseInt(request.getParameter("employeeNo"));
		}
		
		System.out.println("권한 : " + authority);
		System.out.println("ID : " + sessionId);
		
		//배치확인 DAO 호출
		this.employeeDao = new EmployeeDao();
		Map<String, Object> list =  employeeDao.selectMatching(sessionId);
		request.setAttribute("list", list);
		System.out.println("list.size(SelectEmpMatchingController) -> " + list.size());// 디버깅
		
		EmployeeListOne employeeListOne = employeeDao.selectEmpOne(sessionId);
		request.setAttribute("employeeListOne", employeeListOne);
		System.out.println("employeelist.size(SelectEmpOneController) -> " + employeeListOne);
		
		if(authority > 1) {
			request.getRequestDispatcher("/WEB-INF/view/employee/selectMatching.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/view/employee/errorPage.jsp").forward(request, response);
		}
			
	}

	

}
