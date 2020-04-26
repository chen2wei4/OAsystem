/**  
 * @author 王培霖
 * @createDate 2020年4月23日
 */

package com.woniuxy.oasystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.oasystem.entity.IntervieweeInfo;
import com.woniuxy.oasystem.service.IntervieweeInfoService;

/**  
 * @Description  面试人员信息管理
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年4月23日 下午7:35:14 [mayuhang])
 *                      	2.
 */
@Controller
public class IntervieweeInfoController {
	@Autowired
	IntervieweeInfoService intervieweeInfoService;
	
	/**
	 * 展示所有求职者信息
	 * TODO
	 * @return
	 * @changeLog 	1. 创建 (2020年4月23日 下午9:06:57 [mayuhang])  </br>
	 *                      	2.
	 */
	@RequestMapping("intervieweeInfo/display")
	@ResponseBody
	public List<IntervieweeInfo> displayIntervieweeInfo() {
		List<IntervieweeInfo> intervieweeInfos = intervieweeInfoService.displayIntervieweeInfo();
		return intervieweeInfos;
	}
}
