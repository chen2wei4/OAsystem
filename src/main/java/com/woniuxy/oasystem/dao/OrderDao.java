/**
 * @author 陈一玮
 * @createDate 2020年4月28日
 */
package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Contract;
import com.woniuxy.oasystem.entity.Order;

/**
 * @Description 订单信息相关操作接口
 * @author 陈一玮
 * @changeLog 1.创建 (2020年4月28日 上午11:31:50 [陈一玮]
 *            2.
 */
public interface OrderDao {
	/**
	 * 增添一条新的商业订单
	 * @param order 需要添加的订单数据
	 * @changeLog 1.创建 (2020年5月3日 下午2:01:01 [陈一玮]
	 *            2.
	 */
	void addGoodOrder(@Param("order")Order order,@Param("contractId")Integer contractId);

	/**
	 * 查询所有订单信息的条数
	 * @param order 搜索引擎的查询条件
	 * @param contractId 合同id
	 * @return 返回订单信息的条数
	 * @changeLog 1.创建 (2020年5月3日 下午4:34:00 [陈一玮]
	 *            2.
	 */
	Integer getOrderTotalData(@Param("order")Order order,@Param("contractId")List<Integer> contractId);

	/**
	 * 查询分页的所有订单信息
	 * @param order 搜索引擎的查询条件
	 * @param currentPage 当前页码
	 * @param contractId 合同id
	 * @return 返回订单信息的集合
	 * @changeLog 1.创建 (2020年5月3日 下午4:34:41 [陈一玮]
	 *            2.
	 */
	List<Order> showOrders(@Param("order")Order order,@Param("currentPage") Integer currentPage,
			@Param("contractId")List<Integer> contractId);
	/**
	 * 新增一条订单信息
	 * @param order 需要新增的合同信息
	 * @changeLog 1.创建 (2020年4月27日 上午10:44:02 [陈一玮]
	 *            2.
	 */
	void newOrder(@Param("order")Order order,@Param("contractId")Integer contractId,@Param("orderTypeId")Integer orderTypeId);
	/**
	  * 删除复选框选中的订单信息
	 * @param ids 合同信息id数组
	 * @changeLog 1.创建 (2020年4月29日 下午8:46:20 [陈一玮]
	 *            2.
	 */
	void deleteCheckedOrder(@Param("ids")Integer[] ids);
	/**
	  * 删除一条订单信息
	 * @param 需要删除的订单编号id
	 * @changeLog 1.创建 (2020年4月30日 上午11:38:41 [陈一玮]
	 *            2.
	 */
	void deleteOrder(Integer orderId);
	/**
	  * 根据订单信息Id查询一条指定的订单信息
	 * @param contractId 查询条件，订单信息id
	 * @return 返回一条指定的订单信息
	 * @changeLog 1.创建 (2020年4月30日 上午10:13:34 [陈一玮]
	 *            2.
	 */
	Order showOrder(Integer orderId);
	/**
	  * 更改一条订单信息
	 * @param contract 需要更改的订单信息
	 * @changeLog 1.创建 (2020年4月30日 上午11:04:09 [陈一玮]
	 *            2.
	 */
	void updateOrder(@Param("order")Order order,@Param("contractId")Integer contractId,@Param("orderTypeId")Integer orderTypeId);
}
