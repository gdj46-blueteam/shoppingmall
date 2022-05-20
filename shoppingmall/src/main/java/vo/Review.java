package vo;

public class Review {
	//기본생성자
	public Review() {}
	
	//필드생성
	private int reviewNo;
	private String customerId;
	private String review;
	private int tourdiyNo;
	private int estimateNo;
	private String createDate;
	private String updateDate;
	
	//toString() : 필드값을 문자열로 출력
	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", customerId=" + customerId + ", review=" + review + ", tourdiyNo="
				+ tourdiyNo + ", estimateNo=" + estimateNo + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ "]";
	}
	
	//getter & setter
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getcustomerId() {
		return customerId;
	}
	public void setcustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int gettourdiyNo() {
		return tourdiyNo;
	}
	public void settourdiyNo(int tourdiyNo) {
		this.tourdiyNo = tourdiyNo;
	}
	public int getEstimateNo() {
		return estimateNo;
	}
	public void setEstimateNo(int estimateNo) {
		this.estimateNo = estimateNo;
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
