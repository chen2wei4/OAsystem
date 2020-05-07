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

import com.woniuxy.oasystem.entity.EmptyPosition;
import com.woniuxy.oasystem.entity.IntervieweeInfo;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.EmptyPositionService;
import com.woniuxy.oasystem.service.IntervieweeInfoService;

/**  
 * @Description  面试人员信息管理
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年4月23日 下午7:35:14 [王培霖])
 *                      	2.
 */
@Controller
public class IntervieweeInfoController {
	@Autowired
	IntervieweeInfoService intervieweeInfoService;
	
	@Autowired
	EmptyPositionService emptyPositionService;
	
	/**
	 * 展示所有求职者信息
	 * @return
	 * @changeLog 	1. 创建 (2020年4月23日 下午9:06:57 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/intervieweeInfo/display")
	@ResponseBody
	public List<IntervieweeInfo> displayIntervieweeInfo() {
		List<IntervieweeInfo> intervieweeInfos = intervieweeInfoService.displayIntervieweeInfo();
		return intervieweeInfos;
	}
	
	/**
	 * 删除求职者信息
	 * @param intervieweeInfoId
	 * @changeLog 	1. 创建 (2020年4月23日 下午11:43:20 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/intervieweeInfo/delete")
	@ResponseBody
	public List<IntervieweeInfo> deleteIntervieweeInfo(Integer intervieweeId) {
		intervieweeInfoService.deleteIntervieweeInfo(intervieweeId);
		List<IntervieweeInfo> intervieweeInfos = intervieweeInfoService.displayIntervieweeInfo();
		return intervieweeInfos;
	}
	
	/**
	 *  分页展示求职者信息
	 * @param intervieweeInfo
	 * @param pageIndex
	 * @return
	 * @changeLog 	1. 创建 (2020年4月28日 下午5:15:55 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/intervieweeInfo/list")
	@ResponseBody
	public PageBean<IntervieweeInfo> listAllIntervieweeInfo(IntervieweeInfo intervieweeInfo, Integer pageIndex) {
		if (pageIndex == null)
		{
			pageIndex = 1;
		}
		int pageSize = 3;
		PageBean<IntervieweeInfo> pageBean = intervieweeInfoService.selectIntervieweeInfoByPage(intervieweeInfo, pageIndex, pageSize);
		return pageBean;
	}
	
	/**
	 *  批量删除求职者信息
	 * @param leavingIdList
	 * @return
	 * @changeLog 	1. 创建 (2020年4月24日 下午3:43:09 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping(value = "/intervieweeInfo/multiDelete", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<IntervieweeInfo> multiDeleteIntervieweeInfo(@RequestParam(value = "leavingIdList[]", required = false) Integer[] leavingIdList) {
		for (Integer leavingId : leavingIdList) {
			System.out.println(leavingId);
			intervieweeInfoService.deleteIntervieweeInfo(leavingId);
		}
		List<IntervieweeInfo> intervieweeInfos = intervieweeInfoService.displayIntervieweeInfo();
		return intervieweeInfos;
	}
	
	/**
	 *  展示所有空缺职位名称
	 * @return
	 * @changeLog 	1. 创建 (2020年4月24日 下午11:56:36 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/intervieweeInfo/displayEmptyPosition")
	@ResponseBody
	public List<EmptyPosition> displayEmptyPosition() {
		List<EmptyPosition> positions = emptyPositionService.displayEmptyPosition();
		return positions;
	}
	
	/**
	 *  添加面试人员信息
	 * TODO
	 * @param request
	 * @return
	 * @changeLog 	1. 创建 (2020年4月25日 下午7:14:36 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/intervieweeInfo/addIntervieweeInfo")
	@ResponseBody
	public HashMap<String, String> addIntervieweeInfo(HttpServletRequest request) {
		HashMap<String, String> message = new HashMap<String, String>();
		String intervieweeName = request.getParameter("intervieweeName");
		Integer intervieweeAge = null;
		try {
			intervieweeAge = Integer.parseInt(request.getParameter("intervieweeAge"));			
		} catch (NumberFormatException e) {
			message.put("result", "年龄输入有误！");
			return message;
		}
		Integer positionId = Integer.parseInt(request.getParameter("positionId"));
		String intervieweeGender = request.getParameter("intervieweeGender");
		String intervieweePhone = request.getParameter("intervieweePhone");
		String intervieweeEducationBackground = request.getParameter("intervieweeEducationBackground");
		String intervieweeGraduateInstitution = request.getParameter("intervieweeGraduateInstitution");
		String intervieweeMajor = request.getParameter("intervieweeMajor");
		// 验证面试人姓名和电话是否为空
		if (intervieweeName == null || "".equals(intervieweeName) || intervieweePhone == null || "".equals(intervieweePhone)) {
			message.put("result", "面试人姓名及电话必须填写！");
			return message;
		}
		if (intervieweeAge < 0) {
			message.put("result", "年龄不能为负数！");
			return message;
		}
		IntervieweeInfo intervieweeInfo = new IntervieweeInfo(positionId, intervieweeName, intervieweeAge, 
				intervieweeGender, intervieweeEducationBackground, intervieweeGraduateInstitution, intervieweeMajor, intervieweePhone);
		// 添加求职人信息
		intervieweeInfoService.addIntervieweeInfo(intervieweeInfo);
		message.put("result", "添加成功！");
		return message;
	}
	
	/**
	 * 变更面试人员信息
	 * @param request
	 * @return
	 * @throws Exception
	 * @changeLog 	1. 创建 (2020年4月27日 下午5:09:59 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/intervieweeInfo/updateIntervieweeInfo")
	@ResponseBody
	public HashMap<String, String> updateIntervieweeInfo(HttpServletRequest request) throws Exception {
		HashMap<String, String> message = new HashMap<String, String>();
		Integer intervieweeId = Integer.parseInt(request.getParameter("intervieweeId"));
		String intervieweeName = request.getParameter("intervieweeName");
		Integer intervieweeAge = null;
		try {
			intervieweeAge = Integer.parseInt(request.getParameter("intervieweeAge"));			
		} catch (NumberFormatException e) {
			message.put("result", "年龄输入有误！");
			return message;
		}
		Integer positionId = Integer.parseInt(request.getParameter("positionId"));
		String intervieweeGender = request.getParameter("intervieweeGender");
		String intervieweePhone = request.getParameter("intervieweePhone");
		String intervieweeEducationBackground = request.getParameter("intervieweeEducationBackground");
		String intervieweeGraduateInstitution = request.getParameter("intervieweeGraduateInstitution");
		String intervieweeMajor = request.getParameter("intervieweeMajor");
		if (intervieweeName == null || "".equals(intervieweeName) || intervieweePhone == null || "".equals(intervieweePhone)) {
			message.put("result", "面试人姓名和电话必须填写！");
			return message;
		}
		if (intervieweeAge < 0) {
			message.put("result", "年龄不能为负数！");
			return message;
		}
		IntervieweeInfo intervieweeInfo = new IntervieweeInfo(intervieweeId, positionId, intervieweeName, intervieweeAge, intervieweeGender, intervieweeEducationBackground, intervieweeGraduateInstitution, intervieweeMajor, intervieweePhone);
		intervieweeInfoService.modifyIntervieweeInfo(intervieweeInfo);
		message.put("result", "修改成功！");
		return message;
	}
	
	/**
	 *  模糊查询面试信息
	 * @param parameter
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 下午5:01:01 [王培霖])  </br>
	 *                      	2.
	 */
	@RequestMapping("/intervieweeInfo/search")
	@ResponseBody
	public PageBean<IntervieweeInfo> searchLeaving(HttpServletRequest request, IntervieweeInfo intervieweeInfo, Integer pageIndex) {
		String parameter = request.getParameter("parameter");
		String intervieweeGender = request.getParameter("intervieweeGender");
		String positionName = request.getParameter("positionName");
		String educationBackground = request.getParameter("intervieweeEducationBackground");
		Integer positionId = null;
		if (!"".equals(positionName)) {
			positionId = Integer.parseInt(positionName);
		}
		if (pageIndex == null)
		{
			pageIndex = 1;
		}
		int pageSize = 2;
		PageBean<IntervieweeInfo> pageBean = intervieweeInfoService.searchIntervieweeInfo(parameter, intervieweeGender, educationBackground, positionId, intervieweeInfo, pageIndex, pageSize);
		return pageBean;
	}
}
