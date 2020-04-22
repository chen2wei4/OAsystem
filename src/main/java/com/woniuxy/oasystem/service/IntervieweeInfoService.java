package com.woniuxy.oasystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.entity.EmptyPosition;
import com.woniuxy.oasystem.entity.IntervieweeInfo;

@Service
public interface IntervieweeInfoService {
	
	/**
	 * 添加空缺职位信息
	 * @param 
	 */
	void addIntervieweeInfo(IntervieweeInfo intervieweeInfo);
	
	/**
	 *  删除空缺职位信息
	 */
	void deleteIntervieweeInfo(int position_id);
	
	/**
	 *  展示求职人员信息
	 * @return
	 */
	List<IntervieweeInfo> displayIntervieweeInfo();
}
