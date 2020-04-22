package com.woniuxy.oasystem.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.woniuxy.oasystem.entity.EmptyPosition;
import com.woniuxy.oasystem.service.EmptyPositionService;

@SpringBootTest
public class EmptyPositionDaoTest {
	@Autowired
	EmptyPositionDaoTest emptyPositionDao;
	
	@Autowired
	EmptyPositionService emptyPositionService;
	
	// 添加空缺职位
	@Test
	public void addEmptyPosition() {
		EmptyPosition hr = new EmptyPosition(1, "软件工程师", 3, 6500, "本科", "Java开发", 1);
		//emptyPositionDao.addEmptyPosition(hr);
		emptyPositionService.addEmptyPosition(hr);
	}
	
	// 删除空缺职位
	//@Test
	public void deleteEmptyPosition() {
		//emptyPositionDao.deleteEmptyPosition(1);
		emptyPositionService.deleteEmptyPosition(3);
	}
	
	// 显示全部空缺职位
	//@Test
	public void displayEmptyPosition() {
		//List<EmptyPosition> positions = emptyPositionDao.displayEmptyPosition();
		List<EmptyPosition> positions = emptyPositionService.displayEmptyPosition();
		for (EmptyPosition position : positions) {
			System.out.println(position.toString());
		}
	}
}
