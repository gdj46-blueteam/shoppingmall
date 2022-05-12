package vo;

public class Estimate {
	//기본생성자
	public Estimate() {}
	// 필드생성
	private int estimateNo;
	private int tourdiyNo;
	private String adminId;
	private int employeeNo;
	private int estimatePrice;
	private String estimateIng;
	private String createDate;
	private String updateDate;
	
	// toString() : 필드값을 문자열로 출력
	@Override
	public String toString() {
		return "Estimate [estimateNo=" + estimateNo + ", tourdiyNo=" + tourdiyNo + ", adminId=" + adminId
				+ ", employeeNo=" + employeeNo + ", estimatePrice=" + estimatePrice + ", estimateIng=" + estimateIng
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	// getter & setter
	public int getEstimateNo() {
		return estimateNo;
	}

	public void setEstimateNo(int estimateNo) {
		this.estimateNo = estimateNo;
	}

	public int getTourdiyNo() {
		return tourdiyNo;
	}

	public void setTourdiyNo(int tourdiyNo) {
		this.tourdiyNo = tourdiyNo;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public int getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}

	public int getEstimatePrice() {
		return estimatePrice;
	}

	public void setEstimatePrice(int estimatePrice) {
		this.estimatePrice = estimatePrice;
	}

	public String getEstimateIng() {
		return estimateIng;
	}

	public void setEstimateIng(String estimateIng) {
		this.estimateIng = estimateIng;
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
