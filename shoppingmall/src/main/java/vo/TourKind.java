package vo;

public class TourKind {
	//기본생성자
	public TourKind() {}
	//필드생성
	private int tourKindNo;
	private int tourKind;
	private String tourKindDescription;
	//toString() : 필드값을 문자열로 출력
	@Override
	public String toString() {
		return "TourKind [tourKindNo=" + tourKindNo + ", tourKind=" + tourKind + ", tourKindDescription="
				+ tourKindDescription + "]";
	}
	//getter & setter
	public int getTourKindNo() {
		return tourKindNo;
	}
	public int getTourKind() {
		return tourKind;
	}
	public String getTourKindDescription() {
		return tourKindDescription;
	}
	public void setTourKindNo(int tourKindNo) {
		this.tourKindNo = tourKindNo;
	}
	public void setTourKind(int tourKind) {
		this.tourKind = tourKind;
	}
	public void setTourKindDescription(String tourKindDescription) {
		this.tourKindDescription = tourKindDescription;
	}

	
}
