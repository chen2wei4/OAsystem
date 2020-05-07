/**
 * @author 陈一玮
 * @createDate 2020年4月28日
 */
package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Customer;

/**
 * @Description 我的客户相关操作接口
 * @author 陈一玮
 * @changeLog 1.创建 (2020年4月28日 上午11:31:50 [陈一玮]
 *            2.
 */
public interface MyCustomerDao {
	/**
	 * 查询所有的我的客户信息
	 * @param customer 搜索引擎的查询条件
	 * @param currentPage 当前页码
	 * @param customerId 当前登录用户的职工id
	 * @return 返回客户信息的集合
	 * @changeLog 1.创建 (2020年4月28日 上午11:30:30 [陈一玮]
	 *            2.
	 */
	List<Customer> showMyCustomers(@Param("customer")Customer customer,@Param("currentPage")Integer currentPage,@Param("customerDirector")
	String customerDirector);
	/**
	 * 查询所有的我的客户信息的条数
	 * @param customer 搜索引擎的查询条件
	 * @param customerId 当前登录用户的职工id
	 * @return 返回我的客户信息的数据条数
	 * @changeLog 1.创建 (2020年4月26日 上午11:17:44 [陈一玮]
	 *            2.
	 */
	Integer getMyCustomerTotalData(@Param("customer")Customer customer,@Param("customerDirector")String customerDirector);
}
