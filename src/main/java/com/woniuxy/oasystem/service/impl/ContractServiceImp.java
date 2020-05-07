package com.woniuxy.oasystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.ContractDao;
import com.woniuxy.oasystem.dao.MyCustomerDao;
import com.woniuxy.oasystem.entity.Contract;
import com.woniuxy.oasystem.entity.Customer;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.ContractService;
import com.woniuxy.oasystem.service.CustomerService;
import com.woniuxy.oasystem.service.MyCustomerService;
/**
 * 
 * @Description 客户信息接口实现类
 * @author 陈一玮
 * @changeLog 1.创建 (2020年4月25日 下午3:00:53 [陈一玮]
 *            2.
 */
@Service
public class ContractServiceImp implements ContractService {
	@Autowired
	ContractDao contractDao;
	@Autowired
	PageBean<Contract> pb;
	/**
	  * 查询所有的合同信息
	  */
	@Override
	public PageBean<Contract> showContracts(Contract contract, Integer currentPage) {
		List<Contract> contracts = contractDao.showContracts(contract, (currentPage-1)*10);
		Integer totalData = contractDao.getContractTotalData(contract);
		//查询到的客户信息
		pb.setBeanList(contracts);
		//设置分页大小
		pb.setPageSize(10);
		//设置当前页码
		pb.setPageIndex(currentPage);
		//设置数据总条数
		pb.setTotalRecord(totalData);
		//设置总页码
		pb.setTotalPage((totalData%10==0)?(totalData/10):(totalData/10+1));
		//设置起始页码和结束页码
		pb.setBeginPageAndEndPage();
		return pb;
	}
	/**
	    * 新增一条合同信息
	  */
	@Override
	public void newContract(Contract contract) {
		contractDao.newContract(contract);
	}
	 /** 
	  * 删除复选框选中的合同信息
	 */
	@Override
	public void deleteCheckedContract(Integer[] ids) {
		contractDao.deleteCheckedContract(ids);
	}
	 /** 
	  * 查找一条指定的合同信息
	 */
	@Override
	public Contract showContract(Integer contractId) {
		Contract contract=contractDao.showContract(contractId);
		return contract;
	}
	/**
	    * 更改一条合同信息
	  */
	@Override
	public void updateContract(Contract contract) {
		contractDao.updateContract(contract);
		
	}
	/**
	  * 删除一条合同信息
	 */
	@Override
	public void deleteContract(Integer contractId) {
		contractDao.deleteContract(contractId);
	}
	/**
	 * 通过合同号模糊获取合同ID
	 */
	@Override
	public List<Integer> getContractIdByNumber(String contractNumber) {
		List<Integer> contractId=contractDao.getContractIdByNumber(contractNumber);
		return contractId;
	}
	/**
	 * 通过合同号获取合同ID
	 */
	@Override
	public Integer getOneContractIdByNumber(String contractNumber) {
		Integer contractId=contractDao.getOneContractIdByNumber(contractNumber);
		return contractId;
	}
	
}
