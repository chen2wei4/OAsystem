package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.GroupDao;
import com.woniuxy.oasystem.dao.RoomDao;
import com.woniuxy.oasystem.entity.Group;
import com.woniuxy.oasystem.entity.Room;
import com.woniuxy.oasystem.service.GroupService;
import com.woniuxy.oasystem.service.RoomService;

@Service
public class GroupServiceImpl implements GroupService{

	@Autowired
	GroupDao groupDao;

	@Override
	public void addGroup(Group group) {
		groupDao.addGroup(group);
	}

	@Override
	public void deleteGroup(Group group) {
		groupDao.deleteGroup(group);
	}

	@Override
	public void changeGroup(Group group) {
		groupDao.changeGroup(group);
	}

	@Override
	public List<Room> getGroup(Group group) {
		return groupDao.queryGroup(group);
	}
	

	
}
