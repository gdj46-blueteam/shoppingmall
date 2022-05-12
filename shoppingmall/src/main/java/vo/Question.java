package vo;

public class Question {
	//기본생성자
	public Question() {}
	
	//필드생성
	private int questionNo;
	private String customerId;
	private String questionTitle;
	private String questionContent;
	private String createDate;
	private String updateDate;
	
	//toString() : 필드값을 문자열로 출력
	@Override
	public String toString() {
		return "Question [questionNo=" + questionNo + ", customerId=" + customerId + ", questionTitle=" + questionTitle
				+ ", questionContent=" + questionContent + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ "]";
	}
	
	//getter & setter
	public int getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

}
