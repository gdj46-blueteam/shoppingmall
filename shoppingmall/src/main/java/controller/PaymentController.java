package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;

@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 권한
		HttpSession session = request.getSession();
		int authority = (Integer)session.getAttribute("sessionAuthority");
		String sessionId = (String)session.getAttribute("sessionId");			//로그인 세션정보
		
		System.out.println("권한 : " + authority);
		System.out.println("ID : " + sessionId);
		
		// 요청값 분석(c)
		int estimateNo = Integer.parseInt(request.getParameter("estimateNo"));
		
		// 디버깅
		System.out.println("PaymentController : " + estimateNo);
			
		// 뷰로 보낼준비
		request.setAttribute("estimateNo", estimateNo);
		
		// 뷰 포워딩(v)
		request.getRequestDispatcher("/WEB-INF/view/customer/paymentPage.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 요청값 분석(c)
		int estimateNo = Integer.parseInt(request.getParameter("estimateNo"));
		// 디버깅
		System.out.println("PaymentController : " + estimateNo);
		// 메서드 이용하여 모델값 구하기(M)
		CustomerDao customerDao = new CustomerDao();
		int row = customerDao.UpdatepaymentComplete(estimateNo);
		// (수정할 것) 세션 아이디 받아서 마이페이지로 가게 하기

		if (row == 1) { //성공
	        System.out.println("결제성공");
	        response.sendRedirect(request.getContextPath()+"/SelectEstimateListController");
	        return;
	     } else {// row==0이면 영향받은 행이 없으므로 오류
	        System.out.println("결제실패");
	        response.sendRedirect(request.getContextPath()+"/PaymentController"); 
	     }



	}

}
