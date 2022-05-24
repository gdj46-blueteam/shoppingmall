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
	// 회원목록 리스트
	public List<Customer> selectCustomerList() {
		List<Customer> customer = new ArrayList<Customer>(); //list 로 값 받기
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT customer_id customerId, customer_name customerName, customer_country customerCountry, customer_gender customerGender "
				+ " FROM customer ";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			stmt = conn.prepareStatement(sql);//쿼리 실행
			rs = stmt.executeQuery();//쿼리 저장
			while(rs.next()) { //객체를 while 안에서 초기화 
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
	
	// 회원정보 상세보기
	public Customer selectCustomerOne(String customerId) {
			Customer customer = null;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql ="SELECT customer_id customerId, customer_name customerName,customer_gender customerGender, customer_age customerAge, customer_phone customerPhone, customer_email customerEmail, customer_country customerCountry, authority authority, create_date createDate, update_date updateDate "
					+ "FROM customer "
					+ "WHERE customer_id = ?";
			try {
				conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
				stmt = conn.prepareStatement(sql);//쿼리 실행
				stmt.setString(1, customerId);
				rs = stmt.executeQuery();//쿼리 저장
				if(rs.next()) {
					customer = new Customer();
					customer.setCustomerId(rs.getString("customerId"));
					customer.setCustomerName(rs.getString("customerName"));
					customer.setCustomerGender(rs.getString("customerGender"));
					customer.setCustomerAge(rs.getInt("customerAge"));
					customer.setCustomerPhone(rs.getString("customerPhone"));
					customer.setCustomerEmail(rs.getString("customerEmail"));
					customer.setCustomerCountry(rs.getString("customerCountry"));
					customer.setCreateDate(rs.getString("createDate"));
					customer.setAuthority(rs.getInt("authority"));
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
	
	// 회원정보 수정
	public int updateCustomer(Customer customer) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int row = 0;
		String sql ="UPDATE customer "
				+ "SET customer_pw = PASSWORD(?), customer_name= ?, customer_age= ?, customer_phone= ?, customer_email= ?, customer_country= ?, update_date = NOW() "
				+ "WHERE customer_id = ?";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customer.getCustomerPw());
			stmt.setString(2, customer.getCustomerName());
			stmt.setInt(3, customer.getCustomerAge());
			stmt.setString(4, customer.getCustomerPhone());
			stmt.setString(5, customer.getCustomerEmail());
			stmt.setString(6, customer.getCustomerCountry());
			stmt.setString(7, customer.getCustomerId());
			row = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	//회원정보 삭제
	public int deleteCustomer(String customerId, String customerPw) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int row = 0;
		String sql = "DELETE FROM customer WHERE customer_id = ? AND customer_pw = ?";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			stmt = conn.prepareStatement(sql);//쿼리 실행
			stmt.setString(1, customerId);
			stmt.setString(2, customerPw);
			row = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	// 결제완료
	public int UpdatepaymentComplete(int estimateNo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int row = 0;
		String estimateIng = "결제완료";
		String sql = "UPDATE estimate SET estimate_ing = ? "
				+ "WHERE estimate_no = ? ";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			stmt = conn.prepareStatement(sql);//쿼리 실행
			stmt.setInt(1, estimateNo);
			stmt.setString(2, estimateIng);
			row = stmt.executeUpdate(); //쿼리 실행된 행수
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	// 회원 아이디찾기
	public String selectCustomerId(String customerEmail) {
	String customerId = "";
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String sql = "SELECT customer_id customerId"
			+ "FROM customer "
			+ "WHERE customer_email = ? ";
	try {
		conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerEmail);
		rs = stmt.executeQuery();
		if(rs.next()) {
			customerId = rs.getString("customerId");
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
	
	return customerId;
	}
	
	//회원 비밀번호찾기
	public String selectCustomerPw(String customerId) {
	String customerPw = "";
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String sql = "SELECT customer_pw customerPw "
			+ "	 FROM customer "
			+ "	 WHERE customer_id = ? ";
	try {
		conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
		stmt = conn.prepareStatement(sql); //쿼리 실행
		stmt.setString(1, customerId);
		rs = stmt.executeQuery();
		if(rs.next()) {
			customerPw = rs.getString("customerPw");
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
	
	return customerPw;
	}
	
	//회원입력
	public int insertCustomer(Customer customer) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int row = 0;
		String sql ="INSERT INTO customer(customer_id , customer_pw, customer_gender, customer_age, customer_phone, customer_email, customer_country, create_date , update_date, customer_name) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, NOW(), NOW(), ?) ";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			stmt = conn.prepareStatement(sql); //쿼리 실행
			stmt.setString(1, customer.getCustomerId());
			stmt.setString(2, customer.getCustomerPw());
			stmt.setString(3, customer.getCustomerGender());
			stmt.setInt(4, customer.getCustomerAge());
			stmt.setString(5, customer.getCustomerPhone());
			stmt.setString(6, customer.getCustomerEmail());
			stmt.setString(7, customer.getCustomerCountry());
			stmt.setString(8, customer.getCustomerName());
			row = stmt.executeUpdate(); 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	// 국가선택(selectCountry)
		public List<Country> selectCountry() {
			List<Country> list = new ArrayList<Country>(); //리스트로 객체생성
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql = "SELECT country "
					+ "from country";
			try {
				conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
				stmt = conn.prepareStatement(sql); //쿼리 실행
				rs = stmt.executeQuery();
				while(rs.next()) { // while 안에서 초기화
					Country c =  new Country();
					c.setCountry(rs.getString("country"));
					list.add(c);
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
			return list;
		}
}
