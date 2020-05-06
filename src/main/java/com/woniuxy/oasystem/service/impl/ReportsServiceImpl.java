package com.woniuxy.oasystem.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.woniuxy.oasystem.dao.ReportsDao;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.entity.Reports;
import com.woniuxy.oasystem.service.ReportsService;

@Service
public class ReportsServiceImpl implements ReportsService {

	@Autowired
	ReportsDao reportsDao;

	// 根据report_from分页查询
	@Override
	public PageBean<Reports> selectReportsByReportFromAndConditionPage(Reports reports, int pageIndex, int pageSize) {
		PageBean<Reports> pb = new PageBean<Reports>();
		List<Reports> beanList = reportsDao.selectReportsByReportFromAndConditionPage(reports,
				(pageIndex - 1) * pageSize, pageSize);
		pb.setBeanList(beanList);
		pb.setPageIndex(pageIndex);
		pb.setPageSize(pageSize);
		int totalRecord = reportsDao.selectReportsByReportFromAndConditionPageCount(reports);
		pb.setTotalRecord(totalRecord);
		pb.setTotalPage((totalRecord % pageSize == 0) ? totalRecord / pageSize : totalRecord / pageSize + 1);
		pb.setPageBeginAndPageEnd();
		System.out.println(pb);
		return pb;
	}

	// 分页查所有
	@Override
	public PageBean<Reports> selectAllReportsByConditionPage(Reports reports, int pageIndex, int pageSize) {
		PageBean<Reports> pb = new PageBean<Reports>();
		List<Reports> beanList = reportsDao.selectAllReportsByConditionPage(reports, (pageIndex - 1) * pageSize,
				pageSize);
		pb.setBeanList(beanList);
		pb.setPageIndex(pageIndex);
		pb.setPageSize(pageSize);
		int totalRecord = reportsDao.selectAllReportsByConditionPageCount(reports);
		pb.setTotalRecord(totalRecord);
		pb.setTotalPage((totalRecord % pageSize == 0) ? totalRecord / pageSize : totalRecord / pageSize + 1);
		pb.setPageBeginAndPageEnd();
		System.out.println(pb);
		return pb;
	}

	// 软删除
	@Override
	public void deleteReportsByReportId(int reportId) {
		reportsDao.deleteReportsByReportId(reportId);
	}

	// 添加
	@Override
	public void insertReports(Reports reports) {
		reportsDao.insertReports(reports);
	}

	// 根据编号查
	@Override
	public Reports selectByReportId(int reportId) {
		Reports selectByReportId = reportsDao.selectByReportId(reportId);
		return selectByReportId;
	}

	// 根据时间查
	@Override
	public Reports selectByReportDate(Date reportDate) {
		Reports selectByReportDate = reportsDao.selectByReportDate(reportDate);
		return selectByReportDate;
	}

	// 修改
	@Override
	public void updateReportsByReportId(Reports reports) {
		reportsDao.updateReportsByReportId(reports);
	}
}
