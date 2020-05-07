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
import com.woniuxy.oasystem.entity.EmptyPosition;
import com.woniuxy.oasystem.entity.Interview;
import com.woniuxy.oasystem.entity.IntervieweeInfo;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.EmpService;
import com.woniuxy.oasystem.service.EmptyPositionService;
import com.woniuxy.oasystem.service.InterviewService;
import com.woniuxy.oasystem.service.IntervieweeInfoService;

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
	
	@Autowired
	EmptyPositionService emptyPositionService;
	
	@Autowired
	IntervieweeInfoService intervieweeInfoService;
	
	@Autowired
	EmpService empService;
	
	/**
	 * 展示所有面试记录
	 * @return
	 * @changeLog 	1. 创建 (2020年4月23日 下午9:06:24 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/interview/display")
	@ResponseBody
	public List<Interview> displayInterview() {
		List<Interview> interviews = interviewService.displayInterview();
		return interviews;
	}
	
	/**
	 *  删除面试记录
	 * @param intervieweeId
	 * @return
	 * @changeLog 	1. 创建 (2020年4月24日 上午10:13:49 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/interview/delete")
	@ResponseBody
	public List<Interview> deleteInterview(Integer interviewId) {
		interviewService.deleteInterview(interviewId);
		List<Interview> interview = interviewService.displayInterview();
		return interview;
	}
	
	/**
	 *  分页显示面试记录
	 * @param interview
	 * @param pageIndex
	 * @return
	 * @changeLog 	1. 创建 (2020年4月28日 下午5:26:07 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/interview/list")
	@ResponseBody
	public PageBean<Interview> listAllInterview(Interview interview, Integer pageIndex) {
		if (pageIndex == null)
		{
			pageIndex = 1;
		}
		int pageSize = 10;
		PageBean<Interview> pageBean = interviewService.selectInterviewByPage(interview, pageIndex, pageSize);
		return pageBean;
	}
	
	/**
	 *  批量删除面试记录
	 * @param leavingIdList
	 * @return
	 * @changeLog 	1. 创建 (2020年4月24日 下午3:49:17 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping(value = "/interview/multiDelete", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<Interview> multiDeleteLeaving(@RequestParam(value = "leavingIdList[]", required = false) Integer[] leavingIdList) {
		for (Integer leavingId : leavingIdList) {
			interviewService.deleteInterview(leavingId);
		}
		List<Interview> interview = interviewService.displayInterview();
		return interview;
	}
	
	/**
	 * 展示全部空缺职位
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 上午11:40:22 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/interview/displayEmptyPosition")
	@ResponseBody
	public List<EmptyPosition> displayEmptyPosition() {
		List<EmptyPosition> positions = emptyPositionService.displayEmptyPosition();
		return positions;
	}
	
	/**
	 *  添加面试信息
	 * @param request
	 * @return
	 * @throws Exception 
	 * @changeLog 	1. 创建 (2020年4月26日 下午1:54:01 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/interview/addInterview")
	@ResponseBody
	public HashMap<String, String> addInterview(HttpServletRequest request) throws Exception {
		HashMap<String, String> message = new HashMap<String, String>();
		String intervieweeName = request.getParameter("intervieweeName");
		Integer positionId = Integer.parseInt(request.getParameter("positionId"));
		String empIdNumber = request.getParameter("empIdNumber");
		String interviewLocation = request.getParameter("interviewLocation");
		String interviewTime = request.getParameter("interviewTime");
		String intervieweePhone = request.getParameter("intervieweePhone");
		if (intervieweeName == null || "".equals(intervieweeName) || empIdNumber == null || "".equals(empIdNumber) || interviewLocation == null || "".equals(interviewLocation)
				|| interviewTime == null || "".equals(interviewTime) || intervieweePhone == null || "".equals(intervieweePhone)) {
			message.put("result", "面试人姓名，电话，面试官工号，面试地点和时间必须填写！");
			return message;
		}
		// 根据面试者姓名和电话查询此人是否存在
		IntervieweeInfo currentInterviewee = intervieweeInfoService.verityIntervieweeInfo(intervieweeName, intervieweePhone);
		if (currentInterviewee == null) {
			message.put("result", "您输入的面试人员姓名或电话有误！");
			return message;
		}
		System.out.println("当前面试人员信息：" + currentInterviewee.toString());
		// 根据员工工号查找此人是否存在
		Emp currentInterviewer = empService.verifyEmpIdNumber(empIdNumber);
		if (currentInterviewer == null) {
			message.put("result", "您输入的员工工号有误，该员工不存在！");
			return message;
		}
		Interview interview = new Interview(null, currentInterviewee.getIntervieweeId(), positionId, currentInterviewer.getEmpId(), empIdNumber, intervieweeName, null, null, interviewLocation, interviewTime);
		interviewService.addInterview(interview);
		message.put("result", "添加成功！");
		return message;
	}
	
	/**
	 *  变更面试信息
	 * @param request
	 * @return
	 * @throws Exception
	 * @changeLog 	1. 创建 (2020年4月28日 下午9:09:04 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/interview/updateInterview")
	@ResponseBody
	public HashMap<String, String> updateInterview(HttpServletRequest request) throws Exception {
		HashMap<String, String> message = new HashMap<String, String>();
		Integer interviewId = Integer.parseInt(request.getParameter("interviewId"));
		Integer positionId = Integer.parseInt(request.getParameter("positionId"));
		String empIdNumber = request.getParameter("empIdNumber");
		String interviewLocation = request.getParameter("interviewLocation");
		String interviewTime = request.getParameter("interviewTime");
		if (empIdNumber == null || interviewLocation == null || interviewTime == null || "".equals(interviewLocation) 
				|| "".equals(empIdNumber) || "".equals(interviewTime)) {
			message.put("result", "面试官工号，面试时间和地点不能为空！");
			return message;
		}
		// 根据员工工号查找此人是否存在
		Emp currentInterviewer = empService.verifyEmpIdNumber(empIdNumber);
		if (currentInterviewer == null) {
			message.put("result", "您输入的员工工号有误，该员工不存在！");
			return message;
		}
		Interview interview = new Interview(interviewId, positionId, currentInterviewer.getEmpId(), interviewLocation, interviewTime);
		interviewService.modifyInterview(interview);
		message.put("result", "变更成功！");
		return message;
	}
	
	/**
	 *  模糊查询面试信息
	 * @param parameter
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 下午8:54:43 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/interview/search")
	@ResponseBody
	public PageBean<Interview> searchLeaving(String parameter, Interview interview, Integer pageIndex) {
		System.out.println("当前页数：" + pageIndex);
		if (pageIndex == null)
		{
			pageIndex = 1;
		}
		int pageSize = 2;
		PageBean<Interview> pageBean = interviewService.searchInterview(parameter, interview, pageIndex, pageSize);
		return pageBean;
	}
}
