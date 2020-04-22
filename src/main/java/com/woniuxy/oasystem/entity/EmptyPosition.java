package com.woniuxy.oasystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmptyPosition {
	private int positionId;
	private int departmentId;
	private String positionName;
	private int positionNumber;
	private int positionSalary;
	private String positionEducationBackground;
	private String positionDescription;
	private int flag;
	// 构造方法	
	public EmptyPosition(int departmentId, String positionName, int positionNumber, int positionSalary,
			String positionEducationBackground, String positionDescription, int flag) {
		super();
		this.departmentId = departmentId;
		this.positionName = positionName;
		this.positionNumber = positionNumber;
		this.positionSalary = positionSalary;
		this.positionEducationBackground = positionEducationBackground;
		this.positionDescription = positionDescription;
		this.flag = flag;
	}
}
