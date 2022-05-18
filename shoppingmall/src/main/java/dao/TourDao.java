package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import vo.Photo;
import vo.Tour;
import vo.TourArea;
import vo.TourImage;

public class TourDao {
	
	public void insertTourImage(TourImage tourImage) {
		
		System.out.println("insertTourImageDao 실행");
		String dburl="jdbc:mariadb://localhost:3306/blog";
		String dbuser="root";														//3가지 변수화
		String dbpw="java1234"; 
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(dburl,dbuser,dbpw);
			String sql="insert into tourimage(tourimage_name, tourimage_type , create_date ) values(?,?,now())";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, tourImage.getTourimageName());
			stmt.setString(2, tourImage.getTourimageType());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {										//접속 디버깅  
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	}
						
	//입력				//반환 값을 뭘로 할까?
	public void insertTour(List<HashMap<String,Object>> list) {		//tour삽입 쿼리문 --> tourArea와 tourImage를 선 insert 
		int row = 0;												// tourArea와 tourImage가 있으면 기본키값을 받아 넣는다.
		Connection conn = null;										//없을 시  insert
		TourArea tourArea = new TourArea();
		TourImage tourImage;
		

		PreparedStatement tourAreaStmt = null;
		PreparedStatement tourImageStmt = null;
		PreparedStatement tourStmt = null;
		

		
		
		String touAareaSql = "insert into tourarea(area, city) values(?,?)";
		String tourImageSql = "insert into tourimage(tourimage_name, tourimage_type , create_date ) values(?,?,now())";
		String tourSql = "insert into tour(tourarea_id, tour_name, tour_description, tourimage_no) values(?,?,?,?)";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			
			tourAreaStmt =  conn.prepareStatement(touAareaSql);
			tourAreaStmt.setString(1, x);							//tourArea insert
			tourAreaStmt.setString(2, x);	
			
			System.out.println(tourArea.getTourAreaId() + " insertTour에서의 tourAreaId");
																								
																								
															//tourAreaId 값이 있으면 tourArea의 조회 값을 사용
			tourStmt = conn.prepareStatement(tourSql);	
			tourStmt.setInt(1, x);										//insertTourSql 쿼리 실행
			tourStmt.setString(2,x);
			tourStmt.setString(3, x);
			tourStmt.setInt(4, x)
					
					
					
					
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
