package com.woniuxy.oasystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.woniuxy.oasystem.entity.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.woniuxy.oasystem.entity.AddressBook;
import com.woniuxy.oasystem.service.AddressBookService;

@Controller
public class PeopleInfoController {
	
	@Autowired
	AddressBookService addrService;
	
	@RequestMapping("/info")
	@ResponseBody
	ModelAndView Index() {
		ModelAndView mv=new ModelAndView();
		AddressBook addressBook=new AddressBook();//查询条件 此处为空 获取所有
		PageBean<AddressBook> rets = addrService.infoCustomers(addressBook,1);//使用空查询
		mv.addObject("rets", rets);
		mv.setViewName("lyear_pages_addressbook");
		System.out.println("查询");
		return mv;
	}

	@RequestMapping("/addBook")
	@ResponseBody
	ModelAndView add() {
		ModelAndView mv=new ModelAndView();
		System.out.println("add");
		mv.setViewName("lyear_pages_addbook");
		return mv;
	}
}
