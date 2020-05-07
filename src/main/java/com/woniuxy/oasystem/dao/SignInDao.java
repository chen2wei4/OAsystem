/**  
 * @author 王培霖
 * @createDate 2020年5月2日
 */

package com.woniuxy.oasystem.dao;

import com.woniuxy.oasystem.entity.SignIn;

/**  
 * @Description  签到
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年5月2日 下午9:32:59 [王培霖])
 *                      	2.
 */

public interface SignInDao {
	/**
	 * 添加签到记录
	 * @param signIn
	 * @changeLog 	1. 创建 (2020年5月2日 下午9:33:57 [王培霖])  </br>
	 */
	void addCheckIn(SignIn signIn);
	
	/**
	 * 签到效验，输入当前的日期，判断今天是否已签到
	 * @param checkInDate
	 * @param empId
	 * @return
	 * @changeLog 	1. 创建 (2020年5月3日 上午12:39:07 [王培霖])  </br>
	 *                      	2.
	 */
	SignIn verifyCheckIn(String checkInDate, Integer empId);
}
