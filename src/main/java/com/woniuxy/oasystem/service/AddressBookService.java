package com.woniuxy.oasystem.service;

import java.util.List;

import com.woniuxy.oasystem.entity.Customer;
import com.woniuxy.oasystem.entity.PageBean;
import org.springframework.stereotype.Service;

import com.woniuxy.oasystem.dao.AddressBookDao;
import com.woniuxy.oasystem.entity.AddressBook;


public interface AddressBookService {
	void addAddressBook(AddressBook addressBook);
	void deleteAddressBook(AddressBook addressBook);
	void changeAddressBook(AddressBook addressBook);
	Integer getAddressBook(AddressBook addressBook);
	Integer getAddressBookById(AddressBook addressBook,Integer id);
	PageBean<AddressBook> infoCustomers(AddressBook addressBook, Integer currentPage);
	PageBean<AddressBook> infoCustomersById(AddressBook addressBook, Integer currentPage);
}
