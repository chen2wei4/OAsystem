package com.woniuxy.oasystem.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.service.EmpService;

@SpringBootTest
public class EmpDaoTest {
	
	@Autowired
	EmpDao empDao;
	
	@Autowired
	EmpService empService;
	
	// 展示所有员工信息
	@Test
	public void displayEmp() {
		//List<Emp> emps = empDao.displayEmp();
		List<Emp> emps = empService.displayEmp();
		for (Emp emp : emps) {
			System.out.println(emp.toString());
		}
	}
}
