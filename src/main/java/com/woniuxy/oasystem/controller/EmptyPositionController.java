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

import com.woniuxy.oasystem.entity.EmptyPosition;
import com.woniuxy.oasystem.service.EmptyPositionService;

/**  
 * @Description  空缺职位管理
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年4月23日 下午3:13:55 [王培霖])
 *                      	2.
 */

@Controller
public class EmptyPositionController {
	@Autowired
	EmptyPositionService emptyPositionService;
	
	/**
	 * 展示所有空缺职位
	 * TODO
	 * @return
	 * @changeLog 	1. 创建 (2020年4月23日 下午3:41:46 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/emptyPosition/display")
	@ResponseBody
	public List<EmptyPosition> displayEmptyPosition() {
		List<EmptyPosition> emptyPositions = emptyPositionService.displayEmptyPosition();
		return emptyPositions;
	}
}