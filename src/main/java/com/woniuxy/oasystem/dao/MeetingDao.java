package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.CarApply;
import com.woniuxy.oasystem.entity.Meeting;
import com.woniuxy.oasystem.entity.OfficeSupplies;
/**
 * 
 * @Description  会议管理dao
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
 *
 */
public interface MeetingDao {
	//展示所有会议
	List<Meeting> findAllByPage(@Param("m")Meeting meeting,@Param("pageIndex")int pageIndex,
			@Param("pageSize")int pageSize);
	int findAllByPageCount(@Param("m")Meeting meeting);
	//根据mid删除
	void deleteByMid(int caId);
	//根据midd修改
	void updateByMid(@Param("m")Meeting meeting);
	//添加
	void insert(@Param("m")Meeting meeting);
}
