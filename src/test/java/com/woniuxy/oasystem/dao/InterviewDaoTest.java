package com.woniuxy.oasystem.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.woniuxy.oasystem.entity.Interview;
import com.woniuxy.oasystem.service.InterviewService;

@SpringBootTest
public class InterviewDaoTest {
	@Autowired
	InterviewDao interviewDao;
	
	@Autowired
	InterviewService interviewService;
	
	// 显示全部面试信息
	@Test
	public void displayInterview() {
		//List<Interview> interviews = interviewDao.displayInterview();
		List<Interview> interviews = interviewService.displayInterview();
		for (Interview interview : interviews) {
			System.out.println(interview.toString());
		}
	}
	
	// 添加面试信息
	@Test
	public void addInterview() {
		Interview interview1 = new Interview(5, 5, 1, "金融城", "2019-12-04");
		//interviewDao.addInterview(interview1);
		interviewService.addInterview(interview1);
	}
	
	// 删除面试信息
	@Test
	public void deleteInterview() {
		//interviewDao.deleteInterview(4);
		interviewService.deleteInterview(9);
	}
}
