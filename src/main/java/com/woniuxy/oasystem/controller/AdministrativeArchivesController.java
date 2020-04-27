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

import com.woniuxy.oasystem.entity.AdministrativeArchives;
import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.AdministrativeArchivesService;
import com.woniuxy.oasystem.service.CarService;
import com.woniuxy.oasystem.service.OfficeSuppliesService;
import com.woniuxy.oasystem.util.CommonResult;
/**
 * 
 * @Description  行政档案管理
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月22日 [张钰平])
 *
 */
@Controller
@RequestMapping("/administrativeArchives")
public class AdministrativeArchivesController {
	@Autowired
	AdministrativeArchivesService administrativeArchivesService;
	
	/**
	 * 
	 * 展示所有行政档案
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("/list")
	@ResponseBody
	public CommonResult<PageBean<AdministrativeArchives>> findAll(@RequestBody AdministrativeArchives administrativeArchives,Integer pageIndex) {
		System.out.println(administrativeArchives);
		if (pageIndex == null) {
			pageIndex = 1;
		}
		int pageSize = 10;
		try {
			PageBean<AdministrativeArchives> pb = administrativeArchivesService.findAllByPage(administrativeArchives, pageIndex, pageSize);
			return new CommonResult<PageBean<AdministrativeArchives>>(200,"ok",pb);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonResult<PageBean<AdministrativeArchives>>(500,"error",null);
		}
	}
	/**
	 * 
	 * TODO	根据carId删除
	 * @param carId
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("deleteByAaId")
	@ResponseBody
	public CommonResult<PageBean<AdministrativeArchives>> deleteByAaId(Integer aaId) {
		try {
			administrativeArchivesService.deleteByAaId(aaId);
			return new CommonResult<PageBean<AdministrativeArchives>>(200,"删除成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonResult<PageBean<AdministrativeArchives>>(500,"删除失败",null);
		}
		
	}
	/**
	 * 
	 * TODO	根据carId修改
	 * @param car
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("updateByAaId")
	@ResponseBody
	public CommonResult<PageBean<AdministrativeArchives>> updateByAaId(@RequestBody AdministrativeArchives administrativeArchives) {
		try {
			administrativeArchivesService.updateByAaId(administrativeArchives);
			return new CommonResult<PageBean<AdministrativeArchives>>(200,"修改成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonResult<PageBean<AdministrativeArchives>>(500,"修改失败",null);
		}
	}
	/**
	 * 
	 * TODO	添加行政档案
	 * @param car
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("insert")
	@ResponseBody
	public CommonResult<PageBean<AdministrativeArchives>> insert(@RequestBody AdministrativeArchives administrativeArchives) {
		try {
			administrativeArchivesService.insert(administrativeArchives);
			return new CommonResult<PageBean<AdministrativeArchives>>(200,"添加成功",null);
		} catch (Exception e) {
			return new CommonResult<PageBean<AdministrativeArchives>>(500,"添加失败",null);
		}
	}
	
	
}
