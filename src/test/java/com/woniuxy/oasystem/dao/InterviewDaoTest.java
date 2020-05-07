/**  
 * @author 王培霖
 * @createDate 2020年5月6日
 */

package com.woniuxy.oasystem.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.woniuxy.oasystem.entity.Interview;
import com.woniuxy.oasystem.service.InterviewService;

/**  
 * @Description  TODO
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年5月6日 下午5:21:53 [王培霖])
 *                      	2.
 */

@SpringBootTest
public class InterviewDaoTest {
	@Autowired
	InterviewDao interviewDao;
	
	@Autowired
	InterviewService InterviewService;
	
	@Test
	public void searchTest() {
		//List<Interview> interviews = interviewDao.searchInterview("小", new Interview(), 1, 2);
		List<Interview> interviews = InterviewService.searchInterview("小", new Interview(), 2, 2).getBeanList();
		for (Interview interview : interviews) {
			System.out.println(interview.toString());
		}
	}
	
	@Test
	public void addInterview() {
	}
}
