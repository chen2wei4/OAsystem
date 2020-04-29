package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Announcement;

public interface AnnouncementDao {
	/**
	 * TODO
	 * 
	 * @changeLog 1. 创建 (2020年4月24日 下午3:13:11 [liuwenpeng]) 2.条件查询所有公告
	 */
	public List<Announcement> selectAnnouncementByCondition(@Param(value = "pagelimit") Integer pagelimit,
			@Param(value = "pageSize") Integer pageSize, @Param(value = "an") Announcement an);

	

	/**
	 * TODO
	 * 
	 * @param ann
	 * @return 
	 * @changeLog 1. 创建 (2020年4月24日 下午6:24:10 [liuwenpeng]) 2.插入公告3.查询自增列
	 */
	public void insertAnnouncement(Announcement ann);

	

	/**
	 * TODO
	 * 
	 * @param anId
	 * @changeLog 1. 创建 (2020年4月24日 下午9:20:49 [liuwenpeng]) 2.软删除公告
	 */
	public void deleteAn(Integer anId);

	/**
	 * TODO
	 * 
	 * @param ann
	 * @changeLog 1. 创建 (2020年4月25日 下午4:39:06 [liuwenpeng]) 2.通过Id修改公告
	 */
	public void updateAnnouncementById(Announcement ann);



	/**
	 * TODO
	 * 
	 * @param an
	 * @return
	 * @changeLog 1. 创建 (2020年4月28日 下午3:07:46 [liuwenpeng]) 2.条件查询数量
	 */
	public Integer selectAnnouncementCountByCondition(@Param(value = "an") Announcement an);
}
