package com.woniuxy.oasystem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.OfficeSuppliesBuy;
import com.woniuxy.oasystem.entity.PageBean;

/**
 * 
 * @Description 办公用品请购业务
 * @author 张钰平
 * @changeLog 1. 创建 (2020年4月26日 [张钰平])
 *
 */
public interface OfficeSuppliesBuyService {
	//展示所有办公用品
	PageBean<OfficeSuppliesBuy> findAllByPage(OfficeSuppliesBuy officeSuppliesBuy,int pageIndex,int pageSize);
	// 根据osbId删除
	void deleteByOsbId(int osbId);

	// 根据osbId修改
	void updateByOsbId(OfficeSuppliesBuy officeSuppliesBuy);

	// 添加办公用品
	void insert(OfficeSuppliesBuy officeSuppliesBuy);
}
