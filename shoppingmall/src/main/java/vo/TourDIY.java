package vo;

public class TourDIY {
	//기본생성자
public TourDIY() {}
	//필드생성
	private int tourDIYNo;
	private String customerId;
	private int languageNo;
	private int tourAreaId;
	private int tourDIYPeople;
	private String tourDIYTerm;
	private String tourStay;
	private String tourDIYEtc;
	private String createDate;
	//toString() : 필드값을 문자열로 출력
	@Override
	public String toString() {
		return "TourDIY [tourDIYNo=" + tourDIYNo + ", customerId=" + customerId + ", languageNo=" + languageNo
				+ ", tourareaId=" + tourAreaId + ", tourDIYPeople=" + tourDIYPeople + ", tourDIYTerm=" + tourDIYTerm
				+ ", tourStay=" + tourStay + ", tourDIYEtc=" + tourDIYEtc + ", createDate=" + createDate + "]";
	}
	//getter & setter
	public int getTourDIYNo() {
		return tourDIYNo;
	}
	public String getCustomerId() {
		return customerId;
	}
	public int getLanguageNo() {
		return languageNo;
	}
	public int getTourareaId() {
		return tourAreaId;
	}
	public int getTourDIYPeople() {
		return tourDIYPeople;
	}
	public String getTourDIYTerm() {
		return tourDIYTerm;
	}
	public String getTourStay() {
		return tourStay;
	}
	public String getTourDIYEtc() {
		return tourDIYEtc;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setTourDIYNo(int tourDIYNo) {
		this.tourDIYNo = tourDIYNo;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public void setLanguageNo(int languageNo) {
		this.languageNo = languageNo;
	}
	public void setTourareaId(int tourareaId) {
		this.tourAreaId = tourAreaId;
	}
	public void setTourDIYPeople(int tourDIYPeople) {
		this.tourDIYPeople = tourDIYPeople;
	}
	public void setTourDIYTerm(String tourDIYTerm) {
		this.tourDIYTerm = tourDIYTerm;
	}
	public void setTourStay(String tourStay) {
		this.tourStay = tourStay;
	}
	public void setTourDIYEtc(String tourDIYEtc) {
		this.tourDIYEtc = tourDIYEtc;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	
	
	
	
	
}
