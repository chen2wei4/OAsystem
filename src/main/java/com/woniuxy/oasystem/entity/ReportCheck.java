package com.woniuxy.oasystem.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportCheck {
	private Integer checkId;
	private Date checkDate;
	private String checkComment;
	private Integer flag;
	private Reports reports;
	private Emp emp;
}
