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
	public PageBean<AnnouncementType> ShowAllAnnountcementType(AnnouncementType antype, Integer pageIndex, Integer pageSize) {
		// 分页类设置页码
				pagebean.setPageIndex(pageIndex);
				// 分页类设置每页展示数
				pagebean.setPageSize(pageSize);
				// 分页类设置总条数
				Integer count = announcementTypeDao.selectAnnouncementCountByCondition(antype);
				pagebean.setTotalRecord(count);
				// 设置总页数
				Integer totalrecord = pagebean.getTotalRecord();
				pagebean.setTotalPage((totalrecord % 10 == 0) ? (totalrecord / 10) : (totalrecord / 10 + 1));
				// 分页设置开始和结束页
				pagebean.setPageBeginAndPageEnd();
				// 设置内容
				List<AnnouncementType> alltype = announcementTypeDao.selectAnnouncementTypeByType(pageSize*(pageIndex-1),pageSize,antype);
				pagebean.setBeanList(alltype);
				System.out.println(pagebean);
		return pagebean;
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

	// 插入新的公告类别
	@Override
	public void addAnType(AnnouncementType anType) {
		announcementTypeDao.insertAnnouncementType(anType);
	}

	/* 
	 * 查询所有启用的类别
	 */
	@Override
	public List<AnnouncementType> ShowAllAnnountcementTypes() {
		List<AnnouncementType> alltype = announcementTypeDao.selectAnnouncementType();
		return alltype;
	}

	/* 
	 * 修改类别前的查询
	 */
	@Override
	public AnnouncementType showantype(Integer atId) {
		AnnouncementType antype=new AnnouncementType();
		antype.setAtId(atId);
		List<AnnouncementType> types = announcementTypeDao.selectAnnouncementTypeByType(0, 1, antype);
		AnnouncementType type = types.get(0);
		return type;
	}

	/* 
	 * 启用公告类别
	 */
	@Override
	public void StartAntypeById(Integer atId) {
		announcementTypeDao.StartAnnouncementType(atId);
	}

}
