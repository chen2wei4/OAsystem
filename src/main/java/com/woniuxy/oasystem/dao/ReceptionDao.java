package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Department;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.Reception;

@Mapper
public interface ReceptionDao {
	 //查询接待内容
	Reception queryRecptions(@Param("empId")Integer empId);
	 //发送接待内容
	 void  addReception(@Param("reception")Reception reception);
	 //完成接待
	 void  okReception(@Param("receptionId")Integer receptionId);
}
