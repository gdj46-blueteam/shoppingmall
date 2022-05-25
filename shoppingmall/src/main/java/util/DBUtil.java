package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//공통되는 db
public class DBUtil {
	public static Connection getConnection() { //필드가 없으므로 static으로 생성
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");//드라이버 생성
			//db연결
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
