/**
 * @author liuwenpeng
 * @createDate 2020年5月3日
 */
package com.woniuxy.oasystem.service;

import java.util.List;

import com.woniuxy.oasystem.entity.AnnouncementMessage;

/**
 * @Description  TODO
 * @author liuwenpeng
 * @changeLog 	1. 创建 (2020年5月3日 下午4:28:17 [liuwenpeng])
 * 				2.留言板相关service
 */
public interface AnnouncementMessageService {

	/**
	 * TODO
	 * @param am
	 * @changeLog 	1. 创建 (2020年5月3日 下午4:29:12 [liuwenpeng])
	 *              2.添加留言
	 */
	void addMessage(AnnouncementMessage am);

	/**
	 * TODO
	 * @param anId
	 * @changeLog 	1. 创建 (2020年5月3日 下午4:48:25 [liuwenpeng])
	 *              2.通过公告Id查询留言
	 */
		List<AnnouncementMessage> ShowAnnouncementMessage(Integer anId);

	/**
	 * TODO
	 * @param amId
	 * @changeLog 	1. 创建 (2020年5月3日 下午8:28:32 [liuwenpeng])
	 *              2.软删除公告留言
	 */
	void deleteMessage(Integer amId);

}
