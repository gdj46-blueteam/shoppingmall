package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Admin;


public class AdminDao {
	
	// selectAdminOne(관리자정보상세보기)
	public Admin selectAdminOne(String adminId) throws Exception {
		Admin admin = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql ="SELECT admin_id adminId, admin_pw adminPw, admin_phone adminPhone, admin_email adminEmail, adminAddress_id adminAddressId, admin_addressDetail adminAddressDetail, create_date createDate, authority "
				+ "	FROM admin "
				+ "	WHERE admin_id = ?";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, adminId);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
			admin = new Admin();
			admin.setAdminId(rs.getString("adminId"));
			admin.setAdminPw(rs.getString("adminPw"));
			admin.setAdminPhone(rs.getString("adminPhone"));
			admin.setAdminEmail(rs.getString("adminEmail"));
			admin.setAdminAddressId(rs.getInt("adminAddressId"));
			admin.setAddressDetail(rs.getString("adminAddressDetail"));
			admin.setcreateDate(rs.getString("createDate"));
			admin.setauthority(rs.getInt("authority"));
			}
			System.out.println(admin +"<---selectAdminOne ");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return admin;
	}
}
