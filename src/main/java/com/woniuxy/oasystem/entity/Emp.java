package com.woniuxy.oasystem.entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @Description 职工信息实体类
 * @author 陈一玮
 * @changeLog 1.创建 (2020年4月23日 下午2:56:00 [陈一玮]
 *            2.
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
	private Integer empId; //职工工号
	private String empPassword; //职工密码
	private Role role; //职工角色id
	private Department department; //职工部门id
	private String empName; //职工姓名
	private String empDate; //职工出生日期
	private String empSex; //职工性别
	private String empTel; //职工电话号码
	private String empEmail; //职工邮箱
	private String empIdnumber; //职工身份证号
	private String empHiredate; //职工被雇日期
	private String empEducation; //职工学历
	private String empPoliticalStatus; //职工政治面貌
	private Integer flag; //软删除
}
