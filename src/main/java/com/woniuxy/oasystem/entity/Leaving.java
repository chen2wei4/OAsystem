package com.woniuxy.oasystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Leaving {
	private int leavingId; // 请假记录id
	private int empId; // 员工id
	private String empName; // 员工姓名
	private String leavingDate; // 请假日期
	private float leavingTime; // 请假时长(天)
	private int vacationType; // 请假类型
	private String vacationName; // 假期名称
	private String leavingReason; // 请假原因
	private int flag; // 软删除
	/**
	 * 构造方法
	 * @param empId
	 * @param leavingDate
	 * @param leavingTime
	 * @param vacationType
	 * @param leavingReason
	 */
	public Leaving(int empId, String leavingDate, float leavingTime, int vacationType, String leavingReason) {
		super();
		this.empId = empId;
		this.leavingDate = leavingDate;
		this.leavingTime = leavingTime;
		this.vacationType = vacationType;
		this.leavingReason = leavingReason;
	}
	
	
}
