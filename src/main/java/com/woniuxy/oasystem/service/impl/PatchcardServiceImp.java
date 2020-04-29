/**
 * 
 */
package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.oasystem.dao.EmpDao;
import com.woniuxy.oasystem.dao.PatchcardDao;
import com.woniuxy.oasystem.entity.Apply;
import com.woniuxy.oasystem.entity.Department;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.Patchcard;
import com.woniuxy.oasystem.service.PatchcardService;
import com.woniuxy.oasystem.util.Pager;

/**
 * @author THY
 *
 */
@Service
public class PatchcardServiceImp implements PatchcardService{
	
	@Autowired
	PatchcardDao  PatchcardDao;
	
	@Autowired
	EmpDao empDao;
	

	
	public void setPatchcardDao(PatchcardDao patchcardDao) {
		PatchcardDao = patchcardDao;
	}

	  
	
     public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}



	//查询所有补签或带条件
	@Override
	public Pager queryPatchcards(String empName,String departmentName,Integer pageNum) {
					
		 // 掉用分页方法当前页，及每页数
		PageHelper.startPage(pageNum,3);
		//写在分页下面,条件是姓名，和部门id
		 List<Patchcard> pt=PatchcardDao.queryPatchcards(empName, departmentName);
		
		  //分页数组转化为申请数组,设置导航栏条数
		   PageInfo<Patchcard> ita = new PageInfo<>(pt,10);
		      List<Patchcard> it=ita.getList();
	
		      
		    //分页对象
		     Pager pager=new Pager();
		     //分页集合
		     pager.setPageList(it);
		     //首页n
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

	 //补签对象
	@Override
	public void addPatchcard(Integer empId, String patchcardContent) {
		//根据id查询查询员工
		 //Emp emp=empDao.queryEmp(empId);
		//根据员工对象取出部门对象赋给补签对象
	    //Department department=emp.getDepartment();
	
		 Emp emp=empDao.getEmpId(empId);
		
		 //创建补签到对象
		Patchcard patchcard=new Patchcard();
	    patchcard.setDepartment(emp.getDepartment());
		patchcard.setEmp(emp);
		patchcard.setPatchcardContent(patchcardContent);
		PatchcardDao.addPatchcard(patchcard);
	}

}
