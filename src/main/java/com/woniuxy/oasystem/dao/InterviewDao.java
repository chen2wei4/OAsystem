package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sun.org.glassfish.gmbal.ParameterNames;
import com.woniuxy.oasystem.entity.Interview;
import com.woniuxy.oasystem.entity.IntervieweeInfo;
import com.woniuxy.oasystem.entity.Leaving;

public interface InterviewDao {
	/**
	 * 添加面试信息
	 * @param interview
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:35:42 [王培霖])  </br>
	 *                      	2.
	 */
	void addInterview(Interview interview);
	
	/**
	 * 删除面试信息
	 * @param interviewId
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:35:55 [王培霖])  </br>
	 *                      	2.
	 */
	void deleteInterview(int interviewId);
	
	/**
	 * 显示全部面试信息
	 * @return java.util.List<Interview>对象
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:36:09 [王培霖])  </br>
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
	List<Interview> searchInterview(String parameter,
			@Param("interview")Interview interview,
			@Param("pageIndex")int pageIndex,
			@Param("pageSize")int pageSize);
	
	/**
	 *  变更面试信息
	 * @param interview
	 * @changeLog 	1. 创建 (2020年4月28日 下午8:57:58 [王培霖])  </br>
	 *                      	2.
	 */
	void modifyInterview(Interview interview);
	
	/**
	 *  查询满足条件的数据条数
	 * @param interview
	 * @return
	 * @changeLog 	1. 创建 (2020年4月28日 上午11:49:49 [王培霖])  </br>
	 *                      	2.
	 */
	int countByPage(@Param("interview")Interview interview, @Param("parameter")String parameter);
	
	/**
	 *  分页查询面试记录
	 * @param interview
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @changeLog 	1. 创建 (2020年4月28日 上午11:50:51 [王培霖])  </br>
	 *                      	2.
	 */
	List<Interview> selectInterviewByPage(
			@Param("interview")Interview interview,
			@Param("pageIndex")int pageIndex,
			@Param("pageSize")int pageSize);
}
