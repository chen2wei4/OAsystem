package com.woniuxy.oasystem.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.EmptyPositionDao;
import com.woniuxy.oasystem.entity.EmptyPosition;
import com.woniuxy.oasystem.service.EmptyPositionService;

@Service
public class EmptyPositionServiceImp implements EmptyPositionService {
	
	@Autowired
	EmptyPositionDao emptyPositionDao;

	@Override
	public void addEmptyPosition(EmptyPosition emptyPosition) {
		emptyPositionDao.addEmptyPosition(emptyPosition);
		
	}

	@Override
	public void deleteEmptyPosition(int position_id) {
		emptyPositionDao.deleteEmptyPosition(position_id);
		
	}

	@Override
	public List<EmptyPosition> displayEmptyPosition() {
		List<EmptyPosition> positions = emptyPositionDao.displayEmptyPosition();
		return positions;
	}
}
