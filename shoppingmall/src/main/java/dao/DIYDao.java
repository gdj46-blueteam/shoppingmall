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

import vo.Announcement;
import vo.Language;
import vo.TourArea;
import vo.TourDIY;

public class DIYDao {
	public void tourDIYList() {          //DIY리스트
		
		List<HashMap<String,Object>> List = new ArrayList<HashMap<String,Object>>();
		Map<String,Object> map;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			String sql = " 	 SELECT tourDiy_no tourdiyNo, customer_id customerId,language,city, tourdiy_people tourDiyPeople, tourdiy_term tourDIYTERM, tourdiy_stay tourDiyStay,"
					+ " tourDiy_etc, create_date createDate FROM tourdiy t "
					+ "INNER JOIN language l ON t.language_no = l.language_no INNER JOIN tourarea ta ON t.tourArea_No = ta.tourarea_no;";
			
			stmt = conn.prepareStatement(sql); //쿼리문 실행
			rs = stmt.executeQuery();
			
			while(rs.next()) { //결과값 넣기
				map =new HashMap<>();
				
				
//				map.put("cashBookNo",rs.getInt("cashBookNo"));
//				map.put("day",rs.getInt("day"));
//				map.put("kind",rs.getString("kind"));
//				map.put("cash",rs.getInt("cash"));
//				map.put("memo",rs.getString("memo"));
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

		return ;
		
	}
	public void insertDIY() {			
		List<HashMap<String,Object>> List = new ArrayList<HashMap<String,Object>>();
		Map<String,Object> map;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			String sql = " 	 SELECT tourDiy_no tourdiyNo, customer_id customerId,language,city, tourdiy_people tourDiyPeople, tourdiy_term tourDIYTERM, tourdiy_stay tourDiyStay,"
					+ " tourDiy_etc, create_date createDate FROM tourdiy t "
					+ "INNER JOIN language l ON t.language_no = l.language_no INNER JOIN tourarea ta ON t.tourArea_No = ta.tourarea_no;";
			
			stmt = conn.prepareStatement(sql); //쿼리문 실행
			rs = stmt.executeQuery();
			
			while(rs.next()) { //결과값 넣기
				map =new HashMap<>();
				
				
//				map.put("cashBookNo",rs.getInt("cashBookNo"));
//				map.put("day",rs.getInt("day"));
//				map.put("kind",rs.getString("kind"));
//				map.put("cash",rs.getInt("cash"));
//				map.put("memo",rs.getString("memo"));
				
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

		return ;
	}
	public List<TourArea> TourAreaList() {
		List<TourArea> tourArealist = new ArrayList<TourArea>();
		TourArea tourArea;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			String sql = " 	SELECT tourArea_no tourAreaNo, AREA, city FROM tourarea";
			
			stmt = conn.prepareStatement(sql); //쿼리문 실행
			rs = stmt.executeQuery();
			
			while(rs.next()) { //결과값 넣기
				tourArea = new TourArea();
				tourArea.setTourAreaNo(rs.getInt("tourAreaNo"));
				tourArea.setArea(rs.getString("area"));
				tourArea.setCity(rs.getString("city"));
				tourArealist.add(tourArea);
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
		return tourArealist;
	}
	public List<Language> LanguageList() {
		List<Language> languagelist = new ArrayList<Language>();
		Language language;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			String sql = " 	SELECT language_no languageNo, language from language";
			
			stmt = conn.prepareStatement(sql); //쿼리문 실행
			rs = stmt.executeQuery();
			
			while(rs.next()) { //결과값 넣기
				language = new Language();
				language.setLanguageNo(rs.getInt("languageNo"));
				language.setLanguage(rs.getString("language"));
				languagelist.add(language);
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
		return languagelist;
	}
	public void insertTourDIY(TourDIY tourDIY) {
		System.out.println(tourDIY);
		tourDIY.setCustomerId("guest");									//임의의 게스트값 삽입 (########삭제)
		List<TourDIY> tourDIYList = new ArrayList<TourDIY>();
		Language language;
		Connection conn = null;
		PreparedStatement stmt = null;
		int rs = 0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			String sql = " 	insert into tourDIY(customer_id, language_no, tourArea_no, tourDIY_People, tourDIY_Stay,"
					+ " tourDIY_Etc,tourdiy_term, create_date) values(?,?,?,?,?,?,?,now())";
			
			stmt = conn.prepareStatement(sql); //쿼리문 실행
			stmt.setString(1, tourDIY.getCustomerId());
			stmt.setInt(2, tourDIY.getLanguageNo());
			stmt.setInt(3, tourDIY.getTourAreaNo());
			stmt.setInt(4, tourDIY.getTourDIYPeople());
			stmt.setString(5, tourDIY.getTourDIYStay());
			stmt.setString(6, tourDIY.getTourDIYEtc());
			stmt.setString(7, tourDIY.getTourDIYTerm());
			rs = stmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//DB자원 반납
				//rs.close();
				stmt.close();
				conn.close();
			}catch(SQLException e) {
			e.printStackTrace();
			}
		
		}
		//return languagelist;
	}
}
