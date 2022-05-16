package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Tour;

public class TourDao {
	//입력
	public void insertTour() {
		int row = 0;
		Connection conn = null;
		PreparedStatement tourAreaStmt = null;
		PreparedStatement tourImageStmt = null;
		PreparedStatement tourStmt = null;
		String touAareaSql = "insert into tourarea(area, city) values(?,?)";
		String tourImageSql = "insert into tourimage(tourimage_name tourImageName, tourimage_type tourImageType, create_date createDate) values(?,?,now())";
		String tourSql = "insert into tour(tour_name tourName, tour_description, tourimage_no) values(?,?,?)";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			conn.setAutoCommit(false);
			tourAreaStmt = conn.prepareStatement(touAareaSql);
			tourImageStmt = conn.prepareStatement(tourImageSql);
			tourStmt = conn.prepareStatement(tourSql);
			row = tourAreaStmt.executeUpdate();
			row = tourImageStmt.executeUpdate();
			row = tourStmt.executeUpdate();
			conn.commit();
			if(row == 0) {
				System.out.println("입력실패");
			} else {
				System.out.println("입력성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//수정
	public int updateTour(int tourNo) {
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		//수정하는 쿼리문
		String sql = "update tour set tour_no = ?, tourarea_id = ?, tour_name = ?, tour_description = ?, tourimage_no = ? where tour_name = ?";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			stmt = conn.prepareStatement(sql);//쿼리실행
			stmt.setInt(1, tourNo);
			
			row = stmt.executeUpdate();
			if(row == 0) {
				System.out.println("수정실패");
			} else {
				System.out.println("수정성공");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	//삭제
	public void deleteTour() {
	}
	//상세보기
	public int selectTourListOne(int tourNo){
		Tour tour;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//상세보기 쿼리문
		String sql = "select tour_no tourNo, tourarea_id tourAreaId, tour_name tourName, tour_description tourDescription, tourimage_no tourImageNo from tour where tour_no = ?";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			stmt = conn.prepareStatement(sql);//쿼리실행
			stmt.setInt(1, tourNo);
			rs = stmt.executeQuery();//결과값 저장
			while(rs.next()) {
				tour = new Tour();
				tour.setTourNo(rs.getInt("tourNo"));
				tour.setTourAreaId(rs.getInt("tourAreaId"));
				tour.setTourName(rs.getString("tourName"));
				tour.setTourDescription(rs.getString("tourDescription"));
				tour.setTourImageNo(rs.getInt("tourImageNo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tourNo;
		
	}
	//조회
	public List<Tour> selectTourList() { //관광리스트 조회
		List<Tour> tourList = new ArrayList<>();
		Tour tour;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//관광리스트 조회하는 쿼리문
		String sql =  " SELECT tour_no tourNo, tourarea_id tourareaId, tour_name tourName, tour_description tourDescription,"
					+ "	tourimage_no tourImageNo FROM tour";
		try {
			//DB접속
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			stmt = conn.prepareStatement(sql);//쿼리실행
			rs = stmt.executeQuery();//쿼리문 실행값 저장
			//커서가 잡히고 리스트에서 선택되는 행을 바꿈, 내려갈행이 있다면 값을 가져오고 아니면 빠져나감
			while(rs.next()) {		
				//데이터 저장을 위한 객체생성
				tour = new Tour();
				//객체에 각 조회된 결과값을 저장
				tour.setTourNo(rs.getInt("tourNo"));
				tour.setTourAreaId(rs.getInt("tourareaId"));
				tour.setTourName(rs.getString("tourName"));
				tour.setTourDescription(rs.getString("tourDescription"));
				tour.setTourImageNo(rs.getInt("tourImageNo"));
				tourList.add(tour);
				//디버깅
				System.out.println(tour+"<-tour");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		//반환
		return tourList;
	}
	
}
