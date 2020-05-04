/**
 * @author liuwenpeng
 * @createDate 2020年4月29日
 */
package com.woniuxy.oasystem.service;

import java.util.Date;
import java.util.List;

import com.woniuxy.oasystem.entity.AnnouncementWatched;

/**
 * @Description  TODO
 * @author liuwenpeng
 * @changeLog 	1. 创建 (2020年4月29日 下午12:01:09 [liuwenpeng])
 * 				2.
 */
public interface AnnouncementWatchedService {

	/**
	 * TODO
	 * @param anId
	 * @param empId
	 * @param date
	 * @changeLog 	1. 创建 (2020年4月29日 下午12:02:11 [liuwenpeng])
	 *              2.添加用户阅读信息
	 */
	void addWatchedMessage(Integer anId, Integer empId, Date date);

	/**
	 * TODO
	 * @param anId
	 * @return 
	 * @changeLog 	1. 创建 (2020年5月3日 下午9:35:56 [liuwenpeng])
	 *              2.通过Id查询名单
	 */
	List<AnnouncementWatched> ShowWatchedMessage(Integer anId);

	/**
	 * TODO
	 * @param anId
	 * @return
	 * @changeLog 	1. 创建 (2020年5月3日 下午10:07:35 [liuwenpeng])
	 *              2.Id查询一共有多少人观看
	 */
	Integer ShowCountById(Integer anId);

}
