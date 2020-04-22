package com.woniuxy.oasystem.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.LeavingDao;
import com.woniuxy.oasystem.entity.Leaving;
import com.woniuxy.oasystem.service.LeavingService;

@Service
public class LeavingServiceImp implements LeavingService {
	@Autowired
	LeavingDao leavingDao;

	@Override
	public void addLeaving(Leaving leaving) {
		leavingDao.addLeaving(leaving);
		
	}

	@Override
	public void deleteLeaving(int leavingId) {
		leavingDao.deleteLeaving(leavingId);
		
	}

	@Override
	public List<Leaving> displayLeaving() {
		List<Leaving> leavings = leavingDao.displayLeaving();
		return leavings;
	}
	
}
