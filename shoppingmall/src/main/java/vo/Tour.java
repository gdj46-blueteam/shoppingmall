package vo;

public class Tour {
	//기본생성자
	public Tour() {}
	//필드생성
	private int tourNo;
	private int tourAreaId;
	private String tourName;
	private String tourDescription;
	private String tourImage;
	//toString() : 필드값을 문자열로 출력
	@Override
	public String toString() {
		return "Tour[tourNo=" + tourNo + ", tourAreaId=" + tourAreaId + ", tourName=" + tourName
				+ ", tourDescription=" + tourDescription + ", tourImage=" + tourImage + "]";
	}
	//getter & setter
	public int getTourNo() {
		return tourNo;
	}
	public int getTourAreaId() {
		return tourAreaId;
	}
	public String getTourName() {
		return tourName;
	}
	public String getTourDescription() {
		return tourDescription;
	}
	public String getTourImage() {
		return tourImage;
	}
	public void setTourNo(int tourNo) {
		this.tourNo = tourNo;
	}
	public void setTourAreaId(int tourAreaId) {
		this.tourAreaId = tourAreaId;
	}
	public void setTourName(String tourName) {
		this.tourName = tourName;
	}
	public void setTourDescription(String tourDescription) {
		this.tourDescription = tourDescription;
	}
	public void setTourImage(String tourImage) {
		this.tourImage = tourImage;
	}
	
}
