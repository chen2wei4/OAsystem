package com.woniuxy.oasystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
	private Integer empId;
	private String empPassword;
	private Integer roleId;
	private Integer departmentId;
	private String empName;
	private String empDate;
	private String empSex;
	private String empTel;
	private String empEmail;
	private String empIdnumber;
	private String empHiredate;
	private String empEducation;
	private String empPoliticalStatus;
	private Integer flag;
}
