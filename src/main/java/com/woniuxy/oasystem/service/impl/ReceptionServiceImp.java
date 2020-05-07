/**
 * 
 */
package com.woniuxy.oasystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.EmpDao;
import com.woniuxy.oasystem.dao.ReceptionDao;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.Reception;
import com.woniuxy.oasystem.service.ReceptionService;

/**
 * @author THY
 *
 */
@Service
public class ReceptionServiceImp implements ReceptionService{
	
	@Autowired
	ReceptionDao  receptionDao;
	
	@Autowired
	EmpDao empDao;
	
	public void setReceptionDao(ReceptionDao receptionDao) {
		this.receptionDao = receptionDao;
	}

	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

	//查询所有接待内容
	@Override
	public Reception queryRecptions(Integer empId) {	
		return  receptionDao.queryRecptions(empId);
	}

	/* (non-Javadoc)
	 * @see com.woniuxy.oasystem.service.ReceptionService#addReception(java.lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public void addReception(Integer empId, String receptionContent, String receptionTime) {
		//根据id查询查询员工
		 //Emp emp=empDao.queryEmp(empId);
		Emp emp=empDao.getEmpId(empId);
		Reception reception=new Reception();
		reception.setEmp(emp);
		reception.setReceptionContent(receptionContent);
		reception.setReceptionTime(receptionTime);
		
		receptionDao.addReception(reception);
	}

	//完成接待
	@Override
	public void okReception(Integer receptionId) {
		receptionDao.okReception(receptionId);	
	}

	
	//查询可接待接待员工
	@Override
	public List<Emp> queryReceptionEmp() {
		List<Emp> emp=empDao.getEmps();
		return emp;
	}

}
