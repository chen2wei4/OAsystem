package com.woniuxy.oasystem.service;

import java.util.List;

import com.woniuxy.oasystem.entity.EmptyPosition;

public interface EmptyPositionService {
	
	/**
	 *  添加空缺职位
	 * @param intervieweeInfo
	 */
	void addEmptyPosition(EmptyPosition emptyPosition);
	
	
	/**
	 *  删除空缺职位
	 * @param position_id
	 */
	void deleteEmptyPosition(int positionId);
	
	/**
	 *  显示全部空缺职位
	 * @return
	 */
	List<EmptyPosition> displayEmptyPosition();
}
