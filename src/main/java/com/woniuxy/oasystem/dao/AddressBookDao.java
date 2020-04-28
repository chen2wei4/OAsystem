package com.woniuxy.oasystem.dao;

import java.util.List;
import com.woniuxy.oasystem.entity.AddressBook;
import org.apache.ibatis.annotations.Param;

public interface AddressBookDao {
    List<AddressBook> infoCustomers(@Param("addressBook")AddressBook addressBook, @Param("current")Integer i);
    void addAddressBook(AddressBook addressBook);
	void deleteAddressBook(AddressBook addressBook);
	void changeAddressBook(AddressBook addressBook);
	List<AddressBook> queryAddressBook(AddressBook addressBook);
}
