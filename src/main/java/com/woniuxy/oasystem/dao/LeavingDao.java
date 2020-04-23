package com.woniuxy.oasystem.dao;

import java.util.List;

import com.woniuxy.oasystem.entity.Leaving;

public interface LeavingDao {
	/**
	 * 添加请假记录
	 * TODO
	 * @param leaving
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:39:31 [王培霖])  </br>
	 *                      	2.
	 */
	void addLeaving(Leaving leaving);
	
	/**
	 * 删除请假记录
	 * TODO
	 * @param leavingId
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:39:44 [王培霖])  </br>
	 *                      	2.
	 */
	void deleteLeaving(int leavingId);
	
	/**
	 * 展示所有请假记录
	 * TODO
	 * @return java.util.List<Leaving>对象
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:40:03 [王培霖])  </br>
	 *                      	2.
	 */
	List<Leaving> displayLeaving();

}
