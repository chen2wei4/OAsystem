package com.woniuxy.oasystem.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.Memor;
import com.woniuxy.oasystem.entity.Room;
import com.woniuxy.oasystem.service.MemorService;
import com.woniuxy.oasystem.service.RoomService;

@SpringBootTest
public class MemorTest {
		@Autowired
		MemorService memorService;
		
		@Test
		void Test01() {
			Memor memor = new Memor();
			Emp e = new Emp();
			e.setEmpId(1);
			memor.setMemorFrom(e );
			memor.setMemorContent("开始测试");
			
			memorService.addMemor(memor );
		}
		@Test
		void Test02() {
			Memor memor = new Memor();
			memor.setMemorContent("修改后的内容3");
			memor.setMemorType(3);
			memor.setMemorId(1);
			memorService.changeMemor(memor);
		}
		@Test
		void Test03() {
			Memor memor = new Memor();
			Emp e = new Emp();
			e.setEmpId(1);
			memor.setMemorFrom(e );
			memor.setMemorContent("开始测试");
			
			memorService.addMemor(memor );
		}
		@Test
		void Test04() {
			Memor memor = new Memor();
			Emp e = new Emp();
			e.setEmpId(1);
			memor.setMemorFrom(e );
			memor.setMemorContent("开始测试");
			
			memorService.addMemor(memor );
		}
}
