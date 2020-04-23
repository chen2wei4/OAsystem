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

import com.woniuxy.oasystem.entity.Leaving;
import com.woniuxy.oasystem.service.LeavingService;

/**  
 * @Description  请假记录管理
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年4月23日 下午8:42:09 [王培霖])
 *                      	2.
 */

@Controller
public class LeavingController {

	@Autowired
	LeavingService leavingService;
	
	/**
	 * 展示所有差旅记录
	 * TODO
	 * @return 
	 * @changeLog 	1. 创建 (2020年4月23日 下午9:07:26 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("leaving/display")
	@ResponseBody
	public List<Leaving> displayLeaving() {
		List<Leaving> leavings = leavingService.displayLeaving();
		return leavings;
	}
}
