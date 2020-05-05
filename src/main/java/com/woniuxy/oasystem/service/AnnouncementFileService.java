/**
 * @author liuwenpeng
 * @createDate 2020年4月28日
 */
package com.woniuxy.oasystem.service;

import java.util.List;

import com.woniuxy.oasystem.entity.AnnouncementFile;

/**
 * @Description  TODO
 * @author liuwenpeng
 * @changeLog 	1. 创建 (2020年4月28日 下午9:08:42 [liuwenpeng])
 * 				2.
 */
public interface AnnouncementFileService {
	public void addAnnouncementFile(AnnouncementFile anf);

	/**
	 * TODO
	 * @param anId
	 * @return
	 * @changeLog 	1. 创建 (2020年4月28日 下午10:48:27 [liuwenpeng])
	 *              2.查询公告Id下的所有文件
	 */
	public List<AnnouncementFile> ShowFiles(Integer anId);

	/**
	 * TODO
	 * @param afanId
	 * @changeLog 	1. 创建 (2020年5月4日 下午2:55:29 [liuwenpeng])
	 *              2.软删除文件
	 */
	public void deleteFileById(Integer afanId);
}
