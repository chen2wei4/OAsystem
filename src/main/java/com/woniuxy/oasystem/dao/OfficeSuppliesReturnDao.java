package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.OfficeSuppliesApply;
import com.woniuxy.oasystem.entity.OfficeSuppliesReturn;
/**
 * 
 * @Description  办公用品归还dao
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月24日 [张钰平])
 *
 */
public interface OfficeSuppliesReturnDao {
	//展示所有办公用品
	List<OfficeSuppliesReturn> findAllByPage(@Param("osr")OfficeSuppliesReturn officeSuppliesReturn,@Param("pageIndex")int pageIndex,
			@Param("pageSize")int pageSize);
	int findAllByPageCount(@Param("osr")OfficeSuppliesReturn officeSuppliesReturn);
	//根据osrId删除
	void deleteByOsrId(int osrId);
	//根据osrId修改
	void updateByOsrId(@Param("osr")OfficeSuppliesReturn officeSuppliesReturn);
	//添加办公用品
	void insert(@Param("osr")OfficeSuppliesReturn officeSuppliesReturn);
}
