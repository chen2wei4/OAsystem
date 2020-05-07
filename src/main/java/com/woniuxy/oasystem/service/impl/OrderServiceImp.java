/**
 * @author 陈一玮
 * @createDate 2020年5月3日
 */
package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.OrderDao;
import com.woniuxy.oasystem.entity.Contract;
import com.woniuxy.oasystem.entity.Order;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.OrderService;

/**
 * @Description TODO
 * @author 陈一玮
 * @changeLog 1.创建 (2020年5月3日 下午2:21:09 [陈一玮]
 *            2.
 */
@Service
public class OrderServiceImp implements OrderService{
	@Autowired
	OrderDao orderDao;
	@Autowired
	PageBean<Order> pb;
	/**
	 * 增加一条商业订单信息
	 */
	@Override
	public void addGoodOrder(Order order, Integer contractId) {
		orderDao.addGoodOrder(order, contractId);
	}
	/**
	 * 展示所有的分页订单信息
	 */
	@Override
	public PageBean<Order> showOrders(Order order, Integer currentPage,List<Integer> contractId) {
		List<Order> customers = orderDao.showOrders(order,(currentPage-1)*10,contractId);
		Integer totalData = orderDao.getOrderTotalData(order, contractId);
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
	/**
	 * 新增一条订单
	 */
	@Override
	public void newOrder(Order order, Integer contractId, Integer orderTypeId) {
		orderDao.newOrder(order, contractId, orderTypeId);
	}
	/**
	 * 删除复选框选中的订单信息
	 */
	@Override
	public void deleteCheckedOrder(Integer[] ids) {
		orderDao.deleteCheckedOrder(ids);
	}
	/**
	 * 删除订单信息
	 */
	@Override
	public void deleteOrder(Integer orderId) {
		orderDao.deleteOrder(orderId);
	}
	/**
	 * 根据订单信息Id查询一条指定的订单信息
	 */
	@Override
	public Order showOrder(Integer orderId) {
		Order order = orderDao.showOrder(orderId);
		return order;
	}
	/**
	 * 更改一条订单信息
	 */
	@Override
	public void updateOrder(Order order,Integer contractId,Integer orderTypeId) {
		orderDao.updateOrder(order,contractId,orderTypeId);
	}

}
