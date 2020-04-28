package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.OfficeSuppliesDao;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.OfficeSuppliesService;
@Service
public class OfficeSuppliesServiceImpl implements OfficeSuppliesService{
	@Autowired
	OfficeSuppliesDao officeSuppliesDao;
	

	@Override
	public PageBean<OfficeSupplies> findAllByPage(OfficeSupplies officeSupplies,int pageIndex, int pageSize) {
		
		PageBean<OfficeSupplies> pb = new PageBean<OfficeSupplies>();
		List<OfficeSupplies> beanList = officeSuppliesDao.findAllByPage(officeSupplies, (pageIndex-1)*pageSize, pageSize);
		pb.setBeanList(beanList);	
		pb.setPageIndex(pageIndex);
		pb.setPageSize(pageSize);
		int totalRecord = officeSuppliesDao.findAllByPageCount(officeSupplies);
		pb.setTotalRecord(totalRecord);
		pb.setTotalPage((totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1);
		pb.setPageBeginAndPageEnd();
		return pb;
	}

	@Override
	public void deleteByOsId(int osId) {
		officeSuppliesDao.deleteByOsId(osId);
	}

	@Override
	public void updateByOsId(OfficeSupplies officeSupplies) {
		officeSuppliesDao.updateByOsId(officeSupplies);
	}

	@Override
	public void insert(OfficeSupplies officeSupplies) {
		officeSuppliesDao.insert(officeSupplies);
	}

	
}
