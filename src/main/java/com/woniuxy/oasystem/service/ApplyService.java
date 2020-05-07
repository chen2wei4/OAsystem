/**
 * 
 */
package com.woniuxy.oasystem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Apply;
import com.woniuxy.oasystem.entity.Applytype;
import com.woniuxy.oasystem.util.Pager;

/**
 * @author THY
 *
 */
public interface ApplyService {
	 //查询所有申请
	 Pager queryApplys(Integer pageNum);
	 //发出申请,员工id,类型id,申请内容
	 void addApply(Integer empId,Integer applytypeId,String applyContent);
	//删除申请
	 void deleteApplys(List<Integer> applyIds);
	 //批准申请
	 void  approvals(List<Integer> applyIds);
}
