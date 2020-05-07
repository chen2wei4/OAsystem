package com.woniuxy.oasystem.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.MemorDao;
import com.woniuxy.oasystem.entity.Memor;
import com.woniuxy.oasystem.service.MemorService;

@Service
public class MemorServiceImpl implements MemorService{

	@Autowired
	MemorDao memorDao;
	
	@Override
	public void addMemor(Memor memor) {
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		memor.setMemorTime(time);
		memorDao.addMemor(memor);
	}

	@Override
	public void deleteMemor(Memor memor) {
		memorDao.deleteMemor(memor);
	}

	@Override
	public void changeMemor(Memor memor) {
		memorDao.changeMemor(memor);
	}

	@Override
	public List<Memor> getMemor(Memor memor) {
		return memorDao.queryMemor(memor);
	}

}
