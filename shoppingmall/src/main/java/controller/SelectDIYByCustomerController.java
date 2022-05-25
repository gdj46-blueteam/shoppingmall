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

import dao.DIYDao;

@WebServlet("/SelectDIYByCustomerController")
public class SelectDIYByCustomerController extends HttpServlet {			//고객용  (customerId로 삭제)
	private DIYDao dIYDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.dIYDao = new DIYDao();
		
		// 권한
		HttpSession session = request.getSession();
		int authority = (Integer)session.getAttribute("sessionAuthority");
		String sessionId = (String)session.getAttribute("sessionId");			//로그인 세션정보
		
		System.out.println("권한 : " + authority);
		System.out.println("ID : " + sessionId);
		
		List<Map<String,Object>> list = dIYDao.selectDIY(sessionId);			//<--where 조건 추가
		request.setAttribute("list", list);
		//디버깅
		System.out.println(list +"<-list");
		//요청페이지
		if(authority > 0) {
			request.getRequestDispatcher("/WEB-INF/view/customer/selectDIYList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/view/public/errorPage.jsp").forward(request, response);
		}
		
	}
}
