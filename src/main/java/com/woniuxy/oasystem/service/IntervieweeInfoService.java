package com.woniuxy.oasystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.entity.EmptyPosition;
import com.woniuxy.oasystem.entity.IntervieweeInfo;

@Service
public interface IntervieweeInfoService {
	
	/**
	 * 添加求职人信息
	 * TODO
	 * @param intervieweeInfo
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:49:09 [王培霖])  </br>
	 *                      	2.
	 */
	void addIntervieweeInfo(IntervieweeInfo intervieweeInfo);
	
	/**
	 * 删除求职人信息
	 * TODO
	 * @param position_id
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:49:28 [王培霖])  </br>
	 *                      	2.
	 */
	void deleteIntervieweeInfo(int position_id);
	
	/**
	 * 展示求职人员信息
	 * TODO
	 * @return java.util.List<IntervieweeInfo>对象
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:49:40 [王培霖])  </br>
	 *                      	2.
	 */
	List<IntervieweeInfo> displayIntervieweeInfo();
}
