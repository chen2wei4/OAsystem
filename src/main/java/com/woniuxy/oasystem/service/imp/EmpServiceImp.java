package com.woniuxy.oasystem.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.EmpDao;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.service.EmpService;

@Service
public class EmpServiceImp implements EmpService {

	@Autowired
	EmpDao empDao;
	
	@Override
	public List<Emp> displayEmp() {
		List<Emp> emps = empDao.displayEmp();
		return emps;
	}
	
}
