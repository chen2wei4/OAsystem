/**  
 * @author 张钰平
 * @createDate 2020年4月24日
 */

package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.OfficeSuppliesApplyDao;
import com.woniuxy.oasystem.dao.OfficeSuppliesReturnDao;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.OfficeSuppliesApply;
import com.woniuxy.oasystem.entity.OfficeSuppliesReturn;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.OfficeSuppliesApplyService;
import com.woniuxy.oasystem.service.OfficeSuppliesReturnService;

/**  
 * @Description  TODO
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月24日 [张钰平])
 *              
 */
@Service
public class OfficeSuppliesReturnServiceImpl implements OfficeSuppliesReturnService{
	@Autowired
	OfficeSuppliesReturnDao officeSuppliesReturnDao;
	
	
	@Override
	public PageBean<OfficeSuppliesReturn> findAllByPage(OfficeSuppliesReturn officeSuppliesReturn, int pageIndex,
			int pageSize) {
		
		PageBean<OfficeSuppliesReturn> pb = new PageBean<OfficeSuppliesReturn>();
		List<OfficeSuppliesReturn> beanList = officeSuppliesReturnDao.findAllByPage(officeSuppliesReturn, (pageIndex-1)*pageSize, pageSize);
		pb.setBeanList(beanList);	
		pb.setPageIndex(pageIndex);
		pb.setPageSize(pageSize);
		int totalRecord = officeSuppliesReturnDao.findAllByPageCount(officeSuppliesReturn);
		pb.setTotalRecord(totalRecord);
		pb.setTotalPage((totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1);
		pb.setPageBeginAndPageEnd();
		return pb;
	}

	@Override
	public void deleteByOsrId(int osrId) {
		officeSuppliesReturnDao.deleteByOsrId(osrId);		
	}

	@Override
	public void updateByOsrId(OfficeSuppliesReturn officeSuppliesReturn) {
		officeSuppliesReturnDao.updateByOsrId(officeSuppliesReturn);
		
	}

	@Override
	public void insert(OfficeSuppliesReturn officeSuppliesReturn) {
		officeSuppliesReturnDao.insert(officeSuppliesReturn);
		
	}

}
