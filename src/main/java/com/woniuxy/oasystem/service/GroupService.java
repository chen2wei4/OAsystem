package com.woniuxy.oasystem.service;

import java.util.List;

import com.woniuxy.oasystem.entity.AddressBook;
import com.woniuxy.oasystem.entity.Group;
import com.woniuxy.oasystem.entity.Room;

public interface GroupService {
	void addGroup(Group group);
	void deleteGroup(Group group);
	void changeGroup(Group group);
	List<Room> getGroup(Group group);
}
