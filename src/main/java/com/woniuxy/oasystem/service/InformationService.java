/**
 * 
 */
package com.woniuxy.oasystem.service;

import java.util.List;

import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.util.Pager;

/**
 * @author THY
 *
 */
public interface InformationService {
	//查询所有被留言
	Pager queryInformations(Integer did,Integer pageNum);
    
    //发送留言,留言人id，留言内容，被留言人id集合
   void  addInformation(Integer empId,String informationContent,Integer bid);
   
   //删除留言
   void deleteInformation(List<Integer> informationIds);
   
   //查询所有可被留言员工
   List<Emp> queryemps();
   
}
