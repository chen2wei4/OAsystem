package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.BusinessTrip;

public interface BusinessTripDao {
	/**
	 * 添加出差记录
	 * @param businessTrip
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:25:56 [王培霖])  </br>
	 *                      	2.
	 */
	void addBusinessTrip(BusinessTrip businessTrip);
	
	/**
	 * 删除出差记录
	 * @param tripId
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:26:16 [王培霖])  </br>
	 *                      	2.
	 */
	void deleteBusinessTrip(Integer tripId);
	
	/**
	 * 展示出差记录
	 * @return java.util.List<BusinessTrip>对象
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:26:34 [王培霖])  </br>
	 *                      	2.
	 */
	List<BusinessTrip> displayBusinessTrip();
	
	/**
	 *  模糊查询差旅记录
	 * @param parameter
	 * @return
	 * @changeLog 	1. 创建 (2020年4月26日 下午6:39:16 [王培霖])  </br>
	 *                      	2.
	 */
	List<BusinessTrip> searchBusinessTrip(@Param("parameter")String parameter,
						@Param("businessTrip")BusinessTrip businessTrip,
						@Param("pageIndex")int pageIndex,
						@Param("pageSize")int pageSize);
	
	/**
	 * 修改差旅记录
	 * @param businessTrip
	 * @changeLog 	1. 创建 (2020年4月27日 下午9:14:11 [王培霖])  </br>
	 *                      	2.
	 */
	void modifyBusinessTrip(BusinessTrip businessTrip);
	
	/**
	 *  查询满足条件的数据条数
	 * @param interview
	 * @return
	 * @changeLog 	1. 创建 (2020年4月28日 下午2:48:14 [王培霖])  </br>
	 *                      	2.
	 */
	int countByPage(@Param("businessTrip")BusinessTrip businessTrip, @Param("parameter")String parameter);
	
	/**
	 * 分页查询差旅记录
	 * @param businessTrip
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @changeLog 	1. 创建 (2020年4月28日 下午2:49:26 [王培霖])  </br>
	 *                      	2.
	 */
	List<BusinessTrip> selectBusinessTripByPage(
			@Param("businessTrip")BusinessTrip businessTrip,
			@Param("pageIndex")int pageIndex,
			@Param("pageSize")int pageSize);
}
