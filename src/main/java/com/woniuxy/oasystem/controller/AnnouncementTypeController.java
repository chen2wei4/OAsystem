package com.woniuxy.oasystem.controller;

import java.util.List;


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
	@RequestMapping("/selecttypeByAtId")
	public String addAnShowAllantype(AnnouncementType antype,Model model) {
		// 把公告分类查询出来
		List<AnnouncementType> types = announcementTypeService.ShowAllAnnountcementTypes();
		model.addAttribute("antypes", types);
		return "addannouncement";
	}

	// 查看所有公告类别发到管理页面
	@RequestMapping("/selectallantype")
	public String ShowAllantypeByType(AnnouncementType antype,Integer pageIndex,Model model) {
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
	}
	// 添加类别公告
	@PostMapping("/addantype")
	public String addannouncementType(AnnouncementType antype, Model model) {
		// 設置添加時的屬性
		antype.setAtFlag(true);
		announcementTypeService.addAnType(antype);
		return "redirect:/selectallantype";

	}

	// 修改公告类别前的查询
	@RequestMapping("/updantype")
	public String updateShowAnTypeById(AnnouncementType at, Model model) {
		// 查询公告类别信息
		AnnouncementType antype=announcementTypeService.showantype(at.getAtId());
		model.addAttribute("antypeInfo", antype);
		return "updateannouncementtype";
	}

	// 修改公告类别
	@PutMapping("/updateantype")
	public String updateAnnouncement(AnnouncementType anType) {
		// 修改公告
		announcementTypeService.UpdateAntypeById(anType);
		return "redirect:/selectallantype";
	}
	
// 	软删除公告类别
@RequestMapping("/delantype")
public String delAnnouncementType(AnnouncementType at, Model model) {
		// 删除
		announcementTypeService.DeleteAntypeById(at.getAtId());
		return "redirect:/selectallantype";
}
//	启用公告类别
@RequestMapping("/startantype")
public String startAnnouncementType(AnnouncementType at, Model model) {
	System.out.println(at);
	announcementTypeService.StartAntypeById(at.getAtId());
	return "redirect:/selectallantype";
}
	
}
