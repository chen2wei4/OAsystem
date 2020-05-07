package com.woniuxy.oasystem.service;

import java.util.List;

import com.woniuxy.oasystem.entity.EmptyPosition;
import com.woniuxy.oasystem.entity.IntervieweeInfo;
import com.woniuxy.oasystem.entity.PageBean;

public interface EmptyPositionService {
	
	/**
	 * 添加空缺职位
	 * @param emptyPosition
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:47:31 [王培霖])  </br>
	 *                      	2.
	 */
	void addEmptyPosition(EmptyPosition emptyPosition);
	
	
	/**
	 * 删除空缺职位
	 * @param positionId
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:47:43 [王培霖])  </br>
	 *                      	2.
	 */
	void deleteEmptyPosition(Integer positionId);
	
	/**
	 * 展示空缺职位
	 * @return java.util.List<EmptyPosition>
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:47:53 [王培霖])  </br>
	 *                      	2.
	 */
	List<EmptyPosition> displayEmptyPosition();
	
	/**
	 *  模糊查询空缺职位
	 * @param parameter
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 下午5:46:49 [王培霖])  </br>
	 *                      	2.
	 */
	PageBean<EmptyPosition> searchEmptyPosition(String parameter, EmptyPosition emptyPosition,
									Integer departmentId, String educationBackground,
									int pageIndex, int pageSize);
	
	/**
	 * 变更空缺职位
	 * @param emptyPosition
	 * @changeLog 	1. 创建 (2020年4月27日 下午6:48:28 [王培霖])  </br>
	 *                      	2.
	 */
	void modifyEmptyPosition(EmptyPosition emptyPosition);
	
	/**
	 *  分页查询空缺职位
	 * @param emptyPosition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @changeLog 	1. 创建 (2020年4月28日 下午2:37:46 [王培霖])  </br>
	 *                      	2.
	 */
	PageBean<EmptyPosition> selectEmptyPositionByPage(EmptyPosition emptyPosition, int pageIndex, int pageSize);
}
