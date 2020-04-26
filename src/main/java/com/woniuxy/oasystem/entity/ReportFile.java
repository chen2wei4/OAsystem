package com.woniuxy.oasystem.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportFile {
	private Integer fileId;
	private String fileName;
	private Date fileDate;
	private Reports reports;
	private String fileDescribe;
}
