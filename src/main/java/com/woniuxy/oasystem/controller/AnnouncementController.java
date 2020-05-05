package com.woniuxy.oasystem.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

@Controller
public class AnnouncementController {
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
	// 固定每页展示5行数据
	Integer PAGESIZE = 10;

	/*
	 * 通过条件查询当前类别所有公告
	 */
	@RequestMapping("/announcement")
	public String ShowanByType(HttpServletRequest req, Announcement an, Integer pageIndex, Model model) {
		if (pageIndex == null) {
			pageIndex = 1;
		}
		try {
		// 获取读取的人的信息
		Emp emp = (Emp) req.getSession().getAttribute("emp");
		// 分页查询所有公告，同时可以查看是否已经观看
		PageBean<Announcement> pageInfo = announcementService.ShowAnnouncementsByCondition(pageIndex, PAGESIZE, an,
				emp.getEmpId());
		if (pageInfo.getTotalPage() == 0) {
			pageInfo.setPageIndex(0);
		}
		// 将分页信息打到展示页面
		model.addAttribute("page", pageInfo);
		// 查询所有的公告分类
		List<AnnouncementType> list = annountcementTypeService.ShowAllAnnountcementTypes();
		// 将查询的条件返回页面
		model.addAttribute("condition", an);
		// 将类别也传到页面
		model.addAttribute("types", list);
		return "announcementpages";
		}catch(Exception e) {
			e.printStackTrace();
			//发生异常打到错误页
			return "lyear_pages_error";
					
		}
	}

	/*
	 * 通过Id查公告详细内容
	 */
	@RequestMapping("/ancontent")
	public String announcementContent(HttpServletRequest req, Announcement an, Model model) {
		try {
		// 通过Id查询详细公告内容
		Announcement announcement = announcementService.ShowContentById(an);
		// 通过Id查询公告中是否含有附件
		List<AnnouncementFile> files = announcementFileService.ShowFiles(an.getAnId());
		// 获取读取的人的信息
		Emp emp = (Emp) req.getSession().getAttribute("emp");
		// 添加用户阅读过的信息
		announcementWatchedService.addWatchedMessage(an.getAnId(), emp.getEmpId(), new Date());
		// 查看当前公告的留言板
		List<AnnouncementMessage> messages = announcementMessageService.ShowAnnouncementMessage(an.getAnId());
		System.out.println(messages);
		// 展示信息
		model.addAttribute("files", files);
		model.addAttribute("ancontent", announcement);
		model.addAttribute("messages", messages);
		return "announcementcontent";
		}catch(Exception e) {
			e.printStackTrace();
			//发生异常打到错误页
			return "lyear_pages_error";
					
		}
	}

	/*
	 * 通过角色ID查询所有公告跳转管理
	 */
	@RequestMapping("/anmanage")
	public String announcementByEmp(Announcement an, Integer pageIndex, HttpServletRequest req, Model model) {
		try {
		Emp emp = (Emp) req.getSession().getAttribute("emp");
		an.setAnEmpId(emp.getEmpId());
		if (pageIndex == null) {
			pageIndex = 1;
		}
		PageBean<Announcement> pageInfo = announcementService.ShowAnnouncementsByCondition(pageIndex, PAGESIZE, an,
				null);
		if (pageInfo.getTotalPage() == 0) {
			pageInfo.setPageIndex(0);
		}
		model.addAttribute("page", pageInfo);
		// 查询所有的公告分类
		List<AnnouncementType> list = annountcementTypeService.ShowAllAnnountcementTypes();
		// 将查询的条件返回页面
		model.addAttribute("condition", an);
		// 将类别也传到页面
		model.addAttribute("types", list);
		return "announcementmanage";
		}catch(Exception e) {
			e.printStackTrace();
			//发生异常打到错误页
			return "lyear_pages_error";
					
		}
	}

	/*
	 * 软删除公告
	 */
	@RequestMapping("/delan")
	public String delAnnouncement(HttpServletRequest req, Integer anId, Model model) {
		try {
		announcementService.delAn(anId);
		return "redirect:/anmanage";
		}catch(Exception e) {
			e.printStackTrace();
			//发生异常打到错误页
			return "lyear_pages_error";
					
		}
		}

	// 添加公告
	@RequestMapping("/addannouncement")
	public String addannouncement(@RequestParam(value = "files", required = false) MultipartFile[] files,
			HttpServletRequest req, Announcement ann, Model model) {
		try {
		// 添加公告信息到数据库中,同时查出自增列
		ann.setAnFlag(true);
		ann.setAnTime(new Date());
		Emp emp = (Emp) req.getSession().getAttribute("emp");
		ann.setAnEmpId(emp.getEmpId());
		Integer afAnId = announcementService.addAnnouncement(ann);
		// 判断有无文件上传，有则上传文件。并且把文件的信息添加到数据库，没有则直接返回
		if (files.length > 0) {
			for (MultipartFile file : files) {
				try {
					// 文件上传并且获取文件路径
					String filePath = FileUtil.uploadFile(file, "D:/springbootZHSH");
					// 文件名
					String fileName = file.getOriginalFilename();
					// 上传成功把文件的信息存入数据库
					AnnouncementFile announcementFile = new AnnouncementFile();
					announcementFile.setAfAddress(filePath);
					announcementFile.setAfFlag(true);
					announcementFile.setAfName(fileName);
					announcementFile.setAfAnId(afAnId);
					announcementFileService.addAnnouncementFile(announcementFile);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		return "redirect:/anmanage";
		}catch(Exception e) {
			e.printStackTrace();
			//发生异常打到错误页
			return "lyear_pages_error";
					
		}
	}

	/*
	 * // 修改公告前的查询
	 */
	@RequestMapping("/updatean")
	public String updateShowAnById(Announcement an, Model model) { // 查询公告信息 Announcement announcement =
		try {
		Announcement announcement = announcementService.ShowContentById(an);
		List<AnnouncementType> types = annountcementTypeService.ShowAllAnnountcementTypes(); // 查看当前公告的留言板
		List<AnnouncementMessage> messages = announcementMessageService.ShowAnnouncementMessage(an.getAnId());
		// 通过Id查询公告中是否含有附件
		List<AnnouncementFile> files = announcementFileService.ShowFiles(an.getAnId());
		model.addAttribute("files", files);
		model.addAttribute("antypes", types);
		model.addAttribute("anInfo", announcement);
		model.addAttribute("messages", messages);
		return "updateannouncement";
		}catch(Exception e) {
			e.printStackTrace();
			//发生异常打到错误页
			return "lyear_pages_error";
					
		}
		}

// 	添加公告前的查询
	@RequestMapping("/addan")
	public String addShowAnById(Model model) {
		try {
		// 查询公告类别信息
		List<AnnouncementType> types = annountcementTypeService.ShowAllAnnountcementTypes();
		// 把公告类别返回页面
		model.addAttribute("antypes", types);
		return "addannouncement";
		}catch(Exception e) {
			e.printStackTrace();
			//发生异常打到错误页
			return "lyear_pages_error";
					
		}
		}

	/*
	 * 修改公告
	 */
	@RequestMapping("/updateannouncement")
	public String updateAnnouncement(@RequestParam(value = "files", required = false) MultipartFile[] files,
			Announcement ann) {
		try {
		// 修改公告本身的内容
		announcementService.updateAnnouncement(ann);
		// 判断有无文件上传，有则上传文件。并且把文件的信息添加到数据库，没有则直接返回
		System.out.println(files.length);
		System.out.println(111111111);
		if (files.length > 0) {
			System.out.println(2323);
			for (MultipartFile file : files) {
				try {
					// 文件上传并且获取文件路径
					String filePath = FileUtil.uploadFile(file, "D:/springbootZHSH");
					// 文件名
					String fileName = file.getOriginalFilename();
					// 上传成功把文件的信息存入数据库
					AnnouncementFile announcementFile = new AnnouncementFile();
					announcementFile.setAfAddress(filePath);
					announcementFile.setAfFlag(true);
					announcementFile.setAfName(fileName);
					announcementFile.setAfAnId(ann.getAnId());
					announcementFileService.addAnnouncementFile(announcementFile);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}

		return "redirect:/anmanage";
		}catch(Exception e) {
			e.printStackTrace();
			//发生异常打到错误页
			return "lyear_pages_error";
					
		}
		}

}