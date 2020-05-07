package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Leaving;

public interface LeavingDao {
	/**
	 * 添加请假记录
	 * @param leaving
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:39:31 [王培霖])  </br>
	 *                      	2.
	 */
	void addLeaving(Leaving leaving);
	
	/**
	 * 删除请假记录
	 * @param leavingId
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:39:44 [王培霖])  </br>
	 *                      	2.
	 */
	void deleteLeaving(Integer leavingId);
	
	/**
	 * 展示所有请假记录
	 * @return java.util.List<Leaving>对象
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:40:03 [王培霖])  </br>
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
	List<Leaving> searchLeaving(String parameter,
			@Param("leaving")Leaving leaving,
			@Param("pageIndex")int pageIndex,
			@Param("pageSize")int pageSize);
	
	/**
	 * 修改请假记录
	 * @param leaving
	 * @changeLog 	1. 创建 (2020年4月27日 下午2:42:40 [王培霖])  </br>
	 *                      	2.
	 */
	void modifyLeaving(Leaving leaving);
	
	/**
	 *  查询满足条件的数据条数
	 * @param leaving
	 * @return
	 * @changeLog 	1. 创建 (2020年4月28日 上午10:04:26 [王培霖])  </br>
	 *                      	2.
	 */
	int countByPage(@Param("leaving")Leaving leaving, @Param("parameter")String parameter);
	
	/**
	 *  分页查询请假记录
	 * @param leaving
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @changeLog 	1. 创建 (2020年4月28日 上午10:26:08 [王培霖])  </br>
	 *                      	2.
	 */
	List<Leaving> selectLeavingByPage(
			@Param("leaving")Leaving leaving,
			@Param("pageIndex")int pageIndex,
			@Param("pageSize")int pageSize);
}
