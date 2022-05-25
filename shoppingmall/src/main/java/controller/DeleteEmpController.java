package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;

@WebServlet("/DeleteEmpController")
public class DeleteEmpController extends HttpServlet {			//(관리자) 직원 삭제 컨트롤러
	private EmployeeDao empDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employeeNo= Integer.parseInt(request.getParameter("employeeNo"));
		empDao = new EmployeeDao();
		int row = empDao.deleteEmployeeDao(employeeNo);		//직원 삭제 메서드 호출 후 실행된 쿼리 수 반환
		
		if(row==1) {					//삭제 성공
			response.sendRedirect(request.getContextPath()+"/");
		}else {							//삭제 실패
			response.sendRedirect("");
		}
		
	}

}
