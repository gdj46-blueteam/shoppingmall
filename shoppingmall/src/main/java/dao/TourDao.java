package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Tour;

public class TourDao {
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
