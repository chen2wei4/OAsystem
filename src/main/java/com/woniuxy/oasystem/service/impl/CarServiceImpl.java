package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.CarDao;
import com.woniuxy.oasystem.dao.OfficeSuppliesDao;
import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.CarService;
import com.woniuxy.oasystem.service.OfficeSuppliesService;
@Service
public class CarServiceImpl implements CarService{
	@Autowired
	CarDao carDao;
	

	@Override
	public PageBean<Car> findAllByPage(Car car,int pageIndex, int pageSize) {
		
		PageBean<Car> pb = new PageBean<Car>();
		List<Car> beanList = carDao.findAllByPage(car, (pageIndex-1)*pageSize, pageSize);
		pb.setBeanList(beanList);	
		pb.setPageIndex(pageIndex);
		pb.setPageSize(pageSize);
		int totalRecord = carDao.findAllByPageCount(car);
		pb.setTotalRecord(totalRecord);
		pb.setTotalPage((totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1);
		pb.setPageBeginAndPageEnd();
		return pb;
	}

	@Override
	public void deleteByCarId(int carId) {
		carDao.deleteByCarId(carId);
	}

	@Override
	public void updateByCarId(Car car) {
		carDao.updateByCarId(car);
	}

	@Override
	public void insert(Car car) {
		carDao.insert(car);
	}

	
}
