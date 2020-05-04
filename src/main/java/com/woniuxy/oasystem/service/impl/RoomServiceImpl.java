package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.RoomDao;
import com.woniuxy.oasystem.entity.Room;
import com.woniuxy.oasystem.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	RoomDao roomDao;
	
	@Override
	public void addRoom(Room room) {
		roomDao.addRoom(room);
	}

	@Override
	public void deleteRoom(Room room) {
		roomDao.deleteRoom(room);
	}

	@Override
	public void changeRoom(Room room) {
		roomDao.changeRoom(room);
	}

	@Override
	public List<Room> getRoom(Room room) {
		
		return roomDao.queryRoom(room);
	}
	
}
