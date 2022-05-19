package vo;

public class EmpImage {
	//기본생성자
	public EmpImage() {}

	//필드생성
	private int employeeImageNo;
	private String employeeImageName;
	private String employeeImageType;
	private String createDate;
	
	@Override
	public String toString() {
		return "EmpImage [employeeImageNo=" + employeeImageNo + ", employeeImageName=" + employeeImageName
				+ ", employeeImageType=" + employeeImageType + ", createDate=" + createDate + "]";
	}
	
	public int getEmployeeImageNo() {
		return employeeImageNo;
	}
	public void setEmployeeImageNo(int employeeImageNo) {
		this.employeeImageNo = employeeImageNo;
	}
	public String getEmployeeImageName() {
		return employeeImageName;
	}
	public void setEmployeeImageName(String employeeImageName) {
		this.employeeImageName = employeeImageName;
	}
	public String getEmployeeImageType() {
		return employeeImageType;
	}
	public void setEmployeeImageType(String employeeImageType) {
		this.employeeImageType = employeeImageType;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}
