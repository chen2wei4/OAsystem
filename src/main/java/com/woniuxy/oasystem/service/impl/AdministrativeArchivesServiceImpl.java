package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.AdministrativeArchivesDao;
import com.woniuxy.oasystem.dao.CarDao;
import com.woniuxy.oasystem.dao.OfficeSuppliesDao;
import com.woniuxy.oasystem.entity.AdministrativeArchives;
import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.AdministrativeArchivesService;
import com.woniuxy.oasystem.service.CarService;
import com.woniuxy.oasystem.service.OfficeSuppliesService;
@Service
public class AdministrativeArchivesServiceImpl implements AdministrativeArchivesService{
	@Autowired
	AdministrativeArchivesDao administrativeArchivesDao;
	

	@Override
	public PageBean<AdministrativeArchives> findAllByPage(AdministrativeArchives administrativeArchives,int pageIndex, int pageSize) {
		
		PageBean<AdministrativeArchives> pb = new PageBean<AdministrativeArchives>();
		List<AdministrativeArchives> beanList = administrativeArchivesDao.findAllByPage(administrativeArchives, (pageIndex-1)*pageSize, pageSize);
		pb.setBeanList(beanList);	
		pb.setPageIndex(pageIndex);
		pb.setPageSize(pageSize);
		int totalRecord = administrativeArchivesDao.findAllByPageCount(administrativeArchives);
		pb.setTotalRecord(totalRecord);
		pb.setTotalPage((totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1);
		pb.setPageBeginAndPageEnd();
		return pb;
	}

	@Override
	public void deleteByAaId(int aaId) {
		administrativeArchivesDao.deleteByAaId(aaId);
	}

	@Override
	public void updateByAaId(AdministrativeArchives administrativeArchives) {
		administrativeArchivesDao.updateByAaId(administrativeArchives);
	}

	@Override
	public void insert(AdministrativeArchives administrativeArchives) {
		administrativeArchivesDao.insert(administrativeArchives);
	}

	@Override
	public void insertFile(String fileName, String fileAddress,Integer aaId) {
		administrativeArchivesDao.insertFile(fileName,fileAddress,aaId);
	}

	
}
