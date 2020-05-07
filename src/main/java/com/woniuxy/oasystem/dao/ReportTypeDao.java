package com.woniuxy.oasystem.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.woniuxy.oasystem.entity.ReportType;

public interface ReportTypeDao {
	// 查询所有报告类别
	public List<ReportType> selectAllReportType();

	// 分页查所有
	public List<ReportType> selectAllReportTypeByConditionPage(@Param("reportType") ReportType reportType,
			@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

	// 查所有数量
	int selectAllReportTypeByConditionPageCount(@Param("reportType") ReportType reportType);

	// 根据编号查
	ReportType selectByTypeId(int typeId);

	// 添加
	void insertReportType(ReportType reportType);

	// 修改
	void updateReportTypeByTypeId(ReportType reportType);

	// 软删除
	void deleteReportTypeByTypeId(int typeId);
}
