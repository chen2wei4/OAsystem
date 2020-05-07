/**
 * @author 陈一玮
 * @createDate 2020年4月24日
 */
package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Customer;
import com.woniuxy.oasystem.entity.CustomerType;

/**
 * @Description 商务管理操作接口
 * @author 陈一玮
 * @changeLog 1.创建 (2020年4月24日 下午4:53:23 [陈一玮]
 *            2.
 */
public interface CustomerDao {
	/**
	  * 查询所有的客户信息
	 * @param customer 搜索引擎的查询条件
	 * @param currentPage 当前页码
	 * @return 返回客户信息的集合
	 * @changeLog 1.创建 (2020年4月26日 上午11:18:05 [陈一玮]
	 *            2.
	 */
	List<Customer> showCustomers(@Param("customer")Customer customer,@Param("currentPage")Integer currentPage);
	/**
	  * 查询所有的客户信息的条数
	 * @param customer 搜索引擎的查询条件
	 * @return 返回所有的客户信息的条数
	 * @changeLog 1.创建 (2020年4月26日 上午11:17:44 [陈一玮]
	 *            2.
	 */
	Integer getCustomerTotalData(@Param("customer")Customer customer);
	/**
	 * 查询一条指定的客户信息
	 * @param customerId 查询条件，客户信息id
	 * @return 返回一条客户信息
	 * @changeLog 1.创建 (2020年4月27日 上午9:29:39 [陈一玮]
	 *            2.
	 */
	Customer showCustomer(Integer customerId);
	/**
	 * 新增一条客户信息
	 * @param customer 需要新增的客户信息
	 * @param customerTypeId 新增的客户信息中的客户类型id
	 * @changeLog 1.创建 (2020年4月27日 上午10:44:02 [陈一玮]
	 *            2.
	 */
	void newCustomer(@Param("customer")Customer customer,@Param("customerTypeId")Integer customerTypeId);
	/**
	 * 更改一条客户信息
	 * @param customer 需要更改的客户信息
	 * @param customerTypeId 更改的客户信息中的客户类型id
	 * @changeLog 1.创建 (2020年4月24日 下午5:06:44 [陈一玮]
	 *            2.
	 */
	void updateCustomer(@Param("customer")Customer customer,@Param("customerTypeId")Integer customerTypeId);
	/**
	 * 删除一条客户信息
	 * @param customerId 需要删除的客户编号id
	 * @changeLog 1.创建 (2020年4月24日 下午5:07:05 [陈一玮]
	 *            2.
	 */
	void deleteCustomer(Integer customerId);
	/**
	 * 查询所有的客户类型
	 * @return 返回客户类型的集合
	 * @changeLog 1.创建 (2020年4月27日 上午12:32:29 [陈一玮]
	 *            2.
	 */
	List<CustomerType> selectAllCustomerType();
	/**
	 * 删除复选框选中的客户信息
	 * @param ids 客户信息id数组
	 * @changeLog 1.创建 (2020年4月27日 下午5:25:03 [陈一玮]
	 *            2.
	 */
	void deleteCheckedCustomer(@Param("ids")Integer[] ids);
}
