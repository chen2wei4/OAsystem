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

import com.woniuxy.oasystem.entity.Department;
import com.woniuxy.oasystem.entity.EmptyPosition;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.DepartmentService;
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
	
	@Autowired
	DepartmentService departmentService;
	
	/**
	 * 展示所有空缺职位
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
	
	/**
	 *  分页展示空缺职位
	 * @param emptyPosition
	 * @param pageIndex
	 * @return
	 * @changeLog 	1. 创建 (2020年4月28日 下午5:39:26 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/emptyPosition/list")
	@ResponseBody
	public PageBean<EmptyPosition> listAllLeaving(EmptyPosition emptyPosition, Integer pageIndex) {
		if (pageIndex == null)
		{
			pageIndex = 1;
		}
		int pageSize = 5;
		PageBean<EmptyPosition> pageBean = emptyPositionService.selectEmptyPositionByPage(emptyPosition, pageIndex, pageSize);
		return pageBean;
	}
	
	/**
	 *  删除空缺职位
	 * @param interviewId 面试记录主键
	 * @return
	 * @changeLog 	1. 创建 (2020年4月24日 上午11:05:12 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/emptyPosition/delete")
	@ResponseBody
	public List<EmptyPosition> deleteEmptyPosition(Integer positionId) {
		emptyPositionService.deleteEmptyPosition(positionId);
		List<EmptyPosition> positions = emptyPositionService.displayEmptyPosition();
		return positions;
	}
	
	/**
	 *  批量删除空缺职位
	 * @param leavingIdList
	 * @return
	 * @changeLog 	1. 创建 (2020年4月24日 下午4:02:40 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping(value = "/emptyPosition/multiDelete", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<EmptyPosition> multiDeleteLeaving(@RequestParam(value = "leavingIdList[]", required = false) Integer[] leavingIdList) {
		for (Integer leavingId : leavingIdList) {
			emptyPositionService.deleteEmptyPosition(leavingId);
		}
		List<EmptyPosition> positions = emptyPositionService.displayEmptyPosition();
		return positions;
	}
	
	/**
	 *  显示全部空缺职位
	 * @return
	 * @changeLog 	1. 创建 (2020年4月25日 下午10:37:50 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/emptyPosition/displayDepartment")
	@ResponseBody
	public List<Department> displayDepartment() {
		List<Department> departments = departmentService.displayDepartment();
		return departments;
	}
	
	/**
	 *  添加空缺职位
	 * @param request
	 * @return
	 * @changeLog 	1. 创建 (2020年4月25日 下午10:57:07 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/emptyPosition/addEmptyPosition")
	@ResponseBody
	public HashMap<String, String> addEmptyPosition(HttpServletRequest request) {
		HashMap<String, String> message = new HashMap<String, String>();
		String positionName = request.getParameter("positionName");
		Integer positionNumber = null;
		Integer positionSalary = null;
		// 工资和招聘数量可能出现类型转换异常
		try {
			positionSalary = Integer.parseInt(request.getParameter("positionSalary"));
			positionNumber = Integer.parseInt(request.getParameter("positionNumber"));			
		} catch (NumberFormatException e) {
			message.put("result", "薪资或招聘数量输入不正确！");
			return message;
		}
		// 部门编号不由用户输入，不会出现转换异常
		Integer departmentId = Integer.parseInt(request.getParameter("departmentId"));
		String positionEducationBackground = request.getParameter("positionEducationBackground");
		String positionDescription = request.getParameter("positionDescription");
		if (positionNumber < 0 || positionSalary < 0) {
			message.put("result", "薪资或招聘数量不能为负数！");
			return message;
		}
		if (positionDescription.length() > 100) {
			message.put("result", "职责简介不能超过100个字！");
			return message;
		}
		EmptyPosition emptyPosition = new EmptyPosition(departmentId, positionName, positionNumber, positionSalary, positionEducationBackground, positionDescription);
		emptyPositionService.addEmptyPosition(emptyPosition);
		message.put("result", "添加成功！");
		return message;
	}
	
	/**
	 * 修改空缺职位信息
	 * @param request
	 * @return
	 * @changeLog 	1. 创建 (2020年4月27日 下午7:47:16 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/emptyPosition/updateEmptyPosition")
	@ResponseBody
	public HashMap<String, String> updateEmptyPosition(HttpServletRequest request) {
		HashMap<String, String> message = new HashMap<String, String>();
		Integer positionId = Integer.parseInt(request.getParameter("positionId"));
		String positionName = request.getParameter("positionName");
		Integer positionNumber = null;
		Integer positionSalary = null;
		try {
			positionNumber = Integer.parseInt(request.getParameter("positionNumber"));
			positionSalary = Integer.parseInt(request.getParameter("positionSalary"));			
		} catch (NumberFormatException e) {
			message.put("result", "薪资或招聘数量输入不正确！");
			return message;
		}
		Integer departmentId = Integer.parseInt(request.getParameter("departmentId"));
		String positionEducationBackground = request.getParameter("positionEducationBackground");
		String positionDescription = request.getParameter("positionDescription");
		if (positionNumber < 0 || positionSalary < 0) {
			message.put("result", "薪资或招聘数量不能为负数！");
			return message;
		}
		if (positionDescription.length() > 100) {
			message.put("result", "职责简介不能超过100个字！");
			return message;
		}
		EmptyPosition emptyPosition = new EmptyPosition(positionId, departmentId, positionName, positionNumber, positionSalary, positionEducationBackground, positionDescription);
		emptyPositionService.modifyEmptyPosition(emptyPosition);
		message.put("result", " 变更成功！");
		return message;
	}
	
	/**
	 *  模糊查询空缺职位
	 * @param parameter
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 下午6:52:18 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/emptyPosition/search")
	@ResponseBody
	public PageBean<EmptyPosition> searchEmptyPosition(HttpServletRequest request, EmptyPosition emptyPosition, Integer pageIndex) {
		String parameter = request.getParameter("parameter");
		String department = request.getParameter("department");
		String educationBackground = request.getParameter("intervieweeEducationBackground");
		Integer departmentId = null;
		if (!"".equals(department)) {
			departmentId = Integer.parseInt(department);
		}
		if (pageIndex == null)
		{
			pageIndex = 1;
		}
		int pageSize = 2;
		PageBean<EmptyPosition> pageBean = emptyPositionService.searchEmptyPosition(parameter, emptyPosition, departmentId, educationBackground, pageIndex, pageSize);
		return pageBean;
	}
}