package com.woniuxy.oasystem.service;

import java.util.List;

import com.woniuxy.oasystem.entity.Leaving;

public interface LeavingService {
	/**
	 *  添加请假记录
	 * @param leaving
	 */
	void addLeaving(Leaving leaving);
	
	/**
	 *  删除请假记录
	 * @param leavingId
	 */
	void deleteLeaving(int leavingId);
	
	/**
	 *  展示所有请假记录
	 * @return
	 */
	List<Leaving> displayLeaving();
}
