/**  
 * @author 王培霖
 * @createDate 2020年4月24日
 */

package com.woniuxy.oasystem.dao;

import java.util.List;

import com.woniuxy.oasystem.entity.Vacation;

/**  
 * @Description  显示假期
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年4月24日 下午5:30:42 [王培霖])
 *                      	2.
 */

public interface VacationDao {
	/**
	 *  显示全部假期
	 * TODO
	 * @return
	 * @changeLog 	1. 创建 (2020年4月24日 下午5:33:15 [王培霖])  </br>
	 *                      	2.
	 */
	List<Vacation> displayVacation();
}
