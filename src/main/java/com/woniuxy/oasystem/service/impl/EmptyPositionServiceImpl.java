package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.EmptyPositionDao;
import com.woniuxy.oasystem.entity.EmptyPosition;
import com.woniuxy.oasystem.entity.Interview;
import com.woniuxy.oasystem.entity.IntervieweeInfo;
import com.woniuxy.oasystem.entity.Leaving;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.EmptyPositionService;

@Service
public class EmptyPositionServiceImpl implements EmptyPositionService {
	
	@Autowired
	EmptyPositionDao emptyPositionDao;

	@Override
	public void addEmptyPosition(EmptyPosition emptyPosition) {
		emptyPositionDao.addEmptyPosition(emptyPosition);
		
	}

	@Override
	public void deleteEmptyPosition(Integer position_id) {
		emptyPositionDao.deleteEmptyPosition(position_id);
		
	}

	@Override
	public List<EmptyPosition> displayEmptyPosition() {
		List<EmptyPosition> positions = emptyPositionDao.displayEmptyPosition();
		return positions;
	}

//	@Override
//	public List<EmptyPosition> searchEmptyPosition(String parameter) {
//		List<EmptyPosition> emptyPositions = emptyPositionDao.searchEmptyPosition(parameter);
//		return emptyPositions;
//	}

	@Override
	public void modifyEmptyPosition(EmptyPosition emptyPosition) {
		emptyPositionDao.modifyEmptyPosition(emptyPosition);
		
	}

	@Override
	public PageBean<EmptyPosition> selectEmptyPositionByPage(EmptyPosition emptyPosition, int pageIndex,
			int pageSize) {
		PageBean<EmptyPosition> pageBean = new PageBean<EmptyPosition>();
		// 查询本页包含的数据
		List<EmptyPosition> emptyPositions = emptyPositionDao.selectEmptyPositionByPage(null, emptyPosition, (pageIndex-1)*pageSize, pageSize);
		pageBean.setBeanList(emptyPositions); // 将数据添加至本页
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalRecord = emptyPositionDao.countByPage(emptyPosition, null, null, null);
		pageBean.setTotalRecord(totalRecord); // 设置数据总条数
		// 根据数据总条数计算总页数
		pageBean.setTotalPage((totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1);
		pageBean.setPageBeginAndPageEnd(); // 设置起始和末尾页码
		return pageBean;
	}

	/* (non-Javadoc)
	 * @see com.woniuxy.oasystem.service.EmptyPositionService#searchEmptyPosition(java.lang.String, com.woniuxy.oasystem.entity.EmptyPosition, java.lang.Integer, java.lang.String, int, int)
	 */
	@Override
	public PageBean<EmptyPosition> searchEmptyPosition(String parameter, EmptyPosition emptyPosition,
			Integer departmentId, String educationBackground, int pageIndex, int pageSize) {
		PageBean<EmptyPosition> pageBean = new PageBean<EmptyPosition>();
		// 查询本页包含的数据
		List<EmptyPosition> positions = emptyPositionDao.searchEmptyPosition(parameter, departmentId, educationBackground, emptyPosition, (pageIndex-1)*pageSize, pageSize);
		pageBean.setBeanList(positions); // 将数据添加至本页
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalRecord = emptyPositionDao.countByPage(emptyPosition, parameter, departmentId, educationBackground);
		pageBean.setTotalRecord(totalRecord); // 设置数据总条数
		// 根据数据总条数计算总页数
		pageBean.setTotalPage((totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1);
		pageBean.setPageBeginAndPageEnd(); // 设置起始和末尾页码
		return pageBean;
	}
	
	
}
