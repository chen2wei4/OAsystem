package com.woniuxy.oasystem.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.woniuxy.oasystem.entity.AdministrativeArchives;
import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.entity.Vo;
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
	public CommonResult<PageBean<AdministrativeArchives>> findAll(@RequestBody Vo<AdministrativeArchives> vo) {
		
		if(vo.t==null) {
			vo.t = new AdministrativeArchives();
		}
		if (vo.pageIndex == null) {
			vo.pageIndex = 1;
		}
		int pageSize = 3;
		try {
			PageBean<AdministrativeArchives> pb = administrativeArchivesService.findAllByPage(vo.t, vo.pageIndex, pageSize);
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
	/**
	 * 
	 * TODO 文件上传
	 * @return
	 * @changeLog 	1. 创建 (2020年5月5日 [张钰平])
	 */
	@RequestMapping("upload")
	@ResponseBody
	public CommonResult upload(@RequestParam("file")MultipartFile file,@RequestParam(value="aaId",required = false)Integer aaId){
		System.out.println(aaId);
		try {
			if(file.isEmpty()) {
				return new CommonResult(500,"文件是空的",null);
			}
			String fileName = file.getOriginalFilename();
			String suffixName = fileName.substring(fileName.lastIndexOf("."));
			//防止文件重复 获取当前时间给文件重命名
	        long timeT = System.currentTimeMillis();
			//设置文件上传路径
			String filePath = "C:/Users/小陽/Desktop/picture/";
			String path = filePath + timeT+suffixName;
			File dest = new File(path);
			//检测是否存在目录
			if(!dest.getParentFile().exists()) {
				dest.getParentFile().mkdirs();//新建文件夹
			}
			file.transferTo(dest);//文件写入
			administrativeArchivesService.insertFile(fileName,path,aaId);
			return new CommonResult(200,"上传成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonResult(500,"上传失败",null);
		}
	}
}
