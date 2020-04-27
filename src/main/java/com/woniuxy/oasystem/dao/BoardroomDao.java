package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Boardroom;
import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.CarApply;
import com.woniuxy.oasystem.entity.OfficeSupplies;
/**
 * 
 * @Description  会议室dao
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
 *
 */
public interface BoardroomDao {
	//展示所有会议室
	List<Boardroom> findAllByPage(@Param("b")Boardroom boardroom,@Param("pageIndex")int pageIndex,
			@Param("pageSize")int pageSize);
	int findAllByPageCount(@Param("b")Boardroom boardroom);
	//根据BoardroomId删除
	void deleteByBoardroomId(int boardroomId);
	//根据BoardroomId修改
	void updateByBoardroomId(@Param("b")Boardroom boardroom);
	//添加办公用品
	void insert(@Param("b")Boardroom boardroom);
}
