package vo;

public class EmployeeListOne {
	//필드 생성
	private int employeeNo;
	private String employeePw;
	private String employeeSn;
	private String employeeAddress;
	private String employeeAddressDetail;
	private String employeeName;
	private String employeeEmail;
	private String employeePhone;
	private String employeeGender;
	private String employeeImageName;
	private String employeeIntroduce;
	private String language;
	private int authority;
	private String createDate;
	private String updateDate;
	//기본생성자
	public EmployeeListOne() {}
	//toString()
	@Override
	public String toString() {
		return "EmployeeListOne [employeeNo=" + employeeNo + ", employeePw=" + employeePw + ", employeeSn=" + employeeSn
				+ ", employeeAddress=" + employeeAddress + ", employeeAddressDetail=" + employeeAddressDetail
				+ ", employeeName=" + employeeName + ", employeeEmail=" + employeeEmail + ", employeePhone="
				+ employeePhone + ", employeeGender=" + employeeGender + ", employeeImageName=" + employeeImageName
				+ ", employeeIntroduce=" + employeeIntroduce + ", language=" + language + ", authority=" + authority
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
	//setter & getter
	public int getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getEmployeePw() {
		return employeePw;
	}
	public void setEmployeePw(String employeePw) {
		this.employeePw = employeePw;
	}
	public String getEmployeeSn() {
		return employeeSn;
	}
	public void setEmployeeSn(String employeeSn) {
		this.employeeSn = employeeSn;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public String getEmployeeAddressDetail() {
		return employeeAddressDetail;
	}
	public void setEmployeeAddressDetail(String employeeAddressDetail) {
		this.employeeAddressDetail = employeeAddressDetail;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getEmployeeGender() {
		return employeeGender;
	}
	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}
	public String getEmployeeImageName() {
		return employeeImageName;
	}
	public void setEmployeeImageName(String employeeImageName) {
		this.employeeImageName = employeeImageName;
	}
	public String getEmployeeIntroduce() {
		return employeeIntroduce;
	}
	public void setEmployeeIntroduce(String employeeIntroduce) {
		this.employeeIntroduce = employeeIntroduce;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
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
