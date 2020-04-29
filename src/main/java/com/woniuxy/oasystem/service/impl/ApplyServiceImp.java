/**
 * 
 */
package com.woniuxy.oasystem.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.oasystem.dao.ApplyDao;
import com.woniuxy.oasystem.entity.Apply;
import com.woniuxy.oasystem.entity.Applytype;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.Information;
import com.woniuxy.oasystem.service.ApplyService;
import com.woniuxy.oasystem.util.Pager;

/**
 * @author THY
 *
 */
@Service
public class ApplyServiceImp implements ApplyService{
	@Autowired
	 ApplyDao applyDao;
	
	
	public void setApplyDao(ApplyDao applyDao) {
		this.applyDao = applyDao;
	}

	//查询所有员工申请
	@Override
	public Pager queryApplys(Integer pageNum) {
		 // 掉用分页方法当前页，及每页数
		PageHelper.startPage(pageNum,5);
		//写在分页下面
		  List<Apply> ay=applyDao.queryApplys();
		
		  //分页数组转化为申请数组,设置导航栏条数
		   PageInfo<Apply> ita = new PageInfo<>(ay,10);
		      List<Apply> it=ita.getList();
	
		      
		    //分页对象
		     Pager pager=new Pager();
		     //分页集合
		     pager.setPageList(it);
		     //首页
		     pager.setPageBegin(ita.getNavigateFirstPage());
		     //末页  
		     pager.setPageEnd(ita.getNavigateLastPage());
		     // 总页数
		     pager.setTotalPage(ita.getPages());
		     //当前页
		     ita.setPageNum(pageNum);
		     pager.setPageIndex(pageNum);
		    // 总条数
		    pager.setTotal(ita.getTotal());
		   
		  return pager;
	}
	//发出申请
	@Override
	public void addApply(Integer empId,Integer applytypeId,String applyContent) {
		
		 applyDao.addApply(empId, applytypeId, applyContent);
	}
     
	//删除申请
	@Override
	public void deleteApplys(List<Integer> applyIds){
		 applyDao.deleteApplys(applyIds);
	}

	
	//批准申请
	@Override
	public void approvals(List<Integer> applyIds) {
		applyDao.approvals(applyIds);
	}


}
