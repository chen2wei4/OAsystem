package com.woniuxy.oasystem.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patchcard {
	//id	
	private Integer patchcardId;
	//员工id	
	private Emp emp;
	//员工部门id
	private Department  department;
	//补签原由	
	private String patchcardContent;
	//补签时间  	
	private String patchcardTime;
 
}
