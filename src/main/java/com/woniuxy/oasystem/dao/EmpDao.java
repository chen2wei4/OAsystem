package com.woniuxy.oasystem.dao;

import java.util.List;

import com.woniuxy.oasystem.entity.Emp;

public interface EmpDao {
	
	/**
	 * 展示在职员工信息
	 */
	List<Emp> displayEmp();
	
	Emp getEmpId(Integer empId);
	Emp getEmpCellNumber(String empTel);
	Emp getEmpEmail(String empEmail);
}
