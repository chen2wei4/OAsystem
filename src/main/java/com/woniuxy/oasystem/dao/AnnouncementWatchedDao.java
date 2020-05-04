/**
 * @author liuwenpeng
 * @createDate 2020年4月29日
 */
package com.woniuxy.oasystem.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.AnnouncementWatched;

/**
 * @Description  TODO
 * @author liuwenpeng
 * @changeLog 	1. 创建 (2020年4月29日 下午1:41:17 [liuwenpeng])
 * 				2.
 */
public interface AnnouncementWatchedDao {

	/**
	 * TODO
	 * @param anId
	 * @param empId
	 * @param date
	 * @changeLog 	1. 创建 (2020年4月29日 下午1:42:16 [liuwenpeng])
	 *              2.插入相关观看的数据
	 */	
	void insertmessage(@Param(value="anId")Integer anId, @Param(value="empId")Integer empId,@Param(value="date") Date date);

	/**
	 * TODO
	 * @param anId
	 * @param empId
	 * @return
	 * @changeLog 	1. 创建 (2020年4月29日 下午2:09:33 [liuwenpeng])
	 *              2. 条件查询观看的数量
	 */
	Integer selectWatchedCountByCondition(@Param(value="anId")Integer anId,@Param(value="empId") Integer empId);

	/**
	 * TODO
	 * @param anId
	 * @param object
	 * @return
	 * @changeLog 	1. 创建 (2020年4月29日 下午3:26:12 [liuwenpeng])
	 *              2.查询详细观看信息
	 */
	List<AnnouncementWatched> selectWatchedByCondition(@Param(value="anId")Integer anId, @Param(value="empId")Integer empId);
	
}
