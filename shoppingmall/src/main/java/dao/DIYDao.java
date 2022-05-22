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
	//
	public List<Map<String,Object>> selectDIYListExcept() { //관리자용 견적서가 없는 요구사항확인서 확인/대기중인 요구사항확인서
		List<Map<String, Object>> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			String sql = "SELECT t.tourdiy_no tourDIYNo, customer_id customerId, language, city, "
					+ " tourdiy_people tourDIYPeople, tourdiy_term tourDIYTerm, tourdiy_stay tourDIYStay, "
					+ " tourDiy_etc tourDIYEtc, t.create_date createDate FROM tourdiy t"
					+ " INNER JOIN language l ON t.language_no = l.language_no "
					+ " INNER JOIN tourarea ta ON t.tourArea_no = ta.tourarea_no "
					+ " INNER JOIN estimate e ON t.tourdiy_no != e.tourdiy_no";
			stmt = conn.prepareStatement(sql); //쿼리문 실행
			System.out.println(sql + "<-selectDIYListExcept");
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
	
	//요구사항확인서목록 조회
			public List<Map<String,Object>> selectEstimate() { //고객용
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
