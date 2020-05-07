/**
 * @author 陈一玮
 * @createDate 2020年5月3日
 */
package com.woniuxy.oasystem.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.woniuxy.oasystem.entity.Contract;
import com.woniuxy.oasystem.entity.Order;
import com.woniuxy.oasystem.entity.OrderType;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.exception.OrderException;
import com.woniuxy.oasystem.service.ContractService;
import com.woniuxy.oasystem.service.OrderService;

import lombok.Data;

/**
 * @Description 订单相关操作的控制器
 * @author 陈一玮
 * @changeLog 1.创建 (2020年5月3日 下午4:07:31 [陈一玮]
 *            2.
 */
@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	@Autowired
	ContractService contractService;
	/**
	 * 展示所有的分页订单信息
	 * @param model 模型对象
	 * @param order 搜索引擎中的查询条件
	 * @param currentPage 当前页码
	 * @param req 请求域对象
	 * @return 返回一个String对象， 在模板引擎下，会跳转到templates下的订单信息页面
	 * @changeLog 1.创建 (2020年5月3日 下午4:14:13 [陈一玮]
	 *            2.
	 */
	@GetMapping("business/orders")
	public String showOrders(Model model,Order order,Integer currentPage,String contractNumber,HttpServletRequest req) {
		if(currentPage==null) {
			currentPage=1;
		}
		List<Integer> contractId=null;
		if(contractNumber!=null&&!contractNumber.equals("")) {
			model.addAttribute("contractNumber", contractNumber);
			contractId = contractService.getContractIdByNumber(contractNumber);
			System.out.println(contractId);
		}
		PageBean<Order> pb=orderService.showOrders(order,currentPage,contractId);
		System.out.println(pb);
		String uri = getUri(req);
		pb.setUrl(uri);
		if(order!=null) {
			model.addAttribute("order", order);
		}
		System.out.println(pb);
		model.addAttribute("pb", pb);
		return "/lyear_pages_orders";
	}
	/**
	 * 新增一条订单信息
	 * @param order 新增的订单内容
	 * @param orderTypeId 订单类型
	 * @param contractNumber 合同号
	 * @return
	 * @changeLog 1.创建 (2020年5月4日 上午12:52:19 [陈一玮]
	 *            2.
	 */
	@PostMapping("/business/orders")
	public String addContract(Order order,Integer orderTypeId,String contractNumber,Model model) {
		//对前端传参进行数据合法性检查
		Integer jugOrderData = jugOrderData(order, model);
				if(jugOrderData==0) {
					return "/lyear_pages_addorder";
			}
		Integer contractId = contractService.getOneContractIdByNumber(contractNumber);
		if(contractId==null) {
			model.addAttribute("orderMsg", "没有该合同号");
			
		}
		System.out.println(contractId);
		System.out.println(order);
		System.out.println(orderTypeId);
		orderService.newOrder(order, contractId, orderTypeId);
			return "redirect:/business/orders";
	}
	/**
	 * 删除复选框选中的订单信息
	 * @param ids 订单信息id数组
	 * @return 返回值为String，使用模板引擎会跳转到templates下订单信息页面
	 * @changeLog 1.创建 (2020年4月27日 下午6:18:44 [陈一玮]
	 *            2.
	 */
	@DeleteMapping("/business/orders")
	public String deleteAllCustomer(@RequestParam(value = "ids[]" ,required = false)Integer[] ids)  {
		System.out.println(ids);
		orderService.deleteCheckedOrder(ids);
		return "redirect:/business/orders";
	}
	/**
	 * 根据订单信息Id查询一条指定的订单信息，然后跳转到更新
	 * @param model 模型类
	 * @param orderId 查询条件，订单信息id
	 * @return 返回值类型为String,使用模板引擎会跳转到templates下更新订单信息页面
	 * @changeLog 1.创建 (2020年4月27日 上午9:38:10 [陈一玮]
	 *            2.
	 */
	@GetMapping("/business/order/{orderId}")
	public String showContract(@PathVariable("orderId")Integer orderId,Model model) {
		Order order = orderService.showOrder(orderId);
		model.addAttribute("order", order);
		System.out.println(order);
		return "/lyear_pages_updateorder";
	}
	/**
	  * 更改一条订单信息
	 * @param order 需要更改的订单信息
	 * @return 返回值为String，使用模板引擎会跳转到templates下订单信息页面
	 * @changeLog 1.创建 (2020年4月27日 上午10:38:58 [陈一玮]
	 *            2.
	 */
	@PutMapping("/business/orders")
	public String updateContract(Order order,Integer orderTypeId,String contractNumber,Model model) {
		String orderNumber = order.getOrderNumber();
		//对前端传参进行数据合法性检查
		Integer jugOrderData = jugOrderData(order, model);
			if(jugOrderData==0) {
				order = orderService.showOrder(order.getOrderId());
				order.setOrderNumber(orderNumber);
				model.addAttribute("order", order);
					return "/lyear_pages_updateorder";
			}
		Integer contractId = contractService.getOneContractIdByNumber(contractNumber);
		orderService.updateOrder(order,contractId,orderTypeId);
		return "redirect:/business/orders";
	}
	/**
	  * 删除一条订单信息
	 * @param 需要删除的订单编号id
	 * @return 返回值为String，使用模板引擎会跳转到templates下订单信息页面
	 * @changeLog 1.创建 (2020年4月27日 下午6:17:57 [陈一玮]
	 *            2.
	 */
	@DeleteMapping("/business/orders/{orderId}")
	public String deleteCustomer(@PathVariable("orderId")Integer orderId) {
		orderService.deleteOrder(orderId);
		return "redirect:/business/orders";
	}
	/**
	 * 同步获取搜索条件的方法
	 * @param req 请求域对象
	 * @param resp 
	 * @return 返回搜索条件的uri
	 * @changeLog 1.创建 (2020年4月28日 上午9:44:09 [陈一玮]
	 *            2.
	 */
	public String getUri(HttpServletRequest req) {
		//获取uri中的属性与属性值
		String queryString = req.getQueryString();
		//当queryString不为null，且其中有当前页码的属性时，将当前页码的属性移除
		if(queryString!=null) {
			if(queryString.indexOf("currentPage=")!=-1) {
				queryString=queryString.substring(0, queryString.indexOf("currentPage="));
			}
		}
		//进行字符串拼接，形成URI
		String uri=req.getContextPath()+req.getServletPath()+"?"+queryString;
		return uri;
	}
	/**
	 * 对前端传参的Order对象进行合法性检查的方法
	 * @param customer 前端传参的contract
	 * @param model 模型类
	 * @return 返回标志，0为不合法，1为合法
	 * @changeLog 1.创建 (2020年5月5日 下午11:55:03 [陈一玮]
	 *            2.
	 */
	public Integer jugOrderData(Order order,Model model) {
		if(order.getOrderName().length()>20||order.getOrderName().length()==0) {
			model.addAttribute("orderMsg", "请输入20位以下订单名");
			return 0;
		}
		if(order.getOrderNumber().length()!=16) {
			model.addAttribute("orderMsg", "请输入16位订单号");
			return 0;
		}
		if(order.getGoodName().length()>20||order.getGoodName().length()==0) {
			model.addAttribute("orderMsg", "请输入20位以下商品名称");
			return 0;
		}
		if(order.getGoodNumber()<1||order.getGoodNumber()==0) {
			model.addAttribute("orderMsg", "请正确输入商品数量");
			return 0;
		}
		if(order.getOrderDate()==null) {
			model.addAttribute("orderMsg", "请输入订单截止时间");
			return 0;
		}
		return 1;
	}
	/**
	 * 简陋的异常处理
	 * @param ex 遇到的异常
	 * @return 返回模型和视图对象
	 * @changeLog 1.创建 (2020年5月6日 上午12:05:31 [陈一玮]
	 *            2.
	 */
	@ExceptionHandler
	public ModelAndView orderControllerExceptionResolve(Exception ex) {
		ModelAndView mv=new ModelAndView();
		if(ex instanceof OrderException) {
			System.out.println("OrderException");
			mv.setViewName("/lyear_pages_error404");
		}
		return mv;
	}
}
