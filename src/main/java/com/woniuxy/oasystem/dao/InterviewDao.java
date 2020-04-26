package com.woniuxy.oasystem.dao;

import java.util.List;

import com.woniuxy.oasystem.entity.Interview;

public interface InterviewDao {
	/**
	 * 添加面试信息
	 * TODO
	 * @param interview
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:35:42 [王培霖])  </br>
	 *                      	2.
	 */
	void addInterview(Interview interview);
	
	/**
	 * 删除面试信息
	 * TODO
	 * @param interviewId
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:35:55 [王培霖])  </br>
	 *                      	2.
	 */
	void deleteInterview(int interviewId);
	
	/**
	 * 显示全部面试信息
	 * TODO
	 * @return java.util.List<Interview>对象
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:36:09 [王培霖])  </br>
	 *                      	2.
	 */
	List<Interview> displayInterview();
}
