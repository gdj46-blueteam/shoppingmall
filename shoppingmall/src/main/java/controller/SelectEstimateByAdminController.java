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


@WebServlet("/SelectEstimateByAdminController")
public class SelectEstimateByAdminController extends HttpServlet {			//관리자 견적서 리스트
	private EstimateDao estDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		estDao = new EstimateDao();
		List<Map<String, Object>> list = estDao.selectEstimateByAdminList();
		System.out.println(list.size() + "<------SelectEstimateByAdminController(selectEstimateByAdminList)");
		request.setAttribute("list", list);
		request.getRequestDispatcher("WEB-INF/view/admin/selectEstimate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
