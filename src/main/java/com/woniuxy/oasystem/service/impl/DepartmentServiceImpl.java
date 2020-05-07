/**  
 * @author 王培霖
 * @createDate 2020年4月25日
 */

package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.DepartmentDao;
import com.woniuxy.oasystem.entity.Department;
import com.woniuxy.oasystem.service.DepartmentService;

/**  
 * @Description  显示部门信息
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年4月25日 下午10:02:12 [王培霖])
 *                      	2.
 */

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentDao departmentDao;
	
	@Override
	public List<Department> displayDepartment() {
		List<Department> departments= departmentDao.displayDepartment();
		return departments;
	}
	
}
