package vo;

public class Employee {
	//기본생성자
	public Employee() {}
	
	//필드생성
	private int employeeNo;
	private String employeePw;
	private String employeeSn;
	private int empAddressId;
	private String employeeAddressDetail;
	private String employeeName;
	private String employeeEmail;
	private String employeePhone;
	private String employeeGender;
	private int authority;
	private String employeeIntroduce;
	private int employeeImageNo;
	private String createDate;
	private String updateDate;
	
	@Override
	public String toString() {
		return "Employee [employeeNo=" + employeeNo + ", employeePw=" + employeePw + ", employeeSn=" + employeeSn
				+ ", empAddressId=" + empAddressId + ", employeeAddressDetail=" + employeeAddressDetail
				+ ", employeeName=" + employeeName + ", employeeEmail=" + employeeEmail + ", employeePhone="
				+ employeePhone + ", employeeGender=" + employeeGender + ", authority=" + authority
				+ ", employeeIntroduce=" + employeeIntroduce + ", employeeImageNo=" + employeeImageNo + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "]";
	}

	//getter & setter
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

	public int getEmpAddressId() {
		return empAddressId;
	}

	public void setEmpAddressId(int empAddressId) {
		this.empAddressId = empAddressId;
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

	public int getEmployeeImageNo() {
		return employeeImageNo;
	}


	public void setEmployeeImageNo(int employeeImageNo) {
		this.employeeImageNo = employeeImageNo;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	public String getEmployeeIntroduce() {
		return employeeIntroduce;
	}

	public void setEmployeeIntroduce(String employeeIntroduce) {
		this.employeeIntroduce = employeeIntroduce;
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
