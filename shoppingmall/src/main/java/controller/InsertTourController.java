package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.TourDao;
import vo.Tour;
import vo.TourArea;
import vo.TourImage;


@WebServlet("/InsertTourController")
public class InsertTourController extends HttpServlet {
  private TourDao tourDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 권한
		HttpSession session = request.getSession();
		int authority = (Integer)session.getAttribute("sessionAuthority");
		String sessionId = (String)session.getAttribute("sessionId");			//로그인 세션정보
		
		System.out.println("권한 : " + authority);
		System.out.println("ID : " + sessionId);
		
		if(authority > 2) {
			request.getRequestDispatcher("/WEB-INF/view/admin/insertTourForm.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/view/public/errorPage.jsp").forward(request, response);
		}
		 

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.tourDao=new TourDao();

		//String path= application.getRealPath("upload");	
		//String path= "C:\Users\User\git\shoppingmall\shoppingmall\src\main\webapp\Image";
		//request.setCharacterEncoding("utf-8");		
		String path = request.getSession().getServletContext().getRealPath("/") + "image";
		System.out.println(path);
		MultipartRequest multipartRequest  = new MultipartRequest(request, path, 1024*1024*100, "utf-8", new DefaultFileRenamePolicy());
		
		String tourImageName = multipartRequest .getFilesystemName("tourImage");
		String tourImageType = multipartRequest .getContentType("tourImage");
		String province = multipartRequest.getParameter("province");
		String tourCity = multipartRequest.getParameter("tourCity");
		String tourName = multipartRequest.getParameter("tourName");
		String tourDescription = multipartRequest.getParameter("tourDescription");
		
		System.out.println(tourImageName + " <-- tourimageName");
		System.out.println(tourImageType + " <-- tourimageType");
		System.out.println(province + "<--값확인");
		System.out.println(tourCity + "<--값확인");
		System.out.println(tourName + "<--tourName");
		System.out.println(tourDescription + "<--tourDescription");
		
		TourImage tourImage = new TourImage();
		TourArea tourArea = new TourArea();
		Tour tour = new Tour();

		
		
			//파일 업로드의 경우 100mbyte 이하의 image/gif, image/png, image/jpg  3가지 이미지만 허용
		if(tourImageType.equals("image/gif") || tourImageType.equals("image/png") || tourImageType.equals("image/jpeg")){
			System.out.println("insertImage 1");
			
			tourArea.setArea(province);
			tourArea.setCity(tourCity);
			System.out.println(tourArea.toString());
			
			tourImage.setTourImageName(tourImageName);
			tourImage.setTourImageType(tourImageType);
			System.out.println(tourImage.toString());
			// 메서드 호출
			tour.setTourImageNo(tourDao.insertTourImage(tourImage));		
			int tourAreaNo = tourDao.insertTourArea(tourArea);
		
			tour.setTourName(tourName);
			tour.setTourDescription(tourDescription);
			
			tour.setTourAreaNo(tourAreaNo);
			System.out.println(tour.getTourAreaNo()+"tourAreaNo");
			System.out.println(tour.getTourImageNo() +"tourImageNO");
			System.out.println(tour.toString());
			tourDao.insertTour(tour);
			
			response.sendRedirect(request.getContextPath()+"/InsertTourController");
		}else {
			System.out.println("insertImage 2");
			//업로드 취소 
			//19줄의 주석의 이유로 잘못된 파일은 삭제하는 절차 (멀티 리퀘스트는 경로를 달아주면 그냥 파일의 종류없이 업로드한다.) 
			System.out.println("img파일만 업로드!");
			File file = new File(path+"/"+tourImageName);			//java.io.file 잘못된 파일을 불러온다.	웹에서는 \\ = /
			file.delete();
			response.sendRedirect(request.getContextPath()+"/InsertTourController");
			request.setCharacterEncoding("utf-8");
		}
	}
}
