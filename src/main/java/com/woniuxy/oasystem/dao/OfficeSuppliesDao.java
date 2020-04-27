package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.OfficeSupplies;
/**
 * 
 * @Description  办公用品dao
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月23日 [张钰平])
 *
 */
public interface OfficeSuppliesDao {
	//展示所有办公用品
	List<OfficeSupplies> findAllByPage(@Param("os")OfficeSupplies officeSupplies,@Param("pageIndex")int pageIndex,
			@Param("pageSize")int pageSize);
	int findAllByPageCount(@Param("os")OfficeSupplies officeSupplies);
	//根据osId删除
	void deleteByOsId(int osId);
	//根据osId修改
	void updateByOsId(@Param("os")OfficeSupplies officeSupplies);
	//添加办公用品
	void insert(@Param("os")OfficeSupplies officeSupplies);
}
