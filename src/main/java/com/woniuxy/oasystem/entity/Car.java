package com.woniuxy.oasystem.entity;

import lombok.Data;

@Data
public class Car {
	private Integer carId;
	private String license;
	private String maintenance;
	private String useState;
	private String parkingSpace;
	private Integer flag;
}
