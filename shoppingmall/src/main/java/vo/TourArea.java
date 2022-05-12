package vo;

public class TourArea {
	//기본생성자
	public TourArea() {}
	//필드생성
	private int tourAreaId;
	private String area;
	private String city;
	//toString() : 필드값을 문자열로 출력
	@Override
	public String toString() {
		return "TourArea [tourAreaId=" + tourAreaId + ", area=" + area + ", city=" + city + "]";
	}
	//getter & setter
	public int getTourAreaId() {
		return tourAreaId;
	}
	public String getArea() {
		return area;
	}
	public String getCity() {
		return city;
	}
	public void setTourAreaId(int tourAreaId) {
		this.tourAreaId = tourAreaId;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public void setCity(String city) {
		this.city = city;
	}

	
	
}
