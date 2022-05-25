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

import util.DBUtil;
import vo.Review;
import vo.TourArea;

public class ReviewDao {
   //리뷰 리스트
   public List<Review> selecteReview(){ // 반환값 List
   List<Review> reviewList = new ArrayList<Review>();
   Review r = null; // Review 값 null로 준비

   Connection conn = null;
   PreparedStatement stmt = null;
   ResultSet rs = null;

   try {
      conn = DBUtil.getConnection();
      String sql = " SELECT review_no reviewNo , customer_id customerId, review review, tourdiy_no tourdiyNo, estimate_no estimateNo, create_date createDate, update_date updateDate "
            +     " FROM review "; 
      stmt = conn.prepareStatement(sql); //쿼리문 실행
      rs = stmt.executeQuery();

      while(rs.next()) { //결과값 넣기
         r = new Review();
         r.setReviewNo(rs.getInt("reviewNo"));
         r.setcustomerId(rs.getString("customerId"));
         r.setReview(rs.getString("Review"));
         r.settourdiyNo(rs.getInt("tourdiyNo"));
         r.setEstimateNo(rs.getInt("estimateNo"));
         r.setCreateDate(rs.getString("createDate"));
         r.setUpdateDate(rs.getString("UpdateDate"));
         reviewList.add(r);
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
         return reviewList;
      }
   
   // 리뷰 입력
   public int insertReview(Review review) {
      int row = 0;
      Connection conn = null;
      PreparedStatement stmt = null;
      
      String sql = "INSERT INTO review(customer_id, review, tourdiy_no, estimate_no, create_date, update_date)  "
            + "VALUES(?, ?, ?, ?, NOW(), NOW());";
      
      try {
         conn = DBUtil.getConnection();
         stmt = conn.prepareStatement(sql); //쿼리문 실행
         stmt.setString(1, review.getcustomerId());
         stmt.setString(2, review.getReview());
         stmt.setInt(3, review.gettourdiyNo());
         stmt.setInt(4, review.getEstimateNo());
         row = stmt.executeUpdate();
         
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
         try {
            //DB자원 반납
            stmt.close();
            conn.close();
         }catch(SQLException e) {
         e.printStackTrace();
      }
   }
      return row; 
   }
   
   // 리뷰 삭제
   public int delectReview(int reviewNo) {
      int row = 0;
      Connection conn = null;
      PreparedStatement stmt = null;
      
      String sql = "DELETE FROM review "
            + "WHERE review_no = ?";
      try {
         conn = DBUtil.getConnection();
         stmt = conn.prepareStatement(sql); //쿼리문 실행
         stmt.setInt(1, reviewNo);
         row = stmt.executeUpdate();
      }catch (Exception e) {
         e.printStackTrace();
      }finally {
         try {
            //DB자원 반납
            stmt.close();
            conn.close();
         }catch(SQLException e) {
         e.printStackTrace();
      }
   }
      return row;
   }


	// 리뷰 상세보기
	public Map<String, Object> selectReviewOne(int reviewNo){
		
		System.out.println(reviewNo+ "<---ReviewDao(selectReviewOne");
		Map<String, Object> map = new HashMap<String, Object>(); 
		Review review = new Review();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "sELECT r.review_no reviewNo, r.customer_id customerId, r.review, em.employee_name employeeName, ta.area, ta.city  "
				+ " FROM review r  "
				+ " INNER JOIN estimate e ON r.estimate_no = e.estimate_no  "
				+ " INNER JOIN employee em ON e.employee_no = em.employee_no "
				+ " INNER JOIN  tourdiy td ON td.tourdiy_no = r.tourdiy_no  "
				+ " INNER JOIN tourarea ta ON ta.tourarea_no = td.tourarea_no "
				+ " WHERE review_no = ? ";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);//쿼리 실행
			stmt.setInt(1, reviewNo);
			rs = stmt.executeQuery();
			if(rs.next());
			 map.put("ReviewNo",rs.getInt("reviewNo"));
			 map.put("CustomerId",rs.getString("CustomerId"));
			 map.put("review", rs.getString("review"));
			 map.put("EmployeeName",rs.getString("EmployeeName"));
			 map.put("area", rs.getString("area"));
			 map.put("city", rs.getString("city"));
			
			 System.out.println("ReviewNo"+rs.getInt("reviewNo"));
			 System.out.println("CustomerId"+rs.getString("CustomerId"));
			 System.out.println("review"+rs.getString("review"));
			 System.out.println("EmployeeName"+rs.getString("EmployeeName"));
			 System.out.println("area"+rs.getString("area"));
			 System.out.println("city"+rs.getString("city"));
			 
		} catch (Exception e) {
			e.printStackTrace();	
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
	return map;
}
	
	
	public List<TourArea> selectReviewConfirm(String customerId) {
		List<TourArea> list = new ArrayList<TourArea>();
		Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String sql = "SELECT ta.city city "
	    		+ "FROM tourdiy tdy "
	    		+ "INNER JOIN estimate est  "
	    		+ "ON est.tourdiy_no = tdy.tourdiy_no "
	    		+ "INNER JOIN tourarea ta  "
	    		+ "ON tdy.tourarea_no = ta.tourarea_no "
	    		+ "WHERE  est.estimate_ing = '결제완료' "
	    		+ "and tdy.tourdiy_no NOT IN (SELECT tourdiy_no FROM review) "
	    		+ "AND  tdy.customer_id = ? ";
	    try {
	         conn = DBUtil.getConnection();
	         stmt = conn.prepareStatement(sql); //쿼리문 실행
	         stmt.setString(1, customerId);
	         rs = stmt.executeQuery();
	         while(rs.next()) {
	        	 TourArea list2 = new TourArea();
	        	 list2.setCity(rs.getString("city"));
	        	 list.add(list2);
	         }
	      }catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         try {
	            //DB자원 반납
	            stmt.close();
	            conn.close();
	         }catch(SQLException e) {
	         e.printStackTrace();
	      }
	   }
		return list;
	}
	
}


