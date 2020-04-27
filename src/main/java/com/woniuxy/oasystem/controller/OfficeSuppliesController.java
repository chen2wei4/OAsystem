package com.woniuxy.oasystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.OfficeSuppliesService;
import com.woniuxy.oasystem.util.CommonResult;
/**
 * 
 * @Description  办公用品管理
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月22日 [张钰平])
 *
 */
@Controller
@RequestMapping("/officeSupplies")
public class OfficeSuppliesController {
	@Autowired
	OfficeSuppliesService officeSuppliesService;
	
	/**
	 * 
	 * 展示所有办公用品
	 * @return
	 * @changeLog 	1. 创建 (2020年4月22日 [张钰平])
	 */
	@RequestMapping("/list")
	@ResponseBody
	public CommonResult<PageBean<OfficeSupplies>> findAll(@RequestBody OfficeSupplies officeSupplies,Integer pageIndex) {
		System.out.println(officeSupplies);
		if (pageIndex == null) {
			pageIndex = 1;
		}
		int pageSize = 3;
		try {
			PageBean<OfficeSupplies> pb = officeSuppliesService.findAllByPage(officeSupplies, pageIndex, pageSize);
			return new CommonResult<PageBean<OfficeSupplies>>(200,"ok",pb);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonResult<PageBean<OfficeSupplies>>(500,"error",null);
		}
	}
	/**
	 * 
	 * TODO	根据osId删除
	 * @param osId
	 * @return
	 * @changeLog 	1. 创建 (2020年4月23日 [张钰平])
	 */
	@RequestMapping("deleteByOsId")
	@ResponseBody
	public CommonResult<PageBean<OfficeSupplies>> deleteByOsId(Integer osId) {
		try {
			officeSuppliesService.deleteByOsId(osId);
			return new CommonResult<PageBean<OfficeSupplies>>(200,"删除成功",null);
		} catch (Exception e) {
			return new CommonResult<PageBean<OfficeSupplies>>(500,"删除失败",null);
		}
		
	}
	/**
	 * 
	 * TODO	根据osId修改
	 * @param officeSupplies
	 * @return
	 * @changeLog 	1. 创建 (2020年4月23日 [张钰平])
	 */
	@RequestMapping("updateByOsId")
	@ResponseBody
	public CommonResult<PageBean<OfficeSupplies>> updateByOsId(@RequestBody OfficeSupplies officeSupplies) {
		try {
			officeSuppliesService.updateByOsId(officeSupplies);
			return new CommonResult<PageBean<OfficeSupplies>>(200,"修改成功",null);
		} catch (Exception e) {
			return new CommonResult<PageBean<OfficeSupplies>>(500,"修改失败",null);
		}
	}
	/**
	 * 
	 * TODO	添加办公用品
	 * @param officeSupplies
	 * @return
	 * @changeLog 	1. 创建 (2020年4月23日 [张钰平])
	 */
	@RequestMapping("insert")
	@ResponseBody
	public CommonResult<PageBean<OfficeSupplies>> insert(@RequestBody OfficeSupplies officeSupplies) {
		try {
			officeSuppliesService.insert(officeSupplies);
			return new CommonResult<PageBean<OfficeSupplies>>(200,"添加成功",null);
		} catch (Exception e) {
			return new CommonResult<PageBean<OfficeSupplies>>(500,"添加失败",null);
		}
	}
	
	
}
