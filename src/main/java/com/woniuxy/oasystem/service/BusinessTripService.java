package com.woniuxy.oasystem.service;

import java.util.List;

import com.woniuxy.oasystem.entity.BusinessTrip;
import com.woniuxy.oasystem.entity.EmptyPosition;
import com.woniuxy.oasystem.entity.PageBean;

public interface BusinessTripService {
	/**
	 * 添加出差记录
	 * @param businessTrip
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:46:08 [王培霖])  </br>
	 *                      	2.
	 */
	void addBusinessTrip(BusinessTrip businessTrip);
	
	/**
	 * 删除出差记录
	 * @param tripId
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:46:18 [王培霖])  </br>
	 *                      	2.
	 */
	void deleteBusinessTrip(Integer tripId);
	
	/**
	 * 展示出差记录
	 * @return java.util.List<BusinessTrip>对象
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:46:33 [王培霖])  </br>
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
	PageBean<BusinessTrip> searchBusinessTrip(String parameter, BusinessTrip businessTrip, int pageIndex, int pageSize);
	
	/**
	 *  修改差旅记录
	 * @param businessTrip
	 * @changeLog 	1. 创建 (2020年4月27日 下午9:14:11 [王培霖])  </br>
	 *                      	2.
	 */
	void modifyBusinessTrip(BusinessTrip businessTrip);
	
	/**
	 *  分页查询差旅记录
	 * @param businessTrip
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @changeLog 	1. 创建 (2020年4月28日 下午2:55:41 [王培霖])  </br>
	 *                      	2.
	 */
	PageBean<BusinessTrip> selectBusinessTripByPage(BusinessTrip businessTrip, int pageIndex, int pageSize);
}
