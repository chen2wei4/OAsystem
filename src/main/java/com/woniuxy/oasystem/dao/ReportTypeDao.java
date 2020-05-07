package com.woniuxy.oasystem.dao;

import java.util.List;
import com.woniuxy.oasystem.entity.ReportType;

public interface ReportTypeDao {
//	//添加新的类别
//	public void insertAnnouncementType(AnnouncementType antype);
//	//软删除公告类别
//	public void deleteAnnouncementType(Integer id);
	//查询所有公告类别
	public List<ReportType> selectAllReportType();
//	//通过ID查询公告类别(查询当前公告类别下所有公告)
//	public AnnouncementType selectAnnouncementTypeById(Integer id);
//	//修改公告类别名称
//	public void updateAnnouncementTypeById(AnnouncementType antype);
//	//查询公告类别数量
//	public Integer selectAnnouncementTypeCount();
	
}

