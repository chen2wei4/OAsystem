package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sun.org.glassfish.gmbal.ParameterNames;
import com.woniuxy.oasystem.entity.EmptyPosition;
import com.woniuxy.oasystem.entity.IntervieweeInfo;

public interface EmptyPositionDao {
	/**
	 * 添加空缺职位
	 * @param emptyPosition
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:32:19 [王培霖])  </br>
	 *                      	2.
	 */
	void addEmptyPosition(EmptyPosition emptyPosition);
	
	
	/**
	 * 删除空缺职位
	 * @param position_id
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:32:28 [王培霖])  </br>
	 *                      	2.
	 */
	void deleteEmptyPosition(int position_id);
	
	/**
	 * 展示空缺职位
	 * @return java.util.List<EmptyPosition>对象
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:32:47 [王培霖])  </br>
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
	List<EmptyPosition> searchEmptyPosition(String parameter,
			@Param("departmentId")Integer departmentId, 
			@Param("educationBackground")String educationBackground,
			@Param("emptyPosition")EmptyPosition emptyPosition,
			@Param("pageIndex")int pageIndex,
			@Param("pageSize")int pageSize);
	
	/**
	 * 变更空缺职位
	 * @param emptyPosition
	 * @changeLog 	1. 创建 (2020年4月27日 下午6:48:28 [王培霖])  </br>
	 *                      	2.
	 */
	void modifyEmptyPosition(EmptyPosition emptyPosition);
	
	/**
	 *  查询满足条件的数据条数
	 * @param emptyPosition
	 * @return
	 * @changeLog 	1. 创建 (2020年4月28日 下午2:21:39 [王培霖])  </br>
	 *                      	2.
	 */
	int countByPage(@Param("emptyPosition")EmptyPosition emptyPosition,
				@Param("parameter")String parameter,
				@Param("departmentId")Integer departmentId, 
				@Param("educationBackground")String educationBackground);
	
	/**
	 * 分页查询空缺职位信息
	 * @param emptyPosition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @changeLog 	1. 创建 (2020年4月28日 下午2:24:02 [王培霖])  </br>
	 *                      	2.
	 */
	List<EmptyPosition> selectEmptyPositionByPage(String parameter,
			@Param("intervieweeInfo")EmptyPosition emptyPosition,
			@Param("pageIndex")int pageIndex,
			@Param("pageSize")int pageSize);
}
