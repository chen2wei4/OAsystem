package com.woniuxy.oasystem.entity;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Announcement {

	private Integer anId;
	private Integer anEmpId;
	private Integer anType;
	private String anName;
	private String anContent;
	private Date anTime;
	private Boolean anFlag;
	private AnnouncementType atype;
	private Emp emp;
}
