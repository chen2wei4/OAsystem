package com.woniuxy.oasystem.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.woniuxy.oasystem.entity.Boardroom;
import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.CarApply;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.Meeting;
import com.woniuxy.oasystem.entity.MeetingApply;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.entity.Vo;
import com.woniuxy.oasystem.service.CarApplyService;
import com.woniuxy.oasystem.service.CarService;
import com.woniuxy.oasystem.service.MeetingApplyService;
import com.woniuxy.oasystem.service.MeetingService;
import com.woniuxy.oasystem.service.OfficeSuppliesService;
import com.woniuxy.oasystem.util.CommonResult;
/**
 * 
 * @Description  会议申请管理
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月22日 [张钰平])
 *
 */
@Controller
@RequestMapping("/meetingApply")
public class MeetingApplyController {
	@Autowired
	MeetingApplyService meetingApplyService;
	
	/**
	 * 
	 * 展示所有会议申请
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("/list")
	@ResponseBody
	@RequiresPermissions({"AdministrativeManager:select","worker:select"})
	public CommonResult<PageBean<MeetingApply>> findAll(@RequestBody Vo<MeetingApply> vo) {
		System.out.println(vo.t);
		if(vo.t==null) {
			vo.t = new MeetingApply();
			vo.t.setEmp(new Emp());
			vo.t.setBoardroom(new Boardroom());
		}
		if (vo.pageIndex == null) {
			vo.pageIndex = 1;
		}
		int pageSize = 3;
		try {
			PageBean<MeetingApply> pb = meetingApplyService.findAllByPage(vo.t,vo.pageIndex, pageSize);
			return new CommonResult<PageBean<MeetingApply>>(200,"ok",pb);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonResult<PageBean<MeetingApply>>(500,"error",null);
		}
	}
	/**
	 * 
	 * TODO	根据MaId删除
	 * @param maId
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("deleteByMaId")
	@ResponseBody
	@RequiresPermissions("AdministrativeManager:delete")
	public CommonResult<PageBean<MeetingApply>> deleteByMid(Integer maId) {
		try {
			meetingApplyService.deleteByMaId(maId);
			return new CommonResult<PageBean<MeetingApply>>(200,"删除成功",null);
		} catch (Exception e) {
			return new CommonResult<PageBean<MeetingApply>>(500,"删除失败",null);
		}
		
	}
	/**
	 * 
	 * TODO	根据maId修改
	 * @param MeetingApply
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("updateByMaId")
	@ResponseBody
	@RequiresPermissions("AdministrativeManager:update")
	public CommonResult<PageBean<MeetingApply>> updateByCaId(@RequestBody MeetingApply meetingApply) {
		try {
			meetingApplyService.updateByMaId(meetingApply);
			return new CommonResult<PageBean<MeetingApply>>(200,"修改成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonResult<PageBean<MeetingApply>>(500,"修改失败",null);
		}
	}
	/**
	 * 
	 * TODO	添加会议申请
	 * @param MeetingApply
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("insert")
	@ResponseBody
	@RequiresPermissions({"AdministrativeManager:insert","worker:insert"})
	public CommonResult<PageBean<MeetingApply>> insert(@RequestBody MeetingApply meetingApply) {
		try {
			meetingApplyService.insert(meetingApply);
			return new CommonResult<PageBean<MeetingApply>>(200,"添加成功",null);
		} catch (Exception e) {
			return new CommonResult<PageBean<MeetingApply>>(500,"添加失败",null);
		}
	}
	
	
}
