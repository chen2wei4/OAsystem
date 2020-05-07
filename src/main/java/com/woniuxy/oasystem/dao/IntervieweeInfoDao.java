package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.IntervieweeInfo;
import com.woniuxy.oasystem.entity.Leaving;

public interface IntervieweeInfoDao {
	/**
	 * 添加求职人员信息
	 * @param intervieweeInfo
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:36:40 [王培霖])  </br>
	 *                      	2.
	 */
	void addIntervieweeInfo(IntervieweeInfo intervieweeInfo);
	
	/**
	 * 删除求职人员信息
	 * @param interviewee_id
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:37:00 [王培霖])  </br>
	 *                      	2.
	 */
	void deleteIntervieweeInfo(Integer interviewee_id);
	
	/**
	 * 展示求职人员信息
	 * @return java.util.List<IntervieweeInfo>对象
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:37:16 [王培霖])  </br>
	 *                      	2.
	 */
	List<IntervieweeInfo> displayIntervieweeInfo();
	
	/**
	 *  模糊查询求职人员信息
	 * @param parameter
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 下午4:49:28 [王培霖])  </br>
	 *                      	2.
	 */
	List<IntervieweeInfo> searchIntervieweeInfo(String parameter,
									@Param("intervieweeGender")String intervieweeGender,
									@Param("educationBackground")String educationBackground,
									@Param("positionId")Integer positionId,
									@Param("intervieweeInfo")IntervieweeInfo intervieweeInfo,
									@Param("pageIndex")int pageIndex,
									@Param("pageSize")int pageSize);
	
	/**
	 *  验证面试人员是否存在
	 * @param intervieweeName
	 * @param intervieweePhone
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 下午9:45:08 [王培霖])  </br>
	 *                      	2.
	 */
	IntervieweeInfo verityIntervieweeInfo(String intervieweeName, String intervieweePhone);
	
	/**
	 *  更新面试人信息
	 * @param intervieweeInfo
	 * @changeLog 	1. 创建 (2020年4月27日 下午4:53:06 [王培霖])  </br>
	 *                      	2.
	 */
	void modifyIntervieweeInfo(IntervieweeInfo intervieweeInfo);
	
	/**
	 *  查询满足条件的数据条数
	 * @param intervieweeInfo
	 * @return
	 * @changeLog 	1. 创建 (2020年4月28日 上午11:18:13 [王培霖])  </br>
	 *                      	2.
	 */
	int countByPage(@Param("intervieweeInfo")IntervieweeInfo intervieweeInfo,
			@Param("intervieweeGender")String intervieweeGender,
			@Param("educationBackground")String educationBackground,
			@Param("positionId")Integer positionId,
			@Param("parameter")String parameter);
	
	/**
	 *  分页查询面试人信息
	 * @param intervieweeInfo
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @changeLog 	1. 创建 (2020年4月28日 上午11:18:46 [王培霖])  </br>
	 *                      	2.
	 */
	List<IntervieweeInfo> selectIntervieweeInfoByPage(
			@Param("intervieweeInfo")IntervieweeInfo intervieweeInfo,
			@Param("pageIndex")int pageIndex,
			@Param("pageSize")int pageSize);
}
