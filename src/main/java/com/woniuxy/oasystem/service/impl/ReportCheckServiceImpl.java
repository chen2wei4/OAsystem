package com.woniuxy.oasystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.woniuxy.oasystem.dao.ReportCheckDao;
import com.woniuxy.oasystem.entity.ReportCheck;
import com.woniuxy.oasystem.service.ReportCheckService;

@Service
public class ReportCheckServiceImpl implements ReportCheckService {

	@Autowired
	ReportCheckDao reportCheckDao;

	@Override
	public ReportCheck selectByReportId(int reportId) {
		ReportCheck selectByReportId = reportCheckDao.selectByReportId(reportId);
		return selectByReportId;
	}

	@Override
	public void insertReportCheck(ReportCheck reportCheck) {
		reportCheckDao.insertReportCheck(reportCheck);
	}
}
