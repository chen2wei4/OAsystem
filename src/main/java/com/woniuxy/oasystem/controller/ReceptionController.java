/**
 *
 */
package com.woniuxy.oasystem.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.entity.Reception;
import com.woniuxy.oasystem.service.ReceptionService;

/**
 * @author THY唐昊宇事务模块
 *
 */
@Controller
public class ReceptionController {
    @Autowired
	ReceptionService  receptionService;

	public void setReceptionService(ReceptionService receptionService) {
		this.receptionService = receptionService;
	}
    
	//查询接待通知
	@RequestMapping("/queryReception")
	public String queryReception(Integer empId,Model model) {
		
		Reception reception=receptionService.queryRecptions(empId);
		model.addAttribute("re", reception);
		
		return "receptionQuery";
	}
	//接待完成
	@RequestMapping("/okReception")
	public String okReception(Integer receptionId,Model model){
		receptionService.okReception(receptionId);
		return "redirect:/queryReception?empId=1";
	}
	//查询接待人员
	@ResponseBody
	@RequestMapping("/queryReceptionEmp")
	public List<Emp> queryReceptionEmp(){
	return receptionService.queryReceptionEmp();
	}
	
	//新增申请
	@RequiresPermissions("reception:add")
	@RequestMapping("/addReception")
	public String addReception(Integer empId,String receptionTime,String receptionContent,Model model){
		//查询该员工是已经有接待任务
		Reception reception=receptionService.queryRecptions(empId);
		if(reception!=null){
			model.addAttribute("no","该员工已有接待任务");
			return "/reception_add";
			//[[${no}]]
		}
		receptionService.addReception(empId, receptionContent, receptionTime);
		return "/reception_add";
	}
}
