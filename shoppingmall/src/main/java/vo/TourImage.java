package vo;

public class TourImage {
	//기본생성자
	public TourImage() {}
	private int tourImageNo;
	private String tourimageName;
	private String tourimageType;
	private String createDate;
	//toString() : 필드값을 문자열로 출력
	@Override
	public String toString() {
		return "TourImage [tourImageNo=" + tourImageNo + ", tourimageName=" + tourimageName + ", tourimageType="
				+ tourimageType + ", createDate=" + createDate + "]";
	}
	//getter & setter
	public int getTourImageNo() {
		return tourImageNo;
	}
	public String getTourimageName() {
		return tourimageName;
	}
	public String getTourimageType() {
		return tourimageType;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setTourImageNo(int tourImageNo) {
		this.tourImageNo = tourImageNo;
	}
	public void setTourimageName(String tourimageName) {
		this.tourimageName = tourimageName;
	}
	public void setTourimageType(String tourimageType) {
		this.tourimageType = tourimageType;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	

}
