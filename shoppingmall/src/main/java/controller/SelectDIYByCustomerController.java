package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DIYDao;

@WebServlet("/SelectDIYByCustomerController")
public class SelectDIYByCustomerController extends HttpServlet {			//고객용  (customerId로 삭제)
	private DIYDao dIYDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.dIYDao = new DIYDao();
		List<Map<String,Object>> list = dIYDao.selectDIY();			//<--where 조건 추가
		request.setAttribute("list", list);
		//디버깅
		System.out.println(list +"<-list");
		//요청페이지
	request.getRequestDispatcher("/WEB-INF/view/customer/selectDIYList.jsp").forward(request, response);
	}
}
