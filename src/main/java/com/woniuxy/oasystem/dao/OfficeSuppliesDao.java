package com.woniuxy.oasystem.dao;

import java.util.List;

import com.woniuxy.oasystem.entity.OfficeSupplies;

public interface OfficeSuppliesDao {
	//展示所有办公用品
	List<OfficeSupplies> findAll();
}
