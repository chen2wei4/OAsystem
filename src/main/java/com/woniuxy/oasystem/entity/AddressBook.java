package com.woniuxy.oasystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressBook {
	Integer addrbookId;//通讯录主键
	Emp addrbookPeople;//通讯录归属者
	Integer addrbookType;//通讯录类型
	String addrbookName;//备注名
	int addrbookEmpId;//关联公司员工
	String addrbookNumber;//通讯号码
	String addrbookAddress;//通讯地址
	int addrbookDep;//所属部门
	int addrbookRoom;//所属办公室
	int addrbookGroup;//所属团队
	Emp addrbookBoss;//上级领导
	public AddressBook(Emp e,Emp boss,int type,String name,String number,String addr,
			int dep,int room,int group){
		this.addrbookPeople=e;
		this.addrbookName=name;
		this.addrbookNumber=number;
		this.addrbookAddress=addr;
		this.addrbookDep=dep;
		this.addrbookRoom=room;
		this.addrbookGroup=group;
		this.addrbookBoss=boss;
	}
}
