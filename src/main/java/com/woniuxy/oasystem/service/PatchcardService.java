/**
 * 
 */
package com.woniuxy.oasystem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.Patchcard;
import com.woniuxy.oasystem.util.Pager;

/**
 * @author THY
 *
 */
public interface PatchcardService {
	 //查询所有的签到记录,带条件查询，根据id查员工对象，和部门id
	   Pager queryPatchcards(String empName,String departmentName,Integer pageNum);
	   
	   //签到增加,根据员工id查对象，获得部门，接收补签原因
	   void addPatchcard(Integer empId,String patchcardContent);
}
