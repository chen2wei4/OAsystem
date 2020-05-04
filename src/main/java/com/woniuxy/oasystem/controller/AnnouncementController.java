package com.woniuxy.oasystem.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.oasystem.entity.Announcement;
import com.woniuxy.oasystem.entity.AnnouncementType;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.entity.ResponseResult;
import com.woniuxy.oasystem.service.AnnountcementService;
import com.woniuxy.oasystem.service.AnnountcementTypeService;

@Controller
public class AnnouncementController {
	@Autowired
	AnnountcementService announcementService;
	@Autowired
	AnnountcementTypeService annountcementTypeService;
	// 固定每页展示5行数据
	Integer PAGESIZE = 5;

	// 通过类别ID查询当前类别所有公告
	@RequestMapping("/announcement")
	public String ShowanByType(Integer atId, Integer pageIndex, Model model) {
		if (pageIndex == null) {
			pageIndex = 1;
		}
		// 首页点击默认为第一页
		PageBean<Announcement> pageInfo = announcementService.ShowAnnouncementsByType(pageIndex, PAGESIZE, atId);
		if (pageInfo.getTotalPage() == 0) {
			pageInfo.setPageIndex(0);
		}
		// 将分页信息打到展示页面
		model.addAttribute("page", pageInfo);
		// 将类别也传到页面
		model.addAttribute("atId", atId);
		return "announcementpages";
	}

	// 通过Id查公告详细内容
	@GetMapping("/ancontent/{anId}")
	public String announcementContent(@PathVariable("anId") Integer anId, Model model) {
		System.out.println(anId);
		// 通过Id查询详细公告内容
		Announcement an = announcementService.ShowContentById(anId);
		model.addAttribute("ancontent", an);
		return "announcementcontent";

	}

	// 添加公告
	@PostMapping("/announcement")
	public String addannouncement(HttpServletRequest req, Announcement ann, Model model) {
		System.out.println(ann);
		// 設置添加時的屬性
		Emp emp = (Emp) req.getSession().getAttribute("emp");
		ann.setAnEmpId(emp.getEmpId());
		ann.setAnFlag(true);
		ann.setAnTime(new Date());
		announcementService.addAnnouncement(ann);
		return "redirect:/anmanage";

	}

	// 通过角色ID查询所有公告
	@RequestMapping("/anmanage")
	public String announcementByEmp(Integer pageIndex, HttpServletRequest req, Model model) {
		if (pageIndex == null) {
			pageIndex = 1;
		}
		Emp emp = (Emp) req.getSession().getAttribute("emp");
		PageBean<Announcement> pageInfo = announcementService.showannouncementByEmp(pageIndex, PAGESIZE,
				emp.getEmpId());
		if (pageInfo.getTotalPage() == 0) {
			pageInfo.setPageIndex(0);
		}
		// 将分页信息打到展示页面
		System.out.println(pageInfo);
		model.addAttribute("page", pageInfo);
		// 公告信息存在页面
		return "announcementmanage";

	}

	// 软删除公告
	@RequestMapping("/delan")
	public String delAnnouncement(HttpServletRequest req, Integer anId, Model model) {
		System.out.println(anId);
		announcementService.delAn(anId);
		return "redirect:/anmanage";
	}

//	 	修改公告前的查询
	@GetMapping("/updatean/{anId}")
	public String updateShowAnById(@PathVariable("anId") Integer anId, Model model) {
		// 查询公告信息
		Announcement announcement = announcementService.ShowContentById(anId);
		List<AnnouncementType> types = annountcementTypeService.ShowAllAnnountcementType();
		// 把公告类别和详细的公告信息返回页面
		model.addAttribute("antypes", types);
		model.addAttribute("anInfo", announcement);
		return "updateannouncement";
	}

	// 修改公告
	@PutMapping("/announcement")
	public String updateAnnouncement(Announcement ann) {
		// 修改公告
		announcementService.updateAnnouncement(ann);
		return "redirect:/anmanage";
	}
}
