/**  
 * @author 王培霖
 * @createDate 2020年4月25日
 */

package com.woniuxy.oasystem.service;

import java.util.List;

import com.woniuxy.oasystem.entity.Department;

/**  
 * @Description  用于显示部门
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年4月25日 下午9:59:21 [王培霖])
 *                      	2.
 */

public interface DepartmentService {
	/**
	 *  用于显示全部部门
	 * @return
	 * @changeLog 	1. 创建 (2020年4月25日 下午9:56:31 [王培霖])  </br>
	 *                      	2.
	 */
	List<Department> displayDepartment();
}
