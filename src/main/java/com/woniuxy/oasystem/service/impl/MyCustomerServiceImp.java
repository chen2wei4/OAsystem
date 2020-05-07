package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.MyCustomerDao;
import com.woniuxy.oasystem.entity.Customer;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.CustomerService;
import com.woniuxy.oasystem.service.MyCustomerService;
/**
 * 
 * @Description 客户信息接口实现类
 * @author 陈一玮
 * @changeLog 1.创建 (2020年4月25日 下午3:00:53 [陈一玮]
 *            2.
 */
@Service
public class MyCustomerServiceImp implements MyCustomerService {
	@Autowired
	MyCustomerDao myCustomerDao;
	@Autowired
	PageBean<Customer> pb;
	@Override
	/**
	 * 重写查询所有客户信息的方法
	 */
	public PageBean<Customer> showMyCustomers(Customer customer,Integer currentPage,String customerDirector) {
		List<Customer> customers = myCustomerDao.showMyCustomers(customer,(currentPage-1)*10,customerDirector);
		Integer totalData = myCustomerDao.getMyCustomerTotalData(customer,customerDirector);
		//查询到的客户信息
		pb.setBeanList(customers);
		//设置分页大小
		pb.setPageSize(10);
		//设置当前页码
		pb.setPageIndex(currentPage);
		//设置数据总条数
		pb.setTotalRecord(totalData);
		//设置总页码
		pb.setTotalPage((totalData%10==0)?(totalData/10):(totalData/10+1));
		//设置起始页码和结束页码
		pb.setBeginPageAndEndPage();
		return pb;
	}
}
