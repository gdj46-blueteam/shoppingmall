package vo;

public class EmpImage {
	//기본생성자
	public EmpImage() {}

	//필드생성
	private String employeeImageName;
	private String employeeImageType;
	private String createDate;
	
	//toString() : 필드값을 문자열로 출력
	@Override
	public String toString() {
		return "EmpImage [employeeImageName="
				+ employeeImageName + ", employeeImageType=" + employeeImageType + ", createDate=" + createDate + "]";
	}

	//getter & setter
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
