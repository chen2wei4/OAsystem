package com.woniuxy.oasystem.dao;

import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.woniuxy.oasystem.entity.Announcement;


@SpringBootTest
public class AnnoucementDaoTest {

	@Autowired
	AnnouncementDao announcementDao;

	/*
	 * 测试条件查询公告
	 */
	@Test
	void test() {
		Announcement an = new Announcement();
		// an.setAnType(5);
		an.setAnName("啊");
		announcementDao.selectAnnouncementByCondition(0, 5, an);
		System.out.println(announcementDao.selectAnnouncementCountByCondition(an));
	}

	/*
	 * 测试添加公告
	 */
	@Test
	void test2() {
		Announcement an = new Announcement();
		for (int a = 3; a < 100; a++) {
			an.setAnName("添加测试" + a);
			an.setAnType(11);
			an.setAnTime(new Date());
			an.setAnFlag(true);
			an.setAnEmpId(123);
			an.setAnContent("正文内容" + a);
			announcementDao.insertAnnouncement(an);
			System.out.println("添加成功");
		}

	}

	/*
	 * 测试软删除公告
	 */
	@Test
	void test3() {
		announcementDao.deleteAn(100);
	}

	/*
	 * 测试修改公告
	 */
	@Test
	void test4() {
		Announcement ann = new Announcement();
		ann.setAnContent("修改正文");
		ann.setAnName("修改标题");
		ann.setAnId(28);
		ann.setAnType(5);
		announcementDao.updateAnnouncementById(ann);
	}
}
