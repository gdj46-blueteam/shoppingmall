package vo;

public class EmployeeImageList {
	private int employeeNo;
	private String employeeName;
	private String employeeImage;
	
	@Override
	public String toString() {
		return "EmployeeImageList [employeeNo=" + employeeNo + ", employeeName=" + employeeName + ", employeeImage="
				+ employeeImage + "]";
	}
	//getter & setter
	public int getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeImage() {
		return employeeImage;
	}

	public void setEmployeeImage(String employeeImage) {
		this.employeeImage = employeeImage;
	}

	public EmployeeImageList() { //기본생성자
	}
	
	
}
