package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import vo.*; 
public class StaticsDao {
	//페이징
	//통계 검색 메소드
	//1.나라
	public List<Map<String, Object>> StaticsByCountry(){
		List<Map<String, Object>> list = new ArrayList<>(); //map형으로 list에 값 저장
		
		//데이터베이스 연결
		//데이터케이스 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		 
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234"); //DB에 연결한다.
			String sql ="select country, COUNT(country) cnt, RANK() over(ORDER BY cnt desc) rank"
					+ " from statics_list GROUP BY country order by rank limit ?,?";
			stmt = conn.prepareStatement(sql); //쿼리문 실행
			System.out.println("stmt(StaticsDaoByCountry) ->" + stmt);
			
			rs = stmt.executeQuery(); //실행된 쿼리문 결과 저장
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("country", rs.getString("country"));
				map.put("cnt", rs.getString("cnt"));
				map.put("rank", rs.getString("rank"));
				list.add(map); //list에 map에 저장된 값 추가
				System.out.println("rs(StaticsDaoByCountry)->" + rs);
				System.out.println("list(StaticsDaoByCountry)->" + list.size());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	//2.성별
	public List<Map<String, Object>> StaticsByGender(){
		List<Map<String, Object>> list = new ArrayList<>(); //map형으로 list에 값 저장
		
		//데이터베이스 연결
		//데이터케이스 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		 
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234"); //DB에 연결한다.
			String sql ="select gender, COUNT(gender) cnt, RANK() over(ORDER BY cnt desc) rank"
					+ " from statics_list GROUP BY gender order by rank limit ?,?";
			stmt = conn.prepareStatement(sql); //쿼리문 실행
			System.out.println("stmt(StaticsDaoByGender) ->" + stmt);
			
			rs = stmt.executeQuery(); //실행된 쿼리문 결과 저장
			while(rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("gender", rs.getString("gender"));
				map.put("cnt", rs.getString("cnt"));
				map.put("rank", rs.getString("rank"));
				list.add(map); //list에 map에 저장된 값 추가
				System.out.println("rs(StaticsDaoByGender) ->" + rs);
				System.out.println("list(StaticsDaoByGender) ->" + list.size());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	//3.나이
	public List<Map<String, Object>> StaticsByAge(){
		List<Map<String, Object>> list = new ArrayList<>(); //map형으로 list에 값 저장
		
		//데이터베이스 연결
		//데이터케이스 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		 
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234"); //DB에 연결한다.
			String sql ="select age, COUNT(age) cnt, RANK() over(ORDER BY cnt desc) rank"
					+ " from statics_list GROUP BY age order by rank limit ?,?";
			stmt = conn.prepareStatement(sql); //쿼리문 실행
			System.out.println("stmt(StaticsDaoByAge) ->" + stmt);
			
			
			rs = stmt.executeQuery(); //실행된 쿼리문 결과 저장
			while(rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("age", rs.getString("age"));
				map.put("cnt", rs.getString("cnt"));
				map.put("rank", rs.getString("rank"));
				list.add(map); //list에 map에 저장된 값 추가
				System.out.println("rs(StaticsDaoByAge)->" + rs);
				System.out.println("list(StaticsDaoByAge)->" + list.size());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	//4.월별
	public List<Map<String, Object>> StaticsByMonth(){
		List<Map<String, Object>> list = new ArrayList<>(); //map형으로 list에 값 저장
		
		//데이터베이스 연결
		//데이터케이스 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		 
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234"); //DB에 연결한다.
			String sql ="select month, COUNT(month) cnt, RANK() over(ORDER BY cnt desc) rank"
					+ " from statics_list GROUP BY month order by rank limit ?,?";
			stmt = conn.prepareStatement(sql); //쿼리문 실행
			System.out.println("stmt(StaticsDaoByMonth) -> " + stmt);
			
			rs = stmt.executeQuery(); //실행된 쿼리문 결과 저장
			while(rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("month", rs.getString("month"));
				map.put("cnt", rs.getString("cnt"));
				map.put("rank", rs.getString("rank"));
				list.add(map); //list에 map에 저장된 값 추가
				System.out.println("rs(StaticsDaoByMonth) ->" + rs);
				System.out.println("list(StaticsDaoByMonth) ->" + list.size());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	//5.지역
	public List<Map<String, Object>> StaticsByArea(){
		List<Map<String, Object>> list = new ArrayList<>(); //map형으로 list에 값 저장
		
		//데이터베이스 연결
		//데이터케이스 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		 
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234"); //DB에 연결한다.
			String sql ="select area, COUNT(area) cnt, RANK() over(ORDER BY cnt desc) rank"
					+ " from statics_list GROUP BY area order by rank limit ?,?";
			stmt = conn.prepareStatement(sql); //쿼리문 실행
			System.out.println("stmt(StaticsDaoByArea) -> " + stmt);
			
			rs = stmt.executeQuery(); //실행된 쿼리문 결과 저장
			while(rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("area", rs.getString("area"));
				map.put("cnt", rs.getString("cnt"));
				map.put("rank", rs.getString("rank"));
				list.add(map); //list에 map에 저장된 값 추가
				System.out.println("rs(StaticsDaoByArea) ->" + rs);
				System.out.println("list(StaticsDaoByArea) ->" + list.size());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	//6.전체
	public List<Map<String, Object>> StaticsByAll(){
		List<Map<String, Object>> list = new ArrayList<>(); //map형으로 list에 값 저장
		
		//데이터베이스 연결
		//데이터케이스 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		 
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234"); //DB에 연결한다.
			String sql ="select country,gender, age, month, area, COUNT(*) cnt, RANK() over(ORDER BY cnt desc) rank"
					+ " from statics_list "
					+ " GROUP BY country order by rank";
			stmt = conn.prepareStatement(sql); //쿼리문 실행
			System.out.println("stmt(StaticsDaoByAll) -> " + stmt);
			
			rs = stmt.executeQuery(); //실행된 쿼리문 결과 저장
			while(rs.next()) {
				Map<String, Object> map = new HashMap<>(); 
				map.put("country", rs.getString("country"));
				map.put("gender", rs.getString("gender"));
				map.put("age", rs.getString("age"));
				map.put("month", rs.getString("month"));
				map.put("area", rs.getString("area"));
				map.put("cnt", rs.getString("cnt"));
				map.put("rank", rs.getString("rank"));
				list.add(map); //list에 map에 저장된 값 추가
				System.out.println("rs(StaticsDaoByAll) ->" + rs);
				System.out.println("list(StaticsDaoByAll) ->" + list.size());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
