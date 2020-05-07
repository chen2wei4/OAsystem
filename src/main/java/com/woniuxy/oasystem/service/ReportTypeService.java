package com.woniuxy.oasystem.service;

import java.util.List;
import com.woniuxy.oasystem.entity.ReportType;

public interface ReportTypeService {
//	//插入新的公告分类
//	public void addAnType(AnnouncementType anType);
	// 展示所有公告分类
	public List<ReportType> selectAllReportType();
//	//软删除公告类别
//	public void DeleteAntypeById(Integer id);
//	//修改公告类别
//	public void UpdateAntypeById(AnnouncementType anType);
//	//通过Id查询公告类别
//	public  AnnouncementType ShowAntypeById(Integer id);
//	//分页展示公告分类
//	public PageBean<AnnouncementType> ShowAllAnnountcementTypePage(Integer pageIndex,Integer pageSize);
}
