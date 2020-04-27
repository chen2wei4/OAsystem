/**
 * @author 陈一玮
 * @createDate 2020年4月24日
 */
package com.woniuxy.oasystem.service;

import com.woniuxy.oasystem.entity.Customer;
import com.woniuxy.oasystem.entity.PageBean;

/**
 * @Description 客户信息的服务层接口
 * @author 陈一玮
 * @changeLog 1.创建 (2020年4月24日 下午5:08:08 [陈一玮]
 *            2.
 */
public interface CustomerService {
	/**
	 * 
	 * 查询所有客户的信息
	 * @param customer 搜索引擎的参数
	 * @param currentPage 当前页码
	 * @return
	 * @changeLog 1.创建 (2020年4月26日 上午10:58:06 [陈一玮]
	 *            2.
	 */
	PageBean<Customer> showCustomers(Customer customer,Integer currentPage);
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
	 * @changeLog 1.创建 (2020年4月24日 下午5:05:07 [陈一玮]
	 *            2.
	 */
	void newCustomer(Customer customer,Integer customerTypeId);
	/**
	 * 更改一条客户信息
	 * @param customer 需要更改的客户信息
	 * @param customerTypeId 更改的客户信息中的客户类型id
	 * @changeLog 1.创建 (2020年4月24日 下午5:06:44 [陈一玮]
	 *            2.
	 */
	void updateCustomer(Customer customer,Integer customerTypeId);
	/**
	 * 删除一条客户信息
	 * @param customerId 需要删除的客户编号id
	 * @changeLog 1.创建 (2020年4月24日 下午5:07:05 [陈一玮]
	 *            2.
	 */
	void deleteCustomer(Integer customerId);
	/**
	 * 删除复选框选中的客户信息
	 * @param ids 客户信息id数组
	 * @changeLog 1.创建 (2020年4月27日 下午5:25:03 [陈一玮]
	 *            2.
	 */
	void deleteCheckedCustomer(Integer[] ids);
}
