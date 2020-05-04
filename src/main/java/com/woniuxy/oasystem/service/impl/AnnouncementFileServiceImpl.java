/**
 * @author liuwenpeng
 * @createDate 2020年4月28日
 */
package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.AnnouncementFileDao;
import com.woniuxy.oasystem.entity.AnnouncementFile;
import com.woniuxy.oasystem.service.AnnouncementFileService;

/**
 * @Description TODO
 * @author liuwenpeng
 * @changeLog 1. 创建 (2020年4月28日 下午9:08:42 [liuwenpeng]) 2.
 */
@Service
public class AnnouncementFileServiceImpl implements AnnouncementFileService {
	@Autowired
	AnnouncementFileDao announcementFileDao;

	/*
	 * 插入文件
	 */
	public void addAnnouncementFile(AnnouncementFile anf) {
		announcementFileDao.insertFile(anf);
	}

	/* 查询公告中的所有文件
	 */
	@Override
	public List<AnnouncementFile> ShowFiles(Integer anId) {
		List<AnnouncementFile> files=announcementFileDao.selectFileByAnId(anId);
		return files;
	}

	/* 
	 * 软删除文件
	 */
	@Override
	public void deleteFileById(Integer afId) {
		announcementFileDao.deleteFileById(afId);
	}

}
