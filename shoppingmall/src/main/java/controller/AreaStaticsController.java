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

@WebServlet("/AreaStaticsController")
public class AreaStaticsController extends HttpServlet {
	private StaticsDao staticsDao; //dao변수 생성
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//인코딩
		// 권한 가져오기
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		int authority = (int)session.getAttribute("authority");
		String sessionId = (String)session.getAttribute("sessionId");
		
		System.out.println("권한 : " + authority);
		System.out.println("ID : " + sessionId);
		
		this.staticsDao = new StaticsDao(); //dao 객체생성
		List<Map<String, Object>> list = staticsDao.StaticsByArea();  //dao 메소드 생성
		request.setAttribute("list", list); //요청한 속성값 정하기
		
		if(authority > 2) {
			// 뷰 포워딩(v)
			request.getRequestDispatcher("/WEB-INF/view/admin/staticsByArea.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/view/public/errorPage.jsp").forward(request, response);
		}
	}

}
