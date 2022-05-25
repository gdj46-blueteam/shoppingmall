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
 * Servlet implementation class UpdateEstimateController
 */
@WebServlet("/UpdateEstimateController")
public class UpdateEstimateController extends HttpServlet {
	private EstimateDao estDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		estDao = new EstimateDao();
		
		// 권한
		HttpSession session = request.getSession();
		int authority = (int)session.getAttribute("authority");
		String sessionId = (String)session.getAttribute("sessionId");			//로그인 세션정보
		
		System.out.println("권한 : " + authority);
		System.out.println("ID : " + sessionId);
		
		
		int tourDIYNo = Integer.parseInt(request.getParameter("tourDIYNo"));						//tourDIYNo 추출
		int estimateNo = Integer.parseInt(request.getParameter("estimateNo"));						//estimateNo 추출
		
		System.out.println(tourDIYNo +" " + estimateNo +" <----UpdateEstimateController");				//디버깅
		
		Map<String,Object> map = estDao.selectEstOne(Integer.parseInt(request.getParameter("estimateNo")));	
		List<Map<String, Object>> empLanguageList = estDao.insertEstimate(map);
		request.setAttribute("map", map);
		request.setAttribute("empLanguageList", empLanguageList);
		if(authority > 2) {
			request.getRequestDispatcher("/WEB-INF/view/admin/updateEstimateForm.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/view/public/errorPage.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Estimate est = new Estimate();
		est.setEstimateNo(Integer.parseInt(request.getParameter("estimateNo")));
		est.setEstimatePrice(Integer.parseInt(request.getParameter("estimatePrice")));
		est.setEmployeeNo(Integer.parseInt(request.getParameter("employeeNo")));
		est.setTourdiyNo(Integer.parseInt(request.getParameter("tourDIYNo")));
		est.setEstimateIng(request.getParameter("estimateIng"));
		int row= estDao.updateEstimate(est);
		System.out.println(row + " <----- UpdateEstimateController");
		if(row==1) {
			response.sendRedirect(request.getContextPath()+"/DeleteEstimateController?estimateNo="+est.getEstimateNo());
		}else {
			response.sendRedirect(request.getContextPath()+"/UpdateEstimateController?estimateNo="+est.getEstimateNo()+"&tourDIYNo="+est.getTourdiyNo());
		}
	}

}
