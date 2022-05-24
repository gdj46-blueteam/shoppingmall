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
		int sessionId = 0; //요청값 받아오기
		// 권한 가져오기
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		sessionId = Integer.parseInt((String)session.getAttribute("sessionId"));
		
		System.out.println("SelectEmpOneController(sessionId) : " + sessionId);
		
		System.out.println("employeeNo(SelectEmpOneController) -> " + sessionId);// 디버깅
		
		//dao 메소드 호출 객체생성 -> 호출
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
