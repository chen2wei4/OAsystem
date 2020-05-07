package com.woniuxy.oasystem.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.entity.ReportCheck;
import com.woniuxy.oasystem.entity.ReportType;
import com.woniuxy.oasystem.entity.Reports;
import com.woniuxy.oasystem.service.ReportCheckService;
import com.woniuxy.oasystem.service.ReportTypeService;
import com.woniuxy.oasystem.service.ReportsService;

@Controller
public class ReportCheckController {

	@Autowired
	ReportsService reportsService;

	@Autowired
	ReportTypeService reportTypeService;

	@Autowired
	ReportCheckService reportCheckService;

	// 新增审核
	@PostMapping(value = "/addCheck")
	public String addCheck(HttpServletRequest req, ReportCheck reportCheck, Model model, Reports reports,
			Integer pageIndex) {
		Date date = new Date();
		Emp emp = (Emp) req.getSession().getAttribute("emp");
		reportCheck.setEmpIdd(emp.getEmpId());
		reportCheck.setCheckDate(date);
		reportCheck.setReportIdd(reportCheck.getReportIdd());
		reportCheck.setCheckComment(reportCheck.getCheckComment());
		reportCheckService.insertReportCheck(reportCheck);
		reportsService.updateReportsToCheckByReportId(reportCheck.getReportIdd());
		// 通过reportId查到刚添加审核的报表跳转到报表详情页
//		ReportCheck reportCheckDetail = reportCheckService.selectByReportId(reportCheck.getReportIdd());
//		model.addAttribute("reportCheckDetail", reportCheckDetail);
//		Reports reportDetail = reportsService.selectByReportId(reportCheck.getReportIdd());
//		model.addAttribute("reportDetail", reportDetail);
		reports.setReportTo(emp);
		reports.setReportToId(emp.getEmpId());
		if (pageIndex == null) {
			pageIndex = 1;
		}
		int pagesize = 10;
		PageBean<Reports> pb = reportsService.selectReportsByReportToAndConditionPage2(reports, pageIndex, pagesize);
//		System.out.println(pb);
		List<ReportType> allReportType = reportTypeService.selectAllReportType();
		model.addAttribute("reportType", allReportType);
		model.addAttribute("reports", reports);
		model.addAttribute("pb", pb);
		return "reoprt_checkhistory.html";
	}

	// 通过Id查详细报表去审核
	@GetMapping("/goToCheck")
	public String goToCheck(Integer reportId, Model model) {
		Reports reportDetail = reportsService.selectByReportId(reportId);
		ReportCheck reportCheckDetail = reportCheckService.selectByReportId(reportId);
		System.out.println(reportCheckDetail);
		System.out.println(".." + reportDetail);
		model.addAttribute("reportCheckDetail", reportCheckDetail);
		model.addAttribute("reportDetail", reportDetail);
		return "report_checkpage";

	}
}
