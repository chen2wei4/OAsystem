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

import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.Leaving;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.entity.Vacation;
import com.woniuxy.oasystem.service.EmpService;
import com.woniuxy.oasystem.service.LeavingService;
import com.woniuxy.oasystem.service.VacationService;

/**  
 * @Description  请假记录管理
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年4月23日 下午8:42:09 [王培霖])
 */

@Controller
public class LeavingController {

	@Autowired
	LeavingService leavingService;
	
	@Autowired
	VacationService vacationService;
	
	@Autowired
	EmpService empService;
	
	/**
	 * 展示所有差旅记录
	 * @return 
	 * @changeLog 	1. 创建 (2020年4月23日 下午9:07:26 [王培霖])  </br>
	 */
	@RequestMapping("/leaving/display")
	@ResponseBody
	public List<Leaving> displayLeaving() {
		List<Leaving> leavings = leavingService.displayLeaving();
		return leavings;
	}
	
	/**
	 *  分页展示请假记录
	 * @param leaving
	 * @param pageIndex
	 * @return
	 * @changeLog 	1. 创建 (2020年4月28日 下午3:19:32 [王培霖])  </br>
	 */
	@RequestMapping("/leaving/list")
	@ResponseBody
	public PageBean<Leaving> listAllLeaving(Leaving leaving, Integer pageIndex) {
		if (pageIndex == null)
		{
			pageIndex = 1;
		}
		int pageSize = 10;
		PageBean<Leaving> pageBean = leavingService.selectLeavingByPage(leaving, pageIndex, pageSize);
		return pageBean;
	}
	
	/**
	 * 删除差旅记录
	 * @param leavingId
	 * @changeLog 	1. 创建 (2020年4月23日 下午11:11:34 [王培霖])  </br>
	 */
	@RequestMapping("/leaving/delete")
	@ResponseBody
	public List<Leaving> deleteLeaving(Integer leavingId) {
		leavingService.deleteLeaving(leavingId);
		List<Leaving> leavings = leavingService.displayLeaving();
		return leavings;
	}
	
	/**
	 * 批量删除差旅记录
	 * @param leavingIdList
	 * @return
	 * @changeLog 	1. 创建 (2020年4月24日 下午2:53:31 [王培霖])  </br>
	 */
	@RequestMapping(value = "/leaving/multiDelete", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<Leaving> multiDeleteLeaving(@RequestParam(value = "leavingIdList[]", required = false) Integer[] leavingIdList) {
		for (Integer leavingId : leavingIdList) {
			leavingService.deleteLeaving(leavingId);
		}
		List<Leaving> leavings = leavingService.displayLeaving();
		return leavings;
	}
	
	/**
	 * 展示所有假期选项
	 * @return
	 * @changeLog 	1. 创建 (2020年4月24日 下午6:30:40 [王培霖])  </br>
	 */
	@RequestMapping("/leaving/displayVacation")
	@ResponseBody
	public List<Vacation> displayVacation() {
		List<Vacation> vacations = vacationService.displayVacation();
		return vacations;
	}
	
	/**
	 *  添加请假记录
	 * @param request
	 * @return
	 * @throws Exception 
	 * @changeLog 	1. 创建 (2020年4月24日 下午10:06:32 [王培霖])  </br>
	 */
	@RequestMapping("/leaving/addLeaving")
	@ResponseBody
	public HashMap<String, String> addLeaving(HttpServletRequest request) throws Exception {
		HashMap<String, String> message = new HashMap<String, String>();
		String empIdNumber = request.getParameter("empIdNumber");
		String leavingDate = request.getParameter("leavingDate");
		// 验证请假时长
		Float leavingTime = null;
		try {
			leavingTime = Float.parseFloat(request.getParameter("leavingTime"));			
		} catch (NumberFormatException e) {
			message.put("result", "出差时长输入有误！");
			return message;
		}
		// 假期类型不会出现转换错误
		Integer vacationType = Integer.parseInt(request.getParameter("vacationType"));
		String leavingReason = request.getParameter("leavingReason");
		// 员工工号，请假日期和请假时长必填
		if ("".equals(empIdNumber) || empIdNumber == null || "".equals(leavingDate) 
				|| leavingDate == null || leavingTime == null) {
			message.put("result", "员工工号，请假日期和请假时长必须填写！");
			return message;
		}
		if (leavingTime < 0) {
			message.put("result", "请假时长不能为负数！");
			return message;
		}
		if (leavingReason != null && leavingReason.length() > 50) {
			message.put("result", "请假原因不能超过50个字！");
			return message;
		}
		// 验证当前输入的员工工号是否正确(该员工是否存在)
		Emp currentEmp = empService.verifyEmpIdNumber(empIdNumber);
		if (currentEmp == null) {
			message.put("result", "员工工号输入有误，该员工不存在！");
			return message;
		} else {
			Leaving leaving = new Leaving(currentEmp.getEmpId(), leavingDate, leavingTime, vacationType, leavingReason);
			leavingService.addLeaving(leaving);
			message.put("result", "添加成功！");
		}
		return message;
	}
	
	/**
	 *  变更请假信息
	 * @param request
	 * @return
	 * @throws Exception 
	 * @changeLog 	1. 创建 (2020年4月27日 下午2:04:32 [王培霖])  </br>
	 */
	@RequestMapping("/leaving/updateLeaving")
	@ResponseBody
	public HashMap<String, String> updateLeaving(HttpServletRequest request) throws Exception {
		HashMap<String, String> message = new HashMap<String, String>();
		Integer leavingId = Integer.parseInt(request.getParameter("leavingId"));
		Integer empId = Integer.parseInt(request.getParameter("empId"));
		String leavingDate = request.getParameter("leavingDate");
		// 验证请假时长
		Float leavingTime = null;
		try {
			leavingTime = Float.parseFloat(request.getParameter("leavingTime"));			
		} catch (NumberFormatException e) {
			message.put("result", "出差时长输入有误！");
			return message;
		}
		Integer vacationId = Integer.parseInt(request.getParameter("vacationType"));
		String leavingReason = request.getParameter("leavingReason");
		// 员工工号，请假日期和请假时长必填
		if ("".equals(leavingDate) || leavingDate == null || leavingTime == null) {
			message.put("result", "请假日期和请假时长必须填写！");
			return message;
		}
		if (leavingTime < 0) {
			message.put("result", "请假时长不能为负数！");
			return message;
		}
		if (leavingReason != null && leavingReason.length() > 50) {
			message.put("result", "请假原因不能超过50个字！");
			return message;
		}
		Leaving leaving = new Leaving(leavingId, empId, leavingDate, leavingTime, vacationId, leavingReason);
		leavingService.modifyLeaving(leaving);
		message.put("result", "变更成功！");
		return message;
	}
	
	/**
	 *  模糊查询请假记录
	 * @param parameter
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 下午3:23:38 [王培霖])  </br>
	 */
	@RequestMapping("/leaving/search")
	@ResponseBody
	public PageBean<Leaving> searchLeaving(String parameter, Leaving leaving, Integer pageIndex) {	
		if (pageIndex == null)
		{
			pageIndex = 1;
		}
		int pageSize = 2;
		leaving.setEmpName(parameter);
		PageBean<Leaving> pageBean = leavingService.searchLeaving(parameter, leaving, pageIndex, pageSize);
		return pageBean;
	}
}
