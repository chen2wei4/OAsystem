package com.woniuxy.oasystem.service;

import com.woniuxy.oasystem.entity.Emp;

public interface EmpService {
	Emp getEmpId(Integer empId);
	Emp getEmpCellNumber(String empTel);
	Emp getEmpEmail(String empEmail);
}
