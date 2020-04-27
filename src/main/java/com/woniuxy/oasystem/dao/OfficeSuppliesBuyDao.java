package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.OfficeSuppliesBuy;
/**
 * 
 * @Description  办公用品请购dao
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月23日 [张钰平])
 *
 */
public interface OfficeSuppliesBuyDao {
	//展示所有办公用品
	List<OfficeSuppliesBuy> findAllByPage(@Param("osb")OfficeSuppliesBuy officeSuppliesBuy,@Param("pageIndex")int pageIndex,
			@Param("pageSize")int pageSize);
	int findAllByPageCount(@Param("osb")OfficeSuppliesBuy officeSuppliesBuy);
	//根据osbId删除
	void deleteByOsbId(int osbId);
	//根据osbId修改
	void updateByOsbId(@Param("osb")OfficeSuppliesBuy officeSuppliesBuy);
	//添加办公用品
	void insert(@Param("osb")OfficeSuppliesBuy officeSuppliesBuy);
}
