package com.woniuxy.oasystem.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.entity.ReportType;
import com.woniuxy.oasystem.service.ReportTypeService;

@Controller
public class ReportTypeController {

	@Autowired
	ReportTypeService reportTypeService;

	// 所有报告种类分页查询
	@GetMapping(value = "/allReportType")
	public String allReportType(HttpServletRequest req, Model model, ReportType reportType, Integer pageIndex) {
		if (pageIndex == null) {
			pageIndex = 1;
		}
		int pagesize = 10;
		PageBean<ReportType> allpb = reportTypeService.selectAllReportTypeByConditionPage(reportType, pageIndex,
				pagesize);
		model.addAttribute("allpb", allpb);
		return "reoprt_alltype.html";
	}

	// 软删除
	@GetMapping(value = "/deleteReportType")
	public String deleteReportType(HttpServletRequest req, Model model, ReportType reportType, Integer pageIndex,
			int typeId) {
		try {
			reportTypeService.deleteReportTypeByTypeId(typeId);
			if (pageIndex == null) {
				pageIndex = 1;
			}
			int pageSize = 10;
			PageBean<ReportType> allpb = reportTypeService.selectAllReportTypeByConditionPage(reportType, pageIndex,
					pageSize);
			model.addAttribute("allpb", allpb);
			return "reoprt_alltype.html";
		} catch (Exception e) {
			return "lyear_pages_error";
		}
	}

	// 新增报告种类页面跳转
	@GetMapping(value = "/addReportTypePageJumps")
	public String addReportTypePageJumps(Model model) {
		try {
			return "reoprt_addtype.html";
		} catch (Exception e) {
			return "lyear_pages_error";
		}
	}

	// 新增报告种类
	@PostMapping(value = "/addReportType")
	public String addReportType(HttpServletRequest req, @ModelAttribute ReportType reportType, Model model) {
		try {
			reportTypeService.insertReportType(reportType);
			return "index";
		} catch (Exception e) {
			return "lyear_pages_error";
		}
	}

	// 修改报告种类页面跳转
	@GetMapping(value = "/updateReportTypePageJumps")
	public String updateReportTypePageJumps(Model model, Integer typeId) {
		try {
//			Reports updateReport = reportsService.selectByReportId(reportId);
//			model.addAttribute("updateReport", updateReport);
			ReportType updateType = reportTypeService.selectByTypeId(typeId);
			model.addAttribute("updateType", updateType);
			return "reoprt_updatetype.html";
		} catch (Exception e) {
			return "lyear_pages_error";
		}
	}

	// 修改报告种类
	@PostMapping(value = "/updateReportType")
	public String updateReportType(HttpServletRequest req, @ModelAttribute ReportType reportType, Model model) {
		try {
			reportTypeService.updateReportTypeByTypeId(reportType);
			System.out.println("修改成功");
			return "index";
		} catch (Exception e) {
			return "lyear_pages_error";
		}
	}
}
