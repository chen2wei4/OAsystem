package com.woniuxy.oasystem.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.woniuxy.oasystem.dao.ReportsDao;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.entity.Reports;
import com.woniuxy.oasystem.service.ReportsService;
import com.woniuxy.oasystem.service.impl.ReportsServiceImpl;

@Controller
public class ReportsController {

	/*
	 * @Autowired ReportsDao reportsDao;
	 */

	@Autowired
	ReportsService reportsService;

	@RequestMapping("/test")
	public String test() {
		return "index";
	}

	// 分页查看所有
	@GetMapping(value = "/allReports")
	public String getAllReports(Model model, Reports reports, Integer pageIndex) {
		// List<Reports> allReports = reportsDao.selectAll();
		/*
		 * int pageIndex = 1; int pageSize = 10; List<Reports> allReports =
		 * reportsDao.selectAllReportsByConditionPage((pageIndex - 1) * pageSize,
		 * pageSize); model.addAttribute("allReports", allReports); return
		 * "lyear_2_LightYear-admin/lyear_pages_doc.html";
		 */
		if (pageIndex == null) {
			pageIndex = 1;
		}
		int pagesize = 10;
		PageBean<Reports> pb = reportsService.getReportsByConditionPage(reports, pageIndex, pagesize);
		model.addAttribute("pb", pb);
		return "lyear_2_LightYear-admin/lyear_pages_doc.html";
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
		return "lyear_2_LightYear-admin/lyear_pages_doc.html";
	}

	// 新增报表页面跳转
	@GetMapping(value = "/reportDetailsPageJumps")
	public String reportDetailsPageJumps() {
		return "lyear_2_LightYear-admin/lyear_pages_add_doc.html";
	}

	// 新增报表
	@PostMapping(value = "/reportDetails")
	public String reportDetails(@ModelAttribute Reports reports) {
		Date reportDate = new Date();
		reports.setReportDate(reportDate);
		reports.setReportName("哎呀");
		reportsService.insertReports(reports);
		return "lyear_2_LightYear-admin/lyear_pages_add_doc.html";
	}

//	@GetMapping(value = "/emp")
//	public String toEmpAddPage(Model model) {
//		List<Dep> deps = new ArrayList<Dep>();
//		deps.add(new Dep(1, "d01"));
//		deps.add(new Dep(2, "d02"));
//		model.addAttribute("deps", deps);
//		return "empadd";
//	}
//
//	@PostMapping(value = "/emp")
//	public String addEmp(Emp emp) {
//		return "redirect:/emps";
//	}
//
//	@GetMapping(value = "/emp/{eid}")
//	public String toEmpEidtPage(@PathVariable("eid") Integer eid, Model model) {
//		Emp emp = null;
//		if (eid == 1) {
//			emp = new Emp(1, "zs", new Date(), new Dep(1, "d01"));
//		} else {
//			emp = new Emp(2, "ls", new Date(), new Dep(2, "d02"));
//		}
//		model.addAttribute("emp", emp);
//		List<Dep> deps = new ArrayList<Dep>();
//		deps.add(new Dep(1, "d01"));
//		deps.add(new Dep(2, "d02"));
//		model.addAttribute("deps", deps);
//		return "empupdate";
//	}
//
//	@PutMapping(value = "/emp")
//	public String updateEmp(Emp emp) {
//		return "redirect:/emps";
//	}
//
//	@DeleteMapping(value = "/emp/{eid}")
//	public String deleteEmp(@PathVariable("eid") Integer eid) {
//		return "redirect:/emps";
//	}
}
