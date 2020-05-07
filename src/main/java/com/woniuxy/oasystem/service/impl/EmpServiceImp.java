package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.EmpDao;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.PageBean;
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
	@Override
	public PageBean<Emp> selectEmpByPage(Emp emp, int pageIndex, int pageSize) {
		PageBean<Emp> pageBean = new PageBean<Emp>();
		// 查询本页包含的数据
		List<Emp> emps = empDao.selectEmpByPage(emp, (pageIndex-1)*pageSize, pageSize);
		pageBean.setBeanList(emps); // 将数据添加至本页
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalRecord = empDao.countByPage(emp, null, null, null, null);
		pageBean.setTotalRecord(totalRecord); // 设置数据总条数
		// 根据数据总条数计算总页数
		pageBean.setTotalPage((totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1);
		pageBean.setPageBeginAndPageEnd(); // 设置起始和末尾页码
		return pageBean;
	}

	@Override
	public PageBean<Emp> searchEmp(String parameter, String empGender, String educationBackground, Integer departmentId,
			Emp emp, int pageIndex, int pageSize) {
		PageBean<Emp> pageBean = new PageBean<Emp>();
		// 查询本页包含的数据
		List<Emp> emps = empDao.searchEmp(parameter, departmentId, empGender, educationBackground, emp, (pageIndex-1)*pageSize, pageSize);
		pageBean.setBeanList(emps); // 将数据添加至本页
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalRecord = empDao.countByPage(emp, null, null, null, null);
		pageBean.setTotalRecord(totalRecord); // 设置数据总条数
		// 根据数据总条数计算总页数
		pageBean.setTotalPage((totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1);
		pageBean.setPageBeginAndPageEnd(); // 设置起始和末尾页码
		return pageBean;
	}


	@Override
	public void modifyEmp(Emp emp) {
		empDao.modifyEmp(emp);
	}

	@Override
	public Emp verifyEmpIdNumber(String empIdNumber) {
		Emp emp = empDao.verifyEmpIdNumber(empIdNumber);
		return emp;
	}
}
