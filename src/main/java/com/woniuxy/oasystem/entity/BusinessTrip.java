package com.woniuxy.oasystem.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessTrip {
	private int tripId;
	private int empId;
	private String empName;
	private String tripDate;
	private float tripTime;
	private String tripLocation;
	private String tripReason;
	private int flag;
	// 构造方法
	public BusinessTrip(int empId, String tripDate, float tripTime, String tripLocation, String tripReason) {
		super();
		this.empId = empId;
		this.tripDate = tripDate;
		this.tripTime = tripTime;
		this.tripLocation = tripLocation;
		this.tripReason = tripReason;
	}
	
}
