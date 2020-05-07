/**  
 * @author 王培霖
 * @createDate 2020年4月24日
 */

package com.woniuxy.oasystem.service;

import java.util.List;

import com.woniuxy.oasystem.entity.Vacation;

/**  
 * @Description  管理假期
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年4月24日 下午6:05:51 [王培霖])
 *                      	2.
 */

public interface VacationService {
	/**
	 * 显示所有假期类型
	 * @return
	 * @changeLog 	1. 创建 (2020年4月24日 下午6:06:48 [王培霖])  </br>
	 *                      	2.
	 */
	List<Vacation> displayVacation();
	
}
