package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import java.io.File;
import dao.EmployeeDao;
import vo.EmpImage;
import vo.Employee;

@WebServlet("/InsertEmpContoller")
public class InsertEmpContoller extends HttpServlet {
	private EmployeeDao employeeDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/admin/insertEmpForm.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //인코딩
		//사진 삽입
		//String path= request.getRealPath("image"); //application 변수 톰캣을 가르키는 변수
		String path= request.getSession().getServletContext().getRealPath("/")+ "image";
		System.out.println("path(InsertEmpContoller) ->" + path);
		
		MultipartRequest multiReq = new MultipartRequest(request,path,1024*1024*100,"utf-8", new DefaultFileRenamePolicy());
		String employeeImageName = multiReq.getFilesystemName("employeeImageName"); //new DefaultFileRenamePolicy() 객체를 통해 변경된 이름
		String employeeImageType = multiReq.getContentType("employeeImageName");
		//디버깅
		System.out.println("employeeImageName(InsertEmpContoller) ->" + employeeImageName);
		System.out.println("employee_imageType(InsertEmpContoller)->" + employeeImageType);
		
		//이미지 타입
				//파일 업로드의 경우 100Mbyte 이하의 image/gif, image/png, image/jpeg 3가지 이미지만 허용
				if(employeeImageType.equals("image/gif") ||employeeImageType.equals("image/png")||employeeImageType.equals("image/jpeg")){
					//db에 저장
					System.out.println("사진 db에 저장");
					EmpImage empImage = new EmpImage();
					empImage.setEmployeeImageName(employeeImageName);
					empImage.setEmployeeImageType(employeeImageType);
					//employeeDao.insertEmp(null) ;//메서드 구현
					
					//response.sendRedirect(request.getContextPath()+"/SelectEmpListController");
					
				}else{
					System.out.println("이미지 파일을 올려주세요");
					//잘못들어온 파일이므로 업로드된 파일 지우고 폼으로 이동
					File file = new File(path+"\\"+employeeImageName); //잘못된 파일을 불러오기
					file.delete(); //잘못된 파일 삭제
					response.sendRedirect(request.getContextPath()+"/admin/insertEmpForm.jsp");
				}	
		
		Employee employee = new Employee();
		// insertEmpForm.jsp 에서 받은 정보 받아오기
		employee.setEmployeePw(multiReq.getParameter("employeePw"));
		employee.setEmployeeSn(multiReq.getParameter("employeeSn"));
		employee.setEmpAddressId(Integer.parseInt(multiReq.getParameter("empAddressId"))); //int 형변환
		employee.setEmployeeAddressDetail(multiReq.getParameter("employeeAddressDetail"));
		employee.setEmployeeName(multiReq.getParameter("employeeName"));
		employee.setEmployeeEmail(multiReq.getParameter("employeeEmail"));
		employee.setEmployeePhone(multiReq.getParameter("employeePhone"));
		employee.setEmployeeGender(multiReq.getParameter("employeeGender"));
		employee.setEmployeeImageName(multiReq.getParameter("employeeImageName"));
		employee.setEmployeeIntroduce(multiReq.getParameter("employeeIntroduce"));
		
		//Dao 객체 생성해서 insetEmp 메서드 호출해서 실행
		this.employeeDao = new EmployeeDao();
		int row = employeeDao.insertEmp(employee);
		//디버깅
		System.out.println(row +"<- 직원등록");
		
		
		
		
		
		response.sendRedirect(request.getContextPath()+"/SelectEmpListController");
	}
}
