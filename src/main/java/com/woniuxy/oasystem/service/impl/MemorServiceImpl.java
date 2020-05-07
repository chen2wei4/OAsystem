package com.woniuxy.oasystem.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.woniuxy.oasystem.entity.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.MemorDao;
import com.woniuxy.oasystem.entity.Memor;
import com.woniuxy.oasystem.service.MemorService;

@Service
public class MemorServiceImpl implements MemorService{

	@Autowired
	MemorDao memorDao;
	@Autowired
	PageBean<Memor> pb;

	@Override
	public void addMemor(Memor memor) {
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		memor.setMemorTime(time);
		try {
			memorDao.addMemor(memor);
		}catch (Exception e){
			e.printStackTrace();
		}
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
	public PageBean<Memor> getMemor(Memor memor,Integer page) {
		List<Memor> memors=new ArrayList<Memor>();
		try {
			memors = memorDao.queryMemor(memor,(page-1)*10);
		}catch (Exception e){
			e.printStackTrace();
		}
		pb.setBeanList(memors);
		pb.setPageSize(10);
		pb.setPageIndex(page);
		pb.setTotalRecord(memors.size());
		pb.setTotalPage((pb.getTotalRecord()%10==0)?(pb.getTotalRecord()/10):(pb.getTotalRecord()/10+1));
		pb.setUrl("/memors");
		pb.setBeginPageAndEndPage();
		return pb;
	}

}
