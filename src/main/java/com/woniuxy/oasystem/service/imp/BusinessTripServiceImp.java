package com.woniuxy.oasystem.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.BusinessTripDao;
import com.woniuxy.oasystem.entity.BusinessTrip;
import com.woniuxy.oasystem.service.BusinessTripService;

@Service
public class BusinessTripServiceImp implements BusinessTripService {
	@Autowired
	BusinessTripDao businessTripDao;

	@Override
	public void addBusinessTrip(BusinessTrip businessTrip) {
		businessTripDao.addBusinessTrip(businessTrip);
		
	}

	@Override
	public void deleteBusinessTrip(int tripId) {
		businessTripDao.deleteBusinessTrip(tripId);
		
	}

	@Override
	public List<BusinessTrip> displayBusinessTrip() {
		List<BusinessTrip> trips = businessTripDao.displayBusinessTrip();
		return trips;
	}

}
