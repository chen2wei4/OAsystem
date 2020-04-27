/**  
 * @author 张钰平
 * @createDate 2020年4月24日
 */

package com.woniuxy.oasystem.service;

import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.OfficeSuppliesApply;
import com.woniuxy.oasystem.entity.PageBean;

/**  
 * @Description  办公用品申请业务
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月24日 [张钰平])
 *              
 */

public interface OfficeSuppliesApplyService {
	//展示所有办公用品申请
	PageBean<OfficeSuppliesApply> findAllByPage(OfficeSuppliesApply officeSuppliesApply,int pageIndex,int pageSize);
	// 根据osaId删除
	void deleteByOsaId(int osaId);

	// 根据osaId修改
	void updateByOsaId(OfficeSuppliesApply officeSuppliesApply);

	// 添加办公用品
	void insert(OfficeSuppliesApply officeSuppliesApply);
}
