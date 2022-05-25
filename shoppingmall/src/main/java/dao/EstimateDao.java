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
import vo.Estimate;
import vo.TourDIY;

public class EstimateDao {
	public List<Map<String, Object>> insertEstimate(Map<String,Object> map) {		//직원-언어 출력( 견적서 해당 날짜에 배치된 직원은 제외)
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> empLanguagemap;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql ="SELECT emp.employee_no employeeNo, emp.employee_name employeeName, l.language "
					+ "FROM employee emp "
					+ "INNER JOIN employee_language el ON el.employee_no = emp.employee_no "					//견적서에 배치된 직원은 제외
					+ "INNER JOIN language l oN l.language_no = el.language_no "
					+ "WHERE emp.employee_no NOT IN  "
					+ "(SELECT est.employee_no FROM estimate est "
					+ "INNER JOIN (SELECT * from tourdiy where tourdiy_term = ?) tdy ON est.tourdiy_no = tdy.tourdiy_no ) "
					+ "AND l.language = ?";
			stmt = conn.prepareStatement(sql); //쿼리문 실행
			stmt.setString(1, (String) map.get("tourDIYTerm"));
			stmt.setString(2, (String) map.get("language"));
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				empLanguagemap= new HashMap<String, Object>();
				empLanguagemap.put("employeeNo", rs.getInt("employeeNo"));
				empLanguagemap.put("employeeName", rs.getString("employeeName"));
				empLanguagemap.put("langauge", rs.getString("language"));
				
				
				list.add(empLanguagemap);
			}
			System.out.println(list.size() + " < ---   insertEstimateDao");
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
	public int insertEstimate(Estimate est) {				//DIY -> 관리자가 직원 배치, 금액 설정 후  견적서로 삽입	
		Connection conn = null;
		PreparedStatement stmt = null;
		est.setEstimateIng("관리자확인"); 	   		//견적서 상태 초기값 설정	

		int row= 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into estimate(tourdiy_no, admin_id, employee_no, estimate_price, estimate_ing, create_date, update_date) "
					+ "values(?,?,?,?,?,now(),now())";
			
			stmt = conn.prepareStatement(sql); //쿼리문 실행
			stmt.setInt(1, est.getTourdiyNo());
			stmt.setString(2, est.getAdminId());
			stmt.setInt(3, est.getEmployeeNo());
			stmt.setInt(4, est.getEstimatePrice());
			stmt.setString(5, est.getEstimateIng());
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
	
	public List<Map<String, Object>> selectEstimateByAdminList() { 							// 관리자 견적서 리스트 조회
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT est.estimate_no estimateNo, customer_id customerId, language, city, tourdiy_people tourDIYPeople,"
					+ " est.estimate_price estimatePrice, emp.employee_name employeeName, "
					+ "tourdiy_term tourDIYTerm, tourdiy_stay tourDIYStay, tourDiy_etc tourDIYEtc, est.create_date createDate,"
					+ " est.update_date updateDate FROM tourdiy t "
					+ " INNER JOIN language l ON t.language_no = l.language_no "
					+ "INNER JOIN tourarea ta ON t.tourArea_No = ta.tourarea_no "
					+ "INNER JOIN estimate est ON est.tourdiy_no = t.tourdiy_no "
					+ "INNER JOIN employee emp ON emp.employee_no = est.employee_no";
			stmt = conn.prepareStatement(sql); //쿼리문 실행
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				map = new HashMap<String, Object>();
				map.put("estimateNo", rs.getInt("estimateNo"));
				map.put("customerId", rs.getString("customerId"));
				map.put("language", rs.getString("language"));
				map.put("city", rs.getString("city"));
				map.put("estimatePrice", rs.getInt("estimatePrice"));
				map.put("tourDIYPeople", rs.getInt("tourDIYPeople"));
				map.put("employeeName", rs.getString("employeeName"));
				map.put("tourDIYTerm", rs.getString("tourDIYTerm"));
				map.put("tourDIYStay", rs.getString("tourDIYStay"));
				map.put("tourDIYEtc", rs.getString("tourDIYEtc"));
				map.put("createDate", rs.getString("createDate"));
				map.put("updateDate", rs.getString("updateDate"));
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
	public Map<String, Object> selectEstOne(int EstimateNo) { 						// 관리자 견적서 상세보기
		Map<String, Object> map = new HashMap<String, Object>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT est.estimate_no estimateNo,est.tourDIY_no tourDIYNo, customer_id customerId, language, city, tourdiy_people tourDIYPeople,"
					+ " est.estimate_price estimatePrice, emp.employee_name employeeName, est.estimate_ing estimateIng, "
					+ "tourdiy_term tourDIYTerm, tourdiy_stay tourDIYStay, tourDiy_etc tourDIYEtc, est.create_date createDate,"
					+ " est.update_date updateDate FROM tourdiy t "
					+ " INNER JOIN language l ON t.language_no = l.language_no "
					+ "INNER JOIN tourarea ta ON t.tourArea_No = ta.tourarea_no "
					+ "INNER JOIN estimate est ON est.tourdiy_no = t.tourdiy_no "
					+ "INNER JOIN employee emp ON emp.employee_no = est.employee_no where est.estimate_No= ?";
			stmt = conn.prepareStatement(sql); //쿼리문 실행
			stmt.setInt(1, EstimateNo);
			rs = stmt.executeQuery();
			
			while(rs.next()) {

				map.put("estimateNo", rs.getInt("estimateNo"));
				map.put("tourDIYNo", rs.getInt("tourDIYNo"));
				map.put("customerId", rs.getString("customerId"));
				map.put("language", rs.getString("language"));
				map.put("city", rs.getString("city"));
				map.put("estimatePrice", rs.getInt("estimatePrice"));
				map.put("tourDIYPeople", rs.getInt("tourDIYPeople"));
				map.put("employeeName", rs.getString("employeeName"));
				map.put("tourDIYTerm", rs.getString("tourDIYTerm"));
				map.put("estimateIng", rs.getString("estimateIng"));
				map.put("tourDIYStay", rs.getString("tourDIYStay"));
				map.put("tourDIYEtc", rs.getString("tourDIYEtc"));
				map.put("createDate", rs.getString("createDate"));
				map.put("updateDate", rs.getString("updateDate"));
	
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
	
	public int deleteEstimate(int estimateNo,int tourDIYNo) {					//견적서 삭제(DIY도 같이 삭제)
		Connection conn = null;
		PreparedStatement stmt= null;
		PreparedStatement stmt2 = null;	
		int row =0;
		try {
			conn = DBUtil.getConnection();
			String deleteEstSql = "delete from estimate where estimate_No= ?";
			
			stmt = conn.prepareStatement(deleteEstSql);											 //견적서 삭제 쿼리문 실행
			stmt.setInt(1, estimateNo);
			String deleteDIYSql = "delete from DIY where tourDIY_no=? ";						//DIY 삭제 쿼리문 실행
			stmt2 = conn.prepareStatement(deleteDIYSql);
			stmt.setInt(1, tourDIYNo);
			stmt.executeUpdate();
			row = stmt2.executeUpdate();

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
	public int  updateEstimate(Estimate estimate) {

		Connection conn = null;
		PreparedStatement stmt= null;
		PreparedStatement stmt2 = null;	
		int row =0;
		System.out.println(estimate +"updateEstimate" );
		try {
			conn = DBUtil.getConnection();
			String EstSql="UPDATE estimate SET employee_no = ?,estimate_price = ?, estimate_ing = ?, update_date = NOW()"
		               + " WHERE estimate_no =?";
			
			stmt = conn.prepareStatement(EstSql);											 ///견적서 수정쿼리문
			stmt.setInt(1, estimate.getEmployeeNo());
			stmt.setInt(2, estimate.getEstimatePrice());
			stmt.setString(3, estimate.getEstimateIng());
			stmt.setInt(4, estimate.getEstimateNo());

			

			row=stmt.executeUpdate();

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
	public List<Map<String,Object>> selectEstimateByCustomerList(String id) {			//고객 견적서리스트 조회
		List<Map<String,Object>> list = new ArrayList<>();
		Map<String,Object> map;
		Connection conn = null;
		PreparedStatement stmt= null;
		PreparedStatement stmt2 = null;	
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT est.estimate_no estimateNo, customer_id customerId, language, city, tourdiy_people tourDIYPeople, est.tourDIY_no tourDIYNo, "
					+ "est.estimate_price estimatePrice, emp.employee_name employeeName, "
					+ "tourdiy_term tourDIYTerm, tourdiy_stay tourDIYStay, tourDiy_etc tourDIYEtc, est.create_date createDate,  "
					+ "est.update_date updateDate FROM tourdiy t  "
					+ "INNER JOIN language l ON t.language_no = l.language_no  "
					+ "INNER JOIN tourarea ta ON t.tourArea_No = ta.tourarea_no  "
					+ "INNER JOIN estimate est ON est.tourdiy_no = t.tourdiy_no  "
					+ "iNNER JOIN employee emp ON emp.employee_no = est.employee_no where customer_id = ?";
			
			stmt = conn.prepareStatement(sql);											 
			stmt.setString(1, id);								

			rs = stmt.executeQuery();
			while(rs.next()) {
				map = new HashMap<String, Object>();
				map.put("estimateNo", rs.getInt("estimateNo"));
				map.put("customerId", rs.getString("customerId"));
				map.put("language", rs.getString("language"));
				map.put("tourDIYNo", rs.getString("tourDIYNo"));
				map.put("city", rs.getString("city"));
				map.put("estimatePrice", rs.getInt("estimatePrice"));
				map.put("tourDIYPeople", rs.getInt("tourDIYPeople"));
				map.put("employeeName", rs.getString("employeeName"));
				map.put("tourDIYTerm", rs.getString("tourDIYTerm"));
				map.put("tourDIYStay", rs.getString("tourDIYStay"));
				map.put("tourDIYEtc", rs.getString("tourDIYEtc"));
				map.put("createDate", rs.getString("createDate"));
				map.put("updateDate", rs.getString("updateDate"));
				list.add(map);
			}

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

		return list;
		
	}
	
}
