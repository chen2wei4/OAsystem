/**
 * @author 陈一玮
 * @createDate 2020年4月26日
 */
package com.woniuxy.oasystem.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.woniuxy.oasystem.dao.CustomerDao;
import com.woniuxy.oasystem.entity.Customer;
import com.woniuxy.oasystem.entity.PageBean;

/**
 * @Description TODO
 * @author 陈一玮
 * @changeLog 1.创建 (2020年4月26日 上午11:38:40 [陈一玮]
 *            2.
 */
@SpringBootTest
public class CustomerServiceTest {
	@Autowired
	CustomerService customerService;
	@Autowired
	CustomerDao customerDao;
	@Test
	public void testCustomerService() {
		PageBean<Customer> showCustomers = customerService.showCustomers(new Customer(), 1);
		System.out.println(showCustomers);
	}
	@Test
	public void testCustomerService1() {
		List<Customer> showCustomers = customerDao.showCustomers(new Customer(), 1);
		System.out.println(showCustomers);
	}
	@Test
	public void testCustomerService2() {
		Integer customerTotalData = customerDao.getCustomerTotalData(new Customer("张三","公司","X","X"));
		System.out.println(customerTotalData);
	}
}
