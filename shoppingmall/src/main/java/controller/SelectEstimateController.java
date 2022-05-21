package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EstimateDao;
import vo.TourDIY;

@WebServlet("/SelectEstimateController")
public class SelectEstimateController extends HttpServlet {
	private EstimateDao estimateDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.estimateDao = new EstimateDao();
		List<Map<String,Object>> list = estimateDao.selectEstimate();
		request.setAttribute("list", list);
		//디버깅
		System.out.println(list +"<-list");
		//요청페이지
	request.getRequestDispatcher("/WEB-INF/view/customer/selectEstimate.jsp").forward(request, response);
	}

}
