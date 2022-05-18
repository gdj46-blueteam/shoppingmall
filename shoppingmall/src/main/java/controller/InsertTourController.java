package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.*;
import java.io.File;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.*;

import dao.TourDao;
import vo.Tour;
import vo.TourImage;

@WebServlet("/InsertTourController")
public class InsertTourController extends HttpServlet {
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
				
		request.getRequestDispatcher("/WEB-INF/view/admin/insertTourForm.jsp").forward(request, response); 

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		//String path= application.getRealPath("upload");	
		//String path= "C:\Users\User\git\shoppingmall\shoppingmall\src\main\webapp\Image";
		String path = request.getSession().getServletContext().getRealPath("/") + "image";
		//request.setCharacterEncoding("utf-8");
		//String path = request.getSession().getServletContext().getRealPath("/image");
		System.out.println(path);
		MultipartRequest multiReq = new MultipartRequest(request, path, 1024*1024*100, "utf-8", new DefaultFileRenamePolicy());

		String tourimageName = multiReq.getFilesystemName("tourImage");
		String tourimageType = multiReq.getContentType("tourImage");
		
		System.out.println(tourimageName + " <-- tourimageName");
		System.out.println(tourimageType + " <-- tourimageType");

		//response.sendRedirect("");
			//파일 업로드의 경우 100mbyte 이하의 image/gif, image/png, image/jpg  3가지 이미지만 허용
		if(tourimageType.equals("image/gif") || tourimageType.equals("image/png") || tourimageType.equals("image/jpeg")){
			System.out.println("insertImage 1");
			//db저장
			TourDao TourDao  = new TourDao();
			TourImage tourImage = new TourImage();
			
			tourImage.setTourimageName(tourimageName);
			tourImage.setTourimageType(tourimageType);
			
			TourDao.insertTourImage(tourImage); // 메서드 구현

			response.sendRedirect(request.getContextPath()+"/InsertTourController");
		}else {
			System.out.println("insertImage 2");
			//업로드 취소 
			//19줄의 주석의 이유로 잘못된 파일은 삭제하는 절차 (멀티 리퀘스트는 경로를 달아주면 그냥 파일의 종류없이 업로드한다.) 
			System.out.println("img파일만 업로드!");
			File file = new File(path+"/"+tourimageName);			//java.io.file 잘못된 파일을 불러온다.	웹에서는 \\ = /
			file.delete();
			response.sendRedirect(request.getContextPath()+"/InsertTourController");
			request.setCharacterEncoding("utf-8");
		}
	}

}
