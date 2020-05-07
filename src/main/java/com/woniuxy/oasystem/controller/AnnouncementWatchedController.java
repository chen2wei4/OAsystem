package com.woniuxy.oasystem.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniuxy.oasystem.entity.Announcement;
import com.woniuxy.oasystem.service.AnnouncementFileService;
import com.woniuxy.oasystem.service.AnnouncementMessageService;
import com.woniuxy.oasystem.service.AnnouncementService;
import com.woniuxy.oasystem.service.AnnouncementWatchedService;
import com.woniuxy.oasystem.service.AnnountcementTypeService;
import com.woniuxy.oasystem.entity.AnnouncementWatched;

@Controller
public class AnnouncementWatchedController {
	@Autowired
	AnnouncementService announcementService;
	@Autowired
	AnnountcementTypeService annountcementTypeService;
	@Autowired
	AnnouncementFileService announcementFileService;
	@Autowired
	AnnouncementWatchedService announcementWatchedService;
	@Autowired
	AnnouncementMessageService announcementMessageService;
	// 查看观看人员名单
	@RequiresPermissions("announcement:manage")
	@RequestMapping("/announcementwatched")
	public String AnnouncementWatched(Announcement ann,Model model) {
		try {
		// 通过Id查询观看名单
		List<AnnouncementWatched> showWatchedMessage = announcementWatchedService.ShowWatchedMessage(ann.getAnId());
		Integer count=announcementWatchedService.ShowCountById(ann.getAnId());
		//返回基本的公告信息
		model.addAttribute("count", count);
		model.addAttribute("ancontent", ann);
		model.addAttribute("WatchedMessage", showWatchedMessage);
		return "announcementcontentPeoplelist";
		}catch(Exception e) {
			e.printStackTrace();
			//发生异常打到错误页
			model.addAttribute("errorcode", 500);
			model.addAttribute("error","查看观看人员出错请联系管理员");
			return "lyear_pages_error";
					
		}
	}

}
