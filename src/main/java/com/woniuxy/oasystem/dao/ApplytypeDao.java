/**
 *
 */
package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.woniuxy.oasystem.entity.Applytype;

/**
 * @author THY唐昊宇事务模块
 *
 */
@Mapper
public interface ApplytypeDao{
	//查询所有申请类型
	List<Applytype> queryApplytypes();
}
