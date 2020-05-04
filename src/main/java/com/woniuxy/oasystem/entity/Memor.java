package com.woniuxy.oasystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Memor {
	int memorId;
	Emp memorFrom;
	String memorContent;
	String memorTime;
	int memorType;

}
