/**  
 * @author 王培霖
 * @createDate 2020年5月3日
 */

package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.CheckInDao;
import com.woniuxy.oasystem.entity.CheckIn;
import com.woniuxy.oasystem.entity.IntervieweeInfo;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.CheckInService;

/**  
 * @Description  TODO
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年5月3日 下午6:34:27 [王培霖])
 *                      	2.
 */
@Service
public class CheckInServiceImpl implements CheckInService {

	@Autowired
	CheckInDao checkInDao;
	
	@Override
	public PageBean<CheckIn> selectCheckInByPage(CheckIn checkIn, int pageIndex, int pageSize) {
		PageBean<CheckIn> pageBean = new PageBean<CheckIn>();
		// 查询本页包含的数据
		List<CheckIn> checkIns = checkInDao.selectCheckInByPage(checkIn, (pageIndex-1)*pageSize, pageSize);
		pageBean.setBeanList(checkIns); // 将数据添加至本页
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalRecord = checkInDao.countByPage(checkIn, null);
		pageBean.setTotalRecord(totalRecord); // 设置数据总条数
		// 根据数据总条数计算总页数
		pageBean.setTotalPage((totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1);
		pageBean.setPageBeginAndPageEnd(); // 设置起始和末尾页码
		return pageBean;
	}

	
	@Override
	public PageBean<CheckIn> searchCheckIn(String parameter, CheckIn checkIn, int pageIndex, int pageSize) {
		PageBean<CheckIn> pageBean = new PageBean<CheckIn>();
		// 查询本页包含的数据
		List<CheckIn> checkIns = checkInDao.searchCheckIn(parameter, checkIn, (pageIndex-1)*pageSize, pageSize);
		pageBean.setBeanList(checkIns); // 将数据添加至本页
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalRecord = checkInDao.countByPage(checkIn, null);
		pageBean.setTotalRecord(totalRecord); // 设置数据总条数
		// 根据数据总条数计算总页数
		pageBean.setTotalPage((totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1);
		pageBean.setPageBeginAndPageEnd(); // 设置起始和末尾页码
		return pageBean;
	}

}
