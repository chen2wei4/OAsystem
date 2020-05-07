/**  
 * @author 王培霖
 * @createDate 2020年4月24日
 */

package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.VacationDao;
import com.woniuxy.oasystem.entity.Vacation;
import com.woniuxy.oasystem.service.VacationService;

/**  
 * @Description  假期管理
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年4月24日 下午6:09:16 [王培霖])
 *                      	2.
 */

@Service
public class VacationServiceImpl implements VacationService {

	@Autowired
	VacationDao vacationDao;
	
	/**
	 * 查询所有假期
	 */
	@Override
	public List<Vacation> displayVacation() {
		List<Vacation> vacations = vacationDao.displayVacation();
		return vacations;
	}

}
