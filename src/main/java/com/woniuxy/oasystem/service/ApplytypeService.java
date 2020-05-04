/**
 * 
 */
package com.woniuxy.oasystem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Apply;
import com.woniuxy.oasystem.entity.Applytype;

/**
 * @author THY
 *
 */
public interface ApplytypeService {
	 
	//查询所有申请类型
    List<Applytype> queryApplytypes();
}
