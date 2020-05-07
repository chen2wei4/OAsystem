package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Department;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.Patchcard;

@Mapper
public interface PatchcardDao {
   //查询所有的签到记录,带条件查询，姓名，和按部门id查询
   List<Patchcard> queryPatchcards(@Param("empName") String empName,@Param("departmentName") String departmentName);
   
   //签到增加
   void addPatchcard(@Param("patchcard") Patchcard patchcard);
}
