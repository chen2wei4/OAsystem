package com.woniuxy.oasystem.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.AnnouncementType;

/**
 * 公告类别Dao
 * @author Lwp
 *
 */
public interface AnnouncementTypeDao {
	//添加新的类别
	public void insertAnnouncementType(AnnouncementType antype);
	//软删除公告类别
	public void deleteAnnouncementType(Integer id);
	//条件查询公告类别
	public List<AnnouncementType> selectAnnouncementTypeByType(@Param(value="pagelimit")Integer pagelimit, @Param(value="pageSize")Integer pageSize, @Param(value="antype")AnnouncementType antype);
	//修改公告类别名称
	public void updateAnnouncementTypeById(AnnouncementType antype);
	/**
	 * TODO
	 * @param antype
	 * @return
	 * @changeLog 	1. 创建 (2020年4月29日 下午7:38:57 [liuwenpeng])
	 *              2.通过条件查询公告数量
	 */
	public Integer selectAnnouncementCountByCondition(@Param(value="antype")AnnouncementType antype);
	/**
	 * TODO
	 * @return
	 * @changeLog 	1. 创建 (2020年4月30日 上午9:02:05 [liuwenpeng])
	 *              2.查询所有启用的公告类别
	 */
	public List<AnnouncementType> selectAnnouncementType();
	/**
	 * TODO
	 * @param atId
	 * @changeLog 	1. 创建 (2020年5月4日 下午5:09:48 [liuwenpeng])
	 *              2.启用公告
	 */
	public void StartAnnouncementType(Integer atId);
	
}
