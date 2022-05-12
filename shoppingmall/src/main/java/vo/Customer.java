package vo;

public class Customer {
	//기본생성자
	public Customer() {}
		
	//필드생성
	private String customerId;
	private String customerPw;
	private String customerName;
	private String customerGender;
	private int customerAge;
	private String customerPhone;
	private String customerEmail;
	private String customerCountry;
	private int authority;
	private String createDate;
	private String updateDate;
	
	//toString() : 필드값을 문자열로 출력
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerPw=" + customerPw + ", customerName=" + customerName
				+ ", customerGender=" + customerGender + ", customerAge=" + customerAge + ", customerPhone="
				+ customerPhone + ", customerEmail=" + customerEmail + ", customerCountry=" + customerCountry
				+ ", authority=" + authority + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	//getter & setter
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerPw() {
		return customerPw;
	}

	public void setCustomerPw(String customerPw) {
		this.customerPw = customerPw;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerCountry() {
		return customerCountry;
	}

	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
}
