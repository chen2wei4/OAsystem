package com.woniuxy.oasystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.service.OfficeSuppliesService;
/**
 * 
 * @Description  办公用品管理
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月22日 [张钰平])
 *
 */
@Controller
@RequestMapping("/officeSupplies")
public class OfficeSuppliesController {
	@Autowired
	OfficeSuppliesService officeSuppliesService;
	
	/**
	 * 
	 * 展示所有办公用品
	 * @return
	 * @changeLog 	1. 创建 (2020年4月22日 [张钰平])
	 */
	@GetMapping("/list")
	public String findAll(Model model) {
		List<OfficeSupplies> list = officeSuppliesService.findAll();
		model.addAttribute("list",list);
		return "officeSupplies";
	}
	@DeleteMapping("/{osId}")
	public String delete() {
		System.out.println(1111);
		return "officeSupplies";
	}

}
