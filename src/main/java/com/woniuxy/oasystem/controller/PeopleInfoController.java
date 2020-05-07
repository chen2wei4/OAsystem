package com.woniuxy.oasystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.woniuxy.oasystem.dao.AddressBookDao;
import com.woniuxy.oasystem.dao.EmpDao;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.woniuxy.oasystem.entity.AddressBook;
import com.woniuxy.oasystem.service.AddressBookService;

import javax.servlet.http.HttpSession;

@Controller
public class PeopleInfoController {

    @RequestMapping("myinfo")
    ModelAndView getAddressBook(HttpSession session){
        Emp emp = (Emp)session.getAttribute("emp");
        ModelAndView mv=new ModelAndView();
        mv.addObject("info",emp);
        mv.setViewName("people_info");
        return mv;
    }

}
