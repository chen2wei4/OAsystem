package com.woniuxy.oasystem.dao;

import com.woniuxy.oasystem.entity.Emp;
import org.apache.ibatis.annotations.Param;

public interface MyInfoDao {
    void ChangeInfo(@Param("emp")Emp emp);
    Emp getEmpById(@Param("id")Integer id);
}
