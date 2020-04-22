package com.woniuxy.oasystem.service;

import java.util.List;

import com.woniuxy.oasystem.entity.Interview;

public interface InterviewService {
	/**
	 * 添加面试信息
	 * @param 
	 */
	void addInterview(Interview interview);
	
	/**
	 *  删除面试信息
	 */
	void deleteInterview(int interviewId);
	
	/**
	 *  显示全部面试信息
	 * @return
	 */
	List<Interview> displayInterview();
}
