/**  
 * @author 王培霖
 * @createDate 2020年5月2日
 */

package com.woniuxy.oasystem.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.oasystem.entity.SignIn;
import com.woniuxy.oasystem.service.SignInService;

/**  
 * @Description  TODO
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年5月2日 下午11:36:59 [王培霖])
 *                      	2.
 */

@Controller
public class SignInController {
	@Autowired
	SignInService signInService;
	
	/**
	 * 签到函数
	 * @param request
	 * @return
	 * @changeLog 	1. 创建 (2020年5月3日 上午12:20:07 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/signIn/checkIn")
	@ResponseBody
	public HashMap<String, String> addCheckIn(HttpServletRequest request) {
		HashMap<String, String> message = new HashMap<String, String>();
		Integer empId = Integer.parseInt(request.getParameter("empId"));
		SignIn signIn = new SignIn(null, empId, null, 1, 1);
		// 验证今日是否已签到
		SignIn checkResult = signInService.verifyCheckIn(empId);
		if (checkResult != null) {
			message.put("result", "今日已签到！");
			return message;
		}
		// 验证当前时间是否在8:30-9:30
		boolean result = signInService.verifyCheckInTime();
		if (result == false) {
			message.put("result", "当前未到打卡时间，打卡时间为8:30~9:30！");
			return message;
		}
		signInService.addCheckIn(signIn);
		message.put("result", "签到成功！");
		return message;
	}
	
	@RequestMapping("/signIn/verifyCheckIn")
	@ResponseBody
	public HashMap<String, String> verifyCheckIn(HttpServletRequest request) {
		HashMap<String, String> message = new HashMap<String, String>();
		Integer empId = Integer.parseInt(request.getParameter("empId"));
		// 验证今日是否已签到
		SignIn checkResult = signInService.verifyCheckIn(empId);
		if (checkResult != null) {
			message.put("result", "true");
		} else {
			message.put("result", "false");
		}
		return message;
	}
}
