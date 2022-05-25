package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDao;
import vo.Language;

@WebServlet("/SearchAddressController")
public class SearchAddressController extends HttpServlet {
	private EmployeeDao employeeDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		this.employeeDao = new EmployeeDao();
	
		// 권한
		HttpSession session = request.getSession();
		int authority = (Integer)session.getAttribute("sessionAuthority");
		String sessionId = (String)session.getAttribute("sessionId");			//로그인 세션정보
		
		System.out.println("권한 : " + authority);
		System.out.println("ID : " + sessionId);
		
		String searchAddr = request.getParameter("searchAddr");
		List<Map<String, Object>> address = this.employeeDao.selectAddressList(searchAddr);
		
		System.out.println("SearchAddressController : " + address.size());
		
		request.setAttribute("searchList", address);
		
		this.employeeDao = new EmployeeDao();
		List<Language> language = new ArrayList<>();
		language = employeeDao.selectlanguage();
		
		System.out.println("selectlanguage(InsertEmpContoller-doGet)" + language.size());
		request.setAttribute("language", language);
		
		request.getRequestDispatcher("/WEB-INF/view/admin/insertEmpForm.jsp").forward(request, response);
		
	}

}
