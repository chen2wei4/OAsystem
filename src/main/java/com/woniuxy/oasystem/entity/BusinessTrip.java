package com.woniuxy.oasystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @Description  出差记录实体类
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年4月27日 下午10:51:25 [王培霖])
 *                      	2.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessTrip {
	private Integer tripId;
	private Integer empId;
	private String empName;
	private String tripDate;
	private Float tripTime;
	private String tripLocation;
	private String tripReason;
	private Integer flag;
	/**
	 * 构造方法
	 * @param empId
	 * @param tripDate
	 * @param tripTime
	 * @param tripLocation
	 * @param tripReason
	 */
	public BusinessTrip(Integer empId, String tripDate, Float tripTime, String tripLocation, String tripReason) {
		super();
		this.empId = empId;
		this.tripDate = tripDate;
		this.tripTime = tripTime;
		this.tripLocation = tripLocation;
		this.tripReason = tripReason;
	}
	public BusinessTrip(Integer tripId, Integer empId, String tripDate, Float tripTime,
			String tripLocation, String tripReason) {
		super();
		this.tripId = tripId;
		this.empId = empId;
		this.tripDate = tripDate;
		this.tripTime = tripTime;
		this.tripLocation = tripLocation;
		this.tripReason = tripReason;
	}
	
}
