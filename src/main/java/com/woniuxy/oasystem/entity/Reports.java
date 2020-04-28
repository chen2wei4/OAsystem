package com.woniuxy.oasystem.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reports {
	private Integer reportId;
	private String reportName;
	private Date reportDate;
	private String reportContent;
	private String reportTrouble;
	private ReportType typeId;
	private Emp reportFrom;
	private Emp reportTo;
}
