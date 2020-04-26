package com.woniuxy.oasystem.service;

import java.util.List;

import com.woniuxy.oasystem.entity.BusinessTrip;

public interface BusinessTripService {
	/**
	 * 添加出差记录
	 * TODO
	 * @param businessTrip
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:46:08 [王培霖])  </br>
	 *                      	2.
	 */
	void addBusinessTrip(BusinessTrip businessTrip);
	
	/**
	 * 删除出差记录
	 * TODO
	 * @param tripId
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:46:18 [王培霖])  </br>
	 *                      	2.
	 */
	void deleteBusinessTrip(int tripId);
	
	/**
	 * 展示出差记录
	 * TODO
	 * @return java.util.List<BusinessTrip>对象
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:46:33 [王培霖])  </br>
	 *                      	2.
	 */
	List<BusinessTrip> displayBusinessTrip();
}
