package vo;

public class TourDIY {
	//기본생성자
public TourDIY() {}
	//필드생성
	private int tourDIYNo;
	private String customerId;
	private int languageNo;
	private int tourAreaNo;
	private int tourDIYPeople;
	private String tourDIYTerm;
	private String tourDIYStay;
	private String tourDIYEtc;
	private String createDate;
	//toString() : 필드값을 문자열로 출력
	@Override
	public String toString() {
		return "TourDIY [tourDIYNo=" + tourDIYNo + ", customerId=" + customerId + ", languageNo=" + languageNo
				+ ", tourAreaNo=" + tourAreaNo + ", tourDIYPeople=" + tourDIYPeople + ", tourDIYTerm=" + tourDIYTerm
				+ ", tourDIYStay=" + tourDIYStay + ", tourDIYEtc=" + tourDIYEtc + ", createDate=" + createDate + "]";
	}
	public int getTourDIYNo() {
		return tourDIYNo;
	}
	public void setTourDIYNo(int tourDIYNo) {
		this.tourDIYNo = tourDIYNo;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getLanguageNo() {
		return languageNo;
	}
	public void setLanguageNo(int languageNo) {
		this.languageNo = languageNo;
	}
	public int getTourAreaNo() {
		return tourAreaNo;
	}
	public void setTourAreaNo(int tourAreaNo) {
		this.tourAreaNo = tourAreaNo;
	}
	public int getTourDIYPeople() {
		return tourDIYPeople;
	}
	public void setTourDIYPeople(int tourDIYPeople) {
		this.tourDIYPeople = tourDIYPeople;
	}
	public String getTourDIYTerm() {
		return tourDIYTerm;
	}
	public void setTourDIYTerm(String tourDIYTerm) {
		this.tourDIYTerm = tourDIYTerm;
	}
	public String getTourDIYStay() {
		return tourDIYStay;
	}
	public void setTourDIYStay(String tourDIYStay) {
		this.tourDIYStay = tourDIYStay;
	}
	public String getTourDIYEtc() {
		return tourDIYEtc;
	}
	public void setTourDIYEtc(String tourDIYEtc) {
		this.tourDIYEtc = tourDIYEtc;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	
	
	
	
	
}
