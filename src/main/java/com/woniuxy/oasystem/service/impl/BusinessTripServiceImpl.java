package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.BusinessTripDao;
import com.woniuxy.oasystem.entity.BusinessTrip;
import com.woniuxy.oasystem.entity.EmptyPosition;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.BusinessTripService;

@Service
public class BusinessTripServiceImpl implements BusinessTripService {
	@Autowired
	BusinessTripDao businessTripDao;

	@Override
	public void addBusinessTrip(BusinessTrip businessTrip) {
		businessTripDao.addBusinessTrip(businessTrip);
		
	}

	@Override
	public void deleteBusinessTrip(Integer tripId) {
		businessTripDao.deleteBusinessTrip(tripId);
		
	}

	@Override
	public List<BusinessTrip> displayBusinessTrip() {
		List<BusinessTrip> trips = businessTripDao.displayBusinessTrip();
		return trips;
	}

	/*
	 * @Override public List<BusinessTrip> searchBusinessTrip(String parameter) {
	 * List<BusinessTrip> trips = businessTripDao.searchBusinessTrip(parameter);
	 * return trips; }
	 */

	@Override
	public void modifyBusinessTrip(BusinessTrip businessTrip) {
		businessTripDao.modifyBusinessTrip(businessTrip);
		
	}

	@Override
	public PageBean<BusinessTrip> selectBusinessTripByPage(BusinessTrip businessTrip, int pageIndex, int pageSize) {
		PageBean<BusinessTrip> pageBean = new PageBean<BusinessTrip>();
		// 查询本页包含的数据
		List<BusinessTrip> businessTrips = businessTripDao.selectBusinessTripByPage(businessTrip, (pageIndex-1)*pageSize, pageSize);
		pageBean.setBeanList(businessTrips); // 将数据添加至本页
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalRecord = businessTripDao.countByPage(businessTrip, null);
		pageBean.setTotalRecord(totalRecord); // 设置数据总条数
		// 根据数据总条数计算总页数
		pageBean.setTotalPage((totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1);
		pageBean.setPageBeginAndPageEnd(); // 设置起始和末尾页码
		return pageBean;
	}

	/* (non-Javadoc)
	 * @see com.woniuxy.oasystem.service.BusinessTripService#searchBusinessTrip(java.lang.String, com.woniuxy.oasystem.entity.BusinessTrip, int, int)
	 */
	@Override
	public PageBean<BusinessTrip> searchBusinessTrip(String parameter, BusinessTrip businessTrip, int pageIndex,
			int pageSize) {
		PageBean<BusinessTrip> pageBean = new PageBean<BusinessTrip>();
		// 查询本页包含的数据
		List<BusinessTrip> businessTrips = businessTripDao.searchBusinessTrip(parameter, businessTrip, (pageIndex-1)*pageSize, pageSize);
		for (BusinessTrip trip : businessTrips) {
			System.out.println(trip.toString());
		}
		pageBean.setBeanList(businessTrips); // 将数据添加至本页
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalRecord = businessTripDao.countByPage(businessTrip, parameter);
		pageBean.setTotalRecord(totalRecord); // 设置数据总条数
		// 根据数据总条数计算总页数
		pageBean.setTotalPage((totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1);
		pageBean.setPageBeginAndPageEnd(); // 设置起始和末尾页码
		return pageBean;
	}

}
