package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import util.DBUtil;
import vo.Question;

public class QuestionDao {
	
	//입력
	public int indertQuestion(Question question) {
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = " INSERT INTO question(customer_id, question_title, question_content, create_date, update_date)"
					+ " VALUES(?, ?, ?, NOW(), NOW())";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, question.getCustomerId());
			stmt.setString(2, question.getQuestionTitle());
			stmt.setString(3, question.getQuestionContent());
			row = stmt.executeUpdate();
			if(row == 1) {
	            System.out.println("문의사항 1행 입력 성공(insertQuestion)");
	         } else {
	            System.out.println("문의사항 입력 실패(indertQuestion)");
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
		System.out.println("문의사항 삽입 메서드 끝");

		return row;
	}
	
	//삭제
	public void deleteQuestion(int questionNo) { //문의사항 삭제
		System.out.println(questionNo + "deleteQuestion");//매개값 디버깅
		Connection conn = null;
		PreparedStatement stmt = null;
		//문의사항을 삭제하는 쿼리문
		String sql = "DELETE FROM question WHERE question_no = ?";
		try {
			//DB연결
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);//쿼리실행
			stmt.setInt(1, questionNo);//물음표값 넣기
			int row = stmt.executeUpdate();//실행결과 행의 수 받기
			System.out.println(row + "<- deleteQuestion"); //행의 수 디버깅
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//조회
	public List<Question> selectQuestion() { //문의사항 조회
		List<Question> questionList = new ArrayList<Question>();
		Question question;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//문의사항을 조회하는 쿼리문
		String sql = "SELECT question_no questionNo, customer_id customerId, question_title questionTitle,"
				+ "		question_content questionContent, create_date createDate, update_date updateDate"
				+ "		FROM question";
		try {
			//DB접속
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);//쿼리실행
			rs = stmt.executeQuery();//쿼리문실행값을 저장
			//커서가 잡히고 리스트에서 선택되는 행을 바꿈, 내려갈행이 있다면 값을 가져오고 아니면 빠져나감
			while(rs.next()) {
				//데이터 저장을 위한 객체생성
				question = new Question();
				//객체에 각 조회된 결과값을 저장
				question.setQuestionNo(rs.getInt("questionNo"));
				question.setCustomerId(rs.getString("customerId"));
				question.setQuestionTitle(rs.getString("questionTitle"));
				question.setQuestionContent(rs.getString("questionContent"));
				question.setCreateDate(rs.getString("createDate"));
				question.setUpdateDate(rs.getString("updateDate"));
				questionList.add(question);
				//디버깅
				System.out.println(question +"<-question");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//반환
		return questionList;
	}
}
