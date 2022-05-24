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
import dao.EmployeeDao;
import dao.EstimateDao;
import vo.Estimate;


@WebServlet("/InsertEstimateController")
public class InsertEstimateController extends HttpServlet {
	private DIYDao dIYDao;
	private EstimateDao estDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.dIYDao = new DIYDao();
		this.estDao = new EstimateDao();
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		int authority = (int)session.getAttribute("authority");
		String sessionId = (String)session.getAttribute("sessionId");			//로그인 세션정보
		
		System.out.println("권한 : " + authority);
		System.out.println("ID : " + sessionId);
		
		
		int tourDIYNo = Integer.parseInt(request.getParameter("tourDIYNo"));
		//System.out.println(tourDIYNo +"   InsertEstimateController");
		Map<String,Object> tourDIYMap = dIYDao.selectDIYOne(tourDIYNo);
		List<Map<String,Object>> empLanguageList = estDao.insertEstimate(tourDIYMap);
		
		System.out.println(tourDIYMap.get("language") +" <-------- InsertEstimateController(selectDIYOneDao)");
		System.out.println(empLanguageList.size() +" <-------- InsertEstimateController(insertEstimateDao)");
		request.setAttribute("sessionId", sessionId);
		request.setAttribute("tourDIYMap", tourDIYMap);
		request.setAttribute("empLanguageList", empLanguageList);
		
		request.getRequestDispatcher("/WEB-INF/view/admin/insertEstimateForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.estDao = new EstimateDao();
		Estimate est = new Estimate();
		est.setTourdiyNo(Integer.parseInt(request.getParameter("tourDIYNo")));
		est.setEmployeeNo(Integer.parseInt(request.getParameter("employeeNo")));
		est.setEstimatePrice(Integer.parseInt(request.getParameter("estimatePrice")));
		est.setAdminId(request.getParameter("sessionId"));
		int row = estDao.insertEstimate(est);
		
		if(row ==1) {		
			response.sendRedirect(request.getContextPath()+"/SelectDIYByAdminController");
		}else{
			response.sendRedirect(request.getContextPath()+"/SelectDIYByAdminController");
		}
		
	}

}
