package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Employee;

public class EmployeeDao {
//페이징
	//1.직원 목록
	public ArrayList<Employee> selectEmpList(int beginRow, int rowPerPage){
		ArrayList<Employee> list = new ArrayList<>();
		
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
				employee.setEmployeeNo(rs.getInt("EmployeeNo")); //직원번호 가져오기
				employee.setEmployeeName(rs.getString("employeeName")); //직원이름 가져오기
				employee.setEmployeeImage(rs.getString("employeeImage")); //직원 사진 가져오기
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
}
