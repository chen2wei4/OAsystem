/**
 * @author liuwenpeng
 * @createDate 2020年4月29日
 */
package com.woniuxy.oasystem.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.AnnouncementWatchedDao;
import com.woniuxy.oasystem.entity.AnnouncementWatched;
import com.woniuxy.oasystem.service.AnnouncementWatchedService;

/**
 * @Description  TODO
 * @author liuwenpeng
 * @changeLog 	1. 创建 (2020年4月29日 下午12:03:14 [liuwenpeng])
 * 				2.
 */
@Service
public class AnnouncementWatchedServiceImpl implements AnnouncementWatchedService {
	@Autowired
	AnnouncementWatchedDao announcementWatchedDao;
	/* 
	 * 添加用户阅读过的信息
	 */
	@Override
	public void addWatchedMessage(Integer anId, Integer empId, Date date) {
		//先查询是否已经有过观看记录，如果没有则添加进去
		Integer count = announcementWatchedDao.selectWatchedCountByCondition(anId, empId);
		if(count==0) {
		announcementWatchedDao.insertmessage(anId,empId,date);
		}
		}
	/* 
	 * 通过Id查询观看名单
	 */
	@Override
	public List<AnnouncementWatched> ShowWatchedMessage(Integer anId) {
		List<AnnouncementWatched> list = announcementWatchedDao.selectWatchedByCondition(anId, null);
		return list;
	}
	/*
	 * 查看观看人数 
	 */
	@Override
	public Integer ShowCountById(Integer anId) {
		Integer count = announcementWatchedDao.selectWatchedCountByCondition(anId, null);
		return count;
	}

}
