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

import dao.StaticsDao;


@WebServlet("/MonthStaticsController")
public class MonthStaticsController extends HttpServlet {
	private StaticsDao staticsDao; //dao변수 생성
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 권한
		HttpSession session = request.getSession();
		int authority = (Integer)session.getAttribute("sessionAuthority");
		String sessionId = (String)session.getAttribute("sessionId");			//로그인 세션정보
		
		System.out.println("권한 : " + authority);
		System.out.println("ID : " + sessionId);
		
		this.staticsDao = new StaticsDao(); //dao 객체생성
		List<Map<String, Object>> list = staticsDao.StaticsByMonth();  //dao 메소드 생성
		request.setAttribute("list", list); //요청한 속성값 정하기
		
		if(authority > 2) {
			request.getRequestDispatcher("/WEB-INF/view/admin/staticsByMonth.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/view/public/errorPage.jsp").forward(request, response);
		}
		
	}

}
