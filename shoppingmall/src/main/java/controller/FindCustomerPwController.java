package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import vo.Customer;


@WebServlet("/FindCustomerPwController")
public class FindCustomerPwController extends HttpServlet {
   private CustomerDao customerDao;
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String customerPw = request.getParameter("customerPw");
      if(customerPw == null) {
         System.out.println("1");
      }
      if(customerPw != null) {
         System.out.println("3");
   }
      request.setAttribute("customerPw", customerPw);
      
      request.getRequestDispatcher("/WEB-INF/view/public/findCustomerPw.jsp").forward(request, response);
   }

   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      customerDao = new CustomerDao();
      System.out.println("2");
      //id값 받아 오기
      String customerId = request.getParameter("customerId");
      System.out.println(customerId + "---customerId");
      
      //pw값 받아 오기
      String customerPw = customerDao.selectCustomerPw(customerId);
      System.out.println(customerPw + "---customerPw");
      request.setAttribute("customerPw", customerPw);
      
      response.sendRedirect(request.getContextPath()+"/FindCustomerPwController?customerPw="+customerPw); 
   }
}