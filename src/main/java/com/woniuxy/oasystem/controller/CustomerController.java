/**
 * @author 陈一玮
 * @createDate 2020年4月24日
 */
package com.woniuxy.oasystem.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.woniuxy.oasystem.entity.Customer;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.CustomerService;

/**
 * @Description 商务管理控制器
 * @author 陈一玮
 * @changeLog 1.创建 (2020年4月24日 下午4:33:13 [陈一玮]
 *            2.
 */
@Controller
public class CustomerController {
	@Autowired
	CustomerService customerService;
	/**
	 * 获取所有的客户信息
	 * @param model 模型类
	 * @param customer 搜索引擎中的查询条件
	 * @param currentPage 当前页码
	 * @return 返回值为String，使用模板引擎会跳转到templates下客户信息页面
	 * @changeLog 1.创建 (2020年4月26日 下午6:00:20 [陈一玮]
	 *            2.
	 */
	@GetMapping("/business/customers")
	public String showCunstomers(Model model,Customer customer,Integer currentPage) {
		if(currentPage==null) {
			currentPage=1;
		}
		PageBean<Customer> pb = customerService.showCustomers(customer,currentPage);
		System.out.println(pb);
		pb.setUri("/business/customers");
		model.addAttribute("pb", pb);
		return "/lyear_pages_customers";
	}
	/**
	 * 根据客户信息Id查询一条指定的客户信息
	 * @param model 模型类
	 * @param customerId 查询条件，客户信息id
	 * @return 返回值类型为String,使用模板引擎会跳转到templates下更新客户信息页面
	 * @changeLog 1.创建 (2020年4月27日 上午9:38:10 [陈一玮]
	 *            2.
	 */
	@GetMapping("/business/customer/{customerId}")
//	@GetMapping("/business/customer")
	public String showCunstomer(@PathVariable("customerId")Integer customerId,Model model) {
		Customer customer = customerService.showCustomer(customerId);
		model.addAttribute("customer", customer);
		return "/lyear_pages_update_customer";
	}
	/**
	 * 新增一条客户信息
	 * @param customer 需要新增的客户信息
	 * @param customerTypeId 新增的客户信息中的客户类型id
	 * @return 返回值为String，使用模板引擎会跳转到templates下客户信息页面
	 * @changeLog 1.创建 (2020年4月26日 下午8:40:10 [陈一玮]
	 *            2.
	 */
	@PostMapping("/business/customers")
	public String addCustomer(Customer customer,Integer customerTypeId) {
		customerService.newCustomer(customer, customerTypeId);
		return "redirect:/business/customers";
	}
	/**
	 * 新增一条客户信息
	 * @param customer 需要更改的客户信息
	 * @param customerTypeId 更改的客户信息中的客户类型id
	 * @return 返回值为String，使用模板引擎会跳转到templates下客户信息页面
	 * @changeLog 1.创建 (2020年4月27日 上午10:38:58 [陈一玮]
	 *            2.
	 */
	@PutMapping("/business/customers")
	public String updateCustomer(Customer customer,Integer customerTypeId) {
		customerService.updateCustomer(customer, customerTypeId);
		return "redirect:/business/customers";
	}
	@DeleteMapping("/business/customers/{customerId}")
	public String deleteCustomer(@PathVariable("customerId")Integer customerId) {
		customerService.deleteCustomer(customerId);
		return "redirect:/business/customers";
	}
	@DeleteMapping("/business/customers")
	public String deleteAllCustomer(@RequestParam(value = "ids[]" ,required = false)Integer[] ids)  {
		System.out.println(ids);
		customerService.deleteCheckedCustomer(ids);
		return "redirect:/business/customers";
	}
	public String getUri(HttpServletRequest req) {
		System.out.println(req.getContextPath());
		System.out.println(req.getServletPath());
		System.out.println(req.getQueryString());
		return null;
	}
}
