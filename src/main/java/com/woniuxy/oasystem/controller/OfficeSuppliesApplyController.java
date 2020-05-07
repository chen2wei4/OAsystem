/**  
 * @author 张钰平
 * @createDate 2020年4月24日
 */

package com.woniuxy.oasystem.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.OfficeSuppliesApply;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.entity.Vo;
import com.woniuxy.oasystem.service.OfficeSuppliesApplyService;
import com.woniuxy.oasystem.util.CommonResult;

/**  
 * @Description  办公用品申请
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月24日 [张钰平])
 *              
 */
@Controller
@RequestMapping("/officeSuppliesApply")
public class OfficeSuppliesApplyController {
	
	@Autowired 
	OfficeSuppliesApplyService officeSuppliesApplyService;
	/**
	 * 
	 * TODO	展示办公用品申请
	 * @param officeSuppliesApply
	 * @param pageIndex
	 * @return
	 * @changeLog 	1. 创建 (2020年4月24日 [张钰平])
	 */
	@RequestMapping("/list")
	@ResponseBody
	@RequiresPermissions({"AdministrativeManager:select","worker:select"})
	public CommonResult<PageBean<OfficeSuppliesApply>> findAll(@RequestBody Vo<OfficeSuppliesApply> vo) {
		System.out.println(vo.t);
		if(vo.t==null) {
			vo.t = new OfficeSuppliesApply();
			vo.t.setEmp(new Emp());
		}
		if (vo.pageIndex == null) {
			vo.pageIndex = 1;
		}
		int pageSize = 3;
		try {
			PageBean<OfficeSuppliesApply> pb = officeSuppliesApplyService.findAllByPage(vo.t, vo.pageIndex, pageSize);
			return new CommonResult<PageBean<OfficeSuppliesApply>>(200,"ok",pb);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonResult<PageBean<OfficeSuppliesApply>>(500,"error",null);
		}
	}
	/**
	 * 
	 * TODO	根据osaId删除办公用品申请
	 * @param osaId
	 * @return
	 * @changeLog 	1. 创建 (2020年4月24日 [张钰平])
	 */
	@RequestMapping("deleteByOsaId")
	@ResponseBody
	@RequiresPermissions("AdministrativeManager:delete")
	public CommonResult<PageBean<OfficeSuppliesApply>> deleteByOsaId(Integer osaId) {
		try {
			officeSuppliesApplyService.deleteByOsaId(osaId);
			return new CommonResult<PageBean<OfficeSuppliesApply>>(200,"删除成功",null);
		} catch (Exception e) {
			return new CommonResult<PageBean<OfficeSuppliesApply>>(500,"删除失败",null);
		}
	}
	/**
	 * 
	 * TODO	根据osaId修改办公用品申请
	 * @param officeSuppliesApply
	 * @return
	 * @changeLog 	1. 创建 (2020年4月24日 [张钰平])
	 */
	@RequestMapping("updateByOsaId")
	@ResponseBody
	@RequiresPermissions("AdministrativeManager:update")
	public CommonResult<PageBean<OfficeSuppliesApply>> updateByOsId(@RequestBody OfficeSuppliesApply officeSuppliesApply) {
		System.out.println(officeSuppliesApply);
		try {
			officeSuppliesApplyService.updateByOsaId(officeSuppliesApply);
			return new CommonResult<PageBean<OfficeSuppliesApply>>(200,"修改成功",null);
		} catch (Exception e) {
			return new CommonResult<PageBean<OfficeSuppliesApply>>(500,"修改失败",null);
		}
	}
	/**
	 * 
	 * TODO	添加办公用品申请
	 * @param officeSuppliesApply
	 * @return
	 * @changeLog 	1. 创建 (2020年4月24日 [张钰平])
	 */
	@RequestMapping("insert")
	@ResponseBody
	@RequiresPermissions({"AdministrativeManager:insert","worker:insert"})
	public CommonResult<PageBean<OfficeSuppliesApply>> insert(@RequestBody OfficeSuppliesApply officeSuppliesApply) {
		try {
			officeSuppliesApplyService.insert(officeSuppliesApply);
			return new CommonResult<PageBean<OfficeSuppliesApply>>(200,"添加成功",null);
		} catch (Exception e) {
			return new CommonResult<PageBean<OfficeSuppliesApply>>(500,"添加失败",null);
		}
	}
}
