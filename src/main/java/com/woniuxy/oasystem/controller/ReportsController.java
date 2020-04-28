package com.woniuxy.oasystem.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.entity.Reports;
import com.woniuxy.oasystem.service.ReportsService;

@Controller
public class ReportsController {

	@Autowired
	ReportsService reportsService;

	// 分页查看所有
	@GetMapping(value = "/allReports")
	public String getAllReports(Model model, Reports reports, Integer pageIndex) {
		if (pageIndex == null) {
			pageIndex = 1;
		}
		int pagesize = 10;
		PageBean<Reports> pb = reportsService.getReportsByConditionPage(reports, pageIndex, pagesize);
		model.addAttribute("pb", pb);
		return "lyear_pages_reoprts.html";
	}

	// 软删除
	@GetMapping(value = "/deleteReport")
	public String deleteReport(Model model, Reports reports, Integer pageIndex, int reportId) {
		reportsService.deleteReportsByReportId(reportId);
		if (pageIndex == null) {
			pageIndex = 1;
		}
		int pagesize = 10;
		PageBean<Reports> pb = reportsService.getReportsByConditionPage(reports, pageIndex, pagesize);
		model.addAttribute("pb", pb);
		return "lyear_pages_reoprts.html";
	}

	// 新增报表页面跳转
	@GetMapping(value = "/reportDetailsPageJumps")
	public String reportDetailsPageJumps() {
		return "lyear_pages_add_reoprts.html";
	}

	// 新增报表
	@PostMapping(value = "/reportDetails")
	public String reportDetails(@ModelAttribute Reports reports) {
//		Date reportDate = new Date();
//		reports.setReportDate(reportDate);
//		reports.setReportName("测试");
//		reportsService.insertReports(reports);
		return "lyear_pages_add_reports.html";
	}
}
