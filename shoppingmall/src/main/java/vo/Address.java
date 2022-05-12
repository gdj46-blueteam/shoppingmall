package vo;
public class Address {
	//기본생성자
		public Address() {}
	// 필드생성
	private int id;
	private String zipCode;
	private String province;
	private String city;
	private String town;
	private String street;

	// toString() : 필드값을 문자열로 출력
	@Override
	public String toString() {
	 	return "Address [id=" + id + ", zipCode=" + zipCode + ", province=" + province + ", city=" + city + ", town=" + town
	 			+ ", street=" + street + "]";
	}
	// getter & setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	 
}
