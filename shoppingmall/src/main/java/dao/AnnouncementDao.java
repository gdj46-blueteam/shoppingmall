package dao;

import java.sql.*;
import java.util.*;

import vo.Announcement;

public class AnnouncementDao {
	public List<Announcement> selectAnnouncementList( ) {
		List<Announcement> list = new ArrayList<Announcement>();
		Announcement announcement;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT announcement_no announcemetNo, announcement_title announcementTitle, announcement_content announcementContent, create_date createDate"
				+ " FROM announcement";
			
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			stmt = conn.prepareStatement(sql);
			/*
			stmt.setInt(1, announcement.getAnnouncementNo());
			stmt.setString(2, announcement.getAnnouncementTitle());
			stmt.setString(3, announcement.getAnnouncementContent());
			stmt.setString(4, announcement.getCreateDate());
			*/
			rs = stmt.executeQuery();
			while(rs.next()) {
				announcement = new Announcement();
				announcement.setAnnouncementNo(rs.getInt("announcemetNo"));
				announcement.setAnnouncementTitle(rs.getString("announcementTitle"));
				announcement.setAnnouncementContent(rs.getString("announcementContent"));
				announcement.setCreateDate(rs.getString("CreateDate"));
				list.add(announcement);
				System.out.println(announcement.getAnnouncementNo());
			}
			
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return list;
	}
}

	

		


