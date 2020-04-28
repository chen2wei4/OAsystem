package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.BoardroomDao;
import com.woniuxy.oasystem.dao.CarApplyDao;
import com.woniuxy.oasystem.dao.CarDao;
import com.woniuxy.oasystem.dao.OfficeSuppliesDao;
import com.woniuxy.oasystem.entity.Boardroom;
import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.CarApply;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.BoardroomService;
import com.woniuxy.oasystem.service.CarApplyService;
import com.woniuxy.oasystem.service.CarService;
import com.woniuxy.oasystem.service.OfficeSuppliesService;
@Service
public class BoardroomServiceImpl implements BoardroomService{
	@Autowired
	BoardroomDao boardroomDao;
	

	@Override
	public PageBean<Boardroom> findAllByPage(Boardroom boardroom,int pageIndex, int pageSize) {
		
		PageBean<Boardroom> pb = new PageBean<Boardroom>();
		List<Boardroom> beanList = boardroomDao.findAllByPage(boardroom, (pageIndex-1)*pageSize, pageSize);
		pb.setBeanList(beanList);	
		pb.setPageIndex(pageIndex);
		pb.setPageSize(pageSize);
		int totalRecord = boardroomDao.findAllByPageCount(boardroom);
		pb.setTotalRecord(totalRecord);
		pb.setTotalPage((totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1);
		pb.setPageBeginAndPageEnd();
		return pb;
	}

	@Override
	public void deleteByBoardroomId(int boardroomId) {
		boardroomDao.deleteByBoardroomId(boardroomId);
	}

	@Override
	public void updateByBoardroomId(Boardroom boardroom) {
		boardroomDao.updateByBoardroomId(boardroom);
	}

	@Override
	public void insert(Boardroom boardroom) {
		boardroomDao.insert(boardroom);
	}

	
}
