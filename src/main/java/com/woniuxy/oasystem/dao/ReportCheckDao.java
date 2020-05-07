package com.woniuxy.oasystem.dao;

import com.woniuxy.oasystem.entity.ReportCheck;

public interface ReportCheckDao {
	// 新增审核
	void insertReportCheck(ReportCheck reportCheck);

	//根据reportId查找审核
	ReportCheck selectByReportId(int reportId);
}
