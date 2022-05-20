package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mariadb.jdbc.message.client.ExecutePacket;

import vo.Tour;
import vo.TourArea;
import vo.TourImage;

public class TourDao {
	
	public int insertTourImage(TourImage tourImage) {							//TourImage 삽입
		System.out.println("insertTourImageDao 실행"); 
		int row=0;
		int tourImageNo=0;
		Connection conn=null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql="insert into tourimage(tourimage_name, tourimage_type , create_date ) values(?,?,now())";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			System.out.println(tourImage.getTourImageName());
			System.out.println(tourImage.getTourImageType());
			
			stmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);					//insert쿼리문 실행 후 기본키 반환
			stmt.setString(1, tourImage.getTourImageName());
			stmt.setString(2, tourImage.getTourImageType());
			stmt.executeUpdate();
			rs=stmt.getGeneratedKeys();
			if(rs.next()) {
				tourImageNo = rs.getInt(1);
			}
			
			System.out.println(tourImageNo + "<-- insertTourImageDao");
			row=stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {										
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		System.out.println(row +"<-- insertTourImage row");
		return tourImageNo;
	}
	
	public int insertTourArea(TourArea tourArea) {							//TourArea  삽입
		System.out.println("insertTourArea 실행"); 
		int tourAreaNo=0;
		int row=0;
		Connection conn=null;
		ResultSet rs=null;
		String sql = "insert into tourarea(area, city) values(?,?)";		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			System.out.println(tourArea.getArea());
			System.out.println(tourArea.getCity());
			
			PreparedStatement stmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS); 	//insert쿼리문 실행 후 기본키 반환
			stmt.setString(1, tourArea.getArea());
			stmt.setString(2, tourArea.getCity());
			row=stmt.executeUpdate();
			rs=stmt.getGeneratedKeys();
			if(rs.next()) {
				tourAreaNo = rs.getInt(1);																	//기본키 저장
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {										
		try {
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		System.out.println(row +"<-- insertTourArea");
		System.out.println(tourAreaNo + "<-- tourAreaNoDao");
		return tourAreaNo;																				//기본키 반환
	}
						
	//입력				
	public void insertTour(Tour tour) {								//tourImage,tourArea 삽입메서드 실행 후 tour 실행
		Connection conn = null;										
		PreparedStatement stmt= null;
		int row=0;
		String sql = "insert into tour(tourarea_No, tour_name, tour_description, tourimage_no) values(?,?,?,?)";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			
			stmt =  conn.prepareStatement(sql);
			stmt.setInt(1, tour.getTourAreaNo());								
			stmt.setString(2, tour.getTourName());
			stmt.setString(3,tour.getTourDescription());
			stmt.setInt(4,tour.getTourImageNo());																
			row=stmt.executeUpdate();
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
		System.out.println(row +"<-- insertTour");
	}
	//수정
	public int updateTour(Tour tour) {									// tour Update 쿼리
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		//수정하는 쿼리문
		String sql = "update tour set tour_name = ?, tour_description = ? where tour_no = ?";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			stmt = conn.prepareStatement(sql);//쿼리실행
				
			stmt.setString(1, tour.getTourName());
			stmt.setString(2, tour.getTourDescription());
			stmt.setInt(3, tour.getTourNo());
			
			row = stmt.executeUpdate();
			if(row == 0) {
				System.out.println("수정실패");
			} else {
				System.out.println("수정성공");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	//삭제
	public void deleteTour(int tourNo) {	
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		//삭제 쿼리문
		String sql = "delete from tour where tour_no = ?";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			stmt = conn.prepareStatement(sql);//쿼리실행
				
			stmt.setInt(1, tourNo);
			
			row = stmt.executeUpdate();
			if(row == 1) {
				System.out.println("수정성공");
			} else {
				System.out.println("수정실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}


	//상세보기
	public int selectTourListOne(int tourNo){
		Tour tour;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//상세보기 쿼리문
		String sql = "select tour_no tourNo, tourarea_No tourAreaNo, tour_name tourName, tour_description tourDescription, tourimage_no tourImageNo from tour where tour_no = ?";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			stmt = conn.prepareStatement(sql);//쿼리실행
			stmt.setInt(1, tourNo);
			rs = stmt.executeQuery();//결과값 저장
			while(rs.next()) {
				tour = new Tour();
				tour.setTourNo(rs.getInt("tourNo"));
				tour.setTourAreaNo(rs.getInt("tourAreaNo"));
				tour.setTourName(rs.getString("tourName"));
				tour.setTourDescription(rs.getString("tourDescription"));
				tour.setTourImageNo(rs.getInt("tourImageNo"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return tourNo;
		
	}
	//조회
	public List<Tour> selectTourList() { 							//관광리스트 조회
		List<Tour> tourList = new ArrayList<>();
		Tour tour;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//관광리스트 조회하는 쿼리문
		String sql =  " SELECT tour_no tourNo, tourarea_no tourareaNo, tour_name tourName, tour_description tourDescription,"
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
				tour.setTourAreaNo(rs.getInt("tourareaNo"));
				tour.setTourName(rs.getString("tourName"));
				tour.setTourDescription(rs.getString("tourDescription"));
				tour.setTourImageNo(rs.getInt("tourImageNo"));
				tourList.add(tour);
				//디버깅
				System.out.println(tour+"<-tour");
			}
			
		} catch (Exception e) {
		}
		//반환
		return tourList;
	}
	public Tour selectTourOne(int tourNo) {
		Tour tour= new Tour();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		System.out.println(tourNo+"tour상세보기");
		//관광리스트 조회하는 쿼리문
		String sql =  " select tour_no tourNo, tourArea_No tourAreaNo, tour_name tourName, tour_description tourDescription, tourimage_no tourImageNo from tour where tour_no = ?";
		try {
			//DB접속
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			stmt = conn.prepareStatement(sql);										//쿼리실행
			stmt.setInt(1, tourNo);
			rs = stmt.executeQuery();//쿼리문 실행값 저장
			//커서가 잡히고 리스트에서 선택되는 행을 바꿈, 내려갈행이 있다면 값을 가져오고 아니면 빠져나감
			while(rs.next()) {		 
				//객체에 각 조회된 결과값을 저장
				tour.setTourNo(rs.getInt("tourNo"));
				tour.setTourAreaNo(rs.getInt("tourareaNo"));
				tour.setTourName(rs.getString("tourName"));
				tour.setTourDescription(rs.getString("tourDescription"));
				tour.setTourImageNo(rs.getInt("tourImageNo"));
				//디버깅
				System.out.println(tour+"<-tour");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		//반환
		return tour;
		
	}
	public TourImage selectTourImageOne(Tour tour){				//tourImage 상세보기(tour.getTourImageNo를 통하여 TourImage 값 가져오기
		TourImage tourImage = new TourImage();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		System.out.println(tour.getTourImageNo()+" tourImageNo tourImage상세보기");
		//관광리스트 조회하는 쿼리문
		String sql =  " select tourImage_no tourImageNo, tourImage_name tourImageName,tourImage_type tourImageType, create_date createDate from tourImage where TourImage_No = ?";
		try {
			//DB접속
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			stmt = conn.prepareStatement(sql);										//쿼리실행
			stmt.setInt(1, tour.getTourImageNo());
			rs = stmt.executeQuery();//쿼리문 실행값 저장
			//커서가 잡히고 리스트에서 선택되는 행을 바꿈, 내려갈행이 있다면 값을 가져오고 아니면 빠져나감
			while(rs.next()) {		
				//객체에 각 조회된 결과값을 저장
				tourImage.setTourImageNo(rs.getInt("tourImageNo"));
				tourImage.setTourImageName(rs.getString("tourImageName"));
				tourImage.setTourImageType(rs.getString("tourImageType"));
				tourImage.setCreateDate(rs.getString("createDate"));
				//디버깅
				System.out.println(tourImage+"<-tourImage 상세보기");
			}
			
		} catch (Exception e) {

		}
		//반환
		return tourImage;
	}
	public TourArea selectTourAreaOne(Tour tour){
		TourArea tourArea = new TourArea();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		System.out.println(tour.getTourImageNo()+" tourImageNo tourImage상세보기");
		//관광리스트 조회하는 쿼리문
		String sql =  " select TourArea_No tourAreaNo, area,city from tourArea where tourArea_No = ?";
		try {
			//DB접속
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoppingmall","root","java1234");
			stmt = conn.prepareStatement(sql);										//쿼리실행
			stmt.setInt(1, tour.getTourAreaNo());
			rs = stmt.executeQuery();//쿼리문 실행값 저장
			//커서가 잡히고 리스트에서 선택되는 행을 바꿈, 내려갈행이 있다면 값을 가져오고 아니면 빠져나감
			while(rs.next()) {		
				//객체에 각 조회된 결과값을 저장
				tourArea.setTourAreaNo(rs.getInt("tourAreaNo"));
				tourArea.setArea(rs.getString("area"));
				tourArea.setCity(rs.getString("city"));
				//디버깅
				System.out.println(tourArea +"<-tourArea 상세보기 ");
			}
			
		} catch (Exception e) {

		}
		//반환
		return tourArea;
	}
}
