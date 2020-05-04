/**
 * 
 */
package com.woniuxy.oasystem.service;

import java.util.List;

import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.Reception;

/**
 * @author THY
 *
 */
public interface ReceptionService {
	 //查询接待内容
	Reception queryRecptions(Integer empId);
	 //发送接待内容，接待人id,接待内容，接待时间
	 void addReception(Integer empId,String receptionContent,String receptionTime);
      //完成接待
	 void okReception(Integer receptionId);
	 //查询所有接待员工
	  List<Emp> queryReceptionEmp();
}
