package com.woniuxy.oasystem.dao;

import java.util.List;

import com.woniuxy.oasystem.entity.BusinessTrip;

public interface BusinessTripDao {
	/**
	 *  添加出差记录
	 * @param businessTrip
	 */
	void addBusinessTrip(BusinessTrip businessTrip);
	
	/**
	 * 删除出差记录
	 * @param tripId
	 */
	void deleteBusinessTrip(int tripId);
	
	/**
	 *  展示出差记录
	 * @return
	 */
	List<BusinessTrip> displayBusinessTrip();
}
