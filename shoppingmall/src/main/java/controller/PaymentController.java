package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청값 분석(c)
		int estimateNo = Integer.parseInt(request.getParameter("estimateNo"));
		
		// 디버깅
		System.out.println("PaymentController : " + estimateNo);
			
		// 뷰로 보낼준비
		request.setAttribute("estimateNo", estimateNo);
		
		// 뷰 포워딩(v)
		request.getRequestDispatcher("/WEB-INF/view/customer/paymentPage.jsp").forward(request, response);
	}


}
