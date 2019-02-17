package SignInStaff;

public class Staff {
	// 员工名字
	private String staffName;
	// 员工ID
	private int staffId;
	// 员工学习方向
	private String staffDirection;
	// 员工性别
	private char staffSex;

	// Member类有参数和无参数的构造器
	public Staff() {
	}

	public Staff(String memberName, int memberId, String memberDirection, char memberSex) {
		this.staffName = memberName;
		this.staffId = memberId;
		this.staffDirection = memberDirection;
		this.staffSex = memberSex;
	}

	
	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getStaffDirection() {
		return staffDirection;
	}

	public void setStaffDirection(String staffDirection) {
		this.staffDirection = staffDirection;
	}

	public char getStaffSex() {
		return staffSex;
	}

	public void setStaffSex(char staffSex) {
		this.staffSex = staffSex;
	}

	// 重写toString方法
	public String toString() {
		return "员工名字:" + staffName + "," + "  员工ID:" + staffId + "," + "  员工学习方向:" + staffDirection + "," + "  员工性别："
				+ staffSex + "," + "。";
	}
	public String toString1() {
		return "员工名字:" + staffName + "," + "  员工ID:" + staffId + "," + "  员工学习方向:" + staffDirection + "," + "  员工性别："
				+ staffSex + ",";
	}
}
