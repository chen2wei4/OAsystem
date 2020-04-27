package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.AnnouncementTypeDao;
import com.woniuxy.oasystem.entity.Announcement;
import com.woniuxy.oasystem.entity.AnnouncementType;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.AnnountcementTypeService;

@Service
public class AnnountcementTypeServiceImpl implements AnnountcementTypeService {

	@Autowired
	AnnouncementTypeDao announcementTypeDao;
	@Autowired
	PageBean<AnnouncementType> pagebean;

	// 展示所有公告分类
	@Override
	public List<AnnouncementType> ShowAllAnnountcementType() {
		List<AnnouncementType> alltype = announcementTypeDao.selectAllAnnouncementType();
		return alltype;
	}

	// 软删除公告类别
	@Override
	public void DeleteAntypeById(Integer id) {
		announcementTypeDao.deleteAnnouncementType(id);
	}

	// 修改公告名称
	@Override
	public void UpdateAntypeById(AnnouncementType anType) {
		announcementTypeDao.updateAnnouncementTypeById(anType);
	}

	// 通过ID查询单个公告类别
	@Override
	public AnnouncementType ShowAntypeById(Integer id) {
		AnnouncementType antype = announcementTypeDao.selectAnnouncementTypeById(id);
		return antype;
	}

	// 插入新的公告类别
	@Override
	public void addAnType(AnnouncementType anType) {
		announcementTypeDao.insertAnnouncementType(anType);
	}

	/*
	 * 分页
	 */
	@Override
	public PageBean<AnnouncementType> ShowAllAnnountcementTypePage(Integer pageIndex, Integer pageSize) {
		// 分页类设置页码
		pagebean.setPageIndex(pageIndex);
		// 分页类设置每页展示数
		pagebean.setPageSize(pageSize);
		// 分页类设置总条数
		pagebean.setTotalRecord(announcementTypeDao.selectAnnouncementTypeCount());
		// 分页设置开始和结束页
		pagebean.setPageBeginAndPageEnd();
		// 设置内容
		List<AnnouncementType> alltype = announcementTypeDao.selectAllAnnouncementType();
		pagebean.setBeanList(alltype);
		return pagebean;
	}

}
