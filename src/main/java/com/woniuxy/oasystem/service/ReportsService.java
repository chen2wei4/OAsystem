package com.woniuxy.oasystem.service;

import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.entity.Reports;

public interface ReportsService {
	// 分页查看所有
	PageBean<Reports> getReportsByConditionPage(Reports reports, int pageIndex, int pageSize);
	
	// 添加
		void insertReports(Reports reports);

	// 软删除
	void deleteReportsByReportId(int reportId);
}
