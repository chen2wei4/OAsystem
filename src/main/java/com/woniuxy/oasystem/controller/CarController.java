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
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.entity.Vo;
import com.woniuxy.oasystem.service.CarService;
import com.woniuxy.oasystem.service.OfficeSuppliesService;
import com.woniuxy.oasystem.util.CommonResult;
/**
 * 
 * @Description  车辆管理
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月22日 [张钰平])
 *
 */
@Controller
@RequestMapping("/car")
public class CarController {
	@Autowired
	CarService carService;
	
	/**
	 * 
	 * 展示所有车辆
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("/list")
	@ResponseBody
	@RequiresPermissions("AdministrativeManager:select")
	public CommonResult<PageBean<Car>> findAll(@RequestBody Vo<Car> vo) {
		System.out.println(vo.t);
		if(vo.t==null) {
			vo.t = new Car();
		}
		if (vo.pageIndex == null) {
			vo.pageIndex = 1;
		}
		int pageSize = 3;
		try {
			PageBean<Car> pb = carService.findAllByPage(vo.t, vo.pageIndex, pageSize);
			return new CommonResult<PageBean<Car>>(200,"ok",pb);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonResult<PageBean<Car>>(500,"error",null);
		}
		
	}
	/**
	 * 
	 * TODO	根据carId删除
	 * @param carId
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("deleteByCarId")
	@ResponseBody
	@RequiresPermissions("AdministrativeManager:delete")
	public CommonResult<PageBean<Car>> deleteByCarId(Integer carId) {
		try {
			carService.deleteByCarId(carId);
			return new CommonResult<PageBean<Car>>(200,"删除成功",null);
		} catch (Exception e) {
			return new CommonResult<PageBean<Car>>(500,"删除失败",null);
		}
		
	}
	/**
	 * 
	 * TODO	根据carId修改
	 * @param car
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("updateByCarId")
	@ResponseBody
	@RequiresPermissions("AdministrativeManager:update")
	public CommonResult<PageBean<Car>> updateByCarId(@RequestBody Car car) {
		try {
			carService.updateByCarId(car);
			return new CommonResult<PageBean<Car>>(200,"修改成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonResult<PageBean<Car>>(500,"修改失败",null);
		}
	}
	/**
	 * 
	 * TODO	添加车辆
	 * @param car
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("insert")
	@ResponseBody
	@RequiresPermissions("AdministrativeManager:insert")
	public CommonResult<PageBean<Car>> insert(@RequestBody Car car) {
		try {
			carService.insert(car);
			return new CommonResult<PageBean<Car>>(200,"添加成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonResult<PageBean<Car>>(500,"添加失败",null);
		}
	}
	
	
}


