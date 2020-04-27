package com.woniuxy.oasystem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.CarApply;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.PageBean;

/**
 * 
 * @Description 车辆申请业务
 * @author 张钰平
 * @changeLog 1. 创建 (2020年4月26日 [张钰平])
 *
 */
public interface CarApplyService {
	//展示所有车辆申请
	PageBean<CarApply> findAllByPage(CarApply car,int pageIndex,int pageSize);
	// 根据caId删除
	void deleteByCaId(int caId);

	// 根据caId修改
	void updateByCaId(CarApply car);

	// 添加车辆申请
	void insert(CarApply car);

}
