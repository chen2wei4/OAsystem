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

import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.CarApply;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.entity.ReturnRegister;
import com.woniuxy.oasystem.entity.Vo;
import com.woniuxy.oasystem.service.CarApplyService;
import com.woniuxy.oasystem.service.CarService;
import com.woniuxy.oasystem.service.OfficeSuppliesService;
import com.woniuxy.oasystem.service.ReturnRegisterService;
import com.woniuxy.oasystem.util.CommonResult;
/**
 * 
 * @Description  车辆归还登记管理
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月22日 [张钰平])
 *
 */
@Controller
@RequestMapping("/returnRegister")
public class ReturnRegisterController {
	@Autowired
	ReturnRegisterService returnRegisterService;
	
	/**
	 * 
	 * 展示所有归还登记
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("/list")
	@ResponseBody
	public CommonResult<PageBean<ReturnRegister>> findAll(@RequestBody Vo<ReturnRegister> vo) {
		System.out.println(vo.t);
		if(vo.t==null) {
			vo.t = new ReturnRegister();
			vo.t.setEmp(new Emp());
		}
		if (vo.pageIndex == null) {
			vo.pageIndex = 1;
		}
		int pageSize = 3;
		try {
			PageBean<ReturnRegister> pb = returnRegisterService.findAllByPage(vo.t, vo.pageIndex, pageSize);
			return new CommonResult<PageBean<ReturnRegister>>(200,"ok",pb);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonResult<PageBean<ReturnRegister>>(500,"error",null);
		}
	}
	/**
	 * 
	 * TODO	根据caId删除
	 * @param caId
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("deleteByRrId")
	@ResponseBody
	public CommonResult<PageBean<ReturnRegister>> deleteByRrId(Integer rrId) {
		try {
			returnRegisterService.deleteByRrId(rrId);
			return new CommonResult<PageBean<ReturnRegister>>(200,"删除成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonResult<PageBean<ReturnRegister>>(500,"删除失败",null);
		}
		
	}
	/**
	 * 
	 * TODO	根据carId修改
	 * @param carApply
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("updateByRrId")
	@ResponseBody
	public CommonResult<PageBean<ReturnRegister>> updateByRrId(@RequestBody ReturnRegister returnRegister) {
		try {
			returnRegisterService.updateByRrId(returnRegister);
			return new CommonResult<PageBean<ReturnRegister>>(200,"修改成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonResult<PageBean<ReturnRegister>>(500,"修改失败",null);
		}
	}
	/**
	 * 
	 * TODO	添加归还登记
	 * @param carApply
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("insert")
	@ResponseBody
	public CommonResult<PageBean<ReturnRegister>> insert(@RequestBody ReturnRegister returnRegister) {
		try {
			returnRegisterService.insert(returnRegister);
			return new CommonResult<PageBean<ReturnRegister>>(200,"添加成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonResult<PageBean<ReturnRegister>>(500,"添加失败",null);
		}
	}
	
	
}
