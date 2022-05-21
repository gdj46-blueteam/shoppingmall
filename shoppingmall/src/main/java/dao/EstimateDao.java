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

import vo.TourDIY;

public class EstimateDao {
	//견적서 조회
		public List<Map<String,Object>> selectEstimate() {
			List<Map<String, Object>> list = new ArrayList<>();
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
				String sql = 	"	 SELECT tourDiy_no tourDIYNo, customer_id customerId, language, city, tourdiy_people tourDIYPeople, tourdiy_term tourDIYTerm, tourdiy_stay tourDIYStay, tourDiy_etc tourDIYEtc, create_date createDate FROM tourdiy t"
						+ "	  INNER JOIN language l ON t.language_no = l.language_no INNER JOIN tourarea ta ON t.tourArea_No = ta.tourarea_no";
				stmt = conn.prepareStatement(sql); //쿼리문 실행
				System.out.println(sql + "<-selectEstimate");
				rs = stmt.executeQuery();
				while(rs.next()) {
					Map<String, Object> map = new HashMap<>();
					map.put("tourDIYNo", rs.getInt("tourDIYNo"));
					map.put("customerId", rs.getString("customerId"));
					map.put("language", rs.getString("language"));
					map.put("city", rs.getString("city"));
					map.put("tourDIYPeople", rs.getInt("tourDIYPeople"));
					map.put("tourDIYTerm", rs.getString("tourDIYTerm"));
					map.put("tourDIYStay", rs.getString("tourDIYStay"));
					map.put("tourDIYEtc", rs.getString("tourDIYEtc"));
					map.put("createDate", rs.getString("createDate"));
					list.add(map);	
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
			//반환
			return list;
		}
		
}
