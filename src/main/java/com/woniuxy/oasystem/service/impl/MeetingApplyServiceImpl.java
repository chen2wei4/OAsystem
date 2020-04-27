package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.CarApplyDao;
import com.woniuxy.oasystem.dao.CarDao;
import com.woniuxy.oasystem.dao.MeetingApplyDao;
import com.woniuxy.oasystem.dao.MeetingDao;
import com.woniuxy.oasystem.dao.OfficeSuppliesDao;
import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.CarApply;
import com.woniuxy.oasystem.entity.Meeting;
import com.woniuxy.oasystem.entity.MeetingApply;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.CarApplyService;
import com.woniuxy.oasystem.service.CarService;
import com.woniuxy.oasystem.service.MeetingApplyService;
import com.woniuxy.oasystem.service.MeetingService;
import com.woniuxy.oasystem.service.OfficeSuppliesService;
@Service
public class MeetingApplyServiceImpl implements MeetingApplyService{
	@Autowired
	MeetingApplyDao meetingApplyDao;
	

	@Override
	public PageBean<MeetingApply> findAllByPage(MeetingApply meetingApply,int pageIndex, int pageSize) {
		
		PageBean<MeetingApply> pb = new PageBean<MeetingApply>();
		List<MeetingApply> beanList = meetingApplyDao.findAllByPage(meetingApply, (pageIndex-1)*pageSize, pageSize);
		pb.setBeanList(beanList);	
		pb.setPageIndex(pageIndex);
		pb.setPageSize(pageSize);
		int totalRecord = meetingApplyDao.findAllByPageCount(meetingApply);
		pb.setTotalRecord(totalRecord);
		pb.setTotalPage((totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1);
		pb.setPageBeginAndPageEnd();
		return pb;
	}

	@Override
	public void deleteByMaId(int maId) {
		meetingApplyDao.deleteByMaId(maId);
	}

	@Override
	public void updateByMaId(MeetingApply meetingApply) {
		meetingApplyDao.updateByMaId(meetingApply);
	}

	@Override
	public void insert(MeetingApply meetingApply) {
		meetingApplyDao.insert(meetingApply);
	}

	
}
