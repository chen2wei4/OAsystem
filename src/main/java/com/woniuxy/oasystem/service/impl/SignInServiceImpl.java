/**  
 * @author 王培霖
 * @createDate 2020年5月2日
 */

package com.woniuxy.oasystem.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.woniuxy.oasystem.dao.SignInDao;
import com.woniuxy.oasystem.entity.SignIn;
import com.woniuxy.oasystem.service.SignInService;

/**  
 * @Description  签到
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年5月2日 下午10:44:46 [王培霖])
 *                      	2.
 */
@Service
public class SignInServiceImpl implements SignInService {
	@Autowired
	SignInDao signInDao;
	
	@Override
	public void addCheckIn(SignIn signIn) {
		signInDao.addCheckIn(signIn);
	}

	@Override
	public SignIn verifyCheckIn(Integer empId) {
		// 生成当前的时间，判断今日是否已签到
		Date date = new Date();
		// 验证今天是否已签到
		String checkInDate = new SimpleDateFormat("yyyy-MM-dd").format(date);		
		SignIn checkResult = signInDao.verifyCheckIn(checkInDate, empId);
		return checkResult;
	}

	@Override
	public boolean verifyCheckInTime() {
		// 生成当前的时间，判断今日是否已签到
		Date date = new Date();
		String checkInTime = new SimpleDateFormat("HH:mm:ss").format(date); // 当前签到时间
		Date beginTime = null;
		Date endTime = null;
		Date currentTime = null;
		try {
			currentTime = new SimpleDateFormat("HH:mm:ss").parse(checkInTime); // 当前签到时间
			beginTime = new SimpleDateFormat("HH:mm:ss").parse("21:30:00"); // 签到起始时间
			endTime = new SimpleDateFormat("HH:mm:ss").parse("22:30:00"); // 签到结束时间
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 验证当前时间是否在8:30-9:30之间
		boolean result = currentTime.before(endTime) && currentTime.after(beginTime);
		return result;
	}
	
}
