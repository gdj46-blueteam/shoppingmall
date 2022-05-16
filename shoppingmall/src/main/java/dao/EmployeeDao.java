package dao;

import java.security.DrbgParameters.Reseed;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Employee;

public class EmployeeDao {

//페이징
	//1.직원 목록
	public List<Employee> selectEmpList(int beginRow, int rowPerPage){
		List<Employee> list = new ArrayList<>();
		
		//데이터베이스 연결
		Connection conn = null;
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234"); //DB에 연결한다.
			String sql="SELECT employee_no employeeNo, employee_name employeeName, employee_image employeeImage FROM employee ORDER BY employee_no LIMIT ?,?"; //쿼리문
			stmt = conn.prepareStatement(sql); //쿼리문 실행
			stmt.setInt(1, beginRow); //이전행의 개수를 넣는다
			stmt.setInt(2, rowPerPage); //행의 개수를 넣는다
			System.out.println("직원 목록(EmployeeDao)stmt -> " + stmt); //디버깅
			
			rs = stmt.executeQuery(); //쿼리 실행결과 저장
			System.out.println("직원 목록(EmployeeDao)rs ->" + rs); //디버깅
			
			while(rs.next()) { //다음 행이 있으면 true반환해서 실행
				Employee employee = new Employee(); //Employee 객체 생성
				employee.setEmployeeNo(rs.getInt("employeeNo")); //직원번호 가져오기
				employee.setEmployeeName(rs.getString("employeeName")); //직원이름 가져오기
				employee.setEmployeeImageNo(rs.getInt("employeeImageNo")); //직원 사진 가져오기
				list.add(employee); //list에 가져온 값 추가
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
		
		//DB 연결
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			String sql = "INSERT INTO employee(employee_pw, employee_sn, empAddress_id, employee_addressDetail, employee_name, employee_email, employee_phone, employee_gender, employee_image, employee_introduce, create_date, update_date)"
					+ " VALUES(PASSWORD('?'), ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW());";
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
			System.out.println("직원 입력 stmt -> " + stmt); //디버깅
			
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
			String sql = "UPDATE employee SET employee_pw = PASSWORD('?'), employee_email = ?, employee_phone = ?, employee_image = ?, employee_introduce = ?, update_date = NOW()"
					+ " WHERE employee_no =? ";
			stmt = conn.prepareStatement(sql); //쿼리문 실행
			// ? 값 대입
			stmt.setString(1, employee.getEmployeePw());
			stmt.setString(2, employee.getEmployeeEmail());
			stmt.setString(3, employee.getEmployeePhone());
			//stmt.setString(4, employee.getEmployeeImage());
			stmt.setString(5, employee.getEmployeeIntroduce());
			stmt.setInt(6, employee.getEmployeeNo());
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
			String sql = "DELETE FROM employee WHERE employee_no = ? AND employee_pw = PASSWORD('?')";
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
	public Employee selectEmpOneByAdmin(int employeeNo) {
		Employee e = new Employee();
		//DB 연결
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			String sql = "SELECT employee_no employeeNo, employee_pw employeePw, employee_sn employeeSn, CONCAT(a.province,' ', a.city,' ', a.town,' ', a.street,' ', a.building1,'-', a.building2) employeeAddress, e.employee_addressDetail employeeAddressDetail, employee_name employeeName"
					+ " , employee_email employeeEmail, employee_phone employeePhone, employee_gender employeeGender, employee_image employeeImage, employee_introduce employeeIntroduce, authority, create_date createDate, update_date updateDate"
					+ " FROM employee e INNER JOIN address a"
					+ " ON e.empAddress_id = a.id"
					+ " WHERE employee_no = ?";
			stmt = conn.prepareStatement(sql); //쿼리실행
			stmt.setInt(1, employeeNo);
			rs = stmt.executeQuery(); //쿼리결과저장
			if(rs.next()) {
				e.setEmployeeNo(rs.getInt("employeeNo"));
				e.setEmployeePw(rs.getString("employeePw"));
				e.setEmployeeSn(rs.getString("employeeSn"));
				e.setEmpAddressId(rs.getInt("empAddressId"));
				e.setEmployeeAddressDetail(rs.getString("employeeAddressDetail"));
				e.setEmployeeName(rs.getString("employeeName"));
				e.setEmployeeEmail(rs.getString("employeeEmail"));
				e.setEmployeePhone(rs.getString("employeePhone"));
				e.setEmployeeGender(rs.getString("employeeGender"));
				//e.setEmployeeImageNo(rs.getString("employeeImage"));
				e.setAuthority(rs.getInt("authority"));
				e.setEmployeeIntroduce(rs.getString("employeeIntroduce"));
				e.setCreateDate(rs.getString("createDate"));
				e.setUpdateDate(rs.getString("updateDate"));			}
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
		return e;
	}
	
}
