package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EstimateDao;


@WebServlet("/DeleteEstimateController")
public class DeleteEstimateController extends HttpServlet {				//상세보기겸 삭제페이지
	private EstimateDao estDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		estDao = new EstimateDao();
		Map<String,Object> map = estDao.selectEstOne(Integer.parseInt(request.getParameter("estimateNo")));
		request.setAttribute("map", map);
		
		request.getRequestDispatcher("/WEB-INF/view/admin/deleteEstimateForm.jsp").forward(request, response);
	}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		estDao = new EstimateDao();
		int estimateNo =Integer.parseInt(request.getParameter("estimateNo"));
		int tourDIYNo = Integer.parseInt(request.getParameter("tourDIYNo"));
		int row=estDao.deleteEstimate(estimateNo,tourDIYNo);
		System.out.println(estimateNo + "   "+row +"<--DeleteEstimatecontroller" );
		if(row==1) {
			response.sendRedirect(request.getContextPath()+"/SelectEstimateByAdminController");
		}else {
			response.sendRedirect(request.getContextPath()+"/DeleteEstimatecontroller?estimateNo= "+estimateNo);
		}
	}

}
