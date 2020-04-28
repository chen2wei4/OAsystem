package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.CarApply;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.ReturnRegister;
/**
 * 
 * @Description  车辆归还登记dao
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
 *
 */
public interface ReturnRegisterDao {
	//展示所有归还登记
	List<ReturnRegister> findAllByPage(@Param("rr")ReturnRegister returnRegister,@Param("pageIndex")int pageIndex,
			@Param("pageSize")int pageSize);
	int findAllByPageCount(@Param("rr")ReturnRegister returnRegister);
	//根据rrId删除
	void deleteByRrId(int rrId);
	//根据rrId修改
	void updateByRrId(@Param("rr")ReturnRegister returnRegister);
	//添加
	void insert(@Param("rr")ReturnRegister returnRegister);
}
