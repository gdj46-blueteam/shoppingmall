package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDao;
import vo.*;
import java.util.*;
//직원 목록 출력
@WebServlet("/SelectEmpListController")
public class SelectEmpListController extends HttpServlet {
	private EmployeeDao employeeDao; //dao변수 생성
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		int authority = (int)session.getAttribute("authority");
		String sessionId = (String)session.getAttribute("sessionId");			//로그인 세션정보
		
		System.out.println("권한 : " + authority);
		System.out.println("ID : " + sessionId);
		
		//dao 메소드 호출 객체생성 -> 호출
		this.employeeDao = new EmployeeDao();
		List<EmployeeList> list = employeeDao.selectEmpList();
		
		request.setAttribute("list", list);
		
		System.out.println("list.size(SelectEmpListController) -> " + list.size());
		request.getRequestDispatcher("/WEB-INF/view/public/empPage.jsp").forward(request, response);	
	}

}
