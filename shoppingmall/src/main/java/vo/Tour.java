package vo;

public class Tour {
	//기본생성자
	public Tour() {}
	//필드생성
	private int tourNo;
	private int tourAreaNo;
	private String tourName;
	private String tourDescription;
	private int tourImageNo;
	//toString() : 필드값을 문자열로 출력
	@Override
	public String toString() {
		return "Tour [tourNo=" + tourNo + ", tourAreaNo=" + tourAreaNo + ", tourName=" + tourName + ", tourDescription="
				+ tourDescription + ", tourImageNo=" + tourImageNo + "]";
	}
	public int getTourNo() {
		return tourNo;
	}
	public void setTourNo(int tourNo) {
		this.tourNo = tourNo;
	}
	public int getTourAreaNo() {
		return tourAreaNo;
	}
	public void setTourAreaNo(int tourAreaNo) {
		this.tourAreaNo = tourAreaNo;
	}
	public String getTourName() {
		return tourName;
	}
	public void setTourName(String tourName) {
		this.tourName = tourName;
	}
	public String getTourDescription() {
		return tourDescription;
	}
	public void setTourDescription(String tourDescription) {
		this.tourDescription = tourDescription;
	}
	public int getTourImageNo() {
		return tourImageNo;
	}
	public void setTourImageNo(int tourImageNo) {
		this.tourImageNo = tourImageNo;
	}
	
	
}
