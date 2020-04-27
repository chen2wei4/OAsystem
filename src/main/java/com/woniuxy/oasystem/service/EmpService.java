package com.woniuxy.oasystem.service;

import java.util.List;

import com.woniuxy.oasystem.entity.Emp;

/**
 * 
 * @Description 职工相关的服务层接口
 * @author 陈一玮
 * @changeLog 1.创建 (2020年4月23日 下午3:00:29 [陈一玮]
 *            2.
 */
public interface EmpService {
	/**
	 * 展示在职员工信息
	 */
	List<Emp> displayEmp();
	Emp getEmpId(Integer empId);
	/**
	 * 通过手机号查询职工信息
	 * @param empId 输入的手机号
	 * @return 返回职工信息
	 * @changeLog 1.创建 (2020年4月23日 下午2:54:07 [陈一玮]
	 *            2.
	 */
	Emp getEmpCellNumber(String empTel);
	/**
	 * 通过邮箱查询职工信息
	 * @param empId 输入的邮箱
	 * @return 返回职工信息
	 * @changeLog 1.创建 (2020年4月23日 下午2:54:07 [陈一玮]
	 *            2.
	 */
	Emp getEmpEmail(String empEmail);
	/**
	 * 修改密码
	 * @param newPwd 输入的新密码
	 * @changeLog 1.创建 (2020年4月23日 下午5:23:27 [陈一玮]
	 */
	void changeNewPwd(Integer empId,String newPwd);
	/**
	 * 绑定邮箱
	 * @param empId 职工工号
	 * @param bindTel 输入的绑定手机号
	 * @changeLog 1.创建 (2020年4月23日 下午8:23:07 [陈一玮]
	 */
	void bindTel(Integer empId,String bindTel);
	/**
	 * 绑定邮箱
	 * @param empId 职工工号
	 * @param bindEmail 输入的绑定邮箱
	 * @changeLog 1.创建 (2020年4月23日 下午8:23:07 [陈一玮]
	 */
	void bindEmail(Integer empId,String bindEmail);
}
