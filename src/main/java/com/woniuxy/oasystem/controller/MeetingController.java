package com.woniuxy.oasystem.controller;

import java.util.List;

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
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.entity.Vo;
import com.woniuxy.oasystem.service.CarApplyService;
import com.woniuxy.oasystem.service.CarService;
import com.woniuxy.oasystem.service.MeetingService;
import com.woniuxy.oasystem.service.OfficeSuppliesService;
import com.woniuxy.oasystem.util.CommonResult;
/**
 * 
 * @Description  会议管理
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月22日 [张钰平])
 *
 */
@Controller
@RequestMapping("/meeting")
public class MeetingController {
	@Autowired
	MeetingService meetingService;
	
	/**
	 * 
	 * 展示所有会议
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("/list")
	@ResponseBody
	public CommonResult<PageBean<Meeting>> findAll(@RequestBody Vo<Meeting> vo) {
		System.out.println(vo.t);
		if(vo.t==null) {
			vo.t = new Meeting();
			vo.t.setEmp(new Emp());
			vo.t.setBoardroom(new Boardroom());
		}
		if (vo.pageIndex == null) {
			vo.pageIndex = 1;
		}
		int pageSize = 3;
		try {
			PageBean<Meeting> pb = meetingService.findAllByPage(vo.t, vo.pageIndex, pageSize);
			return new CommonResult<PageBean<Meeting>>(200,"ok",pb);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonResult<PageBean<Meeting>>(500,"error",null);
		}
	}
	/**
	 * 
	 * TODO	根据caId删除
	 * @param caId
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("deleteByMid")
	@ResponseBody
	public CommonResult<PageBean<Meeting>> deleteByMid(Integer meetingId) {
		try {
			meetingService.deleteByMid(meetingId);
			return new CommonResult<PageBean<Meeting>>(200,"删除成功",null);
		} catch (Exception e) {
			return new CommonResult<PageBean<Meeting>>(500,"删除失败",null);
		}
		
	}
	/**
	 * 
	 * TODO	根据carId修改
	 * @param carApply
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("updateByMid")
	@ResponseBody
	public CommonResult<PageBean<Meeting>> updateByCaId(@RequestBody Meeting meeting) {
		try {
			meetingService.updateByMid(meeting);
			return new CommonResult<PageBean<Meeting>>(200,"修改成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonResult<PageBean<Meeting>>(500,"修改失败",null);
		}
	}
	/**
	 * 
	 * TODO	添加会议
	 * @param carApply
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("insert")
	@ResponseBody
	public CommonResult<PageBean<Meeting>> insert(@RequestBody Meeting meeting) {
		try {
			meetingService.insert(meeting);
			return new CommonResult<PageBean<Meeting>>(200,"添加成功",null);
		} catch (Exception e) {
			return new CommonResult<PageBean<Meeting>>(500,"添加失败",null);
		}
	}
	
	
}
