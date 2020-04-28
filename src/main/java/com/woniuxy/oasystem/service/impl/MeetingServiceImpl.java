package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.CarApplyDao;
import com.woniuxy.oasystem.dao.CarDao;
import com.woniuxy.oasystem.dao.MeetingDao;
import com.woniuxy.oasystem.dao.OfficeSuppliesDao;
import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.CarApply;
import com.woniuxy.oasystem.entity.Meeting;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.CarApplyService;
import com.woniuxy.oasystem.service.CarService;
import com.woniuxy.oasystem.service.MeetingService;
import com.woniuxy.oasystem.service.OfficeSuppliesService;
@Service
public class MeetingServiceImpl implements MeetingService{
	@Autowired
	MeetingDao meetingDao;
	

	@Override
	public PageBean<Meeting> findAllByPage(Meeting meeting,int pageIndex, int pageSize) {
		
		PageBean<Meeting> pb = new PageBean<Meeting>();
		List<Meeting> beanList = meetingDao.findAllByPage(meeting, (pageIndex-1)*pageSize, pageSize);
		pb.setBeanList(beanList);	
		pb.setPageIndex(pageIndex);
		pb.setPageSize(pageSize);
		int totalRecord = meetingDao.findAllByPageCount(meeting);
		pb.setTotalRecord(totalRecord);
		pb.setTotalPage((totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1);
		pb.setPageBeginAndPageEnd();
		return pb;
	}

	@Override
	public void deleteByMid(int meetingId) {
		meetingDao.deleteByMid(meetingId);
	}

	@Override
	public void updateByMid(Meeting meeting) {
		meetingDao.updateByMid(meeting);
	}

	@Override
	public void insert(Meeting meeting) {
		meetingDao.insert(meeting);
	}

	
}
