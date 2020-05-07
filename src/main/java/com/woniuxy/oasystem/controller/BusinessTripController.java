/**  
 * @author 王培霖
 * @createDate 2020年4月23日
 */

package com.woniuxy.oasystem.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.oasystem.entity.BusinessTrip;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.BusinessTripService;
import com.woniuxy.oasystem.service.EmpService;

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
	
	@Autowired
	EmpService empService;
	
	/**
	 * 展示全部出差记录
	 * @return
	 * @changeLog 	1. 创建 (2020年4月23日 下午9:05:48 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/businessTrip/display")
	@ResponseBody
	public List<BusinessTrip> displayBusinessTrip() {
		List<BusinessTrip> trips = businessTripService.displayBusinessTrip();
		return trips;
	}
	
	/**
	 *  分页展示全部差旅记录
	 * @param businessTrip
	 * @param pageIndex
	 * @return
	 * @changeLog 	1. 创建 (2020年4月28日 下午5:54:47 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/businessTrip/list")
	@ResponseBody
	public PageBean<BusinessTrip> listAllBusinessTrip(BusinessTrip businessTrip, Integer pageIndex) {
		if (pageIndex == null)
		{
			pageIndex = 1;
		}
		int pageSize = 10;
		PageBean<BusinessTrip> pageBean = businessTripService.selectBusinessTripByPage(businessTrip, pageIndex, pageSize);
		return pageBean;
	}
	
	/**
	 *  删除差旅记录
	 * @param tripId
	 * @return
	 * @changeLog 	1. 创建 (2020年4月24日 上午11:21:20 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/businessTrip/delete")
	@ResponseBody
	public List<BusinessTrip> deleteEmptyPosition(Integer tripId) {
		businessTripService.deleteBusinessTrip(tripId);
		List<BusinessTrip> trips = businessTripService.displayBusinessTrip();
		return trips;
	}
	
	/**
	 *  批量删除差旅记录
	 * @param leavingIdList
	 * @return
	 * @changeLog 	1. 创建 (2020年4月24日 下午4:11:44 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping(value = "/businessTrip/multiDelete", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<BusinessTrip> multiDeleteLeaving(@RequestParam(value = "leavingIdList[]", required = false) Integer[] leavingIdList) {
		for (Integer leavingId : leavingIdList) {
			businessTripService.deleteBusinessTrip(leavingId);
		}
		List<BusinessTrip> trips = businessTripService.displayBusinessTrip();
		return trips;
	}
	
	/**
	 *  添加差旅记录
	 * @param request
	 * @return
	 * @throws Exception 
	 * @changeLog 	1. 创建 (2020年4月26日 上午10:50:17 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/businessTrip/addBusinessTrip")
	@ResponseBody
	public HashMap<String, String> addBusinessTrip(HttpServletRequest request) throws Exception {
		HashMap<String, String> message = new HashMap<String, String>();
		String empIdNumber = request.getParameter("empIdNumber");
		String tripDate = request.getParameter("tripDate");
		Float tripTime = null;
		try {
			tripTime = Float.parseFloat(request.getParameter("tripTime"));
		} catch (NumberFormatException e) {
			message.put("result", "出差时长输入有误，请检查输入格式是否正确！");
			return message;
		}
		String tripLocation = request.getParameter("tripLocation");
		String tripReason = request.getParameter("tripReason");
		if ("".equals(empIdNumber) || empIdNumber == null || "".equals(tripDate) || tripDate == null) {
			message.put("result", "员工工号和差旅日期不能为空！");
			return message;
		}
		if (tripReason.length() > 50) {
			message.put("result", "出差原因不能超过50字！");
		}
		// 验证当前输入的员工工号是否正确(该员工是否存在)
		Emp currentEmp = empService.verifyEmpIdNumber(empIdNumber);
		if (currentEmp == null) {
			message.put("result", "当前员工不存在！");
			return message;
		} else {
			BusinessTrip businessTrip = new BusinessTrip(currentEmp.getEmpId(), tripDate, tripTime, tripLocation, tripReason);
			businessTripService.addBusinessTrip(businessTrip);
			message.put("result", "添加成功！");
		}
		return message;
	}
	
	/**
	 * 变更差旅记录
	 * @param request
	 * @return
	 * @throws Exception
	 * @changeLog 	1. 创建 (2020年4月27日 下午10:10:43 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/businessTrip/updateBusinessTrip")
	@ResponseBody
	public HashMap<String, String> updateBusinessTrip(HttpServletRequest request) throws Exception {
		HashMap<String, String> message = new HashMap<String, String>();
		// tripId不由用户输入，不会出现异常
		Integer tripId = Integer.parseInt(request.getParameter("tripId"));
		Integer empId = Integer.parseInt(request.getParameter("empId"));
		Float tripTime = null;
		try {
			tripTime = Float.parseFloat(request.getParameter("tripTime"));
		} catch (NumberFormatException e) {
			message.put("result", "出差时长输入有误，请检查输入格式是否正确！");
			return message;
		}
		String tripDate = request.getParameter("tripDate");
		String tripLocation = request.getParameter("tripLocation");
		String tripReason = request.getParameter("tripReason");
		if (tripTime < 0) {
			message.put("result", "出差时长不能为负数！");
			return message;
		}
		BusinessTrip businessTrip = new BusinessTrip(tripId, empId, tripDate, tripTime, tripLocation, tripReason);
		businessTripService.modifyBusinessTrip(businessTrip);
		message.put("result", "修改成功！");
		return message;
	}
	
	/**
	 *  模糊查询差旅记录
	 * @param parameter
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 下午8:52:46 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/businessTrip/search")
	@ResponseBody
	public PageBean<BusinessTrip> searchBusinessTrip(String parameter, BusinessTrip businessTrip, Integer pageIndex) {	
		if (pageIndex == null)
		{
			pageIndex = 1;
		}
		int pageSize = 2;
		businessTrip.setEmpName(parameter);
		PageBean<BusinessTrip> pageBean = businessTripService.searchBusinessTrip(parameter, businessTrip, pageIndex, pageSize);
		return pageBean;
	}
}
