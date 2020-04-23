package com.woniuxy.oasystem.service;

import java.util.List;

import com.woniuxy.oasystem.entity.Interview;

public interface InterviewService {
	/**
	 * 添加面试信息
	 * TODO
	 * @param interview
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:51:25 [王培霖])  </br>
	 *                      	2.
	 */
	void addInterview(Interview interview);
	
	/**
	 * 删除面试信息
	 * TODO
	 * @param interviewId
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:51:39 [王培霖])  </br>
	 *                      	2.
	 */
	void deleteInterview(int interviewId);
	
	/**
	 * 显示全部面试信息
	 * TODO
	 * @return
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:51:50 [王培霖])  </br>
	 *                      	2.
	 */
	List<Interview> displayInterview();
}
