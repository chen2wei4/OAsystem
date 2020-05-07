/**
 * @author 陈一玮
 * @createDate 2020年4月24日
 */
package com.woniuxy.oasystem.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Contract;
import com.woniuxy.oasystem.entity.PageBean;

/**
 * @Description 我的合同信息的服务层接口
 * @author 陈一玮
 * @changeLog 1.创建 (2020年4月24日 下午5:08:08 [陈一玮]
 *            2.
 */
public interface ContractService {
	/**
	  * 查询所有的合同信息
	 * @param contract 搜索引擎的查询条件
	 * @param currentPage 当前页码
	 * @return 返回合同信息的集合
	 * @changeLog 1.创建 (2020年4月29日 下午2:27:43 [陈一玮]
	 *            2.
	 */
	PageBean<Contract> showContracts(Contract contract,Integer currentPage);
	/**
	  * 新增一条合同信息
	 * @param customer 需要新增的合同信息
	 * @changeLog 1.创建 (2020年4月27日 上午10:44:02 [陈一玮]
	 *            2.
	 */
	void newContract(Contract contract);
	/**
	  * 删除复选框选中的合同信息
	 * @param ids 合同信息id数组
	 * @changeLog 1.创建 (2020年4月29日 下午8:46:20 [陈一玮]
	 *            2.
	 */
	void deleteCheckedContract(Integer[] ids);
	/**
	  * 根据合同信息Id查询一条指定的合同信息
	 * @param contractId 查询条件，合同信息id
	 * @return 返回一条指定的合同信息
	 * @changeLog 1.创建 (2020年4月30日 上午10:13:34 [陈一玮]
	 *            2.
	 */
	Contract showContract(Integer contractId);
	/**
	  * 更改一条合同信息
	 * @param contract 需要更改的合同信息
	 * @changeLog 1.创建 (2020年4月30日 上午11:04:09 [陈一玮]
	 *            2.
	 */
	void updateContract(Contract contract);
	/**
	  * 删除一条合同信息
	 * @param 需要删除的合同编号id
	 * @changeLog 1.创建 (2020年4月30日 上午11:38:41 [陈一玮]
	 *            2.
	 */
	void deleteContract(Integer contractId);
	/**
	 * 通过合同号获取合同ID
	 * @param contractNumber 合同号
	 * @return 返回合同id
	 * @changeLog 1.创建 (2020年5月3日 下午9:52:38 [陈一玮]
	 *            2.
	 */
	List<Integer> getContractIdByNumber(String contractNumber);
	Integer getOneContractIdByNumber(String contractNumber);
}
