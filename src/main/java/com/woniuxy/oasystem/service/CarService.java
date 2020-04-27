package com.woniuxy.oasystem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.PageBean;

/**
 * 
 * @Description 车辆管理业务
 * @author 张钰平
 * @changeLog 1. 创建 (2020年4月26日 [张钰平])
 *
 */
public interface CarService {
	//展示所有办公用品
	PageBean<Car> findAllByPage(Car car,int pageIndex,int pageSize);
	// 根据carId删除
	void deleteByCarId(int carId);

	// 根据carId修改
	void updateByCarId(Car car);

	// 添加办公用品
	void insert(Car car);

}
