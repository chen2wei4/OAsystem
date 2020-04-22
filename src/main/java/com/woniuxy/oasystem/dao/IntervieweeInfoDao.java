package com.woniuxy.oasystem.dao;

import java.util.List;

import com.woniuxy.oasystem.entity.IntervieweeInfo;

public interface IntervieweeInfoDao {
	/**
	 * 添加求职人员信息
	 * @param 
	 */
	void addIntervieweeInfo(IntervieweeInfo intervieweeInfo);
	
	/**
	 *  删除求职人员信息
	 */
	void deleteIntervieweeInfo(int interviewee_id);
	
	/**
	 *  展示求职人员信息
	 * @return
	 */
	List<IntervieweeInfo> displayIntervieweeInfo();
}
