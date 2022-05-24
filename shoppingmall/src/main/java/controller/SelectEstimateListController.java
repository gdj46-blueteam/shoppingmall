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

import dao.EstimateDao;
import vo.Estimate;

/**
 * Servlet implementation class SelectEstimateListController
 */
@WebServlet("/SelectEstimateListController")
public class SelectEstimateListController extends HttpServlet {			//고객 estimate list 조회
	private EstimateDao estimate;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		estimate = new EstimateDao();
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		int authority = (int)session.getAttribute("authority");
		String sessionId = (String)session.getAttribute("sessionId");
		
		System.out.println("권한 : " + authority);
		System.out.println("ID : " + sessionId);

		List<Map<String,Object>> list = estimate.selectEstimateByCustomerList(sessionId);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/view/customer/selectEstimateList.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
