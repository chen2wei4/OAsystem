package com.woniuxy.oasystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @Description  空缺职位类
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年4月27日 下午10:50:50 [王培霖])
 *                      	2.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmptyPosition {
	private Integer positionId;
	private Integer departmentId;
	private String departmentName;
	private String positionName;
	private Integer positionNumber;
	private Integer positionSalary;
	private String positionEducationBackground;
	private String positionDescription;
	private Integer flag;
	/**
	 * 构造方法
	 * @param departmentId
	 * @param positionName
	 * @param positionNumber
	 * @param positionSalary
	 * @param positionEducationBackground
	 * @param positionDescription
	 */
	public EmptyPosition(Integer departmentId, String positionName, Integer positionNumber, Integer positionSalary,
			String positionEducationBackground, String positionDescription) {
		super();
		this.departmentId = departmentId;
		this.positionName = positionName;
		this.positionNumber = positionNumber;
		this.positionSalary = positionSalary;
		this.positionEducationBackground = positionEducationBackground;
		this.positionDescription = positionDescription;
	}
	public EmptyPosition(Integer positionId, Integer departmentId, String positionName, Integer positionNumber,
			Integer positionSalary, String positionEducationBackground, String positionDescription) {
		super();
		this.positionId = positionId;
		this.departmentId = departmentId;
		this.positionName = positionName;
		this.positionNumber = positionNumber;
		this.positionSalary = positionSalary;
		this.positionEducationBackground = positionEducationBackground;
		this.positionDescription = positionDescription;
	}
	
	
	
}
