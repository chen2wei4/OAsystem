/**  
 * @author 张钰平
 * @createDate 2020年4月24日
 */

package com.woniuxy.oasystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.OfficeSuppliesReturn;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.entity.Vo;
import com.woniuxy.oasystem.service.OfficeSuppliesReturnService;
import com.woniuxy.oasystem.util.CommonResult;

/**  
 * @Description  办公用品归还
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月24日 [张钰平])
 *              
 */
@Controller
@RequestMapping("/officeSuppliesReturn")
public class OfficeSuppliesReturnController {
	
	@Autowired 
	OfficeSuppliesReturnService officeSuppliesReturnService;
	/**
	 * 
	 * TODO	展示办公用品归还
	 * @param officeSuppliesReturn
	 * @param pageIndex
	 * @return
	 * @changeLog 	1. 创建 (2020年4月24日 [张钰平])
	 */
	@RequestMapping("/list")
	@ResponseBody
	public CommonResult<PageBean<OfficeSuppliesReturn>> findAll(@RequestBody Vo<OfficeSuppliesReturn> vo) {
		System.out.println(vo.t);
		if(vo.t==null) {
			vo.t = new OfficeSuppliesReturn();
			vo.t.setEmp(new Emp());
		}
		if (vo.pageIndex == null) {
			vo.pageIndex = 1;
		}
		int pageSize = 3;
		try {
			PageBean<OfficeSuppliesReturn> pb = officeSuppliesReturnService.findAllByPage(vo.t, vo.pageIndex, pageSize);
			return new CommonResult<PageBean<OfficeSuppliesReturn>>(200,"ok",pb);
		} catch (Exception e) {
			return new CommonResult<PageBean<OfficeSuppliesReturn>>(500,"error",null);
		}
	}
	/**
	 * 
	 * TODO	根据osrId删除办公用品归还
	 * @param osrId
	 * @return
	 * @changeLog 	1. 创建 (2020年4月24日 [张钰平])
	 */
	@RequestMapping("deleteByOsrId")
	@ResponseBody
	public CommonResult<PageBean<OfficeSuppliesReturn>> deleteByOsrId(Integer osrId) {
		try {
			officeSuppliesReturnService.deleteByOsrId(osrId);
			return new CommonResult<PageBean<OfficeSuppliesReturn>>(200,"删除成功",null);
		} catch (Exception e) {
			return new CommonResult<PageBean<OfficeSuppliesReturn>>(500,"删除失败",null);
		}
	}
	/**
	 * 
	 * TODO	根据osrId修改办公用品归还
	 * @param officeSuppliesReturn
	 * @return
	 * @changeLog 	1. 创建 (2020年4月24日 [张钰平])
	 */
	@RequestMapping("updateByOsrId")
	@ResponseBody
	public CommonResult<PageBean<OfficeSuppliesReturn>> updateByOrId(@RequestBody OfficeSuppliesReturn officeSuppliesReturn) {
		System.out.println(officeSuppliesReturn);
		try {
			officeSuppliesReturnService.updateByOsrId(officeSuppliesReturn);
			return new CommonResult<PageBean<OfficeSuppliesReturn>>(200,"修改成功",null);
		} catch (Exception e) {
			return new CommonResult<PageBean<OfficeSuppliesReturn>>(500,"修改失败",null);
		}
	}
	/**
	 * 
	 * TODO	添加办公用品归还
	 * @param officeSuppliesReturn
	 * @return
	 * @changeLog 	1. 创建 (2020年4月24日 [张钰平])
	 */
	@RequestMapping("insert")
	@ResponseBody
	public CommonResult<PageBean<OfficeSuppliesReturn>> insert(@RequestBody OfficeSuppliesReturn officeSuppliesReturn) {
		try {
			officeSuppliesReturnService.insert(officeSuppliesReturn);
			return new CommonResult<PageBean<OfficeSuppliesReturn>>(200,"添加成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonResult<PageBean<OfficeSuppliesReturn>>(500,"添加失败",null);
		}
	}
}
