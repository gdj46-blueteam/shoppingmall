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
	public String selectLogin(Customer customer){
		//SELECT customer_id customerId, customer_pw customerPw FROM customer
		//WHERE customer_id ='guest'AND customer_pw='1234';
	//List<Customer> customerList = new ArrayList<Customer>();
	//Map<String, Object> map = new HashMap<String, Object>();
		String loginId = "";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT customer_id customerId, customer_pw customerPw FROM customer"
				+ "		WHERE customer_id = ? AND customer_pw=?";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customer.getCustomerId());
			stmt.setString(2, customer.getCustomerPw());
			rs = stmt.executeQuery();
			while(rs.next()) {
				loginId = rs.getString("customerId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(loginId);
		return loginId;
	}

}
