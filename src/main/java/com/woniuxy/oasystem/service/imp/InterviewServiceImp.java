package com.woniuxy.oasystem.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.InterviewDao;
import com.woniuxy.oasystem.entity.Interview;
import com.woniuxy.oasystem.service.InterviewService;

@Service
public class InterviewServiceImp implements InterviewService {
	@Autowired
	InterviewDao interviewDao;

	@Override
	public void addInterview(Interview interview) {
		interviewDao.addInterview(interview);
		
	}

	@Override
	public void deleteInterview(int interviewId) {
		interviewDao.deleteInterview(interviewId);
		
	}

	@Override
	public List<Interview> displayInterview() {
		List<Interview> interviews = interviewDao.displayInterview();
		return interviews;
	}
	
	
}
