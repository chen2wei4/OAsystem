package com.woniuxy.oasystem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Leaving;
import com.woniuxy.oasystem.entity.PageBean;

public interface LeavingService {
	/**
	 * 添加请假记录
	 * @param leaving
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:55:03 [王培霖])  </br>
	 *                      	2.
	 */
	void addLeaving(Leaving leaving);
	
	/**
	 * 删除请假记录
	 * @param leavingId
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:55:44 [王培霖])  </br>
	 *                      	2.
	 */
	void deleteLeaving(Integer leavingId);
	
	/**
	 * 展示所有请假记录
	 * @return java.util.List<Leaving>对象
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:56:04 [王培霖])  </br>
	 *                      	2.
	 */
	List<Leaving> displayLeaving();
	
	/**
	 * 模糊查询
	 * @param parameter
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 下午2:56:00 [王培霖])  </br>
	 *                      	2.
	 */
	PageBean<Leaving> searchLeaving(String parameter, Leaving leaving, int pageIndex, int pageSize);
	
	/**
	 * 修改请假记录
	 * @param leaving
	 * @changeLog 	1. 创建 (2020年4月27日 下午2:42:40 [王培霖])  </br>
	 *                      	2.
	 */
	void modifyLeaving(Leaving leaving);
	
	/**
	 * 分页查询请假记录
	 * @param leaving
	 * @param pageINdex
	 * @param pageSize
	 * @return
	 * @changeLog 	1. 创建 (2020年4月28日 上午10:41:27 [王培霖])  </br>
	 *                      	2.
	 */
	PageBean<Leaving> selectLeavingByPage(Leaving leaving, int pageIndex, int pageSize);
}
