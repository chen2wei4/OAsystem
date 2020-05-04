/**
 * @author liuwenpeng
 * @createDate 2020年4月28日
 */
package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.AnnouncementFileDao;
import com.woniuxy.oasystem.dao.AnnouncementMessageDao;
import com.woniuxy.oasystem.entity.AnnouncementFile;
import com.woniuxy.oasystem.entity.AnnouncementMessage;
import com.woniuxy.oasystem.service.AnnouncementFileService;
import com.woniuxy.oasystem.service.AnnouncementMessageService;

/**
 * @Description TODO
 * @author liuwenpeng
 * @changeLog 1. 创建 (2020年5月3日 下午4:30:42 [liuwenpeng]) 2.留言实现类
 */
@Service
public class AnnouncementMessageServiceImpl implements AnnouncementMessageService {
	@Autowired
	AnnouncementMessageDao announcementMessageDao;



	/* 
	 *添加留言
	 */
	@Override
	public void addMessage(AnnouncementMessage am) {
		announcementMessageDao.insertMessage(am);
	}



	/* 
	 * 通过公告ID查询留言内容
	 */
	@Override
	public List<AnnouncementMessage> ShowAnnouncementMessage(Integer anId) {
		List<AnnouncementMessage> messages=announcementMessageDao.selectMessageByAnId(anId);
		return messages;
	}



	/* 
	 * 软删除公告留言
	 */
	@Override
	public void deleteMessage(Integer amId) {
		announcementMessageDao.deleteMessage(amId);
		
	}

}
