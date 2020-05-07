package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.CarApplyDao;
import com.woniuxy.oasystem.dao.CarDao;
import com.woniuxy.oasystem.dao.OfficeSuppliesDao;
import com.woniuxy.oasystem.dao.ReturnRegisterDao;
import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.CarApply;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.entity.ReturnRegister;
import com.woniuxy.oasystem.service.CarApplyService;
import com.woniuxy.oasystem.service.CarService;
import com.woniuxy.oasystem.service.OfficeSuppliesService;
import com.woniuxy.oasystem.service.ReturnRegisterService;
@Service
public class ReturnRegisterServiceImpl implements ReturnRegisterService{
	@Autowired
	ReturnRegisterDao returnRegisterDao;
	

	@Override
	public PageBean<ReturnRegister> findAllByPage(ReturnRegister returnRegister,int pageIndex, int pageSize) {
		
		PageBean<ReturnRegister> pb = new PageBean<ReturnRegister>();
		List<ReturnRegister> beanList = returnRegisterDao.findAllByPage(returnRegister, (pageIndex-1)*pageSize, pageSize);
		pb.setBeanList(beanList);	
		pb.setPageIndex(pageIndex);
		pb.setPageSize(pageSize);
		int totalRecord = returnRegisterDao.findAllByPageCount(returnRegister);
		pb.setTotalRecord(totalRecord);
		pb.setTotalPage((totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1);
		pb.setPageBeginAndPageEnd();
		return pb;
	}

	@Override
	public void deleteByRrId(int rrId) {
		returnRegisterDao.deleteByRrId(rrId);
	}

	@Override
	public void updateByRrId(ReturnRegister returnRegister) {
		returnRegisterDao.updateByRrId(returnRegister);
	}

	@Override
	public void insert(ReturnRegister returnRegister) {
		returnRegisterDao.insert(returnRegister);
	}

	@Override
	public Integer findIdByEmpName(String empName) {
		
		return 1;
	}

	
}
