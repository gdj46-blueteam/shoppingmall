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
		// 권한 가져오기
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		int sessionId = Integer.parseInt((String)session.getAttribute("sessionId"));
				
		System.out.println("SelectEmpOneController(sessionId) : " + sessionId);
				
		System.out.println("employeeNo(SelectEmpOneController) -> " + sessionId);// 디버깅
		System.out.println("employeeNo(SelectEmpMatchingController) -> " + sessionId); // 디버깅
		
		//배치확인 DAO 호출
		this.employeeDao = new EmployeeDao();
		Map<String, Object> list =  employeeDao.selectMatching(sessionId);
		request.setAttribute("list", list);
		System.out.println("list.size(SelectEmpMatchingController) -> " + list.size());// 디버깅
		
		EmployeeListOne employeeListOne = employeeDao.selectEmpOne(sessionId);
		request.setAttribute("employeeListOne", employeeListOne);
		System.out.println("employeelist.size(SelectEmpOneController) -> " + employeeListOne);
		request.getRequestDispatcher("/WEB-INF/view/employee/selectMatching.jsp").forward(request, response);	
	}

	

}
