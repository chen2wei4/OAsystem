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
/**
 * 
 * @Description 职工的账号相关控制器
 * @author 陈一玮
 * @changeLog 1.创建 (2020年4月23日 下午2:36:25 [陈一玮]
 *            2.
 */
@Controller
public class EmpController {
	@Autowired
	EmpService empService;
	/**
	 * 
	 * 账号登录方法
	 * @param username 用户输入的账号
	 * @param password 用户输入的密码
	 * @param captcha 用户输入的验证码
	 * @param model 模型类，发送登录失败的信息给前端
	 * @param session 会话类
	 * @return 返回值为String，使用模板引擎会跳转到templates下的动态页面(除非是请求转发和重定向)
	 * @changeLog 1.创建 (2020年4月23日 下午2:44:30 [陈一玮]
	 *            2.
	 */
	@RequestMapping("/emp/login")
	public String getEmp(String username,String password,String captcha,Model model,HttpSession session) {
		Emp emp=null;
		//数据非空判断
		if(username==null||password==null||captcha==null||
				username.equals("")||password.equals("")||captcha.equals("")) {
			model.addAttribute("loginMsg", "请正确输入用户名、密码以及验证码");
			return "/lyear_pages_login";
		}
		//判断用户名是数字，手机号，还是邮箱，然后通过相对应的方法进行查询
		if(username.matches(RegexUtil.isMath)&&!username.matches(RegexUtil.isCellNumber)) {
			emp=empService.getEmpId(Integer.valueOf(username));
		}else if(username.matches(RegexUtil.isCellNumber)) {
			emp=empService.getEmpCellNumber(username);
		}else if(username.matches(RegexUtil.isEmail)) {
			emp=empService.getEmpEmail(username);
		}
		//如果上述账号查询不到账户信息，则用户名不存在
		if(emp==null){
			System.out.println("用户名不存在");
			model.addAttribute("loginMsg", "用户名不存在");
			return "/lyear_pages_login";
		}
		//如果上述账号查询到的密码与输入的密码不同，则密码错误
		if(!emp.getEmpPassword().equals(password)) {
			System.out.println(password);
			System.out.println(emp.getEmpPassword());
			model.addAttribute("loginMsg", "密码错误");
			return "/lyear_pages_login";
		}
		//如果密码和账号都正确，验证码不正确，则验证码错误，大小写识别
		String sessionCode = ((String)session.getAttribute(KAPTCHA_SESSION_KEY)).toLowerCase();
		System.out.println(sessionCode);
		if(!sessionCode.equals(captcha.toLowerCase())) {
			model.addAttribute("loginMsg", "验证码错误");
			return "/lyear_pages_login";
		}
		//将账号信息存储在session域中
		System.out.println(emp);
		session.setAttribute("emp", emp);
		return "/index";
	}
	/**
	 * 
	 * 修改密码的方法
	 * @param oldpwd 旧的密码
	 * @param newpwd 新的密码
	 * @param confirmpwd 第二次输入的新密码
	 * @return 返回值为String，使用模板引擎会跳转到templates下的修改密码页面
	 * @changeLog 1.创建 (2020年4月23日 下午4:52:38 [陈一玮]
	 *            2.
	 */
	@RequestMapping("/emp/newpwd")
	public String changePwd(String oldpwd,String newpwd,String confirmpwd,Model model,
			HttpSession session) {
		Emp emp = (Emp) session.getAttribute("emp");
		//获取真实密码和职工id
		String trueOldPwd = emp.getEmpPassword();
		Integer empId = emp.getEmpId();
		//对密码进行合理性检查
		if(oldpwd==null||newpwd==null||confirmpwd==null||
				oldpwd.equals("")||newpwd.equals("")||confirmpwd.equals("")) {
			model.addAttribute("newPwdMsg", "请正确输入新旧密码");
		}else if(!newpwd.equals(confirmpwd)) {
			model.addAttribute("newPwdMsg", "请确保两次密码一致！");
		}else if(!trueOldPwd.equals(oldpwd)) {
			model.addAttribute("newPwdMsg", "账号原有密码输入错误，请重新输入");
		}else {
			//如果密码合理则进行修改密码服务，并将更改后的职工信息进行查询，并存入session域中
			empService.changeNewPwd(empId, newpwd);
			model.addAttribute("newPwdMsg", "修改成功");
			emp = empService.getEmpId(empId);
			session.setAttribute("emp", emp);
		}
		//更改密码后返回更改密码页面
		return "/lyear_pages_edit_pwd";
	}
	/**
	 * 绑定账号方法
	 * @param bindTel 需要绑定的手机号
	 * @param model 模型对象
	 * @param session 会话对象
	 * @return 返回值为String，使用模板引擎会跳转到templates下的绑定账号页面
	 * @changeLog 1.创建 (2020年4月23日 下午9:39:03 [陈一玮]
	 */
	@RequestMapping("/emp/bindTel")
	public String bindTel(String bindTel,Model model,HttpSession session) {
		//获取职工id
		Emp emp = (Emp) session.getAttribute("emp");
		Integer empId = emp.getEmpId();
		//对需要绑定的手机号进行合理性检查
		if(bindTel==null||bindTel.equals("")) {
			model.addAttribute("bindTelMsg", "请输入手机号");
			return "/lyear_pages_bind_account";
		}else if(bindTel.matches(RegexUtil.isCellNumber)) {
			//若满足合法性检查则进行绑定手机号业务
			empService.bindTel(empId, bindTel);
			//绑定好账号之后，把更新后的职工信息重新查询并存入session域中
			emp = empService.getEmpId(empId);
			session.setAttribute("emp", emp);
			//返回绑定账号页面
			return "/lyear_pages_bind_account";
		}else {
			model.addAttribute("bindTelMsg", "请输入正确的手机号");
		}
		return "/lyear_pages_bind_account";
	}
	/**
	 * 绑定账号方法
	 * @param bindEmail 需要绑定邮箱号
	 * @param model 模型对象
	 * @param session 会话对象
	 * @return 返回值为String，使用模板引擎会跳转到templates下的绑定账号页面
	 * @changeLog 1.创建 (2020年4月23日 下午9:39:03 [陈一玮]
	 */
	@RequestMapping("/emp/bindEmail")
	public String bindEmail(String bindEmail,Model model,HttpSession session) {
		//获取职工id
		Emp emp = (Emp) session.getAttribute("emp");
		Integer empId = emp.getEmpId();
		//对需要绑定的邮箱号进行合理性检查
		if(bindEmail==null||bindEmail.equals("")) {
			model.addAttribute("bindEmailMsg", "请输入邮箱");
			return "/lyear_pages_bind_account";
		}else if(bindEmail.matches(RegexUtil.isEmail)) {
			//若满足合法性检查则进行绑定邮箱业务
			empService.bindEmail(empId, bindEmail);
			//绑定好账号之后，把更新后的职工信息重新查询并存入session域中
			emp = empService.getEmpId(empId);
			session.setAttribute("emp", emp);
			return "/lyear_pages_bind_account";
		}else {
			model.addAttribute("bindEmailMsg", "请输入正确的邮箱");
		}
		return "/lyear_pages_bind_account";
	}
	@RequestMapping("/emp/logoff")
	public String logOff(HttpSession session) {
		session.removeAttribute("emp");
		return "/lyear_pages_login";
	}
}
