/**
 * @author liuwenpeng
 * @createDate 2020年4月28日
 */
package com.woniuxy.oasystem.dao;

import java.util.List;

import com.woniuxy.oasystem.entity.AnnouncementFile;

/**
 * @Description TODO
 * @author liuwenpeng
 * @changeLog 1. 创建 (2020年4月28日 下午9:32:01 [liuwenpeng]) 2.
 */
public interface AnnouncementFileDao {

	/**
	 * TODO
	 * 
	 * @param anf
	 * @changeLog 1. 创建 (2020年4月28日 下午9:32:59 [liuwenpeng]) 2.插入文件信息
	 */
	public void insertFile(AnnouncementFile anf);

	/**
	 * TODO
	 * @param anId
	 * @return
	 * @changeLog 	1. 创建 (2020年4月28日 下午10:50:15 [liuwenpeng])
	 *              2.查询文件
	 */
	public List<AnnouncementFile> selectFileByAnId(Integer anId);

	/**
	 * TODO
	 * @param afanId
	 * @changeLog 	1. 创建 (2020年5月4日 下午2:56:44 [liuwenpeng])
	 *              2.软删除公告文件
	 */
	public void deleteFileById(Integer afId);

}
