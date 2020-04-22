package com.woniuxy.oasystem.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
	private int empId;
	private int roleId;
	private int departmentId;
	private String departmentName;
	private String empName;
	private String empDate;
	private String empSex;
	private String empTel;
	private String empEmail;
	private String empIdnumber;
	private Date empHireDate;
	private String empEducation;
	private String empPoliticalStatus;
	private int flag;
	
}
