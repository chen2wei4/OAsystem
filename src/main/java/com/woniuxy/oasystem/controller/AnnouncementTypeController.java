package com.woniuxy.oasystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.oasystem.entity.AnnouncementType;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.entity.ResponseResult;
import com.woniuxy.oasystem.service.AnnountcementTypeService;

@Controller
public class AnnouncementTypeController {
	@Autowired
	AnnountcementTypeService announcementTypeService;
	// 固定每页展示5行数据
		Integer PAGESIZE = 5;

	// 查看所有公告类别
	@ResponseBody
	@RequestMapping("/announcement/alltypes")
	public ResponseResult<List<AnnouncementType>> ShowAllantype(HttpServletRequest req) {
		req.getSession().setAttribute("user", 1);
		try {
			List<AnnouncementType> types = this.selectAllType();
			return new ResponseResult<List<AnnouncementType>>(200, "success", types);
		} catch (Exception e) {
			return new ResponseResult<List<AnnouncementType>>(500, "failed", null);

		}
	}

	// 添加公告前的查看所有公告类别
	@RequestMapping("/addantype/select")
	public String addAnShowAllantype(Model model) {
		// 把公告分类查询出来
		List<AnnouncementType> types = this.selectAllType();
		model.addAttribute("antypes", types);
		return "addannouncement";
	}

	// 查看所有公告类别发到管理页面
	@RequestMapping("/updateantype/select")
	public String updateAnTypeShowAllantype(Model model) {
		// 把公告分类查询出来
		List<AnnouncementType> types = this.selectAllType();
		model.addAttribute("antypes", types);
		return "announcementtypemanage";
	}

	/**
	 * TODO
	 * 
	 * @changeLog 1. 创建 (2020年4月26日 上午9:56:00 [liuwenpeng]) 2.查询所有公告类别
	 */
	private List<AnnouncementType> selectAllType() {
		//分页展示类别
		List<AnnouncementType> types = announcementTypeService.ShowAllAnnountcementType();
		return types;
	}

//	 	软删除公告类别
	@ResponseBody
	@RequestMapping("/announcementtype/del")
	public ResponseResult<List<AnnouncementType>> delAnnouncementType(Integer atId, Model model) {
		System.out.println(atId);
		try {
			// 删除
			announcementTypeService.DeleteAntypeById(atId);
			return new ResponseResult<List<AnnouncementType>>(200, "success", null);
		} catch (Exception e) {
			return new ResponseResult<List<AnnouncementType>>(500, "failed", null);

		}
	}

	// 添加类别公告
	@PostMapping("/addantype")
	public String addannouncementType(AnnouncementType antype, Model model) {
		// 設置添加時的屬性
		antype.setAtFlag(true);
		announcementTypeService.addAnType(antype);
		return "redirect:/updateantype/select";

	}

	// 修改公告类别前的查询
	@GetMapping("/updantype/{atId}")
	public String updateShowAnTypeById(@PathVariable("atId") Integer atId, Model model) {
		// 查询公告类别信息
		AnnouncementType announcementtype = announcementTypeService.ShowAntypeById(atId);
		model.addAttribute("antypeInfo", announcementtype);
		return "updateannouncementtype";
	}

	// 修改公告类别
	@PutMapping("/updateantype")
	public String updateAnnouncement(AnnouncementType anType) {
		// 修改公告
		announcementTypeService.UpdateAntypeById(anType);
		return "redirect:/updateantype/select";
	}
}
