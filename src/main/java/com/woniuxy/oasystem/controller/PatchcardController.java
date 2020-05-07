/**
 *
 */
package com.woniuxy.oasystem.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniuxy.oasystem.service.PatchcardService;
import com.woniuxy.oasystem.util.Pager;

/**
 * @author THY唐昊宇事务模块
 *
 */
@Controller
public class PatchcardController {
    @Autowired
	PatchcardService patchcardService;
   
	public void setPatchcardService(PatchcardService patchcardService) {
		this.patchcardService = patchcardService;
	}

	//补签
	@RequestMapping("/patchcardAdd")
	public String patchcardAdd(Integer empId,String patchcardContent) {
		 if(empId!=null) {
			 patchcardService.addPatchcard(empId, patchcardContent);
			  }
	
		return "patchcard_add";
	}
	
	     //查询所有补签
//		@RequestMapping("/queryPatchcard")
//		public void queryPatchcard(String empName,String departmentName,Integer pageNum,Model model){
//	           System.out.println("11111111111111111111111111");
//	           System.out.println(empName+""+departmentName+""+pageNum);
//			Pager pager=patchcardService.queryPatchcards(empName, departmentName, pageNum);
//	        //申请分页集合
//			System.out.println("thy"+pager.getPageList().toString());
//		   model.addAttribute("pd", pager.getPageList());
//		   model.addAttribute("patchcardPager",pager);
//		}
		//查询所有补签
	@RequiresPermissions("patchcard:query")
		@RequestMapping("/queryPatchcards")
		public  String patchcardQuery(String e,String d,Integer pageNum,Model model) {		
			model.addAttribute("e",e);
			model.addAttribute("d",d);
			Pager  pager=patchcardService.queryPatchcards(e, d, pageNum);
			model.addAttribute("pd", pager.getPageList());
			   model.addAttribute("patchcardPager",pager);
		           return "patchcardQuery";
		}
		
}
