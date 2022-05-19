package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Review;

public class ReviewDao {
	//리뷰 리스트
	public List<Review> selecteReview(){ // 반환값 List
	List<Review> ReviewList = new ArrayList<Review>();
	Review r = null; // Review 값 null로 준비
		
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
		
	try {
		Class.forName("org.mariadb.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
		String sql = " SELECT review_no reviewNo , customer_id customerId, review review, tourdiy_no tourydiyNo, estimate_no estimateNo, create_date createDate, update_date updateDate "
				+ 	 " FROM review "; 
		stmt = conn.prepareStatement(sql); //쿼리문 실행
		rs = stmt.executeQuery();
		
		while(rs.next()) { //결과값 넣기
			r = new Review();
			r.setReviewNo(rs.getInt("reviewNo"));
			r.setCustomerId(rs.getString("customerId"));
			r.setReview(rs.getString("Review"));
			r.setTourDIYNo(rs.getInt("tourDIYNo"));
			r.setEstimateNo(rs.getInt("estimateNo"));
			r.setCreateDate(rs.getString("createDate"));
			r.setUpdateDate(rs.getString("UpdateDate"));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		
		}finally {
			try {
				//DB자원 반납
				rs.close();
				stmt.close();
				conn.close();
			}catch(SQLException e) {
			e.printStackTrace();
		}
	}
			return ReviewList;
		}
}
