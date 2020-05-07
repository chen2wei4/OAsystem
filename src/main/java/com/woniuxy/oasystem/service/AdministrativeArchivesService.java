package com.woniuxy.oasystem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.AdministrativeArchives;
import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.PageBean;

/**
 * 
 * @Description 行政档案业务
 * @author 张钰平
 * @changeLog 1. 创建 (2020年4月26日 [张钰平])
 *
 */
public interface AdministrativeArchivesService {
	//展示所有行政档案
	PageBean<AdministrativeArchives> findAllByPage(AdministrativeArchives administrativeArchives,int pageIndex,int pageSize);
	// 根据aaId删除
	void deleteByAaId(int aaId);

	// 根据aaId修改
	void updateByAaId(AdministrativeArchives administrativeArchives);

	// 添加行政档案
	void insert(AdministrativeArchives administrativeArchives);

}
