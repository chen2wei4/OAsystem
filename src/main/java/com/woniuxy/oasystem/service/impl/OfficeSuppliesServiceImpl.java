package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.OfficeSuppliesDao;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.service.OfficeSuppliesService;
@Service
public class OfficeSuppliesServiceImpl implements OfficeSuppliesService{
	@Autowired
	OfficeSuppliesDao officeSuppliesDao;
	
	@Override
	public List<OfficeSupplies> findAll() {
		return officeSuppliesDao.findAll();
	}
	
}
