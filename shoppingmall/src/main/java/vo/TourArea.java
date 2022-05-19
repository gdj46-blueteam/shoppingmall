package vo;

public class TourArea {
	//기본생성자
	public TourArea() {}
	//필드생성
	private int tourAreaNo;
	private String area;
	private String city;
	//toString() : 필드값을 문자열로 출력
	@Override
	public String toString() {
		return "TourArea [tourAreaNo=" + tourAreaNo + ", area=" + area + ", city=" + city + "]";
	}
	public int getTourAreaNo() {
		return tourAreaNo;
	}
	public void setTourAreaNo(int tourAreaNo) {
		this.tourAreaNo = tourAreaNo;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

	
	
}
