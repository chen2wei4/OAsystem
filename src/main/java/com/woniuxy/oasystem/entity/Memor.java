package com.woniuxy.oasystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Memor {
	Integer memorId;
	Emp memorFrom;
	String memorContent;
	String memorTime;
	int memorType;

}
