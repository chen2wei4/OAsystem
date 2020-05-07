package com.woniuxy.oasystem.dao;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.woniuxy.oasystem.entity.Reports;

public interface ReportsDao {
	// 根据编号查
	Reports selectByReportId(int reportId);

	// 根据时间查
	Reports selectByReportDate(Date reportDate);

	List<Reports> selectAll();

	// 添加
	void insertReports(Reports reports);

	// 软删除
	void deleteReportsByReportId(int reportId);

	// 修改
	void updateReportsByReportId(Reports reports);

	// 根据report_from分页查询（sql语句）
	public List<Reports> selectReportsByReportFromAndConditionPage(@Param("reports") Reports reports,
			@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

	// 根据report_from查数量
	int selectReportsByReportFromAndConditionPageCount(@Param("reports") Reports reports);

	// 分页查所有
	public List<Reports> selectAllReportsByConditionPage(@Param("reports") Reports reports,
			@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

	// 查所有数量
	int selectAllReportsByConditionPageCount(@Param("reports") Reports reports);
}
