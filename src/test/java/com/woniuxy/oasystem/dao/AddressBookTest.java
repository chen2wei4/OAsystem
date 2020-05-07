package com.woniuxy.oasystem.dao;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.woniuxy.oasystem.entity.AddressBook;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.service.AddressBookService;

@SpringBootTest
public class AddressBookTest {
	@Autowired
	AddressBookService addressBookService;
	
	@Test
	void Test01() {
		Emp e=new Emp();
		e.setEmpId(1);
		AddressBook addressBook=new AddressBook(e, e, 1, "测试", "15600654357", "成都", 1, 1, 1);
		addressBookService.addAddressBook(addressBook);
		System.out.println("ok");
	}
	@Test
	void Test02() {
		Emp e=new Emp();
		e.setEmpId(1);
		AddressBook addressBook=new AddressBook(e, e, 1, "张三", "178200654357", "北京", 1, 1, 1);
		addressBook.setAddrbookId(8);
		addressBookService.changeAddressBook(addressBook);
	}
}
