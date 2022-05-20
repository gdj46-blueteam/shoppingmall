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
      conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
      String sql = " SELECT review_no reviewNo , customer_id customerId, review review, tourdiy_no tourydiyNo, estimate_no estimateNo, create_date createDate, update_date updateDate "
            +     " FROM review "; 
      stmt = conn.prepareStatement(sql); //쿼리문 실행
      rs = stmt.executeQuery();

      while(rs.next()) { //결과값 넣기
         r = new Review();
         r.setReviewNo(rs.getInt("reviewNo"));
         r.setcustomerId(rs.getString("customerId"));
         r.setReview(rs.getString("Review"));
         r.settourDIYNo(rs.getInt("tourDIYNo"));
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
   // 리뷰 입력
   public int insertReview(Review review) {
      int row = 0;
      Connection conn = null;
      PreparedStatement stmt = null;
      
      String sql = "INSERT INTO review(customer_id, review, tourdiy_no, estimate_no, create_date, update_date)  "
            + "VALUES(?, ?, ?, ?, NOW(), NOW());";
      
      try {
         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
         stmt = conn.prepareStatement(sql); //쿼리문 실행
         stmt.setString(1, review.getcustomerId());
         stmt.setString(2, review.getReview());
         stmt.setInt(3, review.gettourDIYNo());
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
         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
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
}