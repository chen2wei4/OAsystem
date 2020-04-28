package com.woniuxy.oasystem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.CarApply;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.entity.ReturnRegister;

/**
 * 
 * @Description 车辆归还登记业务
 * @author 张钰平
 * @changeLog 1. 创建 (2020年4月26日 [张钰平])
 *
 */
public interface ReturnRegisterService {
	//展示所有车辆归还登记
	PageBean<ReturnRegister> findAllByPage(ReturnRegister returnRegister,int pageIndex,int pageSize);
	// 根据rrId删除
	void deleteByRrId(int rrId);

	// 根据rrId修改
	void updateByRrId(ReturnRegister returnRegister);

	// 添加
	void insert(ReturnRegister returnRegister);

}
