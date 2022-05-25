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

import dao.*;

@WebServlet("/StaticsListController")
public class SelectStaticsController extends HttpServlet {
	private StaticsDao staticsDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.staticsDao = new StaticsDao();
		
		// 권한
		HttpSession session = request.getSession();
		int authority = (int)session.getAttribute("authority");
		String sessionId = (String)session.getAttribute("sessionId");			//로그인 세션정보
		
		System.out.println("권한 : " + authority);
		System.out.println("ID : " + sessionId);
		
		List<Map<String, Object>> list = staticsDao.StaticsByAll();
		request.setAttribute("list", list);
		if(authority > 2) {
			request.getRequestDispatcher("/WEB-INF/view/admin/staticsList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/view/public/errorPage.jsp").forward(request, response);
		}
		
	}
}
