/**  
 * @author 王培霖
 * @createDate 2020年5月2日
 */

package com.woniuxy.oasystem.service;

import com.woniuxy.oasystem.entity.SignIn;

/**  
 * @Description  签到
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年5月2日 下午10:44:10 [王培霖])
 *                      	2.
 */

public interface SignInService {
	/**
	 * 添加签到记录
	 * @param signIn
	 * @return
	 * @changeLog 	1. 创建 (2020年5月3日 上午12:18:15 [王培霖])  </br>
	 *                      	2.
	 */
	void addCheckIn(SignIn signIn);
	
	/**
	 * 签到效验，输入当前的日期，判断今天是否已签到
	 * @return
	 * @changeLog 	1. 创建 (2020年5月2日 下午11:58:19 [王培霖])  </br>
	 */
	SignIn verifyCheckIn(Integer empId);
	
	/**
	 *  验证签到时间，只有在8:30-9:30直接可以签到
	 * @return
	 * @changeLog 	1. 创建 (2020年5月3日 下午9:12:21 [王培霖])  </br>
	 *                      	2.
	 */
	boolean verifyCheckInTime();
}
