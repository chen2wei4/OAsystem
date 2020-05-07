package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.AdministrativeArchives;
import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.OfficeSupplies;
/**
 * 
 * @Description  行政档案dao
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
 *
 */
public interface AdministrativeArchivesDao {
	//展示所有行政档案
	List<AdministrativeArchives> findAllByPage(@Param("aa")AdministrativeArchives administractiveArchives,@Param("pageIndex")int pageIndex,
			@Param("pageSize")int pageSize);
	int findAllByPageCount(@Param("aa")AdministrativeArchives administractiveArchives);
	//根据aaId删除
	void deleteByAaId(int aaId);
	//根据aaId修改
	void updateByAaId(@Param("aa")AdministrativeArchives administractiveArchives);
	//添加行政档案
	void insert(@Param("aa")AdministrativeArchives administractiveArchives);
	//添加文件名和文件地址
	void insertFile(@Param("fileName")String fileName,@Param("fileAddress")String fileAddress,@Param("aaId")Integer aaId);
}
