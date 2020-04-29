/**
 * 
 */
package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.ApplyDao;
import com.woniuxy.oasystem.dao.ApplytypeDao;
import com.woniuxy.oasystem.entity.Apply;
import com.woniuxy.oasystem.entity.Applytype;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.service.ApplyService;
import com.woniuxy.oasystem.service.ApplytypeService;

/**
 * @author THY
 *
 */
@Service
public class ApplytypeServiceImp implements ApplytypeService{
	@Autowired
	ApplytypeDao   applytypeDao;
	

	public void setApplytypeDao(ApplytypeDao applytypeDao) {
		this.applytypeDao = applytypeDao;
	}


	/* (non-Javadoc)
	 * @see com.woniuxy.oasystem.service.ApplyService#queryApplytypes()
	 */
	@Override
	public List<Applytype> queryApplytypes() {		
		return  applytypeDao.queryApplytypes();
	}

}
