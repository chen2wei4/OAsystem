package com.woniuxy.oasystem.dao;

import java.util.List;

import com.woniuxy.oasystem.entity.AddressBook;
import com.woniuxy.oasystem.entity.Room;

public interface RoomDao {
	void addRoom(Room room);
	void deleteRoom(Room room);
	void changeRoom(Room room);
	List<Room> queryRoom(Room room);
}