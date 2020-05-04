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
	public Integer getAddressBook(AddressBook addressBook) {
		return addrDao.queryAddressBook(addressBook);
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
		pb.setBeanList(rets);
		pb.setPageSize(10);
		pb.setPageIndex(current);
		pb.setTotalRecord(getAddressBook(addressBook));
		pb.setTotalPage((pb.getTotalRecord()%10==0)?(pb.getTotalRecord()/10):(pb.getTotalRecord()/10+1));
		pb.setUrl("/info");
		pb.setBeginPageAndEndPage();
		return pb;
	}

}
