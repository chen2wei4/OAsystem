package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.OfficeSuppliesApply;
/**
 * 
 * @Description  办公用品申请dao
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月23日 [张钰平])
 *
 */
public interface OfficeSuppliesApplyDao {
	//展示所有办公用品
	List<OfficeSuppliesApply> findAllByPage(@Param("osa")OfficeSuppliesApply officeSuppliesApply,@Param("pageIndex")int pageIndex,
			@Param("pageSize")int pageSize);
	int findAllByPageCount(@Param("osa")OfficeSuppliesApply officeSuppliesApply);
	//根据osaId删除
	void deleteByOsaId(int osaId);
	//根据osaId修改
	void updateByOsaId(@Param("osa")OfficeSuppliesApply officeSuppliesApply);
	//添加办公用品
	void insert(@Param("osa")OfficeSuppliesApply officeSuppliesApply);
}
