package com.woniuxy.oasystem.service;

import java.util.List;

import com.woniuxy.oasystem.entity.Interview;
import com.woniuxy.oasystem.entity.Leaving;
import com.woniuxy.oasystem.entity.PageBean;

public interface InterviewService {
	/**
	 * 添加面试信息
	 * @param interview
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:51:25 [王培霖])  </br>
	 *                      	2.
	 */
	void addInterview(Interview interview);
	
	/**
	 * 删除面试信息
	 * @param interviewId
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:51:39 [王培霖])  </br>
	 *                      	2.
	 */
	void deleteInterview(Integer interviewId);
	
	/**
	 * 显示全部面试信息
	 * @return
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:51:50 [王培霖])  </br>
	 *                      	2.
	 */
	List<Interview> displayInterview();
	
	/**
	 * 模糊查询全部面试信息
	 * @param parameter
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 下午7:21:54 [王培霖])  </br>
	 *                      	2.
	 */
	PageBean<Interview> searchInterview(String parameter, Interview interview, int pageIndex, int pageSize);
	
	/**
	 *  变更面试信息
	 * @param interview
	 * @changeLog 	1. 创建 (2020年4月28日 下午8:57:58 [王培霖])  </br>
	 *                      	2.
	 */
	void modifyInterview(Interview interview);
	
	/**
	 * 分页查询面试信息
	 * @param interview
	 * @param pageINdex
	 * @param pageSize
	 * @return
	 * @changeLog 	1. 创建 (2020年4月28日 下午12:12:40 [王培霖])  </br>
	 *                      	2.
	 */
	PageBean<Interview> selectInterviewByPage(Interview interview, int pageIndex, int pageSize);
}
