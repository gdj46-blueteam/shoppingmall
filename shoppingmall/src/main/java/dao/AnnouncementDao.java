package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Announcement;

public class AnnouncementDao {
	//공지사항 리스트 
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
	
	//SelectAnnouncementOne 공지사항 상세보기
	public Announcement SelectAnnouncementOne(int announcementNo) {// 반환값 Announcement로 생성, announcement_no값으로 상세보기 값 가져옴
		Announcement announcement = null; // announcement 값 null로 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT announcement_no announcementNo, announcement_title announcementTitle, announcement_content announcementContent, create_date createDate "
				+ "				FROM announcement "
				+ "				WHERE announcement_no = ? ";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, announcementNo);
			rs = stmt.executeQuery();
			if(rs.next()) {
				announcement  = new Announcement();
				announcement.setAnnouncementNo(rs.getInt("announcementNo"));
				announcement.setAnnouncementTitle(rs.getString("announcementTitle"));
				announcement.setAnnouncementContent(rs.getString("announcementContent"));
				announcement.setCreateDate(rs.getString("createDate"));
			 
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return announcement;


	}
	//Delete announcement 공지사항 삭제하기
	public int deleteAnno(int announcementNo) {
		int row = 0;
		//DB
		Connection conn = null;
		PreparedStatement stmt = null;	
		String sql =" DELETE FROM announcement WHERE announcement_no = ? ";
				
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, announcementNo);	
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

	public int updateAnno(Announcement announcement) {
		int row = 0;
		//DB
		Connection conn = null;
		PreparedStatement stmt = null;	
		String sql = "UPDATE announcement "
				+ " SET announcement_title= ? , announcement_content= ? "
				+ " WHERE announcement_no = ? ";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, announcement.getAnnouncementTitle());
			stmt.setString(2, announcement.getAnnouncementContent());
			stmt.setInt(3, announcement.getAnnouncementNo());
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

	
}
