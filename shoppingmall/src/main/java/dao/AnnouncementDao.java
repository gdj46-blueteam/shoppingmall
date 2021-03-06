package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import vo.Announcement;

public class AnnouncementDao {
	//공지사항 리스트 
	public List<Announcement> SelectAnnouncementList() { // List로 반환
		List<Announcement> acList = new ArrayList<Announcement>();
		Announcement ac = null; //
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = " SELECT announcement_no announcementNo, announcement_title announcementTitle, announcement_content announcementContent, create_date createDate "
					+ 	 " FROM announcement ";
			
			stmt = conn.prepareStatement(sql); //쿼리문 실행
			rs = stmt.executeQuery();
			
			while(rs.next()) { //객체를 while 안에서 초기화 
				ac = new Announcement();//객체를 while 문 안에서 초기화
				ac.setAnnouncementNo(rs.getInt("announcementNo"));
				ac.setAnnouncementTitle(rs.getString("announcementTitle"));
				ac.setAnnouncementContent(rs.getString("announcementContent"));
				ac.setCreateDate(rs.getString("createDate"));
				
//				map.put("cashBookNo",rs.getInt("cashBookNo"));
//				map.put("day",rs.getInt("day"));
//				map.put("kind",rs.getString("kind"));
//				map.put("cash",rs.getInt("cash"));
//				map.put("memo",rs.getString("memo"));
				acList.add(ac); // 가져온 값 추가
			}
			System.out.println("AnnouncementNo"+rs.getInt("announcementNo"));
			System.out.println("AnnouncementTitle"+rs.getInt("announcementTitle"));
			System.out.println("AnnouncementContent"+rs.getInt("announcementContent"));
			System.out.println("CreateDate"+rs.getInt("CreateDate"));
			
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
	
	// 공지사항 상세보기
	public Announcement selectAnnouncementOne(int announcementNo) {// 반환값 Announcement로 생성, announcement_no값으로 상세보기 값 가져옴
		Announcement announcement = new Announcement(); // announcement 값 null로 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT announcement_no announcementNo, announcement_title announcementTitle, announcement_content announcementContent, create_date createDate "
				+ "				FROM announcement "
				+ "				WHERE announcement_no = ? ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);//쿼리 실행
			stmt.setInt(1, announcementNo);
			rs = stmt.executeQuery();
			while(rs.next()) { // 객체를 while 안에서 초기화
				announcement.setAnnouncementNo(rs.getInt("announcementNo"));
				announcement.setAnnouncementTitle(rs.getString("announcementTitle"));
				announcement.setAnnouncementContent(rs.getString("announcementContent"));
				announcement.setCreateDate(rs.getString("createDate"));
				//디버깅
				System.out.println("announcementNo---" + rs.getInt("announcementNo"));
				System.out.println("announcementTitle---" + rs.getString("announcementTitle"));
				System.out.println("announcementContent---" + rs.getString("announcementContent"));
				System.out.println("createDate---" + rs.getString("createDate"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();	
		} finally {
			try {
				//DB자원 반납
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return announcement;
	}
	// 공지사항 삭제하기
	public int deleteAnno(int announcementNo) {
		int row = 0;
		//DB
		Connection conn = null;
		PreparedStatement stmt = null;	
		String sql =" DELETE FROM announcement WHERE announcement_no = ? ";
				
		try { 
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, announcementNo);	
			System.out.println("deleteAnno----"+stmt);
			
			row = stmt.executeUpdate();//쿼리 실행
			
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
	//공지사항 수정
	public int updateAnno(Announcement announcement) {
		int row = 0;
		//DB
		Connection conn = null;
		PreparedStatement stmt = null;	
		String sql = "UPDATE announcement "
				+ " SET announcement_title= ? , announcement_content= ? "
				+ " WHERE announcement_no = ? ";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql); //퀴리문 실행
			stmt.setString(1, announcement.getAnnouncementTitle());
			stmt.setString(2, announcement.getAnnouncementContent());
			stmt.setInt(3, announcement.getAnnouncementNo());
			System.out.println("updateAnno----"+stmt);
			System.out.println(" ");
			row = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//DB자원 반납
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}

	

	//공지사항 입력
	public int insertanno(Announcement announcement) {
	int row = 0;
	 Connection conn = null;
     PreparedStatement stmt = null;
     
     String sql = "INSERT INTO announcement(announcement_title, announcement_content, create_date)"
     			+ "VALUES(?, ?, NOW())";
     
     try {
    	 conn = DBUtil.getConnection();
         stmt = conn.prepareStatement(sql); //쿼리문 실행
        
         stmt.setString(1, announcement.getAnnouncementTitle());
         stmt.setString(2, announcement.getAnnouncementContent());
      

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
}
