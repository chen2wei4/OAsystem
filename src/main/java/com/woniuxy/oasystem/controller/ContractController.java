/**
 * @author 陈一玮
 * @createDate 2020年4月29日
 */
package com.woniuxy.oasystem.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.woniuxy.oasystem.entity.Contract;
import com.woniuxy.oasystem.entity.Order;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.exception.ContractException;
import com.woniuxy.oasystem.service.ContractService;
import com.woniuxy.oasystem.service.OrderService;

/**
 * @Description 合同信息控制器
 * @author 陈一玮
 * @changeLog 1.创建 (2020年4月29日 上午10:19:16 [陈一玮]
 *            2.
 */
@Controller
public class ContractController {
	@Autowired 
	ContractService contractService;
	@Autowired
	OrderService orderService;
	/**
	  * 获取所有的合同信息
	 * @param model 模型类
	 * @param contract 搜索引擎中的查询条件
	 * @param currentPage 当前页码
	 * @return 返回值为String，使用模板引擎会跳转到templates下合同信息页面
	 * @changeLog 1.创建 (2020年4月26日 下午6:00:20 [陈一玮]
	 *            2.
	 */
	@RequestMapping("/business/contracts")
	public String showMyCunstomers(Model model,Contract contract,Integer currentPage,HttpServletRequest req) {
		if(currentPage==null) {
			currentPage=1;
		}
		String uri = getUri(req);
		PageBean<Contract> pb  = contractService.showContracts(contract, currentPage);
		System.out.println(pb);
		pb.setUrl(uri);
		if(contract!=null) {
			model.addAttribute("contract", contract);
		}
		model.addAttribute("pb", pb);
		return "/lyear_pages_contracts";
	}
	
	/**
	 * 新增一条合同信息
	 * @param contract 需要新增的合同信息
	 * @return 返回值为String，使用模板引擎会跳转到templates下客户信息页面
	 * @changeLog 1.创建 (2020年4月26日 下午8:40:10 [陈一玮]
	 *            2.
	 */
	@PostMapping("/business/contracts")
	public String addContract(Contract contract,@DateTimeFormat(iso=ISO.DATE)Date setDate,@DateTimeFormat(iso=ISO.DATE)Date getDate,
			Model model) {
		//对前端传参进行数据合法性检查
		Integer jugContractData = jugContractData(contract, model,setDate,getDate);
		System.out.println(jugContractData);
		if(jugContractData==0) {
			return "/lyear_pages_addcontract";
	}
		System.out.println(3);
		contract.setContractSetDate(setDate);
		contract.setContractGetDate(getDate);
		contractService.newContract(contract);
		Integer contractId = contract.getContractId();
		System.out.println(contractId);
		ArrayList<Order> orders = contract.getOrders();
		for (int i = 0; i < orders.size(); i++) {
			Order order = orders.get(i);
			Integer jugOrderData = jugOrderData(order, model);
			if(jugOrderData==0) {
				return "/lyear_pages_addcontract";
		}
			orderService.addGoodOrder(order, contractId);	
		}
			return "redirect:/business/contracts";
	}
	/**
	 * 删除复选框选中的合同信息
	 * @param ids 合同信息id数组
	 * @return 返回值为String，使用模板引擎会跳转到templates下合同信息页面
	 * @changeLog 1.创建 (2020年4月27日 下午6:18:44 [陈一玮]
	 *            2.
	 */
	@DeleteMapping("/business/contracts")
	public String deleteAllCustomer(@RequestParam(value = "ids[]" ,required = false)Integer[] ids)  {
		System.out.println(ids);
		contractService.deleteCheckedContract(ids);
		return "redirect:/business/contracts";
	}
	/**
	 * 根据合同信息Id查询一条指定的合同信息，然后跳转到更新
	 * @param model 模型类
	 * @param contractId 查询条件，合同信息id
	 * @return 返回值类型为String,使用模板引擎会跳转到templates下更新合同信息页面
	 * @changeLog 1.创建 (2020年4月27日 上午9:38:10 [陈一玮]
	 *            2.
	 */
	@GetMapping("/business/contracts/{contractId}")
	public String showContract(@PathVariable("contractId")Integer contractId,Model model,HttpServletRequest req) {
		System.out.println(req.getQueryString());
		Contract contract = contractService.showContract(contractId);
		model.addAttribute("contract", contract);
		return "/lyear_pages_updatecontract";
	}
	/**
	  * 更改一条合同信息
	 * @param contract 需要更改的合同信息
	 * @return 返回值为String，使用模板引擎会跳转到templates下合同信息页面
	 * @changeLog 1.创建 (2020年4月27日 上午10:38:58 [陈一玮]
	 *            2.
	 */
	@PutMapping("/business/contracts")
	public String updateContract(Contract contract,
			@DateTimeFormat(iso=ISO.DATE)Date setDate,@DateTimeFormat(iso=ISO.DATE)Date getDate,Model model) {
		//对前端传参进行数据合法性检查
		Integer jugContractData = jugContractData(contract, model,setDate,getDate);
		if(jugContractData==0) {
			contract.setContractGetDate(getDate);
			contract.setContractSetDate(setDate);
			model.addAttribute("contract", contract);
				return "/lyear_pages_updatecontract";
		}
		contract.setContractSetDate(setDate);
		contract.setContractGetDate(getDate);
		contractService.updateContract(contract);
		return "redirect:/business/contracts";
	}
	/**
	  * 删除一条合同信息
	 * @param 需要删除的合同编号id
	 * @return 返回值为String，使用模板引擎会跳转到templates下合同信息页面
	 * @changeLog 1.创建 (2020年4月27日 下午6:17:57 [陈一玮]
	 *            2.
	 */
	@DeleteMapping("/business/contracts/{contractId}")
	public String deleteCustomer(@PathVariable("contractId")Integer contractId) {
		contractService.deleteContract(contractId);
		return "redirect:/business/contracts";
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
	 * 对前端传参的Contract对象进行合法性检查的方法
	 * @param customer 前端传参的contract
	 * @param model 模型类
	 * @return 返回标志，0为不合法，1为合法
	 * @changeLog 1.创建 (2020年5月5日 下午11:55:03 [陈一玮]
	 *            2.
	 */
	public Integer jugContractData(Contract contract,Model model,Date setDate,Date getDate) {
		if(contract.getCustomerName().length()>50||contract.getCustomerName().length()==0) {
			model.addAttribute("contractMsg", "请输入50位以下客户名");
			return 0;
		}
		if(contract.getContractName().length()>20||contract.getContractName().length()==0) {
			model.addAttribute("contractMsg", "请输入20位以下合同名称");
			return 0;
		}
		if(contract.getContractNumber().length()!=16) {
			model.addAttribute("contractMsg", "请输入16位合同号");
			return 0;
		}
		if(contract.getContractMoney()==null||contract.getContractMoney()<0) {
			model.addAttribute("contractMsg", "正确输入合同金额");
			return 0;
		}
		if(contract.getContractDirector().length()>10||contract.getContractDirector().length()==0) {
			model.addAttribute("contractMsg", "请输入10位以下负责人姓名");
			return 0;
		}
		if(setDate==null) {
			model.addAttribute("contractMsg", "请输入合同开始时间");
			return 0;
		}
		if(getDate==null) {
			model.addAttribute("contractMsg", "请输入合同结束时间");
			return 0;
		}
		return 1;
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
	public ModelAndView contractControllerExceptionResolve(Exception ex) {
		ModelAndView mv=new ModelAndView();
		if(ex instanceof ContractException) {
			System.out.println("ContractException");
			mv.setViewName("/lyear_pages_error404");
		}
		return mv;
	}
}
