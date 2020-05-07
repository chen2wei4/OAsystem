package com.woniuxy.oasystem.controller;

import com.woniuxy.oasystem.dao.DepartmentDao;
import com.woniuxy.oasystem.dao.MyInfoDao;
import com.woniuxy.oasystem.entity.*;
import com.woniuxy.oasystem.service.MemorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MemorController {

    @Autowired
    MemorService memorService;

    @RequestMapping("/addMemor")
    ModelAndView addMemor(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("memor_form");
        return mv;
    }
    @RequestMapping("/memor")
    ModelAndView getAddressBook(Integer page,HttpSession session){
        if(page==null){
            page=1;
        }
        ModelAndView mv=new ModelAndView();
        Memor m=new Memor();
        PageBean<Memor> ret = memorService.getMemor(m,page);

        mv.addObject("rets", ret);
        mv.setViewName("memors");
        return mv;
    }
    @RequestMapping("/memor/delete")
    ModelAndView delete(Integer id){
        ModelAndView mv=new ModelAndView();
        Memor m=new Memor();
        Memor condition = new Memor();
        condition.setMemorId(id);
        memorService.deleteMemor(condition);
        PageBean<Memor> ret = memorService.getMemor(m,1);

        mv.addObject("rets", ret);
        mv.setViewName("memors");
        return mv;
    }

    @RequestMapping("/memor/save")
    ModelAndView newMemor(Memor m,HttpSession session){
        ModelAndView mv=new ModelAndView();
        Emp e= (Emp) session.getAttribute("emp");
        m.setMemorFrom(e);
        memorService.addMemor(m);

        PageBean<Memor> ret = memorService.getMemor(m,1);
        mv.addObject("rets", ret);
        mv.setViewName("memors");
        return mv;
    }
}
