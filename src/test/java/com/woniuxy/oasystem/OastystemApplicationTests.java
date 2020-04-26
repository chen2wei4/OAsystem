package com.woniuxy.oasystem;

import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.woniuxy.oasystem.dao.ReportsDao;
import com.woniuxy.oasystem.entity.ReportType;
import com.woniuxy.oasystem.entity.Reports;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class OastystemApplicationTests {

	@Autowired
	ReportsDao reportsDao;

	@Test
	void contextLoads() {
	}

	@Test
	void test() {
		System.out.println(reportsDao.selectByReportId(1));
	}

	@Test
	void test2() {
		Reports reports = new Reports();
		ReportType reportType = new ReportType();
		reportType.setTypeId(1);
		for (int a = 3; a < 100; a++) {
			reports.setReportName("添加测试" + a);
			reports.setTypeId(reportType);
			reports.setReportDate(new Date());
			reportsDao.insertReports(reports);
			System.out.println("添加成功");
		}

	}

	@Test
	void test3() {
		reportsDao.deleteReportsByReportId(1);
	}

	@Test
	void test4() {
		List<Reports> selectAll = reportsDao.selectAll();
		System.out.println(selectAll);
	}

	@Test
	void test5() {
		Reports reports = new Reports();
		reports.setReportId(1);
		reports.setReportName("修改测试");
		reports.setReportDate(new Date());
		reportsDao.updateReportsByReportId(reports);
	}
}
