/**
 * @author 陈一玮
 * @createDate 2020年4月28日
 */
package com.woniuxy.oasystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.woniuxy.oasystem.entity.Customer;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.exception.CustomerException;
import com.woniuxy.oasystem.service.MyCustomerService;

/**
 * @Description 我的客户控制器
 * @author 陈一玮
 * @changeLog 1.创建 (2020年4月28日 上午11:23:49 [陈一玮]
 *            2.
 */
@Controller
public class MyCustomerController {
	@Autowired
	MyCustomerService myCustomerService;
	/**
	  * 获取我的客户信息
	 * @param model 模型类
	 * @param customer 搜索引擎中的查询条件
	 * @param currentPage 当前页码
	 * @param req 请求域对象
	 * @param session 会话域对象
	 * @return 返回值为String，使用模板引擎会跳转到templates下我的客户信息页面
	 * @changeLog 1.创建 (2020年4月29日 上午10:17:20 [陈一玮]
	 *            2.
	 */
	@RequestMapping("/business/mycustomers")
	public String showMyCunstomers(Model model,Customer customer,Integer currentPage,HttpServletRequest req,HttpSession session) {
		if(currentPage==null) {
			currentPage=1;
		}
		String uri = getUri(req);
		Emp emp = (Emp) session.getAttribute("emp");
		System.out.println(emp);
		PageBean<Customer> pb = myCustomerService.showMyCustomers(customer,currentPage,emp.getEmpName());
		System.out.println(pb);
		pb.setUrl(uri);
		if(customer!=null) {
			model.addAttribute("customer", customer);
		}
		model.addAttribute("pb", pb);
		return "/lyear_pages_mycustomers";
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
	 * 简陋的异常处理
	 * @param ex 遇到的异常
	 * @return 返回模型和视图对象
	 * @changeLog 1.创建 (2020年5月6日 上午12:05:31 [陈一玮]
	 *            2.
	 */
	@ExceptionHandler
	public ModelAndView myCustomerControllerExceptionResolve(Exception ex) {
		ModelAndView mv=new ModelAndView();
		if(ex instanceof CustomerException) {
			System.out.println("myCustomerException");
			mv.setViewName("/lyear_pages_error404");
		}
		return mv;
	}
}
