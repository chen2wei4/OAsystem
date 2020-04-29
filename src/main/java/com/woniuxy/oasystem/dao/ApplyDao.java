package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Apply;
import com.woniuxy.oasystem.entity.Applytype;
import com.woniuxy.oasystem.entity.Department;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.Reception;

@Mapper
public interface ApplyDao {
	 //查询所有申请
	 List<Apply> queryApplys();
	 //发出申请
	 void addApply(@Param("empId") Integer empId,@Param("applytypeId") Integer applytypeId,@Param("applyContent") String applyContent);
	//删除申请
	 void deleteApplys(List<Integer> applyIds);
	 //批准
	 void  approvals(List<Integer> applyIds);

	             
}
