package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.*;
public class CustomerDao {
	// selectCustomerList(회원목록)
	public List<Customer> selectCustomerList() {
		List<Customer> customer = new ArrayList<Customer>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT customer_id customerId, customer_name customerName, customer_country customerCountry, customer_gender customerGender "
				+ " FROM customer ";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Customer c =  new Customer();
				c.setCustomerId(rs.getString("customerId"));
				c.setCustomerName(rs.getString("customerName"));
				c.setCustomerCountry(rs.getString("customerCountry"));
				c.setCustomerGender(rs.getString("customerGender"));
				customer.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return customer;
	}
	
	//selectCustomerOne(회원상세정보)
	public Customer selectCustomerOne(String customerId) {
		Customer customer = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="SELECT customer_id, customer_pw, customer_name, customer_age, customer_phone, customer_email, customer_country, authority, create_date, update_date "
				+ "FROM customer "
				+ "WHERE customer_id = ?";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return customer;
	}
}
