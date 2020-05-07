package com.woniuxy.oasystem.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.Group;
import com.woniuxy.oasystem.entity.Room;
import com.woniuxy.oasystem.service.GroupService;
import com.woniuxy.oasystem.service.RoomService;

@SpringBootTest
public class GroupTest {
	@Autowired
	GroupService groupService;
	
	@Test
	void Test01() {
		Emp e = new Emp();
		e.setEmpId(1);
		Group group = new Group("第一组", e );
		groupService.addGroup(group );
	}
	@Test
	void Test02() {
		Group group = new Group();
		group.setGroupId(1);
		group.setGroupName("修改");
		Emp e = new Emp();
		e.setEmpId(1);
		group.setGroupBoss(e );
		groupService.changeGroup(group);
	}
	@Test
	void Test03() {
		Group group = new Group();
		group.setGroupId(2);
		groupService.deleteGroup(group);
	}
	@Test
	void Test04() {
		Group group = new Group();
		List<Room> group2 = groupService.getGroup(group);
		System.out.println(group2);
	}

}
