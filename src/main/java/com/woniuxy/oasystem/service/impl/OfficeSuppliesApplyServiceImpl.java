/**  
 * @author 张钰平
 * @createDate 2020年4月24日
 */

package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.OfficeSuppliesApplyDao;
import com.woniuxy.oasystem.entity.Meeting;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.OfficeSuppliesApply;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.OfficeSuppliesApplyService;

/**  
 * @Description  TODO
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月24日 [张钰平])
 *              
 */
@Service
public class OfficeSuppliesApplyServiceImpl implements OfficeSuppliesApplyService{
	@Autowired
	OfficeSuppliesApplyDao officeSuppliesApplyDao;
	
	
	@Override
	public PageBean<OfficeSuppliesApply> findAllByPage(OfficeSuppliesApply officeSuppliesApply, int pageIndex,
			int pageSize) {
		PageBean<OfficeSuppliesApply> pb = new PageBean<OfficeSuppliesApply>();
		List<OfficeSuppliesApply> beanList = officeSuppliesApplyDao.findAllByPage(officeSuppliesApply, (pageIndex-1)*pageSize, pageSize);
		pb.setBeanList(beanList);	
		for (OfficeSuppliesApply l : pb.getBeanList()) {
			System.out.println(l);
		}
		pb.setPageIndex(pageIndex);
		pb.setPageSize(pageSize);
		int totalRecord = officeSuppliesApplyDao.findAllByPageCount(officeSuppliesApply);
		pb.setTotalRecord(totalRecord);
		pb.setTotalPage((totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1);
		pb.setPageBeginAndPageEnd();
		return pb;
	}

	@Override
	public void deleteByOsaId(int osaId) {
		officeSuppliesApplyDao.deleteByOsaId(osaId);		
	}

	@Override
	public void updateByOsaId(OfficeSuppliesApply officeSuppliesApply) {
		officeSuppliesApplyDao.updateByOsaId(officeSuppliesApply);
		
	}

	@Override
	public void insert(OfficeSuppliesApply officeSuppliesApply) {
		officeSuppliesApplyDao.insert(officeSuppliesApply);
		
	}

}
