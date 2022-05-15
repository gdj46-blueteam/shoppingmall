package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import vo.*;

public class LoginDao {
	public String selectLogin(String id, String pw){
		String loginId = null; //		반환할 ligoinId를 저장할 변수선언
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//회원 id,pw를 조회하는 쿼리문
		String sql = "SELECT customer_id customerId, customer_pw customerPw FROM customer"
				+ "		WHERE customer_id = ? AND customer_pw=?";
		try {
			//db접속
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			stmt = conn.prepareStatement(sql); //쿼리실행
			stmt.setString(1, id);//물음표 값에 값을 넣음
			stmt.setString(2, pw);//물음표 값에 값을 넣음
			rs = stmt.executeQuery(); //rs변수에 결과값 저장
			if(rs.next()) { //rs변수에 값이 있으면 
				loginId = rs.getString("customerId");//loginId에 rs변수에 저장한 결과값을 넣음
			}
			if(loginId == null) { //고객아이디 값이 널이라면
				System.out.println(loginId+"고객아이디null값");//디버깅
				//직원 id, pw를 조회하는 쿼리문
				sql = "SELECT employee_email employeeEmail, employee_pw employeePw FROM employee"
					+ " WHERE employee_email = ? AND employee_pw = PASSWORD(?)";
				stmt = conn.prepareStatement(sql);//쿼리실행
				stmt.setString(1, id);//물음표 값에 값을 넣음
				stmt.setString(2, pw);//물음표 값에 값을 넣음
				rs = stmt.executeQuery(); //rs변수에 결과값 저장
				if(rs.next()) { //rs변수에 값이 있으면 
					loginId = rs.getString("employeeEmail");//loginId에 rs변수에 저장한 결과값을 넣음
				}
				if(loginId == null) { //관리자아이디 값이 널이라면
					System.out.println(loginId+"직원아이디null값"); //디버깅
					//관리자 id, pw를 조회하는 쿼리문
					sql = "SELECT admin_id adminId, admin_pw adminPw FROM admin"
						+ " WHERE admin_id = ? AND admin_pw = PASSWORD(?)";
					stmt = conn.prepareStatement(sql); //쿼리실행
					stmt.setString(1, id);//물음표 값에 값을 넣음
					stmt.setString(2, pw);//물음표 값에 값을 넣음
					rs = stmt.executeQuery(); //rs변수에 결과값 저장
					if(rs.next()) { //rs변수에 값이 있으면 
						loginId = rs.getString("adminId");//loginId에 rs변수에 저장한 결과값을 넣음
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(loginId); //loginId 디버깅
		return loginId; //loginId 반환
	}
	
}
