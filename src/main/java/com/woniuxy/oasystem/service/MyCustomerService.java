/**
 * @author 陈一玮
 * @createDate 2020年4月24日
 */
package com.woniuxy.oasystem.service;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Customer;
import com.woniuxy.oasystem.entity.PageBean;

/**
 * @Description 我的客户信息的服务层接口
 * @author 陈一玮
 * @changeLog 1.创建 (2020年4月24日 下午5:08:08 [陈一玮]
 *            2.
 */
public interface MyCustomerService {
	/**
	 * 
	 * 查询我的所有客户的信息
	 * @param customer 搜索引擎的参数
	 * @param currentPage 当前页码
	 * @return
	 * @changeLog 1.创建 (2020年4月26日 上午10:58:06 [陈一玮]
	 *            2.
	 */
	PageBean<Customer> showMyCustomers(Customer customer,Integer currentPage,String customerDirector);
}
