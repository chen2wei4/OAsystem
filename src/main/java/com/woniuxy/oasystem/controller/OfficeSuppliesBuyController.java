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

import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.OfficeSuppliesBuy;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.OfficeSuppliesBuyService;
import com.woniuxy.oasystem.service.OfficeSuppliesService;
import com.woniuxy.oasystem.util.CommonResult;
/**
 * 
 * @Description  办公用品请购管理
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
 *
 */
@Controller
@RequestMapping("/officeSuppliesBuy")
public class OfficeSuppliesBuyController {
	@Autowired
	OfficeSuppliesBuyService officeSuppliesBuyService;
	
	/**
	 * 
	 * 展示所有办公请购用品
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("/list")
	@ResponseBody
	public CommonResult<PageBean<OfficeSuppliesBuy>> findAll(@RequestBody OfficeSuppliesBuy officeSuppliesBuy,Integer pageIndex) {
		System.out.println(officeSuppliesBuy);
		if (pageIndex == null) {
			pageIndex = 1;
		}
		int pageSize = 3;
		try {
			PageBean<OfficeSuppliesBuy> pb = officeSuppliesBuyService.findAllByPage(officeSuppliesBuy, pageIndex, pageSize);
			return new CommonResult<PageBean<OfficeSuppliesBuy>>(200,"ok",pb);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonResult<PageBean<OfficeSuppliesBuy>>(500,"error",null);
		}
	}
	/**
	 * 
	 * TODO	根据osbId删除
	 * @param osId
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("deleteByOsbId")
	@ResponseBody
	public CommonResult<PageBean<OfficeSuppliesBuy>> deleteByOsbId(Integer osbId) {
		try {
			officeSuppliesBuyService.deleteByOsbId(osbId);
			return new CommonResult<PageBean<OfficeSuppliesBuy>>(200,"删除成功",null);
		} catch (Exception e) {
			return new CommonResult<PageBean<OfficeSuppliesBuy>>(500,"删除失败",null);
		}
		
	}
	/**
	 * 
	 * TODO	根据osbId修改
	 * @param officeSuppliesBuy
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("updateByOsbId")
	@ResponseBody
	public CommonResult<PageBean<OfficeSuppliesBuy>> updateByOsId(@RequestBody OfficeSuppliesBuy officeSuppliesBuy) {
		try {
			officeSuppliesBuyService.updateByOsbId(officeSuppliesBuy);
			return new CommonResult<PageBean<OfficeSuppliesBuy>>(200,"修改成功",null);
		} catch (Exception e) {
			return new CommonResult<PageBean<OfficeSuppliesBuy>>(500,"修改失败",null);
		}
	}
	/**
	 * 
	 * TODO	添加办公用品请购
	 * @param officeSuppliesBuy
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
	 */
	@RequestMapping("insert")
	@ResponseBody
	public CommonResult<PageBean<OfficeSuppliesBuy>> insert(@RequestBody OfficeSuppliesBuy officeSuppliesBuy) {
		try {
			officeSuppliesBuyService.insert(officeSuppliesBuy);
			return new CommonResult<PageBean<OfficeSuppliesBuy>>(200,"添加成功",null);
		} catch (Exception e) {
			return new CommonResult<PageBean<OfficeSuppliesBuy>>(500,"添加失败",null);
		}
	}
	
	
}
