package com.woniuxy.oasystem.dao;

import java.util.List;

import com.woniuxy.oasystem.entity.AddressBook;
import com.woniuxy.oasystem.entity.Group;
import com.woniuxy.oasystem.entity.Room;

public interface GroupDao {
	void addGroup(Group group);
	void deleteGroup(Group group);
	void changeGroup(Group group);
	List<Room> queryGroup(Group group);
}