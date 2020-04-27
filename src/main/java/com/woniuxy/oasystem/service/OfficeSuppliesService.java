package com.woniuxy.oasystem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.PageBean;

/**
 * 
 * @Description 办公用品业务
 * @author 张钰平
 * @changeLog 1. 创建 (2020年4月23日 [张钰平])
 *
 */
public interface OfficeSuppliesService {
	//展示所有办公用品
	PageBean<OfficeSupplies> findAllByPage(OfficeSupplies officeSupplies,int pageIndex,int pageSize);
	// 根据osId删除
	void deleteByOsId(int osId);

	// 根据osId修改
	void updateByOsId(OfficeSupplies officeSupplies);

	// 添加办公用品
	void insert(OfficeSupplies officeSupplies);
}
