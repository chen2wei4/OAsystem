package com.woniuxy.oasystem.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniuxy.oasystem.entity.AnnouncementType;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.AnnountcementTypeService;

@Controller
public class AnnouncementTypeController {
	@Autowired
	AnnountcementTypeService announcementTypeService;
	// 固定每页展示5行数据
		Integer PAGESIZE = 10;


	// 添加公告前的查看所有公告类别
	@RequiresPermissions("announcement:select")
	@RequestMapping("/selecttypeByAtId")
	public String addAnShowAllantype(AnnouncementType antype,Model model) {
		try {
		// 把公告分类查询出来
		List<AnnouncementType> types = announcementTypeService.ShowAllAnnountcementTypes();
		model.addAttribute("antypes", types);
		return "addannouncement";
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("errorcode", 500);
			model.addAttribute("error","查询公告类别出错请联系管理员");
			//发生异常打到错误页
			return "lyear_pages_error";
					
		}
		}

	// 查看所有公告类别发到管理页面
	@RequiresPermissions("announcement:select")
	@RequestMapping("/selectallantype")
	public String ShowAllantypeByType(AnnouncementType antype,Integer pageIndex,Model model) {
		try {
		if (pageIndex == null) {
			pageIndex = 1;
		}
		// 把公告分类查询出来
		PageBean<AnnouncementType> types = announcementTypeService.ShowAllAnnountcementType(antype,pageIndex,PAGESIZE);
		if (types.getTotalPage() == 0) {
			types.setPageIndex(0);
		}
		model.addAttribute("antypes", types);
		//把查询条件存入回显
		model.addAttribute("condition", antype);
		return "announcementtypemanage";
		}catch(Exception e) {
			e.printStackTrace();
			//发生异常打到错误页
			model.addAttribute("errorcode", 500);
			model.addAttribute("error","查询公告类别出错请联系管理员");
			return "lyear_pages_error";
					
		}
		}
	// 添加类别公告
	@RequiresPermissions("announcement:manage")
	@PostMapping("/addantype")
	public String addannouncementType(AnnouncementType antype, Model model) {
		try {
		// 設置添加時的屬性
		antype.setAtFlag(true);
		announcementTypeService.addAnType(antype);
		return "redirect:/selectallantype";
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("errorcode", 500);
			model.addAttribute("error","添加失败请联系管理员");
			//发生异常打到错误页
			return "lyear_pages_error";
					
		}
	}

	// 修改公告类别前的查询
	@RequiresPermissions("announcement:select")
	@RequestMapping("/updantype")
	public String updateShowAnTypeById(AnnouncementType at, Model model) {
	try {
		// 查询公告类别信息
		AnnouncementType antype=announcementTypeService.showantype(at.getAtId());
		model.addAttribute("antypeInfo", antype);
		return "updateannouncementtype";
	}catch(Exception e) {
		e.printStackTrace();
		model.addAttribute("errorcode", 500);
		model.addAttribute("error","查询出错请联系管理员");
		//发生异常打到错误页
		return "lyear_pages_error";
				
	}
	}

	// 修改公告类别
	@RequiresPermissions("announcement:manage")
	@PutMapping("/updateantype")
	public String updateAnnouncement(AnnouncementType anType,Model model) {
		try {
		// 修改公告
		announcementTypeService.UpdateAntypeById(anType);
		return "redirect:/selectallantype";
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("errorcode", 500);
			model.addAttribute("error","修改出错请联系管理员");
			//发生异常打到错误页
			return "lyear_pages_error";
					
		}
	}
	
// 	软删除公告类别
@RequestMapping("/delantype")
@RequiresPermissions("announcement:manage")
public String delAnnouncementType(AnnouncementType at, Model model) {
	try {	
	// 删除
		announcementTypeService.DeleteAntypeById(at.getAtId());
		return "redirect:/selectallantype";
	}catch(Exception e) {
		e.printStackTrace();
		//发生异常打到错误页
		model.addAttribute("errorcode", 500);
		model.addAttribute("error","删除失败请联系管理员");
		return "lyear_pages_error";
				
	}
}
//	启用公告类别
@RequestMapping("/startantype")
@RequiresPermissions("announcement:manage")
public String startAnnouncementType(AnnouncementType at, Model model) {
try {
	announcementTypeService.StartAntypeById(at.getAtId());
	return "redirect:/selectallantype";
}catch(Exception e) {
	e.printStackTrace();
	//发生异常打到错误页
	model.addAttribute("errorcode", 500);
	model.addAttribute("error","启用出错请联系管理员");
	return "lyear_pages_error";
			
}
}
	
}