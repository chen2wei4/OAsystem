package com.woniuxy.oasystem.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.woniuxy.oasystem.entity.Announcement;
import com.woniuxy.oasystem.entity.AnnouncementFile;
import com.woniuxy.oasystem.entity.AnnouncementMessage;
import com.woniuxy.oasystem.entity.AnnouncementType;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.AnnouncementFileService;
import com.woniuxy.oasystem.service.AnnouncementMessageService;
import com.woniuxy.oasystem.service.AnnouncementService;
import com.woniuxy.oasystem.service.AnnouncementWatchedService;
import com.woniuxy.oasystem.service.AnnountcementTypeService;
import com.woniuxy.oasystem.util.FileUtil;
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
	@RequestMapping("/announcementwatched")
	public String AnnouncementWatched(Announcement ann,Model model) {
		// 通过Id查询观看名单
		List<AnnouncementWatched> showWatchedMessage = announcementWatchedService.ShowWatchedMessage(ann.getAnId());
		Integer count=announcementWatchedService.ShowCountById(ann.getAnId());
		//返回基本的公告信息
		model.addAttribute("count", count);
		model.addAttribute("ancontent", ann);
		model.addAttribute("WatchedMessage", showWatchedMessage);
		return "announcementcontentPeoplelist";
	}

}
