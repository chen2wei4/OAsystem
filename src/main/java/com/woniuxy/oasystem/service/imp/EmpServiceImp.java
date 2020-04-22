package com.woniuxy.oasystem.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.EmpDao;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.service.EmpService;
@Service
public class EmpServiceImp implements EmpService{
	@Autowired
	EmpDao empDao;
	@Override
	public Emp getEmpId(Integer empId) {
		Emp emp = empDao.getEmpId(empId);
		return emp;
	}
	@Override
	public Emp getEmpCellNumber(String empTel) {
		Emp emp = empDao.getEmpCellNumber(empTel);
		return emp;
	}
	@Override
	public Emp getEmpEmail(String empEmail) {
		Emp emp = empDao.getEmpEmail(empEmail);
		return emp;
	}

}
