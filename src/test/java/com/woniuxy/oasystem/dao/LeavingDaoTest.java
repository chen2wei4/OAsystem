package com.woniuxy.oasystem.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.woniuxy.oasystem.entity.Leaving;
import com.woniuxy.oasystem.service.LeavingService;

@SpringBootTest
public class LeavingDaoTest {
	@Autowired
	LeavingDao leavingDao;
	
	@Autowired
	LeavingService leavingService;
	
	// 添加请假记录
	//@Test
	public void addLeaving() {
		Leaving leaving = new Leaving(2, "2018-01-01", 5f, 4, "无");
		//leavingDao.addLeaving(leaving);
		leavingService.addLeaving(leaving);
	}
	
	// 删除请假记录
	//@Test
	public void deleteLeaving() {
		//leavingDao.deleteLeaving(2);
		leavingService.deleteLeaving(1);
	}
	
	// 展示所有请假记录
	@Test
	public void displayLeaving() {
		List<Leaving> leavings = leavingDao.displayLeaving();
		for (Leaving leaving : leavings) {
			System.out.println(leaving.toString());
		}
	}
}
