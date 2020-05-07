/**  
 * @author 王培霖
 * @createDate 2020年5月3日
 */

package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.CheckIn;
import com.woniuxy.oasystem.entity.Emp;

/**  
 * @Description  TODO
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年5月3日 下午5:25:29 [王培霖])
 *                      	2.
 */

public interface CheckInDao {
	/**
	 *  分页展示全部签到记录
	 * @param checkIn
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @changeLog 	1. 创建 (2020年5月3日 下午5:29:19 [王培霖])  </br>
	 */
	List<CheckIn> selectCheckInByPage(
			@Param("checkIn")CheckIn checkIn,
			@Param("pageIndex")int pageIndex,
			@Param("pageSize")int pageSize);
	
	/**
	 *  查询满足条件的数据条数
	 * @param checkIn
	 * @param parameter
	 * @return
	 * @changeLog 	1. 创建 (2020年5月3日 下午7:37:33 [王培霖])  </br>
	 */
	int countByPage(@Param("checkIn")CheckIn checkIn,
			@Param("parameter")String parameter);
	
	/**
	 *  模糊查询打卡记录 
	 * @param parameter
	 * @return
	 * @changeLog 	1. 创建 (2020年5月3日 下午11:30:06 [王培霖])  </br>
	 */
	List<CheckIn> searchCheckIn(String parameter,
			@Param("checkIn")CheckIn checkIn,
			@Param("pageIndex")int pageIndex,
			@Param("pageSize")int pageSize);
}
