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
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.entity.Vo;
import com.woniuxy.oasystem.service.BoardroomService;
import com.woniuxy.oasystem.service.CarApplyService;
import com.woniuxy.oasystem.service.CarService;
import com.woniuxy.oasystem.service.OfficeSuppliesService;
import com.woniuxy.oasystem.util.CommonResult;
/**
 * 
 * @Description  会议室管理
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月22日 [张钰平])
 *
 */
@Controller
@RequestMapping("/boardroom")
public class BoardroomController {
	@Autowired
	BoardroomService boardroomService;
	
	/**
	 * 
	 * 展示所有会议室
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("/list")
	@ResponseBody
	
	public CommonResult<PageBean<Boardroom>> findAll(@RequestBody Vo<Boardroom> vo) {
		System.out.println(vo.t);
		if(vo.t==null) {
			vo.t = new Boardroom();
		}
		if (vo.pageIndex == null) {
			vo.pageIndex = 1;
		}
		int pageSize = 3;
		try {
			PageBean<Boardroom> pb = boardroomService.findAllByPage(vo.t, vo.pageIndex, pageSize);
			return new CommonResult<PageBean<Boardroom>>(200,"ok",pb);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonResult<PageBean<Boardroom>>(500,"error",null);
		}
	}
	/**
	 * 
	 * TODO	根据boardroomId删除
	 * @param boardroomId
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("deleteByBoardroomId")
	@ResponseBody
	@RequiresPermissions("AdministrativeManager:delete")
	public CommonResult<PageBean<Boardroom>> deleteByBoardroomId(Integer boardroomId) {
		try {
			boardroomService.deleteByBoardroomId(boardroomId);
			return new CommonResult<PageBean<Boardroom>>(200,"删除成功",null);
		} catch (Exception e) {
			return new CommonResult<PageBean<Boardroom>>(500,"删除失败",null);
		}
		
	}
	/**
	 * 
	 * TODO	根据boardroomId修改
	 * @param boardroom
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("updateByBoardroomId")
	@ResponseBody
	@RequiresPermissions("AdministrativeManager:update")
	public CommonResult<PageBean<Boardroom>> updateByBoardroomId(@RequestBody Boardroom boardroom) {
		try {
			boardroomService.updateByBoardroomId(boardroom);
			return new CommonResult<PageBean<Boardroom>>(200,"修改成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonResult<PageBean<Boardroom>>(500,"修改失败",null);
		}
	}
	/**
	 * 
	 * TODO	添加会议室
	 * @param boardroom
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("insert")
	@ResponseBody
	@RequiresPermissions("AdministrativeManager:insert")
	public CommonResult<PageBean<Boardroom>> insert(@RequestBody Boardroom boardroom) {
		try {
			boardroomService.insert(boardroom);
			return new CommonResult<PageBean<Boardroom>>(200,"添加成功",null);
		} catch (Exception e) {
			return new CommonResult<PageBean<Boardroom>>(500,"添加失败",null);
		}
	}
	
	
}
