/**
 *
 */
package com.woniuxy.oasystem.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
