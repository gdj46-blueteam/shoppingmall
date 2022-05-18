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

import vo.Employee;
import vo.EmployeeList;
import vo.EmployeeListOne;

public class EmployeeDao {

//페이징
   //issue :  사진이름대신 사진이 나오게?
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
   
   //issue : 주소번호 삽입대신 검색해서 삽입하게 
   //2.직원 삽입
   public int insertEmp(Employee employee) {
	      int row = 0;
	      
	      //DB 연결
	      Connection conn = null;
	      PreparedStatement stmt = null;
	      PreparedStatement stmt2 = null;
	      
	      try {
	         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
	         conn.setAutoCommit(false);
	         String sql = "INSERT INTO employee(employee_pw, employee_sn, empAddress_id, employee_addressDetail, employee_name, employee_email, employee_phone, employee_gender,employee_imageName, employee_introduce, create_date, update_date)"
	               + " VALUES(PASSWORD(?), ?, ?, ?, ?, ?, ?, ?,?,?, NOW(), NOW())";
	         
	         String sql2 = "INSERT INTO employee_image(employee_imageName, employee_imageType, create_date) VALUES(?, ? ,NOW())";
	         
	         stmt2 = conn.prepareStatement(sql2);
	         stmt2.setString(1, employee.getEmployeeName());
	         stmt2.setString(2, "jpeg");
	         int row2 = stmt2.executeUpdate();
	         System.out.println("employee_image" + row2);
	         
	         stmt = conn.prepareStatement(sql); //쿼리 실행
	         stmt.setString(1, employee.getEmployeePw());
	               //System.out.println(employee.getEmployeePw());
	         stmt.setString(2, employee.getEmployeeSn());
	               //System.out.println(employee.getEmployeeSn());
	         stmt.setInt(3, employee.getEmpAddressId());
	         stmt.setString(4, employee.getEmployeeAddressDetail());
	         stmt.setString(5, employee.getEmployeeName());
	         stmt.setString(6, employee.getEmployeeEmail());
	         stmt.setString(7, employee.getEmployeePhone());
	         stmt.setString(8, employee.getEmployeeGender());
	         stmt.setString(9, employee.getEmployeeImageName());
	         stmt.setString(10, employee.getEmployeeIntroduce());
	         row = stmt.executeUpdate(); //쿼리 실행 결과 저장
	         System.out.println("직원 입력 stmt -> " + stmt); //디버깅
	         
	         conn.commit();
	         if(row == 1) {
	            System.out.println("1행 입력 성공");
	         } else {
	            System.out.println("입력 실패");
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
         System.out.println("직원 수정 stmt -> " + stmt); //디버깅
         
         row = stmt.executeUpdate(); // 몇행입력했는지 리턴
         
         if(row == 1) {
            System.out.println("1행 수정 성공");
         } else {
            System.out.println("수정실패");
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
   
   //4.직원 삭제
   public int deleteEmp(int employeeNo, String employeePw) {
      int row = 0;
      
      //DB연결
      Connection conn = null;
      PreparedStatement stmt = null;
      
      try {
         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
         String sql = "DELETE FROM employee WHERE employee_no = ? AND employee_pw = PASSWORD(?)";
         stmt = conn.prepareStatement(sql); // 쿼리문 실행
         // ? 값 대입
         stmt.setInt(1, employeeNo);
         stmt.setString(2, employeePw);
         System.out.println("직원 삭제 stmt -> " + stmt); //디버깅
         
         row = stmt.executeUpdate();
         
         if(row == 1) {
            System.out.println("1행 삭제 성공");
         } else {
            System.out.println("삭제실패");
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
               + " ,employeePhone, employeeGender, employeeImageName, employeeIntroduce, authority, createDate, updateDate "
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
         String sql = " SELECT p.employee_no ,p.employee_name, c.customer_id,  d.tourdiy_term"
         		+ " FROM employee p"
         		+ " INNER JOIN  estimate e"
         		+ " ON p.employee_no = e.employee_no"
         		+ " INNER JOIN tourdiy d"
         		+ " ON e.tourdiy_no = d.tourdiy_no"
         		+ " INNER JOIN customer c"
         		+ " ON c.customer_id = d.customer_id"
         		+ " WHERE p.employee_no = ?";
         stmt = conn.prepareStatement(sql); //쿼리실행
         stmt.setInt(1, employeeNo);
         
         //디버깅
         System.out.println("stmt(selectMatching) ->" + stmt);
         rs = stmt.executeQuery(); //쿼리결과저장
         //디버깅
         System.out.println("rs(selectMatching)->" + rs);
         
         if(rs.next()) {
            map = new HashMap<String, Object>(); 
            map.put("employeeNo", rs.getInt("employeeNo"));
            map.put("employeeEmail", rs.getString("employeeEmail"));
            map.put("customerId", rs.getString("customerId"));
            
            //디버깅
            System.out.println("employeeNo(selectMatching)->" + rs.getString("employeeNo"));
            System.out.println("employeeEmail(selectMatching)->" + rs.getString("employeeEmail"));
            System.out.println("customerId(selectMatching)->" + rs.getString("customerId"));
          
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
		String sql = " SELECT id, concat(province, ' ', city,' ', town,' ', street,' ', building1) address "
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
}