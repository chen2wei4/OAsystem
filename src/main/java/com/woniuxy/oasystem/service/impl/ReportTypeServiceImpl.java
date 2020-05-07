package com.woniuxy.oasystem.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.woniuxy.oasystem.dao.ReportTypeDao;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.entity.ReportType;
import com.woniuxy.oasystem.service.ReportTypeService;

@Service
public class ReportTypeServiceImpl implements ReportTypeService {

	@Autowired
	ReportTypeDao reportTypeDao;

	// 查询所有公告分类
	@Override
	public List<ReportType> selectAllReportType() {
		List<ReportType> selectAllReportType = reportTypeDao.selectAllReportType();
		return selectAllReportType;
	}

	@Override
	public PageBean<ReportType> selectAllReportTypeByConditionPage(ReportType reportType, int pageIndex, int pageSize) {
		PageBean<ReportType> pb = new PageBean<ReportType>();
		List<ReportType> beanList = reportTypeDao.selectAllReportTypeByConditionPage(reportType,
				(pageIndex - 1) * pageSize, pageSize);
		pb.setBeanList(beanList);
		pb.setPageIndex(pageIndex);
		pb.setPageSize(pageSize);
		int totalRecord = reportTypeDao.selectAllReportTypeByConditionPageCount(reportType);
		pb.setTotalRecord(totalRecord);
		pb.setTotalPage((totalRecord % pageSize == 0) ? totalRecord / pageSize : totalRecord / pageSize + 1);
		pb.setPageBeginAndPageEnd();
		System.out.println(pb);
		return pb;
	}

	// 软删除
	@Override
	public void deleteReportTypeByTypeId(int typeId) {
		reportTypeDao.deleteReportTypeByTypeId(typeId);
	}

	// 添加
	@Override
	public void insertReportType(ReportType reportType) {
		reportTypeDao.insertReportType(reportType);
	}

	// 修改
	@Override
	public void updateReportTypeByTypeId(ReportType reportType) {
		reportTypeDao.updateReportTypeByTypeId(reportType);
	}

	// 根据编号查
	@Override
	public ReportType selectByTypeId(int typeId) {
		ReportType selectByTypeId = reportTypeDao.selectByTypeId(typeId);
		return selectByTypeId;
	}
}
