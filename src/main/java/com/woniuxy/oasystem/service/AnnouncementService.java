package com.woniuxy.oasystem.service;

import com.woniuxy.oasystem.entity.Announcement;
import com.woniuxy.oasystem.entity.PageBean;

public interface AnnouncementService {

	/**
	 * TODO
	 * 
	 * @param anId
	 * @return Announcement
	 * @changeLog 1. 创建 (2020年4月24日 下午3:09:18 [liuwenpeng]) 2.通过查询公告详细信息
	 */
	public Announcement ShowContentById(Announcement an);

	/**
	 * TODO
	 * 
	 * @param ann
	 * @changeLog 1. 创建 (2020年4月24日 下午6:22:09 [liuwenpeng]) 2.添加公告
	 */
	public Integer addAnnouncement(Announcement ann);

	/**
	 * TODO
	 * 
	 * @param annoucement
	 * @param pageIndex
	 * @param pAGESIZE
	 * @return
	 * @changeLog 1. 创建 (2020年4月24日 下午7:21:26 [liuwenpeng]) 2.通过条件查询所有公告
	 */
	public PageBean<Announcement> ShowAnnouncementsByCondition(Integer pageIndex, Integer pageSize, Announcement an);

	/**
	 * TODO
	 * 
	 * @param anId
	 * @changeLog 1. 创建 (2020年4月24日 下午9:19:31 [liuwenpeng]) 2.软删除公告
	 */
	public void delAn(Integer anId);

	/**
	 * TODO
	 * 
	 * @param ann
	 * @changeLog 1. 创建 (2020年4月25日 下午4:37:13 [liuwenpeng]) 2.修改公告
	 */
	public void updateAnnouncement(Announcement ann);

}
