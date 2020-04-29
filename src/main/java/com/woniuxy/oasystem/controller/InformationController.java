/**
 *
 */
package com.woniuxy.oasystem.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.Information;
import com.woniuxy.oasystem.service.InformationService;
import com.woniuxy.oasystem.util.Pager;

/**
 * @author THY唐昊宇事务模块
 *
 */
@Controller
public class InformationController {
	
    @Autowired
   InformationService informationService;

	public void setInformationService(InformationService informationService) {
		this.informationService = informationService;
	}
	
//    @ResponseBody
//	@RequestMapping("/queryInformations")
//    public String StringqueryInformations(Model model) {
//		List<Information> it=informationService.queryInformations(1);
//		  model.addAttribute(attributeValue);
//    	
//    	return "redirect:/information";
//     }
	
	//查询留言人id
    @ResponseBody
	@RequestMapping("/queryEmpIds")
    public List<Emp> queryEmpId(Model model) {
    	//应该查询所有员工
    	 List<Emp> ep=informationService.queryemps();
		 model.addAttribute("emps",ep);
    	return ep;
     }
    
    //提交留言
    @ResponseBody
	@RequestMapping("/addInformation")
    public String addInformation(Integer bempId,String informationContent,Integer eId){
    	informationService.addInformation(eId, informationContent,bempId);
    	return "提交成功";
    }
    
    
    //查询对当前员工的所有留言
   	@RequestMapping("/queryInformation")
   	public String  queryInformation(Integer did,Integer pageNum,Model model){
   		//当前页
   		if(pageNum.equals(null)) {
   			pageNum=1;
   		   }
             //分页完毕
   		Pager pager=informationService.queryInformations(did,pageNum);

   		     //存储分页集合
   		    model.addAttribute("it", pager.getPageList());
   		    //分页存储
   		    model.addAttribute("pg",pager);
   		  return "informationQuery";
   	}
   	
   	//删除留言
	@RequestMapping("/deleteInformation")
	 public String  deleteInformation(Integer[] deletelt,HttpSession session){
		//转化成集合
	     List<Integer> informationIds=new ArrayList<Integer>(Arrays.asList(deletelt));

	     informationService.deleteInformation(informationIds);
	     Object em=session.getAttribute("emp");
	     Emp emp=(Emp) em;
	     Integer a=emp.getEmpId();
	     int b=1;
	     return "redirect:/queryInformation?did="+a+"&pageNum="+b;
	}
}
