package com.woniuxy.oasystem.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.woniuxy.oasystem.entity.BusinessTrip;
import com.woniuxy.oasystem.service.BusinessTripService;

@SpringBootTest
public class BusinessTripDaoTest {
	
	@Autowired
	BusinessTripDao businessTripDao;
	
	@Autowired
	BusinessTripService businessTripService;
	
	// 新增出差记录
	@Test
	public void addBusinessTrip() {
		BusinessTrip businessTrip = new BusinessTrip(1, "2018-04-09", 1f, "重庆", "处理工商业务");
		//businessTripDao.addBusinessTrip(businessTrip);
		businessTripService.addBusinessTrip(businessTrip);
	}
	
	// 删除出差记录
	@Test
	public void deleteBusinessTrip() {
		//businessTripDao.deleteBusinessTrip(2);
		businessTripService.deleteBusinessTrip(1);
	}
	
	// 展示出差记录
	@Test
	public void displayBusinessTrip() {
		//List<BusinessTrip> trips = businessTripDao.displayBusinessTrip();
		List<BusinessTrip> trips = businessTripService.displayBusinessTrip();
		for (BusinessTrip trip : trips) {
			System.out.println(trip.toString());
		}
	}
}
