package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.Information;

public interface InformationDao {
	//查询所有被留言
    List<Information> queryInformations(Integer did);
    
    //发送留言
  void  addInformation(@Param("information") Information information,@Param("bemp") List<Emp> bemp);
    
  //删除留言
  void deleteInformation(List<Integer> informationIds);
}
