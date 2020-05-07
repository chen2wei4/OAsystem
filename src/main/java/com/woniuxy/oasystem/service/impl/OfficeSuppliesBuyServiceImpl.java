package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.OfficeSuppliesBuyDao;
import com.woniuxy.oasystem.dao.OfficeSuppliesDao;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.OfficeSuppliesBuy;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.OfficeSuppliesBuyService;
import com.woniuxy.oasystem.service.OfficeSuppliesService;
@Service
public class OfficeSuppliesBuyServiceImpl implements OfficeSuppliesBuyService{
	@Autowired
	OfficeSuppliesBuyDao officeSuppliesBuyDao;
	

	@Override
	public PageBean<OfficeSuppliesBuy> findAllByPage(OfficeSuppliesBuy officeSuppliesBuy,int pageIndex, int pageSize) {
		System.out.println(1);
		PageBean<OfficeSuppliesBuy> pb = new PageBean<OfficeSuppliesBuy>();
		List<OfficeSuppliesBuy> beanList = officeSuppliesBuyDao.findAllByPage(officeSuppliesBuy, (pageIndex-1)*pageSize, pageSize);
		pb.setBeanList(beanList);	
		pb.setPageIndex(pageIndex);
		pb.setPageSize(pageSize);
		int totalRecord = officeSuppliesBuyDao.findAllByPageCount(officeSuppliesBuy);
		pb.setTotalRecord(totalRecord);
		pb.setTotalPage((totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1);
		pb.setPageBeginAndPageEnd();
		return pb;
	}

	@Override
	public void deleteByOsbId(int osbId) {
		officeSuppliesBuyDao.deleteByOsbId(osbId);
	}

	@Override
	public void updateByOsbId(OfficeSuppliesBuy officeSuppliesBuy) {
		officeSuppliesBuyDao.updateByOsbId(officeSuppliesBuy);
	}

	@Override
	public void insert(OfficeSuppliesBuy officeSuppliesBuy) {
		officeSuppliesBuyDao.insert(officeSuppliesBuy);
	}

	
}
