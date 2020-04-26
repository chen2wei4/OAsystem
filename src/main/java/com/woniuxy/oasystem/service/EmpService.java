package com.woniuxy.oasystem.service;

import java.util.List;

import com.woniuxy.oasystem.entity.Emp;

public interface EmpService {
	/**
	 * 展示在职员工的信息
	 * TODO
	 * @return java.util.List<Emp>对象
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:22:34 [王培霖])  </br>
	 *                      	2.
	 */
	List<Emp> displayEmp();
	
	Emp getEmpId(Integer empId);
	Emp getEmpCellNumber(String empTel);
	Emp getEmpEmail(String empEmail);
}
