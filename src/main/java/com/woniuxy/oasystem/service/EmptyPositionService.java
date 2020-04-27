
package com.woniuxy.oasystem.service;

import java.util.List;

import com.woniuxy.oasystem.entity.EmptyPosition;

public interface EmptyPositionService {
	
	/**
	 * 添加空缺职位
	 * TODO
	 * @param emptyPosition
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:47:31 [王培霖])  </br>
	 *                      	2.
	 */
	void addEmptyPosition(EmptyPosition emptyPosition);
	
	
	/**
	 * 删除空缺职位
	 * TODO
	 * @param positionId
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:47:43 [王培霖])  </br>
	 *                      	2.
	 */
	void deleteEmptyPosition(int positionId);
	
	/**
	 * 展示空缺职位
	 * TODO
	 * @return java.util.List<EmptyPosition>
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:47:53 [王培霖])  </br>
	 *                      	2.
	 */
	List<EmptyPosition> displayEmptyPosition();
}
