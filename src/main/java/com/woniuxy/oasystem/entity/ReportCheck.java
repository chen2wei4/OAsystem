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
	private Integer reportIdd;
	private Integer empIdd;
	private String checkComment;
	private Date checkDate;
	private Integer flag;
	private Reports reportId;
	private Emp empId;
}
