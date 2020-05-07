package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.CarApplyDao;
import com.woniuxy.oasystem.dao.CarDao;
import com.woniuxy.oasystem.dao.OfficeSuppliesDao;
import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.CarApply;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.CarApplyService;
import com.woniuxy.oasystem.service.CarService;
import com.woniuxy.oasystem.service.OfficeSuppliesService;
@Service
public class CarApplyServiceImpl implements CarApplyService{
	@Autowired
	CarApplyDao carApplyDao;
	

	@Override
	public PageBean<CarApply> findAllByPage(CarApply carApply,int pageIndex, int pageSize) {
		
		PageBean<CarApply> pb = new PageBean<CarApply>();
		List<CarApply> beanList = carApplyDao.findAllByPage(carApply, (pageIndex-1)*pageSize, pageSize);
		pb.setBeanList(beanList);	
		pb.setPageIndex(pageIndex);
		pb.setPageSize(pageSize);
		int totalRecord = carApplyDao.findAllByPageCount(carApply);
		pb.setTotalRecord(totalRecord);
		pb.setTotalPage((totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1);
		pb.setPageBeginAndPageEnd();
		return pb;
	}

	@Override
	public void deleteByCaId(int caId) {
		carApplyDao.deleteByCaId(caId);
	}

	@Override
	public void updateByCaId(CarApply carApply) {
		carApplyDao.updateByCaId(carApply);
	}

	@Override
	public void insert(CarApply carApply) {
		carApplyDao.insert(carApply);
	}

	
}
