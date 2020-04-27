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

import com.woniuxy.oasystem.entity.Interview;
import com.woniuxy.oasystem.service.InterviewService;

/**  
 * @Description  面试记录管理
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年4月23日 下午8:01:49 [王培霖])
 *                      	2.
 */

@Controller
public class InterviewController {
	
	@Autowired
	InterviewService interviewService ;
	
	/**
	 * 展示所有面试记录
	 * TODO
	 * @return
	 * @changeLog 	1. 创建 (2020年4月23日 下午9:06:24 [mayuhang])  </br>
	 *                      	2.
	 */
	@RequestMapping("interview/display")
	@ResponseBody
	public List<Interview> displayInterview() {
		List<Interview> interviews = interviewService.displayInterview();
		return interviews;
	}
}
