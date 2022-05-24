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
import dao.EstimateDao;

@WebServlet("/SelectDIYByAdminController")							//관리자가 볼 DIY견적서 
public class SelectDIYByAdminController extends HttpServlet {
	private DIYDao dIYDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.dIYDao = new DIYDao();
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		int authority = (int)session.getAttribute("authority");
		String sessionId = (String)session.getAttribute("sessionId");			//로그인 세션정보
		
		System.out.println("권한 : " + authority);
		System.out.println("ID : " + sessionId);
		
		
		List<Map<String,Object>> list = dIYDao.selectDIYListExcept();		//견적서가 완료된 DIY를 제외한 DIY리스트 출력
		request.setAttribute("list", list);
		//디버깅
		System.out.println(list +"<-SelectDIYByAdminController(selectDIYListExcept)");
		//요청페이지
	request.getRequestDispatcher("/WEB-INF/view/admin/selectDIY.jsp").forward(request, response);
	}

}
