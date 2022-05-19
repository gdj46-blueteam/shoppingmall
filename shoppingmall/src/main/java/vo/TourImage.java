package vo;

public class TourImage {
	//기본생성자
	public TourImage() {}
	private int tourImageNo;
	private String tourImageName;
	private String tourImageType;
	private String createDate;
	//toString() : 필드값을 문자열로 출력
	@Override
	public String toString() {
		return "TourImage [tourImageNo=" + tourImageNo + ", tourimageName=" + tourImageName + ", tourImageType="
				+ tourImageType + ", createDate=" + createDate + "]";
	}
	//getter & setter
	public int getTourImageNo() {
		return tourImageNo;
	}
	public String getTourImageName() {
		return tourImageName;
	}
	public String getTourImageType() {
		return tourImageType;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setTourImageNo(int tourImageNo) {
		this.tourImageNo = tourImageNo;
	}
	public void setTourImageName(String tourImageName) {
		this.tourImageName = tourImageName;
	}
	public void setTourImageType(String tourImageType) {
		this.tourImageType = tourImageType;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	

}
