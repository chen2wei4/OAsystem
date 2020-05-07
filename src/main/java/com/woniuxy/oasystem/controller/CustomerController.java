/**
 * @author 陈一玮
 * @createDate 2020年4月24日
 */
package com.woniuxy.oasystem.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
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

import com.woniuxy.oasystem.entity.Customer;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.exception.CustomerException;
import com.woniuxy.oasystem.service.CustomerService;
import com.woniuxy.oasystem.util.RegexUtil;

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
	@RequiresPermissions("customer:select")
	@GetMapping("/business/customers")
	public String showCunstomers(Model model,Customer customer,Integer currentPage,HttpServletRequest req) {
		if(currentPage==null||currentPage<1) {
			currentPage=1;
		}
		String uri = getUri(req);
		PageBean<Customer> pb = customerService.showCustomers(customer,currentPage);
		pb.setUrl(uri);
		if(customer!=null) {
			model.addAttribute("customer", customer);
		}
		model.addAttribute("pb", pb);
		return "/lyear_pages_customers";
	}
	/**
	 * 根据客户信息Id查询一条指定的客户信息，然后跳转到更新
	 * @param model 模型类
	 * @param customerId 查询条件，客户信息id
	 * @return 返回值类型为String,使用模板引擎会跳转到templates下更新客户信息页面
	 * @changeLog 1.创建 (2020年4月27日 上午9:38:10 [陈一玮]
	 *            2.
	 */
	@RequiresPermissions("customer:update")
	@GetMapping("/business/customer/{customerId}")
	public String showCunstomer(@PathVariable("customerId")Integer customerId,Model model,HttpServletRequest req) {
		System.out.println(req.getQueryString());
		Customer customer = null;
		try {
			customer = customerService.showCustomer(customerId);
		} catch (CustomerException e) {
			e.printStackTrace();
			return "/lyear_pages_error404";
		}
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
	@RequiresPermissions("customer:insert")
	@PostMapping("/business/customers")
	public String addCustomer(Customer customer,Integer customerTypeId,HttpServletRequest req,Model model) {
		System.out.println(customer);
		//对前端传参进行数据合法性检查
		Integer jugCustomerData = jugCustomerData(customer, model);
		if(jugCustomerData==0) {
				return "/lyear_pages_addcustomer";
		}
		customerService.newCustomer(customer, customerTypeId);
		//获取url中的传参，如果有new属性的传参，则进入我的客户信息页面，否则进入客户信息页面
		String queryString = req.getQueryString();
		if(queryString.indexOf("new=")!=-1) {
			return "redirect:/business/mycustomers";
		}else {
			return "redirect:/business/customers";
		}
	}
	/**
	 * 更改一条客户信息
	 * @param customer 需要更改的客户信息
	 * @param customerTypeId 更改的客户信息中的客户类型id
	 * @return 返回值为String，使用模板引擎会跳转到templates下客户信息页面
	 * @changeLog 1.创建 (2020年4月27日 上午10:38:58 [陈一玮]
	 *            2.
	 */
	@RequiresPermissions("customer:update")
	@PutMapping("/business/customers")
	public String updateCustomer(Customer customer,Integer customerTypeId,HttpServletRequest req,Model model) {
		//对前端传参进行数据合法性检查
				Integer jugCustomerData = jugCustomerData(customer, model);
				if(jugCustomerData==0) {
					customer = customerService.showCustomer(customer.getCustomerId());
					model.addAttribute("customer", customer);
						return "/lyear_pages_update_customer";
				}
		customerService.updateCustomer(customer, customerTypeId);
		//获取url中的传参，如果有update属性的传参，则进入我的客户信息页面，否则进入客户信息页面
		if(req.getQueryString().indexOf("update=")!=-1) {
			return "redirect:/business/mycustomers";
		}else {
			return "redirect:/business/customers";
		}
	}
	/**
	 * 删除一条客户信息
	 * @param 需要删除的客户编号id
	 * @return 返回值为String，使用模板引擎会跳转到templates下客户信息页面
	 * @changeLog 1.创建 (2020年4月27日 下午6:17:57 [陈一玮]
	 *            2.
	 */
	@RequiresPermissions("customer:delete")
	@DeleteMapping("/business/customers/{customerId}")
	public String deleteCustomer(@PathVariable("customerId")Integer customerId) {
		customerService.deleteCustomer(customerId);
		return "redirect:/business/customers";
	}
	/**
	 * 删除复选框选中的客户信息
	 * @param ids 客户信息id数组
	 * @return 返回值为String，使用模板引擎会跳转到templates下客户信息页面
	 * @changeLog 1.创建 (2020年4月27日 下午6:18:44 [陈一玮]
	 *            2.
	 */
	@RequiresPermissions("customer:delete")
	@DeleteMapping("/business/customers")
	public String deleteAllCustomer(@RequestParam(value = "ids[]" ,required = false)Integer[] ids)  {
		System.out.println(ids);
		customerService.deleteCheckedCustomer(ids);
		return "redirect:/business/customers";
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
	 * 对前端传参的Customer对象进行合法性检查的方法
	 * @param customer 前端传参的customer
	 * @param model 模型类
	 * @return 返回标志，0为不合法，1为合法
	 * @changeLog 1.创建 (2020年5月5日 下午11:55:03 [陈一玮]
	 *            2.
	 */
	public Integer jugCustomerData(Customer customer,Model model) {
		if(customer.getCustomerName().length()>11||customer.getCustomerName().length()==0) {
			model.addAttribute("customerMsg", "请输入11位以下客户名");
			return 0;
		}
		if(customer.getCustomerCompany().length()>30||customer.getCustomerCompany().length()==0) {
			model.addAttribute("customerMsg", "请输入11位以下公司名");
			return 0;
		}
		if(customer.getCustomerPosition().length()>10||customer.getCustomerPosition().length()==0) {
			model.addAttribute("customerMsg", "请输入10位以下职位名称");
			return 0;
		}
		if(customer.getCustomerDirector().length()>11||customer.getCustomerDirector().length()==0) {
			model.addAttribute("customerMsg", "请输入11位以下负责人名字");
			return 0;
		}
		if(!customer.getCustomerSex().equals("男")&&!customer.getCustomerSex().equals("女")) {
			model.addAttribute("customerMsg", "性别必须为男、女");
			return 0;
		}
		if(!customer.getCustomerEmail().matches(RegexUtil.isEmail)) {
			model.addAttribute("customerMsg", "邮箱需要满足邮箱输入规范");
			return 0;
		}
		if(!customer.getCustomerTel().matches(RegexUtil.isCellNumber)) {
			model.addAttribute("customerMsg", "必须满足11位手机号");
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
	public ModelAndView customerControllerExceptionResolve(Exception ex) {
		ModelAndView mv=new ModelAndView();
		if(ex instanceof CustomerException) {
			System.out.println("customerException");
			mv.setViewName("/lyear_pages_error404");
		}
		return mv;
	}
}
