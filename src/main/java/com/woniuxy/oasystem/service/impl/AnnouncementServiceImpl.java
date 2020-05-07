package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.woniuxy.oasystem.dao.AnnouncementDao;
import com.woniuxy.oasystem.dao.AnnouncementWatchedDao;
import com.woniuxy.oasystem.entity.Announcement;
import com.woniuxy.oasystem.entity.AnnouncementWatched;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.AnnouncementService;

@Service
@EnableTransactionManagement
public class AnnouncementServiceImpl implements AnnouncementService {
	@Autowired
	AnnouncementDao annountcementDao;
	@Autowired
	PageBean<Announcement> pagebean;
	@Autowired
	AnnouncementWatchedDao annountcementwatchedDao;

	/*
	 * 
	 * 条件查询公告
	 */
	@Override
	public PageBean<Announcement> ShowAnnouncementsByCondition(Integer pageIndex, Integer pageSize, Announcement an,
			Integer empId) {
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
		// 传过来的查询条件中具有empId的属性时（管理人员查询），查询观看的人数和每个观看人员信息
		if(an.getAnEmpId()!= null) {
			for (Announcement ann : anns) {
				// 遍历查询每一个个anId观看人员的的详细信息
				Integer countwatch = annountcementwatchedDao.selectWatchedCountByCondition(ann.getAnId(), null);
				ann.setCountwatch(countwatch);
				// 查询详细信息记录在里面
				List<AnnouncementWatched> anwatch = annountcementwatchedDao.selectWatchedByCondition(ann.getAnId(),
						null);
				ann.setWatchedlist(anwatch);
				// 当传过来了empId时 遍历查询当前用户是否阅读过每一个公告
			}
		}

		if (empId != null) {
			for (Announcement ann : anns) {
				Integer anId = ann.getAnId();
				// 通过条件查询观看的数量（当前用户是否阅读）
				Integer countwatch = annountcementwatchedDao.selectWatchedCountByCondition(anId, empId);
				// 当数量为0则为还未观看
				if (countwatch == 0) {
					// 设置在实体类中还没观看
					ann.setIswatched(false);
				} else {
					ann.setIswatched(true);
				}
			}
		}

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
