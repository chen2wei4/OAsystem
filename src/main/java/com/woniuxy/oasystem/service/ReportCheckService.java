package com.woniuxy.oasystem.service;

import com.woniuxy.oasystem.entity.ReportCheck;

public interface ReportCheckService {
	// 新增审核
		void insertReportCheck(ReportCheck reportCheck);
		
	//根据reportId查找
		ReportCheck selectByReportId(int reportId);
}
