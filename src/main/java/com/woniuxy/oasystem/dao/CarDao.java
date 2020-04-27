package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.OfficeSupplies;
/**
 * 
 * @Description  车辆dao
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
 *
 */
public interface CarDao {
	//展示所有车辆
	List<Car> findAllByPage(@Param("car")Car car,@Param("pageIndex")int pageIndex,
			@Param("pageSize")int pageSize);
	int findAllByPageCount(@Param("car")Car car);
	//根据carId删除
	void deleteByCarId(int carId);
	//根据carId修改
	void updateByCarId(@Param("car")Car car);
	//添加办公用品
	void insert(@Param("car")Car car);
}
