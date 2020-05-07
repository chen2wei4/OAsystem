package com.woniuxy.oasystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @Description  请假实体类
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年4月27日 下午10:48:15 [王培霖])
 *                      	2.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Leaving {
	private Integer leavingId; // 请假记录id
	private Integer empId; // 员工id
	private String empName; // 员工姓名
	private String leavingDate; // 请假日期
	private Float leavingTime; // 请假时长(天)
	private Integer vacationType; // 请假类型
	private String vacationName; // 假期名称
	private String leavingReason; // 请假原因
	private Integer flag; // 软删除
	/**
	 * 构造方法
	 * @param empId
	 * @param leavingDate
	 * @param leavingTime
	 * @param vacationType
	 * @param leavingReason
	 */
	public Leaving(Integer empId, String leavingDate, Float leavingTime, Integer vacationType, String leavingReason) {
		super();
		this.empId = empId;
		this.leavingDate = leavingDate;
		this.leavingTime = leavingTime;
		this.vacationType = vacationType;
		this.leavingReason = leavingReason;
	}
	public Leaving(Integer leavingId, Integer empId, String leavingDate, Float leavingTime, Integer vacationType,
			String leavingReason) {
		super();
		this.leavingId = leavingId;
		this.empId = empId;
		this.leavingDate = leavingDate;
		this.leavingTime = leavingTime;
		this.vacationType = vacationType;
		this.leavingReason = leavingReason;
	}
	
	
}
