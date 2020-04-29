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
import com.woniuxy.oasystem.entity.AnnouncementType;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.AnnouncementFileService;
import com.woniuxy.oasystem.service.AnnouncementService;
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
	
	// 固定每页展示5行数据
	Integer PAGESIZE = 10;

	/*
	 * 通过条件查询当前类别所有公告
	 */
	@RequestMapping("/announcement")
	public String ShowanByType(Announcement an, Integer pageIndex, Model model) {
		if (pageIndex == null) {
			pageIndex = 1;
		}
		// 首页点击默认为第一页
		PageBean<Announcement> pageInfo = announcementService.ShowAnnouncementsByCondition(pageIndex, PAGESIZE, an);
		if (pageInfo.getTotalPage() == 0) {
			pageInfo.setPageIndex(0);
		}
		// 将分页信息打到展示页面
		model.addAttribute("page", pageInfo);
		// 查询所有的公告分类
		List<AnnouncementType> list = annountcementTypeService.ShowAllAnnountcementType();
		// 将类别也传到页面
		model.addAttribute("types", list);
		return "announcementpages";
	}

	/*
	 * 通过Id查公告详细内容
	 */
	@RequestMapping("/ancontent")
	public String announcementContent(Announcement an, Model model) {
		// 通过Id查询详细公告内容
		Announcement announcement = announcementService.ShowContentById(an);
		//通过Id查询公告中是否含有附件
		List<AnnouncementFile> files=announcementFileService.ShowFiles(an.getAnId());
		//展示信息
		model.addAttribute("files",files);
		model.addAttribute("ancontent", announcement);
		return "announcementcontent";

	}

	/*
	 * 通过角色ID查询所有公告跳转管理
	 */
	@RequestMapping("/anmanage")
	public String announcementByEmp(Announcement an, Integer pageIndex, HttpServletRequest req, Model model) {
		if (pageIndex == null) {
			pageIndex = 1;
		}
		PageBean<Announcement> pageInfo = announcementService.ShowAnnouncementsByCondition(pageIndex, PAGESIZE, an);
		if (pageInfo.getTotalPage() == 0) {
			pageInfo.setPageIndex(0);
		}
		model.addAttribute("page", pageInfo);
		// 查询所有的公告分类
		List<AnnouncementType> list = annountcementTypeService.ShowAllAnnountcementType();
		// 将类别也传到页面
		model.addAttribute("types", list);
		return "announcementmanage";

	}

	/*
	 * 软删除公告
	 */
	@RequestMapping("/delan")
	public String delAnnouncement(HttpServletRequest req, Integer anId, Model model) {
		System.out.println(anId);
		announcementService.delAn(anId);
		return "redirect:/anmanage";
	}
	// 添加公告
		@RequestMapping("/addannouncement")
		public String addannouncement(@RequestParam(value="files",required=false) MultipartFile[] files,HttpServletRequest req,Announcement ann, Model model) {
			//添加公告信息到数据库中,同时查出自增列
			ann.setAnFlag(true);
			ann.setAnTime(new Date());
			Emp emp = (Emp) req.getSession().getAttribute("emp");
			ann.setAnEmpId(emp.getEmpId());
			Integer afAnId = announcementService.addAnnouncement(ann);
			//判断有无文件上传，有则上传文件。并且把文件的信息添加到数据库，没有则直接返回
			if(files.length>0) {
				for(MultipartFile file:files) {
					//获取文件名
					String fileName = file.getOriginalFilename();
					//设置文件路径
					String filePath =UUID.randomUUID()+ req.getSession().getServletContext().getRealPath("files/");
					//文件上传
					 try {
				          FileUtil.uploadFile(file.getBytes(), filePath, fileName);
				        } catch (Exception e) {
				            // TODO: handle exception
				        }
					 //上传成功把文件的信息存入数据库
					 AnnouncementFile announcementFile = new AnnouncementFile();
					 announcementFile.setAfAddress(filePath);
					 announcementFile.setAfFlag(true);
					 announcementFile.setAfName(fileName);
					 announcementFile.setAfAnId(afAnId);
					 announcementFileService.addAnnouncementFile(announcementFile);
				}
			}
			return "redirect:/anmanage";

		}
//	 	修改公告前的查询
			@GetMapping("/updatean/{anId}")
			public String updateShowAnById(@PathVariable("anId") Integer anId, Model model) {
				//查询公告信息
				
				Announcement an=new Announcement();
				an.setAnId(anId);
				Announcement announcement = announcementService.ShowContentById(an);
				List<AnnouncementType> types = annountcementTypeService.ShowAllAnnountcementType();
				//把公告类别和详细的公告信息返回页面
				model.addAttribute("antypes", types);
				model.addAttribute("anInfo", announcement);
				return "updateannouncement";
			}
			//修改公告
			@PutMapping("/announcement")
			public String updateAnnouncement(Announcement ann) {
				//修改公告
				announcementService.updateAnnouncement(ann);
				return "redirect:/anmanage";
			}


	       
	        
	       
	       
}
