package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Announcement;

public interface AnnouncementDao {
	//查询当前公告类别下所有公告
		public List<Announcement> selectAnnouncementByType(@Param(value="pagelimit")Integer pagelimit,@Param(value="pageSize")Integer pageSize,@Param(value="antype") Integer antype);

		/**
		 * TODO
		 * @changeLog 	1. 创建 (2020年4月24日 下午3:13:11 [liuwenpeng])
		 *              2.ID查公告内容
		 */
		public Announcement selectAnnouncementById(Integer anId);

		/**
		 * TODO
		 * @param ann
		 * @changeLog 	1. 创建 (2020年4月24日 下午6:24:10 [liuwenpeng])
		 *              2.插入公告
		 */
		public void insertAnnouncement(Announcement ann);

		/**
		 * TODO
		 * @param anEmpId
		 * @return
		 * @changeLog 	1. 创建 (2020年4月24日 下午7:22:38 [liuwenpeng])
		 *              2.查询用户所有创建的公告
		 */
		public List<Announcement> selectAnnouncementByEmp(@Param(value="pagelimit")Integer pagelimit,@Param(value="pageSize")Integer pageSize,Integer anEmpId);

		/**
		 * TODO
		 * @param anId
		 * @changeLog 	1. 创建 (2020年4月24日 下午9:20:49 [liuwenpeng])
		 *              2.软删除公告
		 */
		public void deleteAn(Integer anId);

		/**
		 * TODO
		 * @param ann
		 * @changeLog 	1. 创建 (2020年4月25日 下午4:39:06 [liuwenpeng])
		 *              2.通过Id修改公告
		 */
		public void updateAnnouncementById(Announcement ann);
		
		//查询当前公告数量
		public Integer selectAnnouncementCount(Integer antype);

		/**
		 * TODO
		 * @return
		 * @changeLog 	1. 创建 (2020年4月27日 上午11:05:45 [liuwenpeng])
		 *              2.查询数量
		 */
		public int selectAnnouncementCountByEmp(Integer emp);
}
