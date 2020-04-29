/**
 * 
 */
package com.woniuxy.oasystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.oasystem.dao.EmpDao;
import com.woniuxy.oasystem.dao.InformationDao;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.Information;
import com.woniuxy.oasystem.service.InformationService;
import com.woniuxy.oasystem.util.Pager;

/**
 * @author THY
 *
 */
@Service
public class InformationServiceImp implements InformationService{
     
	@Autowired
	InformationDao  informationDao;
	
	@Autowired
	EmpDao empdao;
	
	
	public void setInformationDao(InformationDao informationDao) {
		this.informationDao = informationDao;
	}
	

	public EmpDao getEmpdao() {
		return empdao;
	}


	public void setEmpdao(EmpDao empdao) {
		this.empdao = empdao;
	}


	//查看当前用户留言
	@Override
	public Pager queryInformations(Integer did,Integer pageNum) {
		 // 掉用分页方法当前页，及每页数
			PageHelper.startPage(pageNum,2);
			//写在分页下面
	List<Information>  ly=informationDao.queryInformations(did);
		//返回来的只有留言人id
	for (Information information : ly) {
		Integer empId=information.getEmp().getEmpId();
		    //根据留言人id,查询留言人对象，从而获得留言人姓名
		   //information.setEmp(EmpDao.queryEmp(empId));
	       //临时
		    Emp emp=empdao.getEmpId(empId);
		   information.setEmp(emp);
	 }
  			//分页数组转化为留言数组
  		   PageInfo<Information> ita = new PageInfo<>(ly,10);
  		      List<Information> it=ita.getList();
  		      
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
  		     pager.setPageIndex(pageNum);
		    // 总条数
  		    pager.setTotal(ita.getTotal());
  			
		   return   pager;
	}

	//发起单个或群体留言
	@Override
	public void addInformation(Integer empId, String informationContent, Integer bid) {
		//根据留言人id,查询留言人对象
		Emp emp=empdao.getEmpId(empId);	    
	    //创建被留言人对象集合,只存放id
	    //如果等于9999查询所有员工id,群发
	    List<Emp> bemp=new ArrayList<Emp>();
	    //群留
      	if(bid==9999){
      		bemp=empdao.getEmps();
  		 }
	    else {
	    	//单留
	    	Emp emp2=empdao.getEmpId(bid);
	    	bemp.add(emp2);
	    }
		Information thy=new Information(null,emp,null,informationContent,null);
		informationDao.addInformation(thy,bemp);
	}

	/* (non-Javadoc)
	 * @see com.woniuxy.oasystem.service.InformationService#deleteInformation(java.util.List)
	 */
	//删除留言
	@Override
	public void deleteInformation(List<Integer> informationIds) {
		informationDao.deleteInformation(informationIds);
		
	}


	/* (non-Javadoc)
	 * @see com.woniuxy.oasystem.service.InformationService#queryemps()
	 */
	@Override
	public List<Emp> queryemps() {
		return empdao.getEmps();
	}

}
