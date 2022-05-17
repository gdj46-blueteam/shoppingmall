package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;


@WebServlet("/SelectEmpMatchingController")
public class SelectEmpMatchingController extends HttpServlet {
	private EmployeeDao employeeDao; //dao 변수생성
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeEmail = request.getParameter("employeeEmail");
		//디버깅
		System.out.println("SelectEmpMatchingController()" + employeeEmail);
		
		//배치확인
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
