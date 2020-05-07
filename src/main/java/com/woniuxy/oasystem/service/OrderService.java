/**
 * @author 陈一玮
 * @createDate 2020年5月3日
 */
package com.woniuxy.oasystem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Contract;
import com.woniuxy.oasystem.entity.Order;
import com.woniuxy.oasystem.entity.PageBean;

/**
 * @Description 订单相关操作服务层接口
 * @author 陈一玮
 * @changeLog 1.创建 (2020年5月3日 下午1:59:07 [陈一玮]
 *            2.
 */
public interface OrderService {
	/**
	 * 增添一条新的商业订单
	 * @param order 需要添加的订单数据
	 * @changeLog 1.创建 (2020年5月3日 下午2:01:01 [陈一玮]
	 *            2.
	 */
	void addGoodOrder(Order order,Integer contractId);

	/**
	  * 展示所有的分页订单信息
	 * @param order 搜索引擎中的查询条件
	 * @param currentPage 当前页码
	 * @return 返回分页的实体类
	 * @changeLog 1.创建 (2020年5月3日 下午4:29:44 [陈一玮]
	 *            2.
	 */
	PageBean<Order> showOrders(Order order, Integer currentPage,List<Integer> contractId);
	/**
	 * 新增一条订单信息
	 * @param order 需要新增的合同信息
	 * @changeLog 1.创建 (2020年4月27日 上午10:44:02 [陈一玮]
	 *            2.
	 */
	void newOrder(Order order,Integer contractId,Integer orderTypeId);
	/**
	  * 删除复选框选中的订单信息
	 * @param ids 合同信息id数组
	 * @changeLog 1.创建 (2020年4月29日 下午8:46:20 [陈一玮]
	 *            2.
	 */
	void deleteCheckedOrder(Integer[] ids);
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
	void updateOrder(Order order,Integer contractId,Integer orderTypeId);
}
