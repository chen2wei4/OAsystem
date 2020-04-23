package com.woniuxy.oasystem.dao;

import java.util.List;

import com.woniuxy.oasystem.entity.Emp;

public interface EmpDao {
	
	/**
	 * 展示在职员工信息
	 * TODO
	 * @return
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:28:32 [王培霖])  </br>
	 *                      	2.
	 */
	List<Emp> displayEmp();
	
	Emp getEmpId(Integer empId);
	Emp getEmpCellNumber(String empTel);
	Emp getEmpEmail(String empEmail);
}
