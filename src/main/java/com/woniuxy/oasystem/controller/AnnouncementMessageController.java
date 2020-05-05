package com.woniuxy.oasystem.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.oasystem.entity.Announcement;
import com.woniuxy.oasystem.entity.AnnouncementFile;
import com.woniuxy.oasystem.entity.AnnouncementMessage;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.ResponseResult;
import com.woniuxy.oasystem.service.AnnouncementFileService;
import com.woniuxy.oasystem.service.AnnouncementMessageService;
import com.woniuxy.oasystem.service.AnnouncementService;
import com.woniuxy.oasystem.service.AnnouncementWatchedService;

@Controller
public class AnnouncementMessageController {
	@Autowired
	AnnouncementService announcementService;
	@Autowired
	AnnouncementFileService announcementFileService;
	@Autowired
	AnnouncementMessageService announcementMessageService;
	@Autowired
	AnnouncementWatchedService announcementWatchedService;

	/*
	 * 添加公告留言
	 */
	@RequestMapping("/insertanmessage")
	public String announcementContent(HttpServletRequest req, AnnouncementMessage am, Model model) {
		// 设置添加到数据库的数据
		am.setAmFlag(true);
		am.setAmTime(new Date());

		Emp emp = (Emp) req.getSession().getAttribute("emp");
		am.setAmEmpId(emp.getEmpId());
		// 后台添加到数据库
		announcementMessageService.addMessage(am);

		// 再通过Id查询详细公告内容返回原网页
		Announcement an = new Announcement();
		an.setAnId(am.getAmAnId());
		Announcement announcement = announcementService.ShowContentById(an);
		// 通过Id查询公告中是否含有附件
		List<AnnouncementFile> files = announcementFileService.ShowFiles(an.getAnId());
		// 添加用户阅读过的信息
		announcementWatchedService.addWatchedMessage(an.getAnId(), emp.getEmpId(), new Date());
		// 返回留言板内容
		List<AnnouncementMessage> messages = announcementMessageService.ShowAnnouncementMessage(an.getAnId());
		// 展示信息
		model.addAttribute("files", files);
		model.addAttribute("ancontent", announcement);
		model.addAttribute("messages", messages);
		return "announcementcontent";

	}

	/*
	 * 删除公告留言
	 */
	@ResponseBody
	@RequestMapping("/deletemessage")
	public ResponseResult<AnnouncementMessage> deleteannouncementMessage(HttpServletRequest req, AnnouncementMessage am,
			Model model) {
		try {// 软删除公告
			announcementMessageService.deleteMessage(am.getAmId());
			return new ResponseResult<AnnouncementMessage>(200, "success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseResult<AnnouncementMessage>(500, "failed", null);
		}
	}
}
