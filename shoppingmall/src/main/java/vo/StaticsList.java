package vo;

public class StaticsList {
	public StaticsList() {} //기본 생성자 
	//필드생성
	private String gender; //고객 성별
	private int age; //고객 나이
	private String country; //고객나라
	private String month; //여행기간(월만 출력)
	private String area; //여행 지역
	
	//toString() : 필드값을 문자열로 출력
	@Override
	public String toString() {
		return "StaticsList [gender=" + gender + ", age=" + age + ", country=" + country + ", month=" + month
				+ ", area=" + area + "]";
	}

	//getter & setter
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
}
