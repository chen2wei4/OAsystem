package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.IntervieweeInfoDao;
import com.woniuxy.oasystem.entity.BusinessTrip;
import com.woniuxy.oasystem.entity.EmptyPosition;
import com.woniuxy.oasystem.entity.IntervieweeInfo;
import com.woniuxy.oasystem.entity.Leaving;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.IntervieweeInfoService;

@Service
public class IntervieweeInfoServiceImpl implements IntervieweeInfoService {
	
	@Autowired
	IntervieweeInfoDao intervieweeInfoDao;

	@Override
	public void addIntervieweeInfo(IntervieweeInfo intervieweeInfo) {
		intervieweeInfoDao.addIntervieweeInfo(intervieweeInfo);
		
	}

	@Override
	public void deleteIntervieweeInfo(Integer interviewee_id) {
		intervieweeInfoDao.deleteIntervieweeInfo(interviewee_id);
		
	}

	@Override
	public List<IntervieweeInfo> displayIntervieweeInfo() {
		List<IntervieweeInfo> intervieweeInfos = intervieweeInfoDao.displayIntervieweeInfo();
		return intervieweeInfos;
	}

//	@Override
//	public List<IntervieweeInfo> searchIntervieweeInfo(String parameter) {
//		List<IntervieweeInfo> intervieweeInfos = intervieweeInfoDao.searchIntervieweeInfo(parameter);
//		return intervieweeInfos;
//	}

	@Override
	public IntervieweeInfo verityIntervieweeInfo(String intervieweeName, String intervieweePhone) {
		return intervieweeInfoDao.verityIntervieweeInfo(intervieweeName, intervieweePhone);
	}

	@Override
	public void modifyIntervieweeInfo(IntervieweeInfo intervieweeInfo) {
		intervieweeInfoDao.modifyIntervieweeInfo(intervieweeInfo);
		
	}

	@Override
	public PageBean<IntervieweeInfo> selectIntervieweeInfoByPage(IntervieweeInfo intervieweeInfo, int pageIndex,
			int pageSize) {
		PageBean<IntervieweeInfo> pageBean = new PageBean<IntervieweeInfo>();
		// 查询本页包含的数据
		List<IntervieweeInfo> intervieweeInfos = intervieweeInfoDao.selectIntervieweeInfoByPage(intervieweeInfo, (pageIndex-1)*pageSize, pageSize);
		pageBean.setBeanList(intervieweeInfos); // 将数据添加至本页
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalRecord = intervieweeInfoDao.countByPage(intervieweeInfo, null, null, null, null);
		pageBean.setTotalRecord(totalRecord); // 设置数据总条数
		// 根据数据总条数计算总页数
		pageBean.setTotalPage((totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1);
		pageBean.setPageBeginAndPageEnd(); // 设置起始和末尾页码
		return pageBean;
	}

	/* (non-Javadoc)
	 * @see com.woniuxy.oasystem.service.IntervieweeInfoService#searchIntervieweeInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, com.woniuxy.oasystem.entity.IntervieweeInfo, int, int)
	 */
	@Override
	public PageBean<IntervieweeInfo> searchIntervieweeInfo(String parameter, String intervieweeGender,
			String educationBackground, Integer positionId, IntervieweeInfo intervieweeInfo, int pageIndex,
			int pageSize) {
		PageBean<IntervieweeInfo> pageBean = new PageBean<IntervieweeInfo>();
		// 查询本页包含的数据
		List<IntervieweeInfo> positions = intervieweeInfoDao.searchIntervieweeInfo(parameter, intervieweeGender, educationBackground, positionId, intervieweeInfo, (pageIndex-1)*pageSize, pageSize);
		pageBean.setBeanList(positions); // 将数据添加至本页
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalRecord = intervieweeInfoDao.countByPage(intervieweeInfo, intervieweeGender, educationBackground, positionId, parameter);
		pageBean.setTotalRecord(totalRecord); // 设置数据总条数
		// 根据数据总条数计算总页数
		pageBean.setTotalPage((totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1);
		pageBean.setPageBeginAndPageEnd(); // 设置起始和末尾页码
		return pageBean;
	}

}
