package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vo.EmpImage;
import vo.Employee;
import vo.EmployeeList;
import vo.EmployeeListOne;
import vo.Language;

public class EmployeeDao {

//페이징
 
   //1.직원 목록
   public List<EmployeeList> selectEmpList(){
      List<EmployeeList> list = new ArrayList<>();
      
      //데이터베이스 연결
      Connection conn = null;
      PreparedStatement stmt = null; 
      ResultSet rs = null;
      
      try {
         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234"); //DB에 연결한다.
         //쿼리문
         String sql=" SELECT employeeNo, employeeName, employeeImageName"
               + " FROM employee_list"; 
         stmt = conn.prepareStatement(sql); //쿼리문 실행
         
         System.out.println("직원 목록(EmployeeDao)stmt -> " + stmt); //디버깅
         
         rs = stmt.executeQuery(); //쿼리 실행결과 저장
         System.out.println("직원 목록(EmployeeDao)rs ->" + rs); //디버깅
         
         while(rs.next()) { //다음 행이 있으면 true반환해서 실행
            EmployeeList employeeList = new EmployeeList(); //Employee 객체 생성
            employeeList.setEmployeeNo(rs.getInt("employeeNo")); //직원번호 가져오기
            employeeList.setEmployeeName(rs.getString("employeeName")); //직원이름 가져오기
            employeeList.setEmployeeImageName(rs.getString("employeeImageName")); //직원 사진 가져오기
            list.add(employeeList); //list에 가져온 값 추가
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
       return list;
   }
   
   //2.직원 삽입
   public int insertEmp(Employee employee) {
	      int row = 0;
	      System.out.println("직원 삽입 메서드 시작");
	      //DB 연결
	      Connection conn = null;
	      PreparedStatement stmt = null;
	      
	      try {
	         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
	         String sql = "INSERT INTO employee(employee_pw, employee_sn, empAddress_id, employee_addressDetail, employee_name,"
	         		+ " employee_email, employee_phone, employee_gender,employee_imageNo, employee_introduce, create_date, update_date)"
	               + " VALUES(PASSWORD(?), ?, ?, ?, ?, ?, ?, ?,?,?, NOW(), NOW())";
	         
	         stmt = conn.prepareStatement(sql); //쿼리 실행
	         stmt.setString(1, employee.getEmployeePw());
	         stmt.setString(2, employee.getEmployeeSn());
	         stmt.setInt(3, employee.getEmpAddressId());
	         stmt.setString(4, employee.getEmployeeAddressDetail());
	         stmt.setString(5, employee.getEmployeeName());
	         stmt.setString(6, employee.getEmployeeEmail());
	         stmt.setString(7, employee.getEmployeePhone());
	         stmt.setString(8, employee.getEmployeeGender());
	         stmt.setInt(9, employee.getEmployeeImageNo());
	         stmt.setString(10, employee.getEmployeeIntroduce());
	         row = stmt.executeUpdate(); //쿼리 실행 결과 저장
				
	         if(row == 1) {
	            System.out.println("직원 1행 입력 성공(insertEmpDao)");
	         } else {
	            System.out.println("직원 입력 실패(insertEmpDao)");
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            stmt.close();
	            conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }System.out.println("직원 삽입 메서드 끝");
	      return row;
	   }
   
   //3.직원 수정
   public int updateEmp(Employee employee) {
      int row = 0;
      
      //데이터베이스 연결
      Connection conn = null;
      PreparedStatement stmt = null;
      
      try {
         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234"); // DB연결
         String sql = "UPDATE employee SET employee_pw = PASSWORD(?), employee_email = ?, employee_phone = ?, employee_introduce = ?, update_date = NOW()"
               + " WHERE employee_no =? ";
         stmt = conn.prepareStatement(sql); //쿼리문 실행
         // ? 값 대입
         stmt.setString(1, employee.getEmployeePw());
         stmt.setString(2, employee.getEmployeeEmail());
         stmt.setString(3, employee.getEmployeePhone());
         stmt.setString(4, employee.getEmployeeIntroduce());
         stmt.setInt(5, employee.getEmployeeNo());
         System.out.println("직원 수정stmt(updateEmpDao) -> " + stmt); //디버깅
         
         row = stmt.executeUpdate(); // 몇행입력했는지 리턴
         
         if(row == 1) {
            System.out.println("1행 수정 성공(updateEmpDao)");
         } else {
            System.out.println("수정실패(updateEmpDao)");
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            stmt.close();
            conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }   
      }
      
      return row;
   }
   //4.직원 - 언어삽입
   public int insertEmpLanguage(int languageNo, Employee employee) {
	      int row = 0;
	      System.out.println("직원언어삽입 메서드시작(insertEmpLanguageDao)");
	      //DB 연결
	      Connection conn = null;
	      PreparedStatement stmt = null;
	      
	      try {
	         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
	         String sql = "INSERT INTO employee_language(language_no, employee_no) VALUES(?, ?)";
	         
	         stmt = conn.prepareStatement(sql); //쿼리 실행
	         stmt.setInt(1, languageNo);
	         stmt.setInt(2, employee.getEmployeeNo());
	       
	         row = stmt.executeUpdate(); //쿼리 실행 결과 저장
				
	         if(row == 1) {
	            System.out.println("직원-언어 입력성공(insertEmpLanguage)");
	         } else {
	            System.out.println("직원-언어 입력 실패(insertEmpLanguage)");
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            stmt.close();
	            conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }System.out.println("직원 삽입 메서드 끝");
	      return row;
	   }
   
   //5. 직원상세보기
   public EmployeeListOne selectEmpOne(int employeeNo) {
      EmployeeListOne employeeListOne = new EmployeeListOne();
      //DB 연결
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      
      try {
         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
         //쿼리문
         String sql = " SELECT employeeNo,employeeSn, employeeAddress, employeeAddressDetail, employeeName, employeeEmail "
               + " ,employeePhone, employeeGender, employeeImageName, employeeIntroduce,language, authority, createDate, updateDate "
               + " FROM  employee_list_one where employeeNo=?";
         stmt = conn.prepareStatement(sql); //쿼리실행
         stmt.setInt(1, employeeNo);
         rs = stmt.executeQuery(); //쿼리결과저장
         if(rs.next()) {
            employeeListOne.setEmployeeNo(rs.getInt("employeeNo"));
            employeeListOne.setEmployeeSn(rs.getString("employeeSn"));
            employeeListOne.setEmployeeAddress(rs.getString("employeeAddress"));
            employeeListOne.setEmployeeAddressDetail(rs.getString("employeeAddressDetail"));
            employeeListOne.setEmployeeName(rs.getString("employeeName"));
            employeeListOne.setEmployeeEmail(rs.getString("employeeEmail"));
            employeeListOne.setEmployeePhone(rs.getString("employeePhone"));
            employeeListOne.setEmployeeGender(rs.getString("employeeGender"));
            employeeListOne.setEmployeeImageName(rs.getString("employeeImageName"));
            employeeListOne.setEmployeeIntroduce(rs.getString("employeeIntroduce"));
            employeeListOne.setLanguage(rs.getString("language"));
            employeeListOne.setAuthority(rs.getInt("authority"));
            employeeListOne.setCreateDate(rs.getString("createDate"));
            employeeListOne.setUpdateDate(rs.getString("updateDate"));   
            
            System.out.println("employeeNo(selectEmpOne)->" + rs.getInt(employeeNo));
            System.out.println("employeeSn(selectEmpOne)->" + rs.getString("employeeSn"));
            System.out.println("employeeAddress(selectEmpOne)->" + rs.getString("employeeAddress"));
            System.out.println("employeeAddressDetail(selectEmpOne)->" + rs.getString("employeeAddressDetail"));
            System.out.println("employeeName(selectEmpOne)->" + rs.getString("employeeName"));
            System.out.println("employeeEmail(selectEmpOne)->" + rs.getString("employeeEmail"));
            System.out.println("employeePhone(selectEmpOne)->" + rs.getString("employeePhone"));
            System.out.println("employeeGender(selectEmpOne)->" + rs.getString("employeeGender"));
            System.out.println("employeeImageName(selectEmpOne)->" + rs.getString("employeeImageName"));
            System.out.println("authority(selectEmpOne)->" + rs.getInt("authority"));
            System.out.println("employeeIntroduce(selectEmpOne)->" + rs.getString("employeeIntroduce"));
            System.out.println("language(selectEmpOne)->" + rs.getString("language"));
            System.out.println("createDate(selectEmpOne)->" + rs.getString("createDate"));
            System.out.println("createDate(updateDate)->" + rs.getString("updateDate"));
         }
      } catch (SQLException e1) {
         e1.printStackTrace();
      } finally {
         try {
            rs.close();
            stmt.close();
            conn.close();
         } catch (SQLException e1) {
            e1.printStackTrace();
         }
      }
      return employeeListOne;
   }
   //6. 직원 실적확인 
   public Map<String, Object> selectEmpResult(int employeeNo) {
      Map<String, Object> map = new HashMap<String, Object>(); 
      //DB 연결
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      
      try {
         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
         //쿼리문
         String sql = "SELECT p.employee_no employeeNo, p.employee_name employeeName, sum(e.estimate_price) sum, COUNT(e.estimate_price) cnt "
               + " FROM estimate e "
               + " INNER JOIN employee p "
               + " ON e.employee_no = p.employee_no "
               + " WHERE e.employee_no = ? AND estimate_ing = '결제완료' "
               + " GROUP BY employeeName "
               + " ORDER BY sum(e.estimate_price) DESC ";
         
         stmt = conn.prepareStatement(sql); //쿼리실행
         System.out.println("stmt(selectEmpResult) ->" + stmt);
         stmt.setInt(1, employeeNo);
      
         rs = stmt.executeQuery(); //쿼리결과저장
         System.out.println("rs(selectEmpResult)->" + rs);
         if(rs.next()) {
            map = new HashMap<String, Object>(); 
            map.put("employeeNo", rs.getInt("employeeNo"));
            map.put("employeeName", rs.getString("employeeName"));
            map.put("sum", rs.getInt("sum"));
            map.put("cnt", rs.getInt("cnt"));
            
            //디버깅
            System.out.println("employeeNo(selectEmpResult)->" + rs.getInt(employeeNo));
            System.out.println("employeeName(selectEmpResult)->" + rs.getString("employeeName"));
            System.out.println("sum(selectEmpResult)->" + rs.getInt("sum"));
            System.out.println("cnt(selectEmpResult)->" + rs.getInt("cnt"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            rs.close();
            stmt.close();
            conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      return map;
   }
   
   //7.배치확인
   public Map<String, Object> selectMatching(int employeeNo) {
      Map<String, Object> map = new HashMap<String, Object>(); 
      //DB 연결
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      
      try {
         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
         //쿼리문
         String sql = " SELECT p.employee_no employeeNo ,p.employee_name employeeName, c.customer_id customerId,  d.tourdiy_term tourdiyTerm"
         		+ " FROM employee p"
         		+ " INNER JOIN  estimate e"
         		+ " ON p.employee_no = e.employee_no"
         		+ " INNER JOIN tourdiy d"
         		+ " ON e.tourdiy_no = d.tourdiy_no"
         		+ " INNER JOIN customer c"
         		+ " ON c.customer_id = d.customer_id"
         		+ " WHERE p.employee_no = ?"
         		+ " order by d.tourdiy_term DESC";
         stmt = conn.prepareStatement(sql); //쿼리실행
         System.out.println("stmt(selectMatching) ->" + stmt);
         stmt.setInt(1, employeeNo);
         
         rs = stmt.executeQuery(); //쿼리결과저장
         System.out.println("rs(selectMatching)->" + rs); //디버깅
         
         if(rs.next()) {
            map = new HashMap<String, Object>(); 
            map.put("employeeNo", rs.getInt("employeeNo"));
            map.put("employeeName", rs.getString("employeeName"));
            map.put("customerId", rs.getString("customerId"));
            map.put("tourdiyTerm", rs.getString("tourdiyTerm"));
            
            //디버깅
            System.out.println("employeeNo(selectMatching)->" + rs.getInt("employeeNo"));
            System.out.println("employeeName(selectMatching)->" + rs.getString("employeeName"));
            System.out.println("customerId(selectMatching)->" + rs.getString("customerId"));
            System.out.println("tourdiyTerm(selectMatching)->" + rs.getString("tourdiyTerm"));
          
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            rs.close();
            stmt.close();
            conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }

      }
      return map;
   }
   
   //8.주소검색
   public List<Map<String, Object>> selectAddressList(String street){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		//데이터베이스 연결
		Connection conn = null;
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		String sql = " SELECT id, concat(province, ' ', city,' ', town,' ', street,' ', building1,' ',building2) address "
					+ "FROM address "
					+ "WHERE street LIKE ? "; 
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234"); //DB에 연결한다.
			stmt = conn.prepareStatement(sql); //쿼리문 실행
			stmt.setString(1, "%"+street+"%");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> m = new HashMap<>();
				m.put("id", rs.getInt("id"));
				m.put("addr", rs.getString("address"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		 return list;
	}
   //9. 직원이미지 삽입
	public int insertEmployeeImage(EmpImage empImage) {
		
		System.out.println("직원이미지 삽입 메서드 시작");
	   int row =0;
	//데이터베이스 연결
	Connection conn = null;
	PreparedStatement stmt = null; 
	ResultSet rs =null;
	int imageNo=0;
	String sql = "insert into employee_image(employee_imageName, employee_imageType, create_date) values(?,?,NOW())"; 
	try {
		conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234"); //DB에 연결한다.
		stmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS); //쿼리문 실행
		stmt.setString(1, empImage.getEmployeeImageName());
		stmt.setString(2, empImage.getEmployeeImageType());
		System.out.println("stmt (insertEmployeeImage) -> " + stmt); //디버깅
		row = stmt.executeUpdate();
		rs=stmt.getGeneratedKeys();
		if(rs.next()) {
			imageNo = rs.getInt(1);
		}
		 if(row == 1) {
	            System.out.println("1행 입력 성공(insertEmployeeImage)");
	         } else {
	            System.out.println("입력 실패(insertEmployeeImage)");
	         }
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			stmt.close();
			conn.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	System.out.println("직원이미지 삽입 메서드 끝");
	return imageNo;
	 
	}
   
   //10. 직원 이미지삭제
   public int delteEmployeeImage(int employeeImageNo) {
	   int row =0;
	//데이터베이스 연결
	Connection conn = null;
	PreparedStatement stmt = null; 
	
	String sql = "delete from employee_image where employee_imageNo = ?"; 
	try {
		conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234"); //DB에 연결한다.
		stmt = conn.prepareStatement(sql); //쿼리문 실행
		stmt.setInt(1, employeeImageNo);
		System.out.println("stmt (delteEmployeeImage) -> " + stmt); //디버깅
		row = stmt.executeUpdate();
		
		 if(row == 1) {
	            System.out.println("1행 삭제 성공(delteEmployeeImageDAO)");
	         } else {
	            System.out.println("삭제 실패(delteEmployeeImageDAO)");
	         }
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	System.out.println("직원이미지 삽입 메서드 끝");
	return row;
	 
   }
   //11.직원 이미지 이름 반환
	public int selectEmpImageName(int employeeImageNo) {
	//데이터베이스 연결
	Connection conn = null;
	PreparedStatement stmt = null; 
	ResultSet rs =null;
	
	String EmpImageName  = "select employee_imageName where employee_imageNo =?"; 
	try {
		conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234"); //DB에 연결한다.
		stmt = conn.prepareStatement(EmpImageName); //쿼리문 실행
		stmt.setInt(1, employeeImageNo);
		System.out.println("stmt (selectEmpImageName) -> " + stmt); //디버깅
		rs = stmt.executeQuery(); //실행결과 저장
		System.out.println("rs(selectEmpImageName) ->" + rs);
		 
	} catch (SQLException e) { 
		e.printStackTrace();
	} finally {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return employeeImageNo;
	 
	}
   
   // 12. 언어선택(selectlanguageDao)
   public List<Language> selectlanguage(){
	      List<Language> list = new ArrayList<>();
	      
	      //데이터베이스 연결
	      Connection conn = null;
	      PreparedStatement stmt = null; 
	      ResultSet rs = null;
	      
	      try {
	         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234"); //DB에 연결한다.
	         //쿼리문
	         String sql=" SELECT language_no languageNo, language"
	               + " FROM language"; 
	         stmt = conn.prepareStatement(sql); //쿼리문 실행
	         
	         System.out.println("언어목록(selectlanguageDao)stmt -> " + stmt); //디버깅
	         
	         rs = stmt.executeQuery(); //쿼리 실행결과 저장
	         System.out.println("언어목록(selectlanguageDao)rs ->" + rs); //디버깅
	         
	         while(rs.next()) { //다음 행이 있으면 true반환해서 실행
	        	 Language language = new Language(); //Language 객체 생성
	        	 language.setLanguageNo(rs.getInt("languageNo")); 
	        	 language.setLanguage(rs.getString("language"));
	             list.add(language); //list에 가져온 값 추가
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	        	 rs.close();
	        	 stmt.close();
	            conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	       return list;
	   }
   
}