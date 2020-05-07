package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.InterviewDao;
import com.woniuxy.oasystem.entity.Interview;
import com.woniuxy.oasystem.entity.Leaving;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.InterviewService;

@Service
public class InterviewServiceImpl implements InterviewService {
	@Autowired
	InterviewDao interviewDao;

	@Override
	public void addInterview(Interview interview) {
		System.out.println("Service里的面试人信息：" + interview.toString());
		interviewDao.addInterview(interview);
		
	}

	@Override
	public void deleteInterview(Integer interviewId) {
		interviewDao.deleteInterview(interviewId);
		
	}

	@Override
	public List<Interview> displayInterview() {
		List<Interview> interviews = interviewDao.displayInterview();
		return interviews;
	}

	/*
	 * @Override public List<Interview> searchInterview(String parameter) {
	 * List<Interview> interviews = interviewDao.searchInterview(parameter); return
	 * interviews; }
	 */
	
	@Override
	public void modifyInterview(Interview interview) {
		interviewDao.modifyInterview(interview);
	}

	@Override
	public PageBean<Interview> selectInterviewByPage(Interview interview, int pageIndex, int pageSize) {
		PageBean<Interview> pageBean = new PageBean<Interview>();
		// 查询本页包含的数据
		List<Interview> interviews = interviewDao.selectInterviewByPage(interview, (pageIndex-1)*pageSize, pageSize);
		pageBean.setBeanList(interviews); // 将数据添加至本页
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalRecord = interviewDao.countByPage(interview, null);
		pageBean.setTotalRecord(totalRecord); // 设置数据总条数
		// 根据数据总条数计算总页数
		pageBean.setTotalPage((totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1);
		pageBean.setPageBeginAndPageEnd(); // 设置起始和末尾页码
		return pageBean;
	}

	/* (non-Javadoc)
	 * @see com.woniuxy.oasystem.service.InterviewService#searchInterview(java.lang.String, com.woniuxy.oasystem.entity.Interview, int, int)
	 */
	@Override
	public PageBean<Interview> searchInterview(String parameter, Interview interview, int pageIndex, int pageSize) {
		System.out.println("pageIndex=" + pageIndex);
		PageBean<Interview> pageBean = new PageBean<Interview>();
		// 查询本页包含的数据
		List<Interview> interviews = interviewDao.searchInterview(parameter, interview, (pageIndex-1)*pageSize, pageSize);
		pageBean.setBeanList(interviews); // 将数据添加至本页
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalRecord = interviewDao.countByPage(interview, parameter);
		pageBean.setTotalRecord(totalRecord); // 设置数据总条数
		// 根据数据总条数计算总页数
		pageBean.setTotalPage((totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1);
		pageBean.setPageBeginAndPageEnd(); // 设置起始和末尾页码
		for (Interview interview2 : interviews) {
			System.out.println(interview2.toString());
		}
		return pageBean;
	}

}
