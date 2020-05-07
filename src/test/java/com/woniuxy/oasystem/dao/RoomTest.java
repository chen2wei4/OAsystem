package com.woniuxy.oasystem.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.woniuxy.oasystem.entity.Room;
import com.woniuxy.oasystem.service.RoomService;

@SpringBootTest
public class RoomTest {
	@Autowired
	RoomService roomService;
	
	@Test
	void Test01() {
		Room room=new Room(2, "三楼二号");
		Room room1=new Room(1, "八楼二号");
		roomService.addRoom(room);
		roomService.addRoom(room1);
		Room room2=new Room(2, "五楼二号");
		roomService.changeRoom(room1);
		roomService.deleteRoom(room2);
		Room edit=new Room();
		List<Room> room3 = roomService.getRoom(edit);
		System.out.println(room3);
	}
	
	@Test
	void Test02() {
		
		Room condition=new Room();
		condition.setRoomId(1);
		List<Room> room=roomService.getRoom(condition);
		
		System.out.println(room);
	}
}
