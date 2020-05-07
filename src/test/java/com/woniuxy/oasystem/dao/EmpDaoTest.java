/**
 *
 */
package com.woniuxy.oasystem.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.woniuxy.oasystem.entity.Emp;

/**
 * @author THY唐昊宇事务模块
 *
 */
@SpringBootTest
public class EmpDaoTest {
	@Autowired
	EmpDao empDao;

	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
	
	@Test
	public void getEmpsTest() {
		System.out.println(empDao.getEmps());
	}
	
	@Test
	public void displayEmp() {
		List<Emp> emps = empDao.selectEmpByPage(new Emp(), 1, 10);
		for (Emp emp: emps) {}
		System.out.println(emps.toString());
	}
}
