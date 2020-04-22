package com.woniuxy.oasystem.dao;

import com.woniuxy.oasystem.entity.Emp;

public interface EmpDao {
	Emp getEmpId(Integer empId);
	Emp getEmpCellNumber(String empTel);
	Emp getEmpEmail(String empEmail);
}
