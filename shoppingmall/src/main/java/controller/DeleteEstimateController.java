package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EstimateDao;


@WebServlet("/DeleteEstimateController")
public class DeleteEstimateController extends HttpServlet {		//상세보기겸 삭제페이지
	private EstimateDao estDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  HttpSession session = request.getSession(); 
		  int authority =(Integer)session.getAttribute("sessionAuthority"); 
		  String sessionId =(String)session.getAttribute("sessionId"); //로그인 세션정보
		 
		 System.out.println("권한 : " + authority); 
		 System.out.println("ID : " + sessionId);
		 
		
		estDao = new EstimateDao();
		Map<String,Object> map = estDao.selectEstOne(Integer.parseInt(request.getParameter("estimateNo")));
		request.setAttribute("map", map);
		if(authority==3) {
		request.getRequestDispatcher("/WEB-INF/view/admin/deleteEstimateForm.jsp").forward(request, response);
		}
		if(authority==1) {
			request.getRequestDispatcher("/WEB-INF/view/customer/deleteEstimateForm.jsp").forward(request, response);
		}
	}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		estDao = new EstimateDao();
		
		HttpSession session = request.getSession(); 
		int authority =(Integer)session.getAttribute("sessionAuthority"); 

		
		int estimateNo =Integer.parseInt(request.getParameter("estimateNo"));
		int tourDIYNo = Integer.parseInt(request.getParameter("tourDIYNo"));
		System.out.println(authority+" "+estimateNo+"  "+tourDIYNo  +"  <--  DeleteEstimateController(deleteEstimate)");
		int row=estDao.deleteEstimate(estimateNo,tourDIYNo);
		System.out.println( row +"<--DeleteEstimatecontroller" );
		if(row==1) {
			if(authority==1) {			//직원 권한은 관리자견적서 확인으로 이동
				response.sendRedirect(request.getContextPath()+"/SelectEstimateListController");
			}
			if(authority==3) {			//관리자 권한은 관리자견적서 확인으로 이동
				response.sendRedirect(request.getContextPath()+"/SelectEstimateByAdminController");
			}
		}else {
			response.sendRedirect(request.getContextPath()+"/DeleteEstimatecontroller?estimateNo= "+estimateNo);
		}
	}

}
