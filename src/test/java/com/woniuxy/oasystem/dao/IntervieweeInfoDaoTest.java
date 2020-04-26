package com.woniuxy.oasystem.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.woniuxy.oasystem.entity.IntervieweeInfo;
import com.woniuxy.oasystem.service.IntervieweeInfoService;

@SpringBootTest
public class IntervieweeInfoDaoTest {
	@Autowired
	IntervieweeInfoDao intervieweeInfoDao;
	
	@Autowired
	IntervieweeInfoService intervieweeService;
	
	// 添加求职人员信息
	@Test
	public void addIntervieweeInfo() {
		IntervieweeInfo zhangsan = new IntervieweeInfo(1, "张三", 35, "男", "本科", "北京理工大学", "通信工程", "15254656498", 1);
		// intervieweeInfoDao.addIntervieweeInfo(zhangsan);
		intervieweeService.addIntervieweeInfo(zhangsan);
	}
	
	// 删除求职人员信息
	@Test
	public void deleteIntervieweeInfo() {
		//intervieweeInfoDao.deleteIntervieweeInfo(1);
		intervieweeService.deleteIntervieweeInfo(4);
	}
	
	// 显示全部求职人员信息
	@Test
	public void displayIntervieweeInfo() {
		//List<IntervieweeInfo> intervieweeInfos = intervieweeInfoDao.displayIntervieweeInfo();
		List<IntervieweeInfo> intervieweeInfos = intervieweeService.displayIntervieweeInfo();
		for (IntervieweeInfo info : intervieweeInfos) {
			System.out.println(info.toString());
		}
	}
}
