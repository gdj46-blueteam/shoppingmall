package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DIYDao;
import dao.EstimateDao;

@WebServlet("/SelectEstimateController")
public class SelectDIYListController extends HttpServlet {
	private DIYDao dIYDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.dIYDao = new DIYDao();
		List<Map<String,Object>> list = dIYDao.selectEstimate();
		request.setAttribute("list", list);
		//디버깅
		System.out.println(list +"<-list");
		//요청페이지
	request.getRequestDispatcher("/WEB-INF/view/customer/selectEstimate.jsp").forward(request, response);
	}

}
