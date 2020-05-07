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

import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.CarApply;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.entity.Vo;
import com.woniuxy.oasystem.service.CarApplyService;
import com.woniuxy.oasystem.service.CarService;
import com.woniuxy.oasystem.service.OfficeSuppliesService;
import com.woniuxy.oasystem.util.CommonResult;
/**
 * 
 * @Description  车辆申请管理
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月22日 [张钰平])
 *
 */
@Controller
@RequestMapping("/carApply")
public class CarApplyController {
	@Autowired
	CarApplyService carApplyService;
	
	/**
	 * 
	 * 展示所有车辆申请
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("/list")
	@ResponseBody
	
	public CommonResult<PageBean<CarApply>> findAll(@RequestBody Vo<CarApply> vo) {
		System.out.println(vo.t);
		if(vo.t==null) {
			vo.t = new CarApply();
			vo.t.setEmp(new Emp());
		}
		if (vo.pageIndex == null) {
			vo.pageIndex = 1;
		}
		int pageSize = 3;
		try {
			PageBean<CarApply> pb = carApplyService.findAllByPage(vo.t, vo.pageIndex, pageSize);
			return new CommonResult<PageBean<CarApply>>(200,"ok",pb);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonResult<PageBean<CarApply>>(500,"error",null);
		}
	}
	/**
	 * 
	 * TODO	根据caId删除
	 * @param caId
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("deleteByCaId")
	@ResponseBody
	@RequiresPermissions("AdministrativeManager:delete")
	public CommonResult<PageBean<CarApply>> deleteByCaId(Integer caId) {
		try {
			carApplyService.deleteByCaId(caId);
			return new CommonResult<PageBean<CarApply>>(200,"删除成功",null);
		} catch (Exception e) {
			return new CommonResult<PageBean<CarApply>>(500,"删除失败",null);
		}
		
	}
	/**
	 * 
	 * TODO	根据carId修改
	 * @param carApply
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("updateByCaId")
	@ResponseBody
	@RequiresPermissions("AdministrativeManager:update")
	public CommonResult<PageBean<CarApply>> updateByCaId(@RequestBody CarApply carApply) {
		try {
			carApplyService.updateByCaId(carApply);
			return new CommonResult<PageBean<CarApply>>(200,"修改成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonResult<PageBean<CarApply>>(500,"修改失败",null);
		}
	}
	/**
	 * 
	 * TODO	添加车辆申请
	 * @param carApply
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("insert")
	@ResponseBody
	@RequiresPermissions({"AdministrativeManager:insert","worker:insert"})
	public CommonResult<PageBean<CarApply>> insert(@RequestBody CarApply carApply) {
		try {
			carApplyService.insert(carApply);
			return new CommonResult<PageBean<CarApply>>(200,"添加成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonResult<PageBean<CarApply>>(500,"添加失败",null);
		}
	}
	
	
}
