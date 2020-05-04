package com.woniuxy.oasystem.service;

import java.util.Date;

import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.entity.Reports;

public interface ReportsService {
	// 根据report_from分页查询
	PageBean<Reports> selectReportsByReportFromAndConditionPage(Reports reports, int pageIndex, int pageSize);

	// 分页查所有
	PageBean<Reports> selectAllReportsByConditionPage(Reports reports, int pageIndex, int pageSize);

	// 添加
	void insertReports(Reports reports);

	// 软删除
	void deleteReportsByReportId(int reportId);

	// 根据编号查
	Reports selectByReportId(int reportId);

	// 根据时间查
	Reports selectByReportDate(Date reportDate);

	// 修改
	void updateReportsByReportId(Reports reports);
}
