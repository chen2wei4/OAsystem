/**  
 * @author 王培霖
 * @createDate 2020年5月3日
 */

package com.woniuxy.oasystem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.CheckIn;
import com.woniuxy.oasystem.entity.PageBean;

/**  
 * @Description  TODO
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年5月3日 下午6:33:48 [王培霖])
 *                      	2.
 */

public interface CheckInService {
	/**
	 *  分页展示全部签到记录
	 * @param checkIn
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @changeLog 	1. 创建 (2020年5月3日 下午5:29:19 [王培霖])  </br>
	 *                      	2.
	 */
	PageBean<CheckIn> selectCheckInByPage(
			@Param("checkIn")CheckIn checkIn,
			@Param("pageIndex")int pageIndex,
			@Param("pageSize")int pageSize);
	
	/**
	 *  模糊查询打卡记录
	 * @param parameter
	 * @param checkIn
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @changeLog 	1. 创建 (2020年5月3日 下午11:39:19 [王培霖])  </br>
	 *                      	2.
	 */
	PageBean<CheckIn> searchCheckIn(String parameter,
			@Param("checkIn")CheckIn checkIn,
			@Param("pageIndex")int pageIndex,
			@Param("pageSize")int pageSize);
}
