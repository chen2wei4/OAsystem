package com.woniuxy.oasystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.entity.EmptyPosition;
import com.woniuxy.oasystem.entity.IntervieweeInfo;
import com.woniuxy.oasystem.entity.Leaving;
import com.woniuxy.oasystem.entity.PageBean;

@Service
public interface IntervieweeInfoService {
	
	/**
	 * 添加求职人信息
	 * @param intervieweeInfo
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:49:09 [王培霖])  </br>
	 *                      	2.
	 */
	void addIntervieweeInfo(IntervieweeInfo intervieweeInfo);
	
	/**
	 * 删除求职人信息
	 * @param position_id
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:49:28 [王培霖])  </br>
	 *                      	2.
	 */
	void deleteIntervieweeInfo(Integer interviewee_id);
	
	/**
	 * 展示求职人员信息
	 * @return java.util.List<IntervieweeInfo>对象
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:49:40 [王培霖])  </br>
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
	PageBean<IntervieweeInfo> searchIntervieweeInfo(String parameter, String intervieweeGender, 
			String educationBackground, Integer positionId, 
			IntervieweeInfo intervieweeInfo, int pageIndex, int pageSize);
	
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
	 *  分页查询面试人信息
	 * @param intervieweeInfo
	 * @param pageINdex
	 * @param pageSize
	 * @return
	 * @changeLog 	1. 创建 (2020年4月28日 上午11:34:40 [王培霖])  </br>
	 *                      	2.
	 */
	PageBean<IntervieweeInfo> selectIntervieweeInfoByPage(IntervieweeInfo intervieweeInfo, int pageIndex, int pageSize);
}
