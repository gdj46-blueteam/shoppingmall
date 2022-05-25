package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import java.io.File;
import dao.EmployeeDao;
import vo.EmpImage;
import vo.Employee;
import vo.Language;

@WebServlet("/InsertEmpContoller")
public class InsertEmpContoller extends HttpServlet {
	private EmployeeDao employeeDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/admin/insertEmpForm.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //인코딩
		this.employeeDao = new EmployeeDao(); //dao 객체 생성
		Employee employee = new Employee();
		EmpImage empImage = new EmpImage();
		
		// 권한
		HttpSession session = request.getSession();
		int authority = (Integer)session.getAttribute("sessionAuthority");
		String sessionId = (String)session.getAttribute("sessionId");			//로그인 세션정보
		
		System.out.println("권한 : " + authority);
		System.out.println("ID : " + sessionId);
		
		
		//사진 삽입
		String path= request.getSession().getServletContext().getRealPath("/")+ "image";
		System.out.println("path(InsertEmpContoller) ->" + path);
		
		//MultipartRequest
		MultipartRequest multiRequest = new MultipartRequest(request,path,1024*1024*100,"utf-8", new DefaultFileRenamePolicy());
		String employeeImageName = multiRequest.getFilesystemName("employeeImageName"); //new DefaultFileRenamePolicy() 객체를 통해 변경된 이름
		String employeeImageType = multiRequest.getContentType("employeeImageType");
		//디버깅
		System.out.println("employeeImageName(InsertEmpContoller) ->" + employeeImageName);
		System.out.println("employee_imageType(InsertEmpContoller)->" + employeeImageType);
		
		//이미지 타입
		//파일 업로드의 경우 100Mbyte 이하의 image/gif, image/png, image/jpeg 3가지 이미지만 허용
		if(employeeImageType==null) {
			employeeImageType="image/jpeg";
		}
		if(employeeImageType.equals("image/gif") ||employeeImageType.equals("image/png")||employeeImageType.equals("image/jpeg")){
			//db에 저장
			System.out.println("사진 db에 저장(InsertEmpContoller)");
		
			empImage.setEmployeeImageName(employeeImageName);
			empImage.setEmployeeImageType(employeeImageType);
			
			employee.setEmployeeImageNo(employeeDao.insertEmployeeImage(empImage)); //이미지 삽입 메소드 호출
			System.out.println(empImage +" 메서드 실행 후 키값 가져오기");
			
			
		}else{
			System.out.println("이미지 파일을 올려주세요");
			//잘못들어온 파일이므로 업로드된 파일 지우고 폼으로 이동
			File file = new File(path+"\\"+employeeImageName); //잘못된 파일을 불러오기
			file.delete(); //잘못된 파일 삭제
			response.sendRedirect(request.getContextPath()+"/admin/insertEmpForm.jsp");
		}	

		
		
		// insertEmpForm.jsp 에서 받은 정보 받아오기
		//multiReq
		employee.setEmployeePw(multiRequest.getParameter("employeePw"));
		employee.setEmployeeSn(multiRequest.getParameter("employeeSn"));
		employee.setEmpAddressId(Integer.parseInt(multiRequest.getParameter("empAddressId"))); //int 형변환
		employee.setEmployeeAddressDetail(multiRequest.getParameter("employeeAddressDetail"));
		employee.setEmployeeName(multiRequest.getParameter("employeeName"));
		employee.setEmployeeEmail(multiRequest.getParameter("employeeEmail"));
		employee.setEmployeePhone(multiRequest.getParameter("employeePhone"));
		employee.setEmployeeGender(multiRequest.getParameter("employeeGender"));
		employee.setEmployeeIntroduce(multiRequest.getParameter("employeeIntroduce"));
		
		//Dao 객체 생성해서 insetEmp 메서드 호출해서 실행
		employee.setEmployeeNo(employeeDao.insertEmp(employee)); //직원삽입 메소드
		//디버깅
		System.out.println(employee.getEmployeeNo() +" <- 직원등록(InsertEmpContoller)");
		
		//삽입 메소드 반복 - post
		//Language language = new Language();
		//language.setLanguage(multiRequest.getParameter("language"));
		
		String[] arrLanguage = multiRequest.getParameterValues("language");
		
		for(int i =0; i<arrLanguage.length; i++)
			System.out.println(arrLanguage[i] + "arrLanguage(InsertEmpContoller)");
		
		for(int i =0; i <arrLanguage.length; i=i+1) {
			employeeDao.insertEmpLanguage(Integer.parseInt(arrLanguage[i]), employee.getEmployeeNo());
			//request.setAttribute("language", language);
		}
		if(authority > 2) {
			response.sendRedirect(request.getContextPath()+"/SelectEmpListController");
		} else {
			response.sendRedirect(request.getContextPath()+"/SelectEmpListController");
		}
		

	}
}
