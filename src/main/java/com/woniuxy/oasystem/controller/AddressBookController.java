package com.woniuxy.oasystem.controller;

import com.woniuxy.oasystem.dao.AddressBookDao;
import com.woniuxy.oasystem.dao.EmpDao;
import com.woniuxy.oasystem.entity.AddressBook;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AddressBookController {
	@Autowired
	AddressBookService addressBookService;
	@Autowired
	EmpDao empDao;
	@Autowired
	AddressBookDao addrDao;

	@RequestMapping("/info")
	@ResponseBody
	ModelAndView Index(Integer currentPage, HttpSession session) {
		if(currentPage==null)
			currentPage=1;
		ModelAndView mv=new ModelAndView();
		AddressBook addressBook=new AddressBook();//查询条件 此处为空 获取所有
		Emp e= (Emp) session.getAttribute("emp");
		String name = ((Emp) session.getAttribute("emp")).getEmpName();
		PageBean<AddressBook> rets=new PageBean<AddressBook>();
		if(name.equals("admin")){
			rets = addressBookService.infoCustomers(addressBook,currentPage);//使用空查询
		}else{
			addressBook.setAddrbookPeople(e);
			rets = addressBookService.infoCustomersById(addressBook,currentPage);//使用空查询
		}

		mv.addObject("rets", rets);
		mv.setViewName("lyear_pages_addressbook");
		System.out.println("查询");
		return mv;
	}

	@RequestMapping("/addBook")
	@ResponseBody
	ModelAndView add() {
		ModelAndView mv=new ModelAndView();
		System.out.println("toAdd");
		List<Emp> emps=empDao.getEmps();
		mv.addObject("emps", emps);
		mv.addObject("editdata", null);
		mv.setViewName("lyear_pages_addbook");
		return mv;
	}

	@RequestMapping("/editBook")
	@ResponseBody
	ModelAndView edit(Integer id) {
		ModelAndView mv=new ModelAndView();
		AddressBook condition=new AddressBook();
		condition.setAddrbookId(id);
		List<Emp> emps=empDao.getEmps();
		AddressBook ret = addrDao.infoCustomers(condition, 1).get(1);
		mv.addObject("emps", emps);
		mv.addObject("editdata", ret);
		mv.setViewName("lyear_pages_addbook");

		return mv;
	}

	@RequestMapping("save")
	@ResponseBody
	String save(AddressBook addressBook,Integer boss,HttpSession session) {
		Emp user = (Emp) session.getAttribute("emp");
		Emp emp = empDao.getEmpId(boss);
		addressBook.setAddrbookBoss(emp);
		addressBook.setAddrbookPeople(user);
		addressBookService.addAddressBook(addressBook);
		System.out.println("save"+addressBook);
		return "ok";
	}
	@RequestMapping("saveEdit")
	@ResponseBody
	String saveEdit(AddressBook addressBook,Integer boss,HttpSession session) {
		Emp user = (Emp) session.getAttribute("emp");
		Emp emp = empDao.getEmpId(boss);
		addressBook.setAddrbookBoss(emp);
		addressBook.setAddrbookPeople(user);
		addressBookService.changeAddressBook(addressBook);
		System.out.println("edit"+addressBook);
		return "ok";
	}
	@RequestMapping("deleteBook")
	String deleteBook(Integer id) {
		AddressBook condition=new AddressBook();
		condition.setAddrbookId(id);
		addressBookService.deleteAddressBook(condition);
		return "redirect:/info";
	}
}
