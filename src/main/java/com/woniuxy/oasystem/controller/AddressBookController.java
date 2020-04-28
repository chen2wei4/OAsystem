package com.woniuxy.oasystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddressBookController {
	
	@RequestMapping("peopleInfo")
	String getAddressBook(){
		return "forward:/peopleInfo.html";
	}

}
