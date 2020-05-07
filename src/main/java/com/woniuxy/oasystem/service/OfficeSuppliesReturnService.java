/**  
 * @author 张钰平
 * @createDate 2020年4月24日
 */

package com.woniuxy.oasystem.service;


import com.woniuxy.oasystem.entity.OfficeSuppliesReturn;
import com.woniuxy.oasystem.entity.PageBean;

/**  
 * @Description  办公用品归还业务
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月24日 [张钰平])
 *              
 */

public interface OfficeSuppliesReturnService {
	//展示所有办公用品申请
	PageBean<OfficeSuppliesReturn> findAllByPage(OfficeSuppliesReturn officeSuppliesReturn,int pageIndex,int pageSize);
	// 根据osrId删除
	void deleteByOsrId(int osrId);

	// 根据osrId修改
	void updateByOsrId(OfficeSuppliesReturn officeSuppliesReturn);

	// 添加办公用品
	void insert(OfficeSuppliesReturn officeSuppliesReturn);
	
}
