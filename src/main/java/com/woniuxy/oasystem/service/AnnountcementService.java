package com.woniuxy.oasystem.service;

import java.util.List;

import com.woniuxy.oasystem.entity.Announcement;
import com.woniuxy.oasystem.entity.PageBean;

public interface AnnountcementService {
	/**
	 * TODO
	 * @param pageIndex,pageSize,antype
	 * @return PageInfo<Announcement>
	 * @changeLog 	1. 创建 (2020年4月24日 下午3:09:18 [liuwenpeng])
	 *              2.查询所有公告
	 */
	public PageBean<Announcement> ShowAnnouncementsByType(Integer pageIndex,Integer pageSize,Integer antype);

	/**
	 * TODO
	 * @param anId
	 * @return Announcement
	 * @changeLog 	1. 创建 (2020年4月24日 下午3:09:18 [liuwenpeng])
	 *              2.通过Id查询公告详情
	 */
	public Announcement ShowContentById(Integer anId);

	/**
	 * TODO
	 * @param ann
	 * @changeLog 	1. 创建 (2020年4月24日 下午6:22:09 [liuwenpeng])
	 *              2.添加公告
	 */
	public void addAnnouncement(Announcement ann);

	/**
	 * TODO
	 * @param anEmpId
	 * @param anEmpId2 
	 * @param pAGESIZE 
	 * @return
	 * @changeLog 	1. 创建 (2020年4月24日 下午7:21:26 [liuwenpeng])
	 *              2.通过用户ID查询所有公告
	 */
	public PageBean<Announcement> showannouncementByEmp(Integer pageIndex, Integer PAGESIZE, Integer anEmpId);

	/**
	 * TODO
	 * @param anId
	 * @changeLog 	1. 创建 (2020年4月24日 下午9:19:31 [liuwenpeng])
	 *              2.软删除公告
	 */
	public void delAn(Integer anId);

	/**
	 * TODO
	 * @param ann
	 * @changeLog 	1. 创建 (2020年4月25日 下午4:37:13 [liuwenpeng])
	 *              2.修改公告
	 */
	public void updateAnnouncement(Announcement ann);
	
}
