package com.woniuxy.oasystem.controller;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.service.EmpService;
import com.woniuxy.oasystem.util.RegexUtil;

@Controller
public class EmpController {
	@Autowired
	EmpService empService;

	@RequestMapping("/emp/login")
	public String getEmp(String username, String password, String captcha, Model model, HttpSession session) {
		Emp emp = null;
		if (username.matches(RegexUtil.isMath) && !username.matches(RegexUtil.isCellNumber)) {
			emp = empService.getEmpId(Integer.valueOf(username));
		} else if (username.matches(RegexUtil.isCellNumber)) {
			emp = empService.getEmpCellNumber(username);
		} else if (username.matches(RegexUtil.isEmail)) {
			emp = empService.getEmpEmail(username);
		}
		if (emp == null) {
			System.out.println("用户名不存在");
			model.addAttribute("loginMsg", "用户名不存在");
			return "/lyear_pages_login";
		}
		if (!emp.getEmpPassword().equals(password)) {
			System.out.println(password);
			System.out.println(emp.getEmpPassword());
			model.addAttribute("loginMsg", "密码错误");
			return "/lyear_pages_login";
		}
		String sessionCode = (String) session.getAttribute(KAPTCHA_SESSION_KEY);
		System.out.println(sessionCode);
		/*
		 * if (!sessionCode.equals(captcha)) { model.addAttribute("loginMsg", "验证码错误");
		 * return "/lyear_pages_login"; }
		 */
		System.out.println(emp);
		session.setAttribute("emp", emp);
		return "index";
	}
}
