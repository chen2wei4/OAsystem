package com.woniuxy.oasystem.dao;

import java.util.List;

import com.woniuxy.oasystem.entity.EmptyPosition;

public interface EmptyPositionDao {
	/**
	 * 添加空缺职位
	 * TODO
	 * @param emptyPosition
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:32:19 [王培霖])  </br>
	 *                      	2.
	 */
	void addEmptyPosition(EmptyPosition emptyPosition);
	
	
	/**
	 * 删除空缺职位
	 * TODO
	 * @param position_id
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:32:28 [王培霖])  </br>
	 *                      	2.
	 */
	void deleteEmptyPosition(int position_id);
	
	/**
	 * 展示空缺职位
	 * TODO
	 * @return java.util.List<EmptyPosition>对象
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:32:47 [王培霖])  </br>
	 *                      	2.
	 */
	List<EmptyPosition> displayEmptyPosition();
}
