package com.woniuxy.oasystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
	int groupId;
	String groupName;
	Emp groupBoss;
	public Group(String name,Emp e){
		this.groupName=name;
		this.groupBoss=e;
	}
}
