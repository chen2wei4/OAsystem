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

import com.woniuxy.oasystem.entity.BusinessTrip;
import com.woniuxy.oasystem.service.BusinessTripService;

/**  
 * @Description  差旅记录管理
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年4月23日 下午8:16:10 [王培霖])
 *                      	2.
 */
@Controller
public class BusinessTripController {
	@Autowired
	BusinessTripService businessTripService;
	
	/**
	 * 展示全部出差记录
	 * TODO
	 * @return
	 * @changeLog 	1. 创建 (2020年4月23日 下午9:05:48 [mayuhang])  </br>
	 *                      	2.
	 */
	@RequestMapping("businessTrip/display")
	@ResponseBody
	public List<BusinessTrip> displayBusinessTripService() {
		List<BusinessTrip> trips = businessTripService.displayBusinessTrip();
		return trips;
	}
}
