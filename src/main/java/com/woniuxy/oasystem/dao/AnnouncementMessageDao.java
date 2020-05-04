/**
 * @author liuwenpeng
 * @createDate 2020年5月3日
 */
package com.woniuxy.oasystem.dao;

import java.util.List;

import com.woniuxy.oasystem.entity.AnnouncementMessage;

/**
 * @Description  TODO
 * @author liuwenpeng
 * @changeLog 	1. 创建 (2020年5月3日 下午4:32:15 [liuwenpeng])
 * 				2.留言Dao
 */
public interface AnnouncementMessageDao {

	/**
	 * TODO
	 * @param am
	 * @changeLog 	1. 创建 (2020年5月3日 下午4:32:47 [liuwenpeng])
	 *              2.添加留言
	 */
	void insertMessage(AnnouncementMessage am);

	/**
	 * TODO
	 * @param anId
	 * @return
	 * @changeLog 	1. 创建 (2020年5月3日 下午4:53:34 [liuwenpeng])
	 *              2.通过Id查询所有留言
	 */
	List<AnnouncementMessage> selectMessageByAnId(Integer anId);

	/**
	 * TODO
	 * @param amId
	 * @changeLog 	1. 创建 (2020年5月3日 下午8:30:26 [liuwenpeng])
	 *              2.软删除公告留言
	 */
	void deleteMessage(Integer amId);

}
