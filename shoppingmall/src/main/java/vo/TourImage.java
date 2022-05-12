package vo;

public class TourImage {
	private int tourimageNo;
	private int tourNo;
	private String tourimageName;
	private String tourimageType;
	private String createDate;
	//toString() : 필드값을 문자열로 출력
	@Override
	public String toString() {
		return "TourImage [tourimageNo=" + tourimageNo + ", tourNo=" + tourNo + ", tourimageName=" + tourimageName
				+ ", tourimageType=" + tourimageType + ", createDate=" + createDate + "]";
	}
	//getter & setter
	public int getTourimageNo() {
		return tourimageNo;
	}
	public int getTourNo() {
		return tourNo;
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
	public void setTourimageNo(int tourimageNo) {
		this.tourimageNo = tourimageNo;
	}
	public void setTourNo(int tourNo) {
		this.tourNo = tourNo;
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
	public TourImage() {
	}
	

}
