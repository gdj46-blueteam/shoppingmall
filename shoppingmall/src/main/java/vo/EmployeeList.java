package vo;

public class EmployeeList {
	private int employeeNo;
	private String employeeName;
	private String employeeImageName;
	
	@Override
	public String toString() {
		return "EmployeeImageList [employeeNo=" + employeeNo + ", employeeName=" + employeeName + ", employeeImageName="
				+ employeeImageName + "]";
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

	public String getEmployeeImageName() {
		return employeeImageName;
	}

	public void setEmployeeImageName(String employeeImageName) {
		this.employeeImageName = employeeImageName;
	}

	public EmployeeList() { //기본생성자
	}
	
	
}
