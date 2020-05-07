/**  
 * @author 王培霖
 * @createDate 2020年5月3日
 */

package com.woniuxy.oasystem.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.oasystem.entity.CheckIn;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.CheckInService;

/**  
 * @Description  TODO
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年5月3日 下午10:02:49 [王培霖])
 *                      	2.
 */

@Controller
public class CheckInController {
	
	@Autowired
	CheckInService checkInService;
	
	/**
	 * 展示全部签到记录
	 * @param checkIn
	 * @param pageIndex
	 * @return
	 * @changeLog 	1. 创建 (2020年5月3日 下午11:05:25 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/checkIn/list")
	@ResponseBody
	public PageBean<CheckIn> listAllCheckIn(CheckIn checkIn, Integer pageIndex) {
		if (pageIndex == null)
		{
			pageIndex = 1;
		}
		int pageSize = 10;
		PageBean<CheckIn> pageBean = checkInService.selectCheckInByPage(checkIn, pageIndex, pageSize);
		return pageBean;
	}
	
	/**
	 *  模糊查询打卡记录
	 * @param request
	 * @param checkIn
	 * @param pageIndex
	 * @return
	 * @changeLog 	1. 创建 (2020年5月3日 下午11:47:17 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/checkIn/search")
	@ResponseBody
	public PageBean<CheckIn> searchCheckIn(HttpServletRequest request, CheckIn checkIn, Integer pageIndex) {
		String parameter = request.getParameter("parameter");
		if (pageIndex == null)
		{
			pageIndex = 1;
		}
		int pageSize = 5;
		PageBean<CheckIn> pageBean = checkInService.searchCheckIn(parameter, checkIn, pageIndex, pageSize);
		return pageBean;
	}
}
