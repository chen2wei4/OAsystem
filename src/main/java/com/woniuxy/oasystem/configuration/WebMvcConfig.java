package com.woniuxy.oasystem.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.woniuxy.oasystem.interceptor.LoginHandlerInterceptor;

//import com.woniuxy.oasystem.interceptor.LoginHandlerInterceptor;
/**
 * 
 * @Description WebMvc配置类
 * @author 陈一玮
 * @changeLog 1.创建 (2020年4月23日 下午2:35:19 [陈一玮]
 */
@Configuration
public class WebMvcConfig {
	/**
	 * 路径映射和拦截器方法
	 * @return WebMvcConfigurer对象，可以用来配置路径映射
	 * @changeLog 1.创建 (2020年4月23日 下午2:36:39 [陈一玮]
	 * 			  2.修改 (2020年5月6日 下午5:10:43 [陈一玮]
	 */
	@Bean
	public WebMvcConfigurer oaConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {				
				//localhost:8080/返回登陆页面
				registry.addViewController("/").setViewName("/lyear_pages_login");
				//localhost:8080/index返回主页
				registry.addViewController("/index").setViewName("/index");
				//localhost:8080/newpwd进入修改密码页面
				registry.addViewController("/newpwd").setViewName("/lyear_pages_edit_pwd");
				//localhost:8080/newpwd进入绑定账号页面
				registry.addViewController("/bindaccount").setViewName("/lyear_pages_bind_account");
				//localhost:8080/organizationchart进入显示组织架构图页面
				registry.addViewController("/organizationchart").setViewName("/lyear_pages_organization_chart");
				//localhost:8080/addcustomer进入新增客户信息界面
				registry.addViewController("/addcustomer").setViewName("/lyear_pages_addcustomer");
				//localhost:8080/addcontract进入新增合同界面
				registry.addViewController("/addcontract").setViewName("/lyear_pages_addcontract");
				//localhost:8080/addorder进入新增订单界面
				registry.addViewController("/addorder").setViewName("/lyear_pages_addorder");
				
				// 公告相关
				registry.addViewController("/addaantype").setViewName("addantype");
				registry.addViewController("/anmanage").setViewName("announcementmanage");
				registry.addViewController("/anmanagetype").setViewName("announcementtypemanage");
				//车辆管理相关
				registry.addViewController("/car.html").setViewName("car");
				registry.addViewController("/carApply.html").setViewName("carApply");
				registry.addViewController("/returnRegister.html").setViewName("returnRegister");
				//会议管理相关
				registry.addViewController("/meeting.html").setViewName("meeting");
				registry.addViewController("/meetingApply.html").setViewName("meetingApply");
				registry.addViewController("/boardroom.html").setViewName("boardroom");
				//办公用品管理相关
				registry.addViewController("/officeSupplies.html").setViewName("officeSupplies");
				registry.addViewController("/officeSuppliesApply.html").setViewName("officeSuppliesApply");
				registry.addViewController("/officeSuppliesReturn.html").setViewName("officeSuppliesReturn");
				registry.addViewController("/officeSuppliesBuy.html").setViewName("officeSuppliesBuy");
				//行政档案管理相关
				registry.addViewController("/administrativeArchives.html").setViewName("administrativeArchives");
				//跳转异常页面
				registry.addViewController("/exception.html").setViewName("exception");
				//事务模块
				registry.addViewController("/information").setViewName("information");
				registry.addViewController("/apply_add").setViewName("apply_add");
				registry.addViewController("/reception_add").setViewName("reception_add");
				registry.addViewController("/patchcard_add").setViewName("patchcard_add");
				//人事模块
				registry.addViewController("/leaving").setViewName("hr_leaving");
				registry.addViewController("/interview").setViewName("hr_interview");
				registry.addViewController("/intervieweeInfo").setViewName("hr_intervieweeInfo");
				registry.addViewController("/emptyPosition").setViewName("hr_emptyPosition");
				registry.addViewController("/businessTrip").setViewName("hr_businessTrip");
				registry.addViewController("/checkIn").setViewName("hr_checkIn");
				registry.addViewController("/emp").setViewName("hr_emp");
				registry.addViewController("/addLeaving").setViewName("hr_addLeaving");
				registry.addViewController("/addInterview").setViewName("hr_addInterview");
				registry.addViewController("/addIntervieweeInfo").setViewName("hr_addIntervieweeInfo");
				registry.addViewController("/addEmptyPosition").setViewName("hr_addEmptyPosition");
				registry.addViewController("/addBusinessTrip").setViewName("hr_addBusinessTrip");
				registry.addViewController("/updateLeaving").setViewName("hr_updateLeaving");
				registry.addViewController("/updateInterview").setViewName("hr_updateInterview");
				registry.addViewController("/updateIntervieweeInfo").setViewName("hr_updateIntervieweeInfo");
				registry.addViewController("/updateEmp").setViewName("hr_updateEmp");
				registry.addViewController("/updateEmptyPosition").setViewName("hr_updateEmptyPosition");
				registry.addViewController("/updateBusinessTrip").setViewName("hr_updateBusinessTrip");
					
					
		}
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(new LoginHandlerInterceptor())
				//拦截的路径
				.addPathPatterns("/**")
				//特殊路径放行
				.excludePathPatterns("/","/css/**","/js/**","/fonts/**","/images/**","/emp/login","/render");
			}
	};
}
				
}