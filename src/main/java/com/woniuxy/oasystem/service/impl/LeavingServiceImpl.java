package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.LeavingDao;
import com.woniuxy.oasystem.entity.Leaving;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.LeavingService;

@Service
public class LeavingServiceImpl implements LeavingService {
	@Autowired
	LeavingDao leavingDao;

	@Override
	public void addLeaving(Leaving leaving) {
		leavingDao.addLeaving(leaving);
		
	}

	@Override
	public void deleteLeaving(Integer leavingId) {
		leavingDao.deleteLeaving(leavingId);
		
	}

	@Override
	public List<Leaving> displayLeaving() {
		List<Leaving> leavings = leavingDao.displayLeaving();
		return leavings;
	}

//	@Override
//	public List<Leaving> searchLeaving(String parameter) {
//		List<Leaving> leavings = leavingDao.searchLeaving(parameter);
//		return leavings;
//	}

	@Override
	public void modifyLeaving(Leaving leaving) {
		leavingDao.modifyLeaving(leaving);
		
	}

	@Override
	public PageBean<Leaving> selectLeavingByPage(Leaving leaving, int pageIndex, int pageSize) {
		PageBean<Leaving> pageBean = new PageBean<Leaving>();
		// 查询本页包含的数据
		List<Leaving> leavings = leavingDao.selectLeavingByPage(leaving, (pageIndex-1)*pageSize, pageSize);
		pageBean.setBeanList(leavings); // 将数据添加至本页
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalRecord = leavingDao.countByPage(leaving, null);
		pageBean.setTotalRecord(totalRecord); // 设置数据总条数
		// 根据数据总条数计算总页数
		pageBean.setTotalPage((totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1);
		pageBean.setPageBeginAndPageEnd(); // 设置起始和末尾页码
		return pageBean;
	}

	/* (non-Javadoc)
	 * @see com.woniuxy.oasystem.service.LeavingService#searchLeaving(java.lang.String, com.woniuxy.oasystem.entity.Leaving, int, int)
	 */
	@Override
	public PageBean<Leaving> searchLeaving(String parameter, Leaving leaving, int pageIndex, int pageSize) {
		PageBean<Leaving> pageBean = new PageBean<Leaving>();
		// 查询本页包含的数据
		List<Leaving> leavings = leavingDao.searchLeaving(parameter, leaving, (pageIndex-1)*pageSize, pageSize);
		pageBean.setBeanList(leavings); // 将数据添加至本页
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalRecord = leavingDao.countByPage(leaving, parameter);
		pageBean.setTotalRecord(totalRecord); // 设置数据总条数
		// 根据数据总条数计算总页数
		pageBean.setTotalPage((totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1);
		pageBean.setPageBeginAndPageEnd(); // 设置起始和末尾页码
		return pageBean;
	}
	
}
