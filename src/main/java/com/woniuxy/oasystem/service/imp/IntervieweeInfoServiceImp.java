package com.woniuxy.oasystem.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.IntervieweeInfoDao;
import com.woniuxy.oasystem.entity.EmptyPosition;
import com.woniuxy.oasystem.entity.IntervieweeInfo;
import com.woniuxy.oasystem.service.IntervieweeInfoService;

@Service
public class IntervieweeInfoServiceImp implements IntervieweeInfoService {
	
	@Autowired
	IntervieweeInfoDao intervieweeInfoDao;

	@Override
	public void addIntervieweeInfo(IntervieweeInfo intervieweeInfo) {
		intervieweeInfoDao.addIntervieweeInfo(intervieweeInfo);
		
	}

	@Override
	public void deleteIntervieweeInfo(int position_id) {
		intervieweeInfoDao.deleteIntervieweeInfo(position_id);
		
	}

	@Override
	public List<IntervieweeInfo> displayIntervieweeInfo() {
		List<IntervieweeInfo> intervieweeInfos = intervieweeInfoDao.displayIntervieweeInfo();
		return intervieweeInfos;
	}

}
