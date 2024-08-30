package com.webServerProject.SpringProject1.Services;

public class EmployeeDetails {
	private String EmpName,EmpId,EmpDept;
	public EmployeeDetails() {}
	public EmployeeDetails(String empName, String empId, String empDept) {
		super();
		EmpName = empName;
		EmpId = empId;
		EmpDept = empDept;
	}
	public String getEmpName() {
		return EmpName;
	}
	public String getEmpId() {
		return EmpId;
	}
	public String getEmpDept() {
		return EmpDept;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public void setEmpId(String empId) {
		EmpId = empId;
	}
	public void setEmpDept(String empDept) {
		EmpDept = empDept;
	}
	
}
