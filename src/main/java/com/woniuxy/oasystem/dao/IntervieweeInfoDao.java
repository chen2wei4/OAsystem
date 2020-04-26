package com.woniuxy.oasystem.dao;

import java.util.List;

import com.woniuxy.oasystem.entity.IntervieweeInfo;

public interface IntervieweeInfoDao {
	/**
	 * 添加求职人员信息
	 * TODO
	 * @param intervieweeInfo
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:36:40 [王培霖])  </br>
	 *                      	2.
	 */
	void addIntervieweeInfo(IntervieweeInfo intervieweeInfo);
	
	/**
	 * 删除求职人员信息
	 * TODO
	 * @param interviewee_id
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:37:00 [王培霖])  </br>
	 *                      	2.
	 */
	void deleteIntervieweeInfo(int interviewee_id);
	
	/**
	 * 展示求职人员信息
	 * TODO
	 * @return java.util.List<IntervieweeInfo>对象
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:37:16 [王培霖])  </br>
	 *                      	2.
	 */
	List<IntervieweeInfo> displayIntervieweeInfo();
}
