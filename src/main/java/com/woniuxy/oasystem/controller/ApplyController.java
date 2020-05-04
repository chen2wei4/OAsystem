/**
 *
 */
package com.woniuxy.oasystem.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.oasystem.entity.Apply;
import com.woniuxy.oasystem.entity.Applytype;
import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.service.ApplyService;
import com.woniuxy.oasystem.service.ApplytypeService;
import com.woniuxy.oasystem.util.Pager;

/**
 * @author THY唐昊宇事务模块
 *
 */
@Controller
public class ApplyController {
	
	  @Autowired
	  ApplyService  applyService;
	  
	  @Autowired
	  ApplytypeService  applytypeService;
	
	
	public void setApplyService(ApplyService applyService) {
		this.applyService = applyService;
	}

	public void setApplytypeService(ApplytypeService applytypeService) {
		this.applytypeService = applytypeService;
	}



	@ResponseBody
	@RequestMapping("/queryApplyEmp")
	public List<Applytype> queryApplyEmp(Model model){
		//查询申请类型
		List<Applytype> at=applytypeService.queryApplytypes();
		System.out.println(at.toString());
		return at;
	}
	
	/**
	 * @param applytypeId
	 * @param applyContent
	 * @param eId
	 * @param model
	 */
	//新增申请
	@ResponseBody
	@RequestMapping("/addApply")
	public String queryApplyEmp(Integer applytypeId,String applyContent,Integer eId,Model model){
		applyService.addApply(eId, applytypeId, applyContent);	
		return "申请成功";
	}
     //查询所有申请
	@RequestMapping("/queryApplys")
	public String queryAllApplys(Integer pageNum,Model model){
   Pager pager=applyService.queryApplys(pageNum);
     //申请分页集合
	model.addAttribute("ap", pager.getPageList());
	model.addAttribute("applyPager",pager);
		return "applyQuery";
	}
	
	   //删除申请
		@RequestMapping("/deleteApplys")
		 public String  deletedeleteApplys(Integer[] deletelt){
			//转化成集合
		     List<Integer> applyIds=new ArrayList<Integer>(Arrays.asList(deletelt));
		     applyService.deleteApplys(applyIds);
		     return "redirect:/queryApplys?&pageNum=1";
		}
		
		//批准申请
		@RequestMapping("/approvalApplys")
		 public String  approvalApplys(Integer[] approvals){
			//转化成集合
		     List<Integer> applyIds=new ArrayList<Integer>(Arrays.asList(approvals));
		     applyService.approvals(applyIds);
		     return "redirect:/queryApplys?&pageNum=1";
		}
}
