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
import vo.Announcement;
import vo.Language;
import vo.TourArea;
import vo.TourDIY;

public class DIYDao {
	
	public List<Map<String,Object>> selectDIYListExcept() { //관리자용 견적서가 없는 요구사항확인서 확인/대기중인 요구사항확인서
		List<Map<String, Object>> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			
			String sql = " SELECT tourdiy_no tourDIYNo, customer_id customerId, language, city, "
					+ " tourdiy_people tourDIYPeople, tourdiy_term tourDIYTerm, tourdiy_stay tourDIYStay, "
					+ "tourDiy_etc tourDIYEtc, t.create_date createDate  "
					+ "FROM tourdiy t  "
					+ "INNER JOIN language l ON t.language_no = l.language_no "
					+ "INNER JOIN tourarea ta ON t.tourArea_no = ta.tourarea_no "
					+ " WHERE t.tourdiy_no NOT IN (SELECT t.tourdiy_no FROM tourdiy t "
					+ "INNER JOIN estimate e ON t.tourdiy_no = e.tourdiy_no) ";
			stmt = conn.prepareStatement(sql); //쿼리문 실행

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
	
	//요구사항확인서목록 조회 //고객용
	public List<Map<String,Object>> selectDIY(String sessionId) { //고객용
		List<Map<String, Object>> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "	  SELECT t.tourdiy_no tourDIYNo, customer_id customerId, language, city, tourdiy_people tourDIYPeople"
					+ " , tourdiy_term tourDIYTerm, tourdiy_stay tourDIYStay, tp.transportation transportation, tk.tourkind tourkind"
					+ "	,tourdiy_etc tourDIYEtc, create_date createDate FROM tourdiy t"
					+ " INNER JOIN language l ON t.language_no = l.language_no"
					+ " INNER JOIN tourarea ta ON t.tourArea_No = ta.tourarea_no "
					+ " INNER JOIN tourdiy_transportation tt ON t.tourdiy_no = tt.tourdiy_no"
					+ " INNER JOIN transportation tp ON tt.transportation_no = tp.transportation_no"
					+ " INNER JOIN tourkind_diy td ON t.tourdiy_no = td.tourdiy_no"
					+ " INNER JOIN tourkind tk ON td.tourkind_no = tk.tourkind_no"
					+ " where customer_id = ?";
			stmt = conn.prepareStatement(sql); //쿼리문 실행

			stmt.setString(1, sessionId);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("tourDIYNo", rs.getInt("tourDIYNo"));
				map.put("customerId", rs.getString("customerId"));
				map.put("language", rs.getString("language"));
				map.put("transportation", rs.getString("transportation"));
				map.put("tourkind", rs.getString("tourkind"));
				map.put("city", rs.getString("city"));
				map.put("tourDIYPeople", rs.getInt("tourDIYPeople"));
				map.put("tourDIYTerm", rs.getString("tourDIYTerm"));
				map.put("tourDIYStay", rs.getString("tourDIYStay"));
				map.put("tourDIYEtc", rs.getString("tourDIYEtc"));
				map.put("createDate", rs.getString("createDate"));
				list.add(map);	
			}
			System.out.println(list + " selectDIY(고객용)");
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
	//관광지역		
	public List<TourArea> TourAreaList() {
		List<TourArea> tourArealist = new ArrayList<TourArea>();
		TourArea tourArea;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = " 	SELECT tourarea_no tourAreaNo, area, city FROM tourarea";
			
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
	//언어
	public List<Language> LanguageList() {
		List<Language> languagelist = new ArrayList<Language>();
		Language language;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
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
	//diy 입력
	public int insertTourDIY(TourDIY tourDIY,int transportationNo, int tourkindNo) {					
		System.out.println("tourDIY(tourDAO) : " + tourDIY);
		System.out.println("transportationNo(tourDAO) : " + transportationNo);
		System.out.println("tourkindNo(tourDAO) : " + tourkindNo);
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		PreparedStatement stmt3=null;
		ResultSet rs = null;
		int tourDIYNo =0;
		int row =0;
		try {
			//String sql = "SELECT tourDiy_no tourdiyNo, customer_id customerId,language,city, tourdiy_people tourDiyPeople, tourdiy_term tourDIYTERM, tourdiy_stay tourDiyStay,"
				//	+ " tourDiy_etc, create_date createDate FROM tourdiy t "
				//	+ "INNER JOIN language l ON t.language_no = l.language_no INNER JOIN tourarea ta ON t.tourArea_No = ta.tourarea_no;";
			conn = DBUtil.getConnection();
			String sql = "insert into tourdiy(customer_id, language_no, tourarea_no, tourdiy_people, tourdiy_stay,"
					+ " tourdiy_etc,tourdiy_term, create_date) values(?,?,?,?,?,?,?,now())";
			String sql2 ="insert into tourdiy_transportation(tourdiy_no, transportation_no) values(?,?)";
			String sql3 ="insert into tourkind_diy(tourdiy_no,tourkind_no) values(?,?)";
			
			stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); //쿼리문 실행
			
			stmt.setString(1, tourDIY.getCustomerId());
			stmt.setInt(2, tourDIY.getLanguageNo());
			stmt.setInt(3, tourDIY.getTourAreaNo());
			stmt.setInt(4, tourDIY.getTourDIYPeople());
			stmt.setString(5, tourDIY.getTourDIYStay());
			stmt.setString(6, tourDIY.getTourDIYEtc());
			stmt.setString(7, tourDIY.getTourDIYTerm());
			stmt.executeUpdate();
			
			rs=stmt.getGeneratedKeys();
			if(rs.next()) {
				tourDIYNo = rs.getInt(1);
				System.out.println(tourDIYNo + "tourDIYNo 기본키");
			}
			
			stmt2 = conn.prepareStatement(sql2);
			stmt2.setInt(1, tourDIYNo);
			stmt2.setInt(2, transportationNo);
			stmt2.executeUpdate();
			stmt3=conn.prepareStatement(sql3);
			stmt3.setInt(1, tourDIYNo);
			stmt3.setInt(2, tourkindNo);
			row = stmt3.executeUpdate();
			if(row == 1) {
				System.out.println("입력성공  insertTourDIY" + row);
			} else {
				System.out.println("입력실패  insertTourDIY" + row);
			}
			
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
		return row;
	}
	//diy 상세보기
	public Map<String,Object> selectDIYOne(int tourDIYNo) {							 //고객용 DIY상세보기
		Map<String, Object> map = new HashMap<String, Object>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 	"SELECT tourDiy_no tourDIYNo, customer_id customerId, language, city, tourdiy_people tourDIYPeople,"
					+ " tourdiy_term tourDIYTerm, tourdiy_stay tourDIYStay, tourdiy_etc tourDIYEtc, create_date createDate FROM tourdiy t"
					+ " INNER JOIN language l ON t.language_no = l.language_no "
					+ "INNER JOIN tourarea ta ON t.tourArea_No = ta.tourarea_no and tourDiy_no = ?" ;
			stmt = conn.prepareStatement(sql); //쿼리문 실행
			stmt.setInt(1, tourDIYNo);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				map.put("tourDIYNo", rs.getInt("tourDIYNo"));
				map.put("customerId", rs.getString("customerId"));
				map.put("language", rs.getString("language"));
				map.put("city", rs.getString("city"));
				map.put("tourDIYPeople", rs.getInt("tourDIYPeople"));
				map.put("tourDIYTerm", rs.getString("tourDIYTerm"));
				map.put("tourDIYStay", rs.getString("tourDIYStay"));
				map.put("tourDIYEtc", rs.getString("tourDIYEtc"));
				map.put("createDate", rs.getString("createDate"));
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
		return map;
	}
	
	//교통수단 출력
	public List<Map<String,Object>> transportationList() {
		List<Map<String,Object>> transportationList = new ArrayList<>();
		Map<String,Object> map;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = " 	SELECT transportation_no transportationNo, transportation from transportation";
			
			stmt = conn.prepareStatement(sql); //쿼리문 실행
			rs = stmt.executeQuery();
			
			while(rs.next()) { //결과값 넣기
				map = new HashMap<>();
				map.put("transportationNo", rs.getInt("transportationNo"));
				map.put("transportation", rs.getString("transportation"));
				transportationList.add(map);
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
		return transportationList;
	}
	
	//테마 출력
	public List<Map<String,Object>> tourkindList() {
		List<Map<String,Object>> tourkindList = new ArrayList<>();
		Map<String,Object> map;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = " 	SELECT tourkind_no tourkindNo, tourkind from tourkind";
			
			stmt = conn.prepareStatement(sql); //쿼리문 실행
			rs = stmt.executeQuery();
			while(rs.next()) { //결과값 넣기
				map = new HashMap<>();
				map.put("tourkindNo", rs.getInt("tourkindNo"));
				map.put("tourkind", rs.getString("tourkind"));
				tourkindList.add(map);
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
		return tourkindList;
	}
	
}
