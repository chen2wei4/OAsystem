package com.woniuxy.oasystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.woniuxy.oasystem.dao.AddressBookDao;
import com.woniuxy.oasystem.dao.DepartmentDao;
import com.woniuxy.oasystem.dao.EmpDao;
import com.woniuxy.oasystem.dao.MyInfoDao;
import com.woniuxy.oasystem.entity.Department;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.PageBean;
import com.woniuxy.oasystem.service.DepartmentService;
import com.woniuxy.oasystem.service.EmpService;
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
    @Autowired
    DepartmentDao department;
    @Autowired
    MyInfoDao empDao;
    @RequestMapping("myinfo")
    ModelAndView getAddressBook(HttpSession session){
        Emp emp = (Emp)session.getAttribute("emp");
        List<Department> departments = department.displayDepartment();
        ModelAndView mv=new ModelAndView();
        Emp ret=new Emp();
        ret = empDao.getEmpById(emp.getEmpId());
        System.out.println(departments);
        mv.addObject("emp",ret);
        Integer id=null;
        if(ret.getDepartment()!=null){
            id=ret.getDepartment().getDepartmentId();
        }
        mv.addObject("did",id);
        mv.addObject("deps",departments);
        mv.setViewName("people_info");
        return mv;
    }

    @RequestMapping("editmyinfo")
    @ResponseBody
    String editmyinfo(Emp emp){
        System.out.println(emp);
            empDao.ChangeInfo(emp);
        return "ok";
    }
}
