package dao;

import java.sql.*;
import java.util.*;


import vo.Announcement;

public class AnnouncementDao {
	public List<Announcement> SelectAnnouncementList() { // List로 반환
		List<Announcement> acList = new ArrayList<Announcement>();
		Announcement ac = null; //ac값 = null로 준비
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			String sql = " SELECT announcement_no announcementNo, announcement_title announcementTitle, announcement_content announcementContent, create_date createDate "
					+ 	 " FROM announcement ";
			
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) { //결과값 넣기
				ac = new Announcement();
				ac.setAnnouncementNo(rs.getInt("announcementNo"));
				ac.setAnnouncementTitle(rs.getString("announcementTitle"));
			
//				map.put("cashBookNo",rs.getInt("cashBookNo"));
//				map.put("day",rs.getInt("day"));
//				map.put("kind",rs.getString("kind"));
//				map.put("cash",rs.getInt("cash"));
//				map.put("memo",rs.getString("memo"));
				acList.add(ac);
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

		return acList;
	}
	

	public Announcement SelectAnnouncementOne(int announcement_no) {// 반환값 Announcement로 생성, announcement_no값으로 상세보기 값 가져옴
		Announcement announcement = null; // announcement 값 null로 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT announcement_no , announcement_title announcementTitle, announcement_content announcementContent, create_date createDate "
				+ "				FROM announcement "
				+ "				WHERE announcement_no = ? ";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, announcement_no);
			rs = stmt.executeQuery();
			while(rs.next()) {
				announcement  = new Announcement();
				announcement.setAnnouncementNo(rs.getInt(announcement_no));
				announcement.setAnnouncementTitle(rs.getString("announcementTitle"));
				announcement.setAnnouncementContent(rs.getString("announcementContent"));
				announcement.setCreateDate(rs.getString("CreateDate"));
			 
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return announcement;


	}
}

