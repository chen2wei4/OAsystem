package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.AnnouncementDao;
import com.woniuxy.oasystem.entity.Announcement;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.AnnouncementService;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
	@Autowired
	AnnouncementDao annountcementDao;
	@Autowired
	PageBean<Announcement> pagebean;

	/*
	 * 
	 * 条件查询公告
	 */
	@Override
	public PageBean<Announcement> ShowAnnouncementsByCondition(Integer pageIndex, Integer pageSize, Announcement an) {
		// 分页类设置页码
		pagebean.setPageIndex(pageIndex);
		// 分页类设置每页展示数
		pagebean.setPageSize(pageSize);
		// 分页类设置总条数
		Integer count = annountcementDao.selectAnnouncementCountByCondition(an);
		pagebean.setTotalRecord(count);
		// 设置总页数
		Integer totalrecord = pagebean.getTotalRecord();
		pagebean.setTotalPage((totalrecord % 10 == 0) ? (totalrecord / 10) : (totalrecord / 10 + 1));
		// 分页设置开始和结束页
		pagebean.setPageBeginAndPageEnd();
		// 设置内容
		List<Announcement> anns = annountcementDao.selectAnnouncementByCondition(pageSize * (pageIndex - 1), pageSize,
				an);
		pagebean.setBeanList(anns);
		return pagebean;
	}

	/*
	 * 
	 * 展示详细内容
	 */
	@Override
	public Announcement ShowContentById(Announcement an) {
		System.out.println(an.getAnId());
		// 默认第一条数据
		List<Announcement> announcements = annountcementDao.selectAnnouncementByCondition(0, 1, an);
		Announcement announcement = announcements.get(0);
		return announcement;
	}

	/*
	 * 添加数据
	 */
	@Override
	public Integer addAnnouncement(Announcement ann) {
		// 添加
		annountcementDao.insertAnnouncement(ann);
		Integer anId = ann.getAnId();
		return anId;
	}

	/*
	 * 软删除公告
	 */
	@Override
	public void delAn(Integer anId) {
		annountcementDao.deleteAn(anId);
	}

	/*
	 * 修改公告
	 */
	@Override
	public void updateAnnouncement(Announcement ann) {
		annountcementDao.updateAnnouncementById(ann);
	}

}
