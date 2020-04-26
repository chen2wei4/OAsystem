package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Reports;

public interface ReportsDao {
	// 根据编号查
	Reports selectByReportId(int reportId);

	// 查所有
	List<Reports> selectAll();

	// 添加
	void insertReports(Reports reports);

	// 软删除
	void deleteReportsByReportId(int reportId);

	// 修改
	void updateReportsByReportId(Reports reports);

	// 分页查询
	public List<Reports> selectAllReportsByConditionPage(@Param("reports") Reports reports,
			@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

	int selectReportsByConditionPageCount(@Param("reports") Reports reports);
}
