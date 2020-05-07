package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.CarApply;
import com.woniuxy.oasystem.entity.OfficeSupplies;
/**
 * 
 * @Description  车辆申请dao
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
 *
 */
public interface CarApplyDao {
	//展示所有车辆申请
	List<CarApply> findAllByPage(@Param("ca")CarApply carApply,@Param("pageIndex")int pageIndex,
			@Param("pageSize")int pageSize);
	int findAllByPageCount(@Param("ca")CarApply carApply);
	//根据caId删除
	void deleteByCaId(int caId);
	//根据caId修改
	void updateByCaId(@Param("ca")CarApply carApply);
	//添加办公用品
	void insert(@Param("ca")CarApply carApply);
}
