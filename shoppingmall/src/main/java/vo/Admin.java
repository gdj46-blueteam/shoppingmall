package vo;

public class Admin {
	//기본생성자
		public Admin() {}
	// 필드생성
	private String adminId;
	private String adminPw;
	private String adminPhone;
	private String adminEmail;
	private int adminAddressId;
	private String addressDetail;
	private String createDate;
	private int authority;
	
	// toString() : 필드값을 문자열로 출력
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminPw=" + adminPw + ", adminPhone=" + adminPhone + ", adminEmail="
				+ adminEmail + ", adminAddressId=" + adminAddressId + ", addressDetail=" + addressDetail
				+ ", createDate=" + createDate + ", authority=" + authority + "]";
	}
	// getter & setter
	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	public String getAdminPhone() {
		return adminPhone;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public int getAdminAddressId() {
		return adminAddressId;
	}

	public void setAdminAddressId(int adminAddressId) {
		this.adminAddressId = adminAddressId;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getcreateDate() {
		return createDate;
	}

	public void setcreateDate(String createDate) {
		this.createDate = createDate;
	}

	public int getauthority() {
		return authority;
	}

	public void setauthority(int authority) {
		this.authority = authority;
	}
	
}
