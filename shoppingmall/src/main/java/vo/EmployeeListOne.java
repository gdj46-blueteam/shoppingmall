package vo;

public class EmployeeListOne {
	//필드 생성
	private int employeeNo;
	private String employeePW;
	private String employeeSn;
	private String employeeAddress;
	private String employeeAddressDetail;
	private String employeeName;
	private String employeeEmail;
	private String employeePhone;
	private String employeeGender;
	private String employeeImageName;
	private String employeeIntroduce;
	private int authority;
	private String createDate;
	private String updateDate;
	
	@Override
	public String toString() {
		return "EmployeeListOne [employeeNo=" + employeeNo + ", employeePW=" + employeePW + ", employeeSn=" + employeeSn
				+ ", employeeAddress=" + employeeAddress + ", employeeAddressDetail=" + employeeAddressDetail
				+ ", employeeName=" + employeeName + ", employeeEmail=" + employeeEmail + ", employeePhone="
				+ employeePhone + ", employeeGender=" + employeeGender + ", employeeImageName=" + employeeImageName
				+ ", employeeIntroduce=" + employeeIntroduce + ", authority=" + authority + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}
	
	//getter & setter
	public int getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getEmployeePW() {
		return employeePW;
	}

	public void setEmployeePW(String employeePW) {
		this.employeePW = employeePW;
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
