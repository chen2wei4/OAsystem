package com.woniuxy.oasystem;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.woniuxy.oasystem.dao.ReportsDao;
import com.woniuxy.oasystem.entity.ReportType;
import com.woniuxy.oasystem.entity.Reports;
import com.woniuxy.oasystem.service.ReportsService;

@SpringBootTest
class OastystemApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	ReportsDao reportsDao;

	@Autowired
	ReportsService reportsService;

	// 根据id查报表
	@Test
	void test() {
		System.out.println(reportsDao.selectByReportId(1));
	}

	// 添加报表
	@Test
	void test2() {
		Reports reports = new Reports();
		reports.setTypeId(1);
		reports.setReportFromId(123);
		reports.setReportName("添加测试");
		reports.setReportDate(new Date());
		reports.setReportContent("描述");
		reports.setReportTrouble("问题");
		reportsDao.insertReports(reports);
		System.out.println("添加成功");
	}

	// 软删除
	@Test
	void test3() {
		reportsDao.deleteReportsByReportId(1);
	}

	// 查所有报表
	@Test
	void test4() {
		List<Reports> selectAll = reportsDao.selectAll();
		System.out.println(selectAll);
	}

	// 修改报表
	@Test
	void test5() {
		Reports reports = new Reports();
		reports.setReportId(1);
		reports.setReportName("修改测试");
		reports.setReportDate(new Date());
		reportsDao.updateReportsByReportId(reports);
	}
}