package com.woniuxy.oasystem.service;

import java.util.List;

import com.woniuxy.oasystem.entity.AddressBook;
import com.woniuxy.oasystem.entity.Room;

public interface RoomService {
	void addRoom(Room room);
	void deleteRoom(Room room);
	void changeRoom(Room room);
	List<Room> getRoom(Room room);
}
