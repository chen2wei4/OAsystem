package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.EmpDao;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.service.EmpService;
/**
 * 
 * @Description 职工相关的服务层接口实现类
 * @author 陈一玮
 * @changeLog 1.创建 (2020年4月23日 下午3:00:53 [陈一玮]
 *            2.
 */
@Service
public class EmpServiceImp implements EmpService {

	@Autowired
	EmpDao empDao;
	
	@Override
	public List<Emp> displayEmp() {
		List<Emp> emps = empDao.displayEmp();
		return emps;
	}
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
	@Override
	public void changeNewPwd(Integer empId, String newPwd) {
		empDao.changeNewPwd(empId, newPwd);
	}
	@Override
	public void bindTel(Integer empId, String bindTel) {
		empDao.bindTel(empId, bindTel);
	}
	@Override
	public void bindEmail(Integer empId, String bindEmail) {
		empDao.bindEmail(empId, bindEmail);
	}
}
