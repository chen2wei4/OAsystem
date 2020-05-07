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
	private Integer typeId;
	private Integer reportFromId;
	private Integer reportToId;
	private String reportName;
	private String reportStatus;
	private Date reportDate;
	private String reportContent;
	private String reportTrouble;
	private ReportType reportType;
	private Emp reportFrom;
	private Emp reportTo;
}
