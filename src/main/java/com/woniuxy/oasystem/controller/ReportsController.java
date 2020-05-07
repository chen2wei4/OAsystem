package com.woniuxy.oasystem.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.entity.ReportCheck;
import com.woniuxy.oasystem.entity.ReportType;
import com.woniuxy.oasystem.entity.Reports;
import com.woniuxy.oasystem.service.EmpService;
import com.woniuxy.oasystem.service.ReportCheckService;
import com.woniuxy.oasystem.service.ReportTypeService;
import com.woniuxy.oasystem.service.ReportsService;

@Controller
public class ReportsController {

	@Autowired
	ReportsService reportsService;

	@Autowired
	ReportTypeService reportTypeService;

	@Autowired
	ReportCheckService reportCheckService;

	@Autowired
	EmpService empService;

	// 根据report_from分页查询
	@GetMapping(value = "/reportByReportFrom")
	public String reportByReportFrom(HttpServletRequest req, Model model, Reports reports, Integer pageIndex) {
//		System.out.println(reports);
//		System.out.println(reports.getTypeId());
//		System.out.println(reports.getReportName());
		Emp emp = (Emp) req.getSession().getAttribute("emp");
		reports.setReportFrom(emp);
		reports.setReportFromId(emp.getEmpId());
		if (pageIndex == null) {
			pageIndex = 1;
		}
		int pagesize = 10;
		PageBean<Reports> pb = reportsService.selectReportsByReportFromAndConditionPage(reports, pageIndex, pagesize);
		System.out.println(pb);
		List<ReportType> allReportType = reportTypeService.selectAllReportType();
		model.addAttribute("reportType", allReportType);
		model.addAttribute("reports", reports);
		model.addAttribute("pb", pb);
		return "reoprt_list.html";
	}

	// 根据report_to和未审核分页查询（查看去审核）
	@GetMapping(value = "/reportByReportTo")
	public String reportByReportTo(HttpServletRequest req, Model model, Reports reports, Integer pageIndex) {
//		System.out.println(reports);
//		System.out.println(reports.getTypeId());
//		System.out.println(reports.getReportName());
		Emp emp = (Emp) req.getSession().getAttribute("emp");
		reports.setReportTo(emp);
		reports.setReportToId(emp.getEmpId());
		if (pageIndex == null) {
			pageIndex = 1;
		}
		int pagesize = 10;
		PageBean<Reports> pb = reportsService.selectReportsByReportToAndConditionPage(reports, pageIndex, pagesize);
		System.out.println(pb);
		List<ReportType> allReportType = reportTypeService.selectAllReportType();
		model.addAttribute("reportType", allReportType);
		model.addAttribute("reports", reports);
		model.addAttribute("pb", pb);
		return "reoprt_waitforchecklist.html";
	}

	// 根据report_to已审核分页查询（查看历史审核）
	@GetMapping(value = "/reportByReportTo2")
	public String reportByReportTo2(HttpServletRequest req, Model model, Reports reports, Integer pageIndex) {
//		System.out.println(reports);
//		System.out.println(reports.getTypeId());
//		System.out.println(reports.getReportName());
		Emp emp = (Emp) req.getSession().getAttribute("emp");
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

	// 分页查所有
	@GetMapping(value = "/allReports")
	public String allReports(HttpServletRequest req, Model model, Reports reports, Integer pageIndex) {
		if (pageIndex == null) {
			pageIndex = 1;
		}
		try {
			int pagesize = 10;
			PageBean<Reports> allpb = reportsService.selectAllReportsByConditionPage(reports, pageIndex, pagesize);
			List<ReportType> allReportType = reportTypeService.selectAllReportType();
			model.addAttribute("reportType", allReportType);
			model.addAttribute("reports", reports);
			model.addAttribute("allpb", allpb);
			return "reoprt_alllist.html";
		} catch (Exception e) {
			return "lyear_pages_error";
		}

	}

	// 软删除
	@GetMapping(value = "/deleteReport")
	public String deleteReport(HttpServletRequest req, Model model, Reports reports, Integer pageIndex, int reportId) {
		try {
			Emp emp = (Emp) req.getSession().getAttribute("emp");
			reports.setReportFrom(emp);
			reports.setReportFromId(emp.getEmpId());
			reportsService.deleteReportsByReportId(reportId);
			if (pageIndex == null) {
				pageIndex = 1;
			}
			int pageSize = 10;
			PageBean<Reports> pb = reportsService.selectReportsByReportFromAndConditionPage(reports, pageIndex,
					pageSize);
			model.addAttribute("pb", pb);
			return "reoprt_list.html";
		} catch (Exception e) {
			return "lyear_pages_error";
		}
	}

	// 修改报表页面跳转
	@GetMapping(value = "/updateReportPageJumps")
	public String updateReportPageJumps(Model model, Integer reportId) {
		try {
			List<ReportType> allReportType = reportTypeService.selectAllReportType();
			model.addAttribute("reportType", allReportType);
			List<Emp> allEmps = empService.displayEmp();
			model.addAttribute("allEmps", allEmps);
			Reports updateReport = reportsService.selectByReportId(reportId);
			model.addAttribute("updateReport", updateReport);
			return "reoprt_update.html";
		} catch (Exception e) {
			return "lyear_pages_error";
		}
	}

	// 修改报表
	@PostMapping(value = "/updateReport")
	public String updateReport(HttpServletRequest req, @ModelAttribute Reports reports, Model model) {
		try {
			Date date = new Date();
			Emp emp = (Emp) req.getSession().getAttribute("emp");
			reports.setReportFromId(emp.getEmpId());
			reports.setReportDate(date);
			reportsService.updateReportsByReportId(reports);
			// 通过时间查到刚修改的报表跳转到报表详情页
			Reports reportDetail = reportsService.selectByReportDate(date);
			model.addAttribute("reportDetail", reportDetail);
			return "report_detail";
		} catch (Exception e) {
			return "lyear_pages_error";
		}
	}

	// 新增报表页面跳转
	@GetMapping(value = "/addReportPageJumps")
	public String addReportPageJumps(Model model) {
		try {
			List<ReportType> allReportType = reportTypeService.selectAllReportType();
			model.addAttribute("reportType", allReportType);
			List<Emp> allEmps = empService.displayEmp();
			model.addAttribute("allEmps", allEmps);
			System.out.println(allEmps);
			return "reoprt_add.html";
		} catch (Exception e) {
			return "lyear_pages_error";
		}
	}

	// 新增报表
	@PostMapping(value = "/addReport")
	public String addReport(HttpServletRequest req, @ModelAttribute Reports reports, Model model) {
		try {
			Date date = new Date();
			Emp emp = (Emp) req.getSession().getAttribute("emp");
			reports.setReportFromId(emp.getEmpId());
			reports.setReportDate(date);
			reports.setReportStatus("未审核");
			reportsService.insertReports(reports);
			// 通过时间查到刚添加的报表跳转到报表详情页
			Reports reportDetail = reportsService.selectByReportDate(date);
			model.addAttribute("reportDetail", reportDetail);
			return "report_detail";
		} catch (Exception e) {
			return "lyear_pages_error";
		}
	}

	// 通过Id查详细报表
	@GetMapping("/reportDetail")
	public String reportDetail(Integer reportId, Model model) {
		Reports reportDetail = reportsService.selectByReportId(reportId);
		ReportCheck reportCheckDetail = reportCheckService.selectByReportId(reportId);
//		System.out.println(reportCheckDetail);
//		System.out.println(reportDetail);
		model.addAttribute("reportCheckDetail", reportCheckDetail);
		model.addAttribute("reportDetail", reportDetail);
		return "report_detail";

	}
}
