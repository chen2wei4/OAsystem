package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.AnnouncementDao;
import com.woniuxy.oasystem.entity.Announcement;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.AnnountcementService;

@Service
public class AnnountcementServiceImpl implements AnnountcementService {
	@Autowired
	AnnouncementDao annountcementDao;
	@Autowired
	PageBean<Announcement> pagebean;

	/*
	 * 
	 * 通过分页展示某个类别公告
	 */
	@Override
	public PageBean<Announcement> ShowAnnouncementsByType(Integer pageIndex, Integer pageSize, Integer antype) {
		// 分页类设置页码
		pagebean.setPageIndex(pageIndex);
		// 分页类设置每页展示数
		pagebean.setPageSize(pageSize);
		// 分页类设置总条数
		Integer count = annountcementDao.selectAnnouncementCount(antype);
		pagebean.setTotalRecord(count);
		// 设置总页数
		Integer totalrecord = pagebean.getTotalRecord();
		pagebean.setTotalPage((totalrecord % 10 == 0) ? (totalrecord / 10) : (totalrecord / 10 + 1));
		// 分页设置开始和结束页
		pagebean.setPageBeginAndPageEnd();
		// 设置内容
		List<Announcement> anns = annountcementDao.selectAnnouncementByType(pageSize * (pageIndex - 1), pageSize,
				antype);
		pagebean.setBeanList(anns);
		return pagebean;
	}

	/*
	 * 
	 * 展示详细内容
	 */
	@Override
	public Announcement ShowContentById(Integer anId) {
		Announcement announcement = annountcementDao.selectAnnouncementById(anId);
		return announcement;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.woniuxy.oasystem.service.AnnountcementService#addAnnouncement(com.woniuxy
	 * .oasystem.entity.Announcement)
	 */
	@Override
	public void addAnnouncement(Announcement ann) {
		// 添加
		annountcementDao.insertAnnouncement(ann);
	}

	/*
	 * 展示所有当前用户Id创建的
	 */
	@Override
	public PageBean<Announcement> showannouncementByEmp(Integer pageIndex, Integer pageSize, Integer anEmpId) {
		// 分页类设置页码
		pagebean.setPageIndex(pageIndex);
		// 分页类设置每页展示数
		pagebean.setPageSize(pageSize);
		// 分页类设置总条数
		pagebean.setTotalRecord(annountcementDao.selectAnnouncementCountByEmp(anEmpId));
		// 设置总页数
		Integer totalrecord = pagebean.getTotalRecord();
		pagebean.setTotalPage((totalrecord % 10 == 0) ? (totalrecord / 10) : (totalrecord / 10 + 1));
		// 分页设置开始和结束页
		pagebean.setPageBeginAndPageEnd();
		// 设置内容
		List<Announcement> ans = annountcementDao.selectAnnouncementByEmp(pageSize * (pageIndex - 1), pageSize,
				anEmpId);
		pagebean.setBeanList(ans);
		return pagebean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.woniuxy.oasystem.service.AnnountcementService#delAn(java.lang.Integer)
	 */
	@Override
	public void delAn(Integer anId) {
		annountcementDao.deleteAn(anId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.woniuxy.oasystem.service.AnnountcementService#updateAnnouncement(com.
	 * woniuxy.oasystem.entity.Announcement)
	 */
	@Override
	public void updateAnnouncement(Announcement ann) {
		annountcementDao.updateAnnouncementById(ann);
	}

}
