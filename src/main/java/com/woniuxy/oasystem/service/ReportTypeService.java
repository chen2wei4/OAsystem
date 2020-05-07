package com.woniuxy.oasystem.service;

import java.util.List;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.entity.ReportType;

public interface ReportTypeService {

	// 查询所有报告分类
	public List<ReportType> selectAllReportType();

	// 分页查所有
	PageBean<ReportType> selectAllReportTypeByConditionPage(ReportType reportType, int pageIndex, int pageSize);

	// 根据编号查
	ReportType selectByTypeId(int typeId);

	// 添加
	void insertReportType(ReportType reportType);

	// 修改
	void updateReportTypeByTypeId(ReportType reportType);

	// 软删除
	void deleteReportTypeByTypeId(int typeId);
}
