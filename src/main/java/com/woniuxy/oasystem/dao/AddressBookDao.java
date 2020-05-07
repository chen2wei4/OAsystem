package com.woniuxy.oasystem.dao;

import java.util.List;
import com.woniuxy.oasystem.entity.AddressBook;
import org.apache.ibatis.annotations.Param;

public interface AddressBookDao {
    List<AddressBook> infoCustomers(@Param("addressBook")AddressBook addressBook, @Param("current")Integer i);
    void addAddressBook(@Param("addressBook")AddressBook addressBook,@Param("addressEmpId")Integer addressEmpId);
	void deleteAddressBook(@Param("addressBook")AddressBook addressBook);
	void changeAddressBook(@Param("addressBook")AddressBook addressBook,@Param("empId")Integer empId,@Param("addressEmpId")Integer addressEmpId);
	Integer queryAddressBook(@Param("addressBook")AddressBook addressBook);
	Integer queryAddressBookById(@Param("addressBook")AddressBook addressBook,@Param("empId")Integer id);
	List<AddressBook> infoCustomersById(@Param("aa")AddressBook addressBook, @Param("current")Integer i, @Param("empId")Integer empId);
}
