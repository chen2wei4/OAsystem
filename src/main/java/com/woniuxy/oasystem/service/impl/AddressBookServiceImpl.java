package com.woniuxy.oasystem.service.impl;

import java.util.List;

import com.woniuxy.oasystem.entity.Customer;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.woniuxy.oasystem.dao.AddressBookDao;
import com.woniuxy.oasystem.dao.EmpDao;
import com.woniuxy.oasystem.entity.AddressBook;
import com.woniuxy.oasystem.service.AddressBookService;

@Service
public class AddressBookServiceImpl implements AddressBookService{

	@Autowired
	AddressBookDao addrDao;
	@Autowired
	EmpDao empDao;
	@Autowired
	PageBean<AddressBook> pb;

	@Override
	public void addAddressBook(AddressBook addressBook) {
		addrDao.addAddressBook(addressBook);
	}

	@Override
	public void deleteAddressBook(AddressBook addressBook) {
		addrDao.deleteAddressBook(addressBook);
	}

	@Override
	public void changeAddressBook(AddressBook addressBook) {
		addrDao.changeAddressBook(addressBook);
	}

	@Override
	public List<AddressBook> getAddressBook(AddressBook addressBook) {
		List<AddressBook> rets = addrDao.queryAddressBook(addressBook);
		for(AddressBook ret:rets) {
			if(!StringUtils.isEmpty(ret.getAddrbookPeople())){
				Emp emp = empDao.getEmpId(ret.getAddrbookPeople().getEmpId());
				ret.setAddrbookPeople(emp);
			}
			if(!StringUtils.isEmpty(ret.getAddrbookBoss())){
				Emp emp = empDao.getEmpId(ret.getAddrbookBoss().getEmpId());
				ret.setAddrbookBoss(emp);
			}
		}
		return rets;
	}

	@Override
	public PageBean<AddressBook> infoCustomers(AddressBook addressBook, Integer current) {
		List<AddressBook> rets = addrDao.infoCustomers(addressBook,(current-1)*10);
		for(AddressBook ret:rets) {
			if(!StringUtils.isEmpty(ret.getAddrbookPeople())){
				Emp emp = empDao.getEmpId(ret.getAddrbookPeople().getEmpId());
				ret.setAddrbookPeople(emp);
			}
			if(!StringUtils.isEmpty(ret.getAddrbookBoss())){
				Emp emp = empDao.getEmpId(ret.getAddrbookBoss().getEmpId());
				ret.setAddrbookBoss(emp);
			}
		}
		Integer total = rets.size();
		//查询到的客户信息
		pb.setBeanList(rets);
		//设置分页大小
		pb.setPageSize(10);
		//设置当前页码
		pb.setPageIndex(current);
		//设置数据总条数
		pb.setTotalRecord(total);
		//设置总页码
		pb.setTotalPage((total%10==0)?(total/10):(total/10+1));
		//设置起始页码和结束页码
		pb.setBeginPageAndEndPage();
		return pb;
	}

}
